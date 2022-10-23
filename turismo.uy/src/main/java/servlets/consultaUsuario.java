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
import javax.servlet.http.HttpSession;

import model.logica.clases.Turista;
import model.datatypes.DTUsuario;
import model.logica.clases.Proveedor;
import model.logica.clases.Usuario;
import model.logica.handlers.HandlerUsuarios;
import model.logica.interfaces.Fabrica;
import model.logica.interfaces.ICtrlUsuario;

@WebServlet("/consultaUsuario")
public class consultaUsuario extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * @see HttpServlet#HttpServlet()
     */
	public consultaUsuario() {
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
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
	            HandlerUsuarios hu = HandlerUsuarios.getInstance();
	            ICtrlUsuario ctrlUsr = Fabrica.getInstance().getICtrlUsuario();
		        Set<DTUsuario> usuarios = new HashSet<DTUsuario>();
				for(String u : ctrlUsr.listarUsuarios()) {
					usuarios.add(ctrlUsr.getInfoBasicaUsuario(u));
				};
		        String estado;
		        if(request.getParameter("STATE") == null)
		            estado = "";
		        else
		            estado = request.getParameter("STATE");
		        System.out.print(estado);
		    switch (estado) {
		      case "LISTAR":
		        request.setAttribute("STATE", "LISTAR");
		        request.setAttribute("USUARIOS", usuarios);
		        request.getRequestDispatcher("/WEB-INF/consultaUsuario/consultaUsuario.jsp").forward(request,
		            response);
		        break;
		      case "INFO":
		        DTUsuario usuarioLogueado =
		            (DTUsuario) request.getSession().getAttribute("usuario_logueado");
		        String nombreUsuario = (String) request.getParameter("NICKNAME");
		        request.setAttribute("STATE", "INFO");
		        //no estoy logueada 
		        if(usuarioLogueado == null) {
		            request.setAttribute("PERFIL_USUARIO", (DTUsuario)
		                    ctrlUsr.getInfoBasicaUsuario(nombreUsuario));
		        }
		        //estoy logueada viendo otro perfil
		        else if(!usuarioLogueado.getNickname().equals(nombreUsuario)){
		        request.setAttribute("PERFIL_USUARIO", (DTUsuario)
                        ctrlUsr.getInfoBasicaUsuario(nombreUsuario));
		      
		        }
		        //estoy logueada viendo mi perfil
		        else{
		            request.setAttribute("MI_PERFIL_USUARIO", (DTUsuario)
                            ctrlUsr.getInfoBasicaUsuario(nombreUsuario));

		        }
		        request.getRequestDispatcher("/WEB-INF/consultaUsuario/consultaUsuario.jsp").forward(request,
		            response);
		        break;
		      default:
		        request.setAttribute("STATE", "DEFAULT");
		        request.getRequestDispatcher("/WEB-INF/error/error500.jsp").forward(request, response);
		    }
		  }

		  protected void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		      request.setCharacterEncoding("UTF-8");
		    doGet(request, response);
		  }
}
