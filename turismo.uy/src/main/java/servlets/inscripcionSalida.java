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
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 * 
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
		request.getRequestDispatcher("/WEB-INF/altaUsuario/altaUsuario.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getAttribute("name") != null) {
			// viene de consultaSalida.jsp
			request.getRequestDispatcher("/WEB-INF/altaUsuario/inscripcionSalida.jsp").forward(request, response);
		} else {
			// viene de home.jsp
			request.getRequestDispatcher("/WEB-INF/altaUsuario/inscripcionSalida.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/altaUsuario/inscripcionSalida.jsp").forward(request, response);
	}
	
	/*
	En primer lugar, el turista indica el departamento donde se
	realiza la actividad turística o una categoría, y el sistema muestra las
	actividades asociadas con estado “Confirmada”
	*/
	/*
	 Como lograr este efecto?
	 Pedir todos los datos de una y dsps manejarlo desde js
	 o ir haciendo peticiones con ajax
	*/
}
