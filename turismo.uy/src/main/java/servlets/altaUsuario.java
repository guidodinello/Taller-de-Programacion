package servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import excepciones.YaExisteException;
import model.logica.interfaces.ICtrlUsuario;
import model.logica.interfaces.Fabrica;
import model.logica.clases.Turista;
import model.datatypes.DTProveedor;
import model.datatypes.DTTurista;
import model.datatypes.DTUsuario;
import model.datatypes.tipoUsuario;
import model.logica.clases.Proveedor;
import model.logica.clases.Usuario;

@MultipartConfig
@WebServlet("/altaUsuario")
public class altaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICtrlUsuario ctrlUsuario = Fabrica.getInstance().getICtrlUsuario();
	private String[] ext = {".icon", ".png", ".jpg"};
	
	public altaUsuario() {
		super();
	}
	
    private String guardarImg(Part p, HttpServletRequest req, String ext) {
        String dir = "media/imagenes/usuarioPerfil.png";
        
        try {
            
            dir = req.getServletContext().getRealPath(/media/imagenes/);
            dir = dir +"/media/imagenes/";
            File uploads = new File(dir);
            
            String na = req.getParameter("Nickname") + ext;
            InputStream ab = p.getInputStream(); 
            
            if(ab != null) {
                File img = new File(uploads, na);
                dir = "media/imagnes/"+na;
                Files.copy(ab, img.toPath());       
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return dir;
    }


	
	private String extencionValida(String fn) {
	    String resultado = "";
		for(String es : ext) {
			if(fn.toLowerCase().endsWith(es)) {
			    resultado = es;
				return resultado;
			}
		}
		return resultado;
	}
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("usuario_logueado") != null) {
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
		String fd = "media/imagenes/usuarioPerfil.png";  //para guardar la direccion;
		
		if(!extencionValida(p.getSubmittedFileName()).isEmpty()) {
		    fd = guardarImg(p, request ,extencionValida(p.getSubmittedFileName()));
		}
		
		
		try {
			if(tU.equals("Turista")) {
				String nacionalidad = request.getParameter("Nacionalidad");
				ctrlUsuario.altaUsuario(nic, ema, nom, ape, pas, new GregorianCalendar(Integer.parseInt(nac[0]),Integer.parseInt(nac[1])-1, Integer.parseInt(nac[2])), fd,tipoUsuario.turista, nacionalidad, "", "");
			}else {
				String desc = request.getParameter("Descripcion");
				String sitio = request.getParameter("LinkSitioWeb");
				ctrlUsuario.altaUsuario(nic, ema, nom, ape, pas, new GregorianCalendar(Integer.parseInt(nac[0]),Integer.parseInt(nac[1])-1, Integer.parseInt(nac[2])), fd, tipoUsuario.proveedor, "", desc, sitio);
			}
		    DTUsuario newUsr = Fabrica.getInstance().getICtrlUsuario().getInfoBasicaUsuario(nic);
            session.setAttribute("usuario_logueado", newUsr);
			response.sendRedirect("index");
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("fail", true);
			request.getRequestDispatcher("/WEB-INF/altaUsuario/altaUsuario.jsp").forward(request, response);
		}
	
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
	        request.setAttribute("fail", false);
			request.getRequestDispatcher("/WEB-INF/altaUsuario/altaUsuario.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		processRequest(req, resp);

	}
	
}