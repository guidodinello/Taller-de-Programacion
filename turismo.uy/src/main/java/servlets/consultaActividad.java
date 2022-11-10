package servlets;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import webservices.DtSalida;
import webservices.DtPaquete;
import webservices.DtActividad;
import webservices.ActividadTuristica;

@WebServlet("/consultaActividad")
public class consultaActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public consultaActividad() {
		super();
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
		//ActividadTuristica actividad = hA.obtenerActividadTuristica(request.getParameter("nombreAct"));
	    webservices.WebServicesService service = new webservices.WebServicesService();
        webservices.WebServices port = service.getWebServicesPort();
	    DtActividad datosActividad = port.getInfoActividad(request.getParameter("nombreAct"));
		
		Set<DtSalida> salidasActividad = new HashSet<DtSalida>();
		for(String sal : datosActividad.getSalidas())
		    salidasActividad.add(port.getInfoCompletaSalida(sal));
		
		List<String> nombPaquetesActividad = datosActividad.getPaquetes();
		Set<DtPaquete> paquetesActvidad = new HashSet<DtPaquete>(); 
		nombPaquetesActividad.forEach((e)->{
			paquetesActvidad.add(port.getInfoPaquete(e));
		});
		
		request.setAttribute("datosPaqueteActividad", paquetesActvidad);
		request.setAttribute("datosActividad", datosActividad);
		request.setAttribute("datosSalidaActividad", salidasActividad);
		request.getRequestDispatcher("/WEB-INF/actividad/consultaActividad.jsp").forward(request, response);
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		processRequest(request, response);

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
	    request.setCharacterEncoding("UTF-8");
		processRequest(request, response);
	}
	
}