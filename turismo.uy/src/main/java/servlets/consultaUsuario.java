package servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.datatypes.DTUsuario;
import model.datatypes.DTTurista;
import model.datatypes.DTProveedor;
import model.logica.clases.Turista;
import model.logica.clases.Proveedor;
import model.logica.handlers.HandlerUsuarios;
import model.logica.interfaces.Fabrica;
import model.logica.interfaces.ICtrlUsuario;

@MultipartConfig
@WebServlet("/consultaUsuario")
public class consultaUsuario extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] ext = {".icon", ".png", ".jpg", ".jpeg"};
	private String udi = "media/imagenes/usuarioPerfil.png";
	private String rui = "media/imagenes/";
	/**
     * @see HttpServlet#HttpServlet()
     */
	public consultaUsuario() {
		super();
	}
	
    private String guardarImg(Part p, HttpServletRequest req, String ext, String nick) {
        String dir = udi;
        try {
            /*Si existe un archivo con el mismo nombre lo eliminamos*/
            File file = new File(req.getServletContext().getRealPath("/"+rui)+"/"+nick+ "_usr" +ext);
            if(file.delete())
                System.out.println("deleted");
            
            
            dir = req.getServletContext().getRealPath("/"+rui);
            File fil = new File(dir);
            
            String na = nick+ "_usr" + ext;
            InputStream ab = p.getInputStream(); 
            
            if(ab != null) {
                File img = new File(fil, na);
                dir = rui + na;
                Files.copy(ab, img.toPath());       
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return dir;
    }
    
    private String extencionValida(String fn) {
        String res = "";
        for(String es : ext) {
            if(fn.toLowerCase().endsWith(es)) {
                res = es;
                return res;
            }
        }
        return res;
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
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     DTUsuario dtU = (DTUsuario) request.getSession().getAttribute("usuario_logueado");
	     
	     String nombre = request.getParameter("Nombre");
	     String apellido = request.getParameter("Apellido");
	     String [] nac = request.getParameter("FechaNacimiento").split("-");
	     ICtrlUsuario ctrlUsr = Fabrica.getInstance().getICtrlUsuario();
	     
	     Part part     = request.getPart("nuevaImagenPerfil");
	     String fd = "";
	     if(part != null && !extencionValida(part.getSubmittedFileName()).isEmpty()) {
	         fd = guardarImg(part, request ,extencionValida(part.getSubmittedFileName()), dtU.getNickname());
	     }
	     
	     if(dtU instanceof DTTurista) {
	         ctrlUsr.actualizarUsuario(dtU.getNickname(), nombre, apellido, new GregorianCalendar(Integer.parseInt(nac[0]),Integer.parseInt(nac[1])-1, Integer.parseInt(nac[2])), fd, ((DTTurista)dtU).getNacionalidad(), "", "");
	         HandlerUsuarios hU = HandlerUsuarios.getInstance();
	         Turista t = hU.getTuristaByNickname(dtU.getNickname());
	         request.getSession().setAttribute("usuario_logueado", new DTTurista(t));
	     } else {
	         String descripcion = request.getParameter("Descripcion");
	         String link = request.getParameter("Link");
	         ctrlUsr.actualizarUsuario(dtU.getNickname(), nombre, apellido, new GregorianCalendar(Integer.parseInt(nac[0]),Integer.parseInt(nac[1])-1, Integer.parseInt(nac[2])), fd, "", descripcion, link);
	         HandlerUsuarios hU = HandlerUsuarios.getInstance();
             Proveedor p = hU.getProveedorByNickname(dtU.getNickname());
             request.getSession().setAttribute("usuario_logueado", new DTProveedor(p));
	     }
	     response.sendRedirect("consultaUsuario?STATE=INFO&&NICKNAME=" + dtU.getNickname());
	 }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
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
		      processRequest(request, response);
		  }
}
