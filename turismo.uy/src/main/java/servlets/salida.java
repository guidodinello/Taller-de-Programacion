package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.logica.interfaces.ICtrlActividad;
import model.logica.interfaces.Fabrica;

import model.datatypes.DTSalida;

@WebServlet("/salida")
public class salida extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public salida() {
		super();
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
		ICtrlActividad ctrlActividad = Fabrica.getInstance().getICtrlActividad();
		String name = request.getParameter("nombreSalida");
		DTSalida salidaT = ctrlActividad.getInfoCompletaSalida(name);
		
		request.setAttribute("salida", salidaT);
		
		request.getRequestDispatcher("/WEB-INF/altaUsuario/consultaSalida.jsp").
			forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}