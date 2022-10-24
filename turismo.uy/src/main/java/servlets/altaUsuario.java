package servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.logica.interfaces.ICtrlUsuario;
import model.logica.interfaces.Fabrica;
import model.datatypes.DTUsuario;
import model.datatypes.tipoUsuario;

@MultipartConfig
@WebServlet("/altaUsuario")
public class altaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICtrlUsuario ctrlUsuario = Fabrica.getInstance().getICtrlUsuario();
	private String[] ext = {".icon", ".png", ".jpg", ".jpeg"};
	private String udi = "media/imagenes/usuarioPerfil.png";
	private String rui = "media/imagenes/";
	
	public altaUsuario() {
		super();
	}
	
    private String guardarImg(Part p, HttpServletRequest req, String ext) {
        String dir = udi;
        try {
            /*Si existe un archivo con el mismo nombre lo eliminamos*/
            File file = new File(req.getServletContext().getRealPath("/"+rui)+"/"+req.getParameter("Nickname")+ "_usr" +ext);
            if(file.delete())
                System.out.println("deleted");
            
            
            dir = req.getServletContext().getRealPath("/"+rui);
            File fil = new File(dir);
            
            String na = req.getParameter("Nickname")+ "_usr" + ext;
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
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
		HttpSession ses = request.getSession();
		if(ses.getAttribute("usuario_logueado") != null) {
			response.sendRedirect("index");
			return;
		}
		String nic     = request.getParameter("Nickname");
		String nom     = request.getParameter("Nombre");
		String ape    = request.getParameter("Apellido");
		String ema    = request.getParameter("Email");
		String [] nac = request.getParameter("FechaNacimiento").split("-");
		String tU  = request.getParameter("TipoUsuario");
		String pas     = request.getParameter("Contrasenia");
		//Foto de perfil
		Part p     = request.getPart("FotoPerfil");
		String fd = udi;  //para guardar la direccion;
		
		if(p != null && !extencionValida(p.getSubmittedFileName()).isEmpty()) {
		    fd = guardarImg(p, request ,extencionValida(p.getSubmittedFileName()));
		}
		
		try {
			if(tU.equals("Turista")) {
				String nacionalidad = request.getParameter("Nacionalidad");
				ctrlUsuario.altaUsuario(nic, ema, nom, ape, pas, new GregorianCalendar(Integer.parseInt(nac[0]),Integer.parseInt(nac[1])-1, Integer.parseInt(nac[2])), fd,tipoUsuario.turista, nacionalidad, "", "");
			}else {
				String des = request.getParameter("Descripcion");
				String web = request.getParameter("LinkSitioWeb");
				ctrlUsuario.altaUsuario(nic, ema, nom, ape, pas, new GregorianCalendar(Integer.parseInt(nac[0]),Integer.parseInt(nac[1])-1, Integer.parseInt(nac[2])), fd, tipoUsuario.proveedor, "", des, web);
			}
		    DTUsuario usr = Fabrica.getInstance().getICtrlUsuario().getInfoBasicaUsuario(nic);
            ses.setAttribute("usuario_logueado", usr);
			response.sendRedirect("index?exito=Usuario registrado correctamente");
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("UsuarioYaExiste", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/altaUsuario/altaUsuario.jsp").forward(request, response);
		}
	
	}
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException ,IOException {
			req.getRequestDispatcher("/WEB-INF/altaUsuario/altaUsuario.jsp").forward(req, res);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException ,IOException {
	    req.setCharacterEncoding("UTF-8");
		processRequest(req, res);

	}
	
}