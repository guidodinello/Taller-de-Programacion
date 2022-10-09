package servlets;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.datatypes.DTActividad;
import model.datatypes.tipoUsuario;
import model.logica.clases.ActividadTuristica;
import model.logica.handlers.HandlerActividades;
import model.logica.interfaces.Fabrica;
import model.logica.interfaces.ICtrlActividad;
import model.logica.interfaces.ICtrlUsuario;

@WebServlet("/consultaActividad")
public class consultaActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICtrlUsuario ctrlUsuario = Fabrica.getInstance().getICtrlUsuario();
	private ICtrlActividad ctrlActividad = Fabrica.getInstance().getICtrlActividad();
	private HandlerActividades hA = HandlerActividades.getInstance();
	
	public consultaActividad() {
		super();
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
	
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		try {
			ctrlUsuario.altaUsuario("testProv", "testEmail", "testNomb", "testAp", "testPass", new GregorianCalendar(),"", tipoUsuario.proveedor, "", "testdesc", "testSitio");
			ctrlActividad.altaDepartamento("deptotest","deptotest" ,"deptotest");
			ctrlActividad.altaActividadTuristica("deptotest", "test", "test", 0, 0, "test", "testProv", new GregorianCalendar());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ActividadTuristica actividad = hA.obtenerActividadTuristica(request.getParameter("nombreAct"));
		DTActividad datosActividad = ctrlActividad.getInfoActividad(actividad.getNombre());
		request.setAttribute("datosActividad", datosActividad);
		request.getRequestDispatcher("/WEB-INF/actividad/consultaActividad.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {


	}
	
}