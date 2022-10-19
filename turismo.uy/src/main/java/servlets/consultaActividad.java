package servlets;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.datatypes.DTActividad;
import model.datatypes.DTPaquete;
import model.datatypes.DTSalida;
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
		ActividadTuristica actividad = hA.obtenerActividadTuristica(request.getParameter("nombreAct"));
		Set<DTSalida> salidasActividad = ctrlActividad.listarInfoSalidasVigentes(actividad.getNombre(), new GregorianCalendar(19, 1, 2020));
		
		DTActividad datosActividad = ctrlActividad.getInfoActividad(actividad.getNombre());
		
		Set<String> nombPaquetesActividad = datosActividad.getPaquetes();
		Set<DTPaquete> paquetesActvidad = new HashSet<DTPaquete>(); 
		nombPaquetesActividad.forEach((e)->{
			paquetesActvidad.add(ctrlActividad.getInfoPaquete(e));
		});
		
		request.setAttribute("datosPaqueteActividad", paquetesActvidad);
		request.setAttribute("datosActividad", datosActividad);
		request.setAttribute("datosSalidaActividad", salidasActividad);
		request.getRequestDispatcher("/WEB-INF/actividad/consultaActividad.jsp").forward(request, response);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		/*try {
		    Set<String> setString = new HashSet<String>();
			ctrlUsuario.altaUsuario("testProv", "testEmail", "testNomb", "testAp", "testPass", new GregorianCalendar(),"", tipoUsuario.proveedor, "", "testdesc", "testSitio");
			ctrlActividad.altaDepartamento("deptotest","deptotest" ,"deptotest");
			ctrlActividad.altaActividadTuristica("deptotest", "testNombre", "testDesc", 10, 110, "test", "testProv", new GregorianCalendar(), "", setString);
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		processRequest(request, response);

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		processRequest(request, response);
	}
	
}