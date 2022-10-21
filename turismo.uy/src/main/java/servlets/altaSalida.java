package servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import excepciones.YaExisteException;
import model.logica.interfaces.Fabrica;
import model.logica.interfaces.ICtrlActividad;


/**
 * Servlet implementation class altaSalida
 */
@MultipartConfig
@WebServlet("/altaSalida")
public class altaSalida extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICtrlActividad iA = Fabrica.getInstance().getICtrlActividad();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public altaSalida() {
        super();
    }

    
    protected void cargarActividades(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {        
        Set<String> nomAct = iA.listarActividadesDepartamento(request.getParameter("nombreDep"));
        
        request.setAttribute("nombreDep", request.getParameter("nombreDep"));
        request.setAttribute("listaAct", nomAct);
        request.getRequestDispatcher("/WEB-INF/altaSalida/altaSalida.jsp").forward(request, response);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setAttribute("fail", false);
	    
	    if(request.getParameter("nombreDep") != null) {
	       cargarActividades(request, response);
	    } else {
	        request.getRequestDispatcher("/WEB-INF/altaSalida/altaSalida.jsp").forward(request, response);
	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
        String actividad = request.getParameter("actividad");
        String nombre = request.getParameter("nombre");
        
        String[] setFecha = request.getParameter("fechaNuevaYUnica").split("-");
        Integer hora = Integer.parseInt(request.getParameter("hora")); 
        GregorianCalendar fecha = new GregorianCalendar(Integer.parseInt(setFecha[0]), Integer.parseInt(setFecha[1]), Integer.parseInt(setFecha[2]), hora, 0);
        
        String lugar = request.getParameter("lugar");
        Integer cantMaxTur = Integer.parseInt(request.getParameter("cantMaxTur"));        
        
        // img
        try {
            iA.altaSalidaTuristica(nombre, fecha, lugar, cantMaxTur, new GregorianCalendar(), actividad, "");
            request.getRequestDispatcher("/index").forward(request, response);
        }catch(YaExisteException e) {
            e.printStackTrace();
            request.setAttribute("fail", true);
            request.getRequestDispatcher("/WEB-INF/altaSalida/altaSalida.jsp").forward(request, response);
        }
	}
	   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
