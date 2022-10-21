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
    
    /*private void hardCodeoParaTesting(HttpServletRequest request) {
        Fabrica f = Fabrica.getInstance();
        ICtrlActividad cAct = f.getICtrlActividad();
        ICtrlUsuario cUsr = f.getICtrlUsuario();
        
        String deptoActividad1 = "Montevideo";
        String nombActividad1 = "Actividad 1";
        String desActividad1 = "act1 d";
        int duraHsActividad1 = 2;
        float costoActividad1 = 11;
        String ciudadActividad1 = "Centro";
        String nickProvAct1 = "cris";
        GregorianCalendar fechaAct1 = new GregorianCalendar(2000, 2, 2);
        String img = "";
        Set<String> setString = new HashSet<String>();
        
        GregorianCalendar fecha = new GregorianCalendar(2022,8,30);
        String nomSal = "A Centro";
        
        String imgPerfil = "";
        try {
            // TODO
            // compraPaquete para testear turistas con paquetes comprados
            cUsr.altaUsuario(nickProvAct1, "cris@", "Cristian", "Gonzalez", "password", new GregorianCalendar(), imgPerfil, tipoUsuario.proveedor, "uruguayo", "provee cosas", "cris.com");
            cAct.altaDepartamento(deptoActividad1, "Capital de Uruguay", "mvdeo.com.uy");
            cAct.altaActividadTuristica(deptoActividad1, nombActividad1, desActividad1, duraHsActividad1, costoActividad1, ciudadActividad1, nickProvAct1, fechaAct1, img, setString);
            cAct.altaSalidaTuristica(nomSal, fecha, "Centro", 10, new GregorianCalendar(), nombActividad1);
        } catch (YaExisteException e) {
            e.printStackTrace();
        }
        
        //turistas
        String nickT1 = "agus";
        String emailT1 = "agus@";
        String nombT1 = "Agustin";
        String apT1 = "Franco";
        GregorianCalendar fechaNac1 = new GregorianCalendar(2000, 2, 2);
        String nacionalidadT1 = "uruguayo";
        String pass = "password";
        String perfilImg = "imagen";
        try {
            cUsr.altaUsuario(nickT1, emailT1, nombT1, apT1, pass, fechaNac1, perfilImg, tipoUsuario.turista, nacionalidadT1, null, null);
        } catch (YaExisteException e) {
            e.printStackTrace();
        }
        
        request.setAttribute("nombreSalida", nomSal);
    }*/
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 El turista indico la salida a la que se quiere inscribir.
		 RENDERIZADO DEL FORMULARIO DE INSCRIPCION
		*/
	    
	    //hardCodeoParaTesting(request);
        ICtrlActividad ICA = Fabrica.getInstance().getICtrlActividad();
        
	    if (request.getParameter("nombreSalida") != null){
	        
	        // obtener info de la salida seleccionada
	        DTSalida dts = ICA.getInfoCompletaSalida((String)request.getParameter("nombreSalida"));
	        
	        request.setAttribute("salida", dts);
	        
	        /*
                En caso de que el turista haya comprado paquetes que aún estén vigentes y
            que incluyan la actividad turística de la salida seleccionada y posea
            inscripciones disponibles, el sistema muestra estos paquetes y el turista
            podrá elegir uno de ellos para realizar la inscripción. En este caso, se
            deberán descontar la cantidad de inscripciones indicada del paquete
            seleccionado y la actividad turística correspondiente
            */
            HttpSession session = request.getSession();
            DTTurista dttur = (DTTurista)session.getAttribute("usuario_logueado");
            
            String nomAct = dts.getNombreActividad();
            Set<DTPaquete> paqCompVig = new HashSet<DTPaquete>();
            DTPaquete p;
            for (DTCompra c : dttur.getCompras()) {
                p = ICA.getInfoPaquete(c.getPaquete());
                if (c.getCantTuristas()>0 && p.getActividades().contains(nomAct))
                    paqCompVig.add(p);
            }
            request.setAttribute("paquetes", paqCompVig);
	        
			request.getRequestDispatcher("/WEB-INF/salida/inscripcionSalida.jsp").forward(request, response);
	    } else if (request.getParameter("listar") != null) {
	        // se llego desde acceso a casos de uso
	        // se listan todas las salidas
	        Function<SalidaTuristica, DTSalida> darDts = (s) -> { 
	             return ICA.getInfoCompletaSalida(s.getNombre());
	            };
	        Predicate<SalidaTuristica> truthy = (s) -> { return true; };
	        Set<DTSalida> dtsalidas = ICA.filterSalidas(darDts, truthy);

	        request.setAttribute("salidas", dtsalidas);
	        request.getRequestDispatcher("/WEB-INF/salida/listadoSalidas.jsp").forward(request, response);
	    } else {
		    // ERROR: se llego a la pagina de inscripcion salida sin haber seleccionado una salida
		    // TODO
		    // ver como se redirige a la pagina de error correctamente
		    request.getRequestDispatcher("/WEB-INF/errorPages/500.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	    
        HttpSession session = request.getSession();
        DTTurista turista = (DTTurista)session.getAttribute("usuario_logueado");
        
        Fabrica fabrica = Fabrica.getInstance();
        ICtrlActividad ICA = fabrica.getICtrlActividad();
        ICtrlUsuario ICU = fabrica.getICtrlUsuario();
        
        // de donde saco la salida??
        DTSalida salida = ICA.getInfoCompletaSalida(request.getParameter("Salida"));
   
        int cantTuristas = Integer.parseInt(request.getParameter("cantTuristas"));
        
        // compra por paquete
        if (request.getParameter("tipoDeInscripcion").equals("porPaquete")) {
            // obtener paquete seleccionado
            DTPaquete paq = ICA.getInfoPaquete(request.getParameter("paqueteSeleccionado"));
            
            // descontar cantidad de inscripciones indicada del paquete para la actividad correspondiente
            // TODO 
            //      de eso se encarga alguna funcion de compra que hay que implementar en el controlador
//            try {
//                 ICA.comprarPaquete(turista.getNombre(), salida.getNombreActividad(), cantTuristas);
//            } catch(CompraException e) {
//                request.setAttribute("nombreSalida", salida.getNombre());
//                request.setAttribute("CompraException", e.getMessage());
//                doGet(request, response);
//                e.printStackTrace();
//            }
  
            
        // compra general
        } else {
            
        }
        
        // efectivizar la inscripcion
//        try {
//            ICU.ingresarInscripcion(turista.getNickname(), salida.getNombre(), cantTuristas, new GregorianCalendar());
//        } catch (InscriptionFailException e) {
//            // ERROR : ya existe un registro del turista en la salida turística o
//            // se alcanzo el límite máximo de turistas para la salida
//            request.setAttribute("nombreSalida", salida.getNombre());
//            request.setAttribute("InscriptionFailedError", e.getMessage());
//            doGet(request, response);
//            e.printStackTrace();
//        }
        
        

        // TODO
        // elegir a donde redirigir luego de inscripto
        // decidir como darle feedback al usuario si la inscripcion se realizo con exito o no
	    request.getRequestDispatcher("/WEB-INF/salida/inscripcionSalida.jsp").forward(request, response);
	}
	
//	// TODO
//	En caso de que ya exista un registro de el/la turista a la salida turística o
//	se haya alcanzado el límite máximo de turistas para la salida, el turista
//	podrá (dependiendo del caso): cambiar la salida seleccionada o cancelar el
//	caso de uso.
//  Como hacer esto? 
//  1. cambiar la salida seleccionada: lo mando a consulta Salida (hay algun lado donde se listan las salidas?)
//  2. cancelar : que aprete el loquito en el home o en otro lado
}
