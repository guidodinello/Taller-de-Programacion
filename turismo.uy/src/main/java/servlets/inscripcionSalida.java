package servlets;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.datatypes.DTActividad;
import model.datatypes.DTCompra;
import model.datatypes.DTPaquete;
import model.datatypes.DTSalida;
import model.datatypes.DTTurista;
import model.datatypes.tipoUsuario;
import excepciones.InscriptionFailException;
import excepciones.YaExisteException;
import model.logica.interfaces.Fabrica;
import model.logica.interfaces.ICtrlActividad;
import model.logica.interfaces.ICtrlUsuario;
import model.datatypes.DTUsuario;
import model.datatypes.estadoActividad;
import model.datatypes.tipoInscripcion;
import model.logica.clases.ActividadTuristica;
import model.logica.clases.Proveedor;
import model.logica.clases.SalidaTuristica;
import model.logica.clases.Turista;
import model.logica.clases.Usuario;

/**
 * Servlet implementation class inscripcionSalida
 */
@WebServlet("/inscripcionSalida")
public class inscripcionSalida extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * Default constructor. 
     */
    public inscripcionSalida() {
        super();
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 El turista indico la salida a la que se quiere inscribir.
		 RENDERIZADO DEL FORMULARIO DE INSCRIPCION
		*/
	    if(!(request.getSession().getAttribute("usuario_logueado") instanceof DTTurista))
	        response.sendRedirect("index");
	    else {
            ICtrlActividad ICA = Fabrica.getInstance().getICtrlActividad();
            
    	    if (request.getParameter("nombreSalida") != null){
    	        
    	        // obtener info de la salida seleccionada
    	        DTSalida dts = ICA.getInfoCompletaSalida((String)request.getParameter("nombreSalida"));
    	        
    	        request.setAttribute("salida", dts);
    	        
    	        /*
                    En caso de que el turista haya comprado paquetes que aún estén vigentes y
                que incluyan la actividad turística de la salida seleccionada y posea
                inscripciones disponibles, el sistema muestra estos paquetes y el turista
                podrá elegir uno de ellos para realizar la inscripción. 
                */
                HttpSession session = request.getSession();
                DTTurista dttur = (DTTurista)session.getAttribute("usuario_logueado");
                
                String nomAct = dts.getNombreActividad();
                Set<DTPaquete> paqCompVig = new HashSet<DTPaquete>();
                DTPaquete p;
                for (DTCompra c : dttur.getCompras()) {
                    if(c.getVigente()) {
                        p = ICA.getInfoPaquete(c.getPaquete());
                        if (p.getActividades().contains(nomAct) && c.disponiblesEnActividad(nomAct) > 0)
                            paqCompVig.add(p);
                    }
                }
                request.setAttribute("paquetes", paqCompVig);
    	        
    			request.getRequestDispatcher("/WEB-INF/salida/inscripcionSalida.jsp").forward(request, response);
    	    } else if (request.getParameter("listar") != null) {
    	        // se llego desde acceso a casos de uso
    	        // se listan todas las salidas vigentes al dia actual
    	        
    	        Set<DTSalida> dtsalidas = new HashSet<DTSalida>();
    	        GregorianCalendar fecha = new GregorianCalendar();
    	        for(DTActividad act : ICA.getDTActividadesConfirmadas()) {
    	            dtsalidas.addAll(ICA.listarInfoSalidasVigentes(act.getNombre(), fecha));
    	        }
    
    	        request.setAttribute("salidas", dtsalidas);
    	        request.getRequestDispatcher("/WEB-INF/salida/listadoSalidas.jsp").forward(request, response);
    	    } else {
    		    // ERROR: se llego a la pagina de inscripcion salida sin paso previo
    	        response.sendRedirect("/WEB-INF/errorPages/500.jsp");
    		}
	    
	    }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    
	    //Si llegas al POST ya tenes nombreSalida, y si la inscripcion falla necesitas mandar de nuevo el DTSalida y los DTPaquete al JSP
	    
	    Fabrica fabrica = Fabrica.getInstance();
	    ICtrlActividad ICA = Fabrica.getInstance().getICtrlActividad();
	    DTSalida dts = ICA.getInfoCompletaSalida((String)request.getParameter("nombreSalida"));
        request.setAttribute("salida", dts);
        
        HttpSession session = request.getSession();
        DTTurista turista = (DTTurista)session.getAttribute("usuario_logueado");
        
        String nomAct = dts.getNombreActividad();
        Set<DTPaquete> paqCompVig = new HashSet<DTPaquete>();
        DTPaquete p;
        for (DTCompra c : turista.getCompras()) {
            if(c.getVigente()) {
                p = ICA.getInfoPaquete(c.getPaquete());
                if (p.getActividades().contains(nomAct) && c.disponiblesEnActividad(nomAct) > 0)
                    paqCompVig.add(p);
            }
        }
        request.setAttribute("paquetes", paqCompVig);
        
		/* 
		Respuesta del formulario de inscripcion a salida
		SE PROCESA LA PETICION DE INSCRIPCION
		*/
	    
	    /*
	    En caso de que ya exista un registro de el/la turista a la salida turística o
	    se haya alcanzado el límite máximo de turistas para la salida, el turista
	    podrá (dependiendo del caso): cambiar la salida seleccionada o cancelar el
	    caso de uso.
	    */
        
        ICtrlUsuario ICU = fabrica.getICtrlUsuario();
        
        //DTSalida salida = ICA.getInfoCompletaSalida(request.getParameter("Salida"));
   
        int cantTuristas = Integer.parseInt(request.getParameter("cantTuristas"));
        String sal = request.getParameter("nombreSalida");
        
        try {
            if(request.getParameter("tipoDeInscripcion").equals("porPaquete")) {
                String paq = request.getParameter("paqueteSeleccionado");
                ICU.ingresarInscripcion(turista.getNickname(), sal, cantTuristas, new GregorianCalendar(), tipoInscripcion.paquete, paq);
            }
            else {
                ICU.ingresarInscripcion(turista.getNickname(), sal, cantTuristas, new GregorianCalendar(), tipoInscripcion.general, "");
            }
            request.setAttribute("exito", "Te has inscripto con exito a la salida "+ sal);
            request.getRequestDispatcher("/index").forward(request, response);
        } catch(InscriptionFailException e) {
            e.printStackTrace();
            request.setAttribute("InscriptionFailedError", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/salida/inscripcionSalida.jsp").forward(request, response);
        }
            
	}
}
