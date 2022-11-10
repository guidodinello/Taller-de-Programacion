package servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservices.DtActividad;
import webservices.DtPaquete;
import webservices.DtSalida;

@WebServlet("/consultaActividad")
public class consultaActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	webservices.WebServicesService service = new webservices.WebServicesService();
    webservices.WebServices port = service.getWebServicesPort();
    
    public consultaActividad() {
		super();
	}
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
    	// parametro requerido: nombreAct
    	String nombreAct = request.getParameter("nombreAct");
    	DtActividad datosActividad = port.getInfoActividad(nombreAct);
    	
    	Set<DtSalida> salidasActividad = new HashSet<DtSalida>();
    	for(String sal: datosActividad.getSalidas())
    		salidasActividad.add(port.getInfoCompletaSalida(sal));
    	
    	Set<DtPaquete> paquetesActividad = new HashSet<DtPaquete>();
    	for(String paq: datosActividad.getPaquetes())
    		paquetesActividad.add(port.getInfoPaquete(paq));
    	
    	//Pedir atributos en consultaActividad.jsp
    	request.setAttribute("datosPaqueteActividad", paquetesActividad);
		request.setAttribute("datosActividad", datosActividad);
		request.setAttribute("datosSalidaActividad", salidasActividad);
		request.getRequestDispatcher("/WEB-INF/consultaActividad.jsp").forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		processRequest(request, response);

	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
	    request.setCharacterEncoding("UTF-8");
		processRequest(request, response);
	}
	
}