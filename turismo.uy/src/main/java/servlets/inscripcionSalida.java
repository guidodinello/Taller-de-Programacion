package servlets;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datatypes.DTPaquete;
import datatypes.DTSalida;
import datatypes.DTTurista;
import excepciones.InscriptionFailException;
import logica.interfaces.Fabrica;
import logica.interfaces.ICtrlActividad;
import logica.interfaces.ICtrlUsuario;
import model.datatypes.DTUsuario;
import model.logica.clases.Proveedor;
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
	    if (request.getAttribute("nombreSalida") != null){
	        
	        // obtener info de la salida seleccionada
	        Fabrica fabrica = Fabrica.getInstance();
	        ICtrlActividad ICA = fabrica.getICtrlActividad();
	        request.setAttribute("salida", ICA.getInfoCompletaSalida((String)request.getAttribute("nombreSalida")));
	        
	        /*
                En caso de que el turista haya comprado paquetes que aún estén vigentes y
            que incluyan la actividad turística de la salida seleccionada y posea
            inscripciones disponibles, el sistema muestra estos paquetes y el turista
            podrá elegir uno de ellos para realizar la inscripción. En este caso, se
            deberán descontar la cantidad de inscripciones indicada del paquete
            seleccionado y la actividad turística correspondiente
            */
            ICtrlUsuario ICU = fabrica.getICtrlUsuario();
            HttpSession session = request.getSession();
            DTTurista dttur = (DTTurista)session.getAttribute("usuario_loggueado");
            /* TODO
            act = salida.getNombreActividad()
            paq = turista.getPaquetesCompradosVigentes()
            paq2 = filter(paq, 
                        incluye act && 
                        le quedan inscripciones disponibles
                   )
            request.setAttribute("paquetes", paq2);
            
            */
	        
			request.getRequestDispatcher("/WEB-INF/salida/inscripcionSalida.jsp").forward(request, response);
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
	    
	    // TODO validar campos no vacio desde js
	    
	    /*
	    En caso de que ya exista un registro de el/la turista a la salida turística o
	    se haya alcanzado el límite máximo de turistas para la salida, el turista
	    podrá (dependiendo del caso): cambiar la salida seleccionada o cancelar el
	    caso de uso.
	    */
	    
        HttpSession session = request.getSession();
        DTUsuario turista = (DTUsuario)session.getAttribute("usuario_loggueado");
        
        Fabrica fabrica = Fabrica.getInstance();
        ICtrlActividad ICA = fabrica.getICtrlActividad();
        ICtrlUsuario ICU = fabrica.getICtrlUsuario();
        
        DTSalida salida = ICA.getInfoCompletaSalida(request.getParameter("Salida"));
   
        int cantTuristas = Integer.parseInt(request.getParameter("cantTuristas"));
        
        // compra por paquete
        if (request.getParameter("TipoDeInscripcion").equals("InscripcionPorPaquete")) {
            // obtener paquete seleccionado
            DTPaquete paq = ICA.getInfoPaquete(request.getParameter("paqueteSeleccionado"));
            
            // descontar cantidad de inscripciones indicada del paquete para la actividad correspondiente
            // TODO 
            //      funcion en el controlador que devuelva el paquete y setearle la nueva cantidad
            //      o funcion en el controlador que le saque cierta cantidad
            //      DONDE SE GUARDAN LOS PAQUETES?, NO HAY HANDLER
  
            
        // compra general
        } else {
            
        }
        
        // efectivizar la inscripcion
        try {
            ICU.ingresarInscripcion(turista.getNickname(), salida.getNombre(), cantTuristas, new GregorianCalendar());
        } catch (InscriptionFailException e) {
            // TODO
            // decidir que hacer si hay error en la inscripcion
            e.printStackTrace();
        }
        
        

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
