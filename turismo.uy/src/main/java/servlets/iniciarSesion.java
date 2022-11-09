package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.logica.handlers.HandlerUsuarios;
import model.logica.clases.Usuario;
import model.logica.clases.Turista;
import model.logica.clases.Proveedor;
import model.datatypes.DTUsuario;
import model.datatypes.DTTurista;
import model.datatypes.DTProveedor;

//import webservices.DtUsuario;
//import webservices.DtTurista;
//import webservices.DtProveedor;


/**
 * Servlet implementation class iniciarSesion
 */
@WebServlet("/iniciarSesion")
public class iniciarSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    webservices.WebServicesService service = new webservices.WebServicesService();
    webservices.WebServices port = service.getWebServicesPort();
	
    /**
     * Default constructor. 
     */
    public iniciarSesion() {
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
		
		String nickOrEmail = request.getParameter("nick-or-email");
		String pass = request.getParameter("password");
		
		// validacion en la logica
		HandlerUsuarios hu = HandlerUsuarios.getInstance();
		
		Usuario usr = hu.getUsuarioByEmail(nickOrEmail);
		if (usr == null)
			usr = hu.getUsuarioByNickname(nickOrEmail);
		
		if (usr == null || !(usr.getContrasena().equals(pass))) {
			request.setAttribute("invalid_attempt", true);
			request.getRequestDispatcher("/WEB-INF/sesion/iniciarSesion.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			if(usr instanceof Turista) {
			    DTTurista tur = new DTTurista((Turista)usr);
			    session.setAttribute("usuario_logueado", (DTUsuario)tur);
			}
			else {
			    DTProveedor prov = new DTProveedor((Proveedor)usr);
			    session.setAttribute("usuario_logueado", (DTUsuario)prov);
			}
			response.sendRedirect("index");
		}

	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("invalid_attempt", false);
		request.getRequestDispatcher("/WEB-INF/sesion/iniciarSesion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
		processRequest(request, response);
	}

}
