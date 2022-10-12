package servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
import model.datatypes.tipoUsuario;
import model.logica.clases.Proveedor;
import model.logica.clases.Usuario;

@MultipartConfig
@WebServlet("/altaUsuario")
public class altaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICtrlUsuario ctrlUsuario = Fabrica.getInstance().getICtrlUsuario();
	private String[] extencionesValidas = {".icon", ".png", ".jpg"};
	
	public altaUsuario() {
		super();
	}
	
	private String guardarImg(Part part, HttpServletRequest request) {
		String direccionImagen = "";
		
		try {
			
			String direccionArchivos = request.getServletContext().getRealPath("/assests/imgPerfilUsuario/");
			System.out.print(direccionArchivos);
			File uploads = new File(direccionArchivos);
			
			String nombreArchivo = request.getParameter("Nickname") + ".PNG";
			InputStream archivoBits = part.getInputStream(); 
			
			if(archivoBits != null) {
				File imagen = new File(uploads, nombreArchivo);
				direccionImagen = imagen.getAbsolutePath();
				Files.copy(archivoBits, imagen.toPath());		
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return direccionImagen;
	}
	
	private boolean extencionValida(String fileName) {
		for(String es : extencionesValidas) {
			if(fileName.toLowerCase().endsWith(es)) {
				return true;
			}
		}
		return false;
	}
	
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("usuario_logueado") != null) {
			response.sendRedirect("/home");
			return;
		}
		String nick     = request.getParameter("Nickname");
		String nomb     = request.getParameter("Nombre");
		String apell    = request.getParameter("Apellido");
		String email    = request.getParameter("Email");
		String [] fechaNac = request.getParameter("FechaNacimiento").split("-");
		String tipoUsu  = request.getParameter("TipoUsuario");
		String pass     = request.getParameter("Contrasenia");
		Part foto     = request.getPart("FotoPerfil");
		String fotoDireccion = "";
		
		if(foto != null) {
			if(extencionValida(foto.getSubmittedFileName())) {
				fotoDireccion = guardarImg(foto, request);
			}
		}
		try {
			if(tipoUsu.equals("Turista")) {
				String nacionalidad = request.getParameter("Nacionalidad");
				ctrlUsuario.altaUsuario(nick, email, nomb, apell, pass, new GregorianCalendar(Integer.parseInt(fechaNac[0]),Integer.parseInt(fechaNac[1])-1, Integer.parseInt(fechaNac[2])),fotoDireccion,tipoUsuario.turista, nacionalidad, "", "");
			}else {
				String desc = request.getParameter("Descripcion");
				String sitio = request.getParameter("LinkSitioWeb");
				ctrlUsuario.altaUsuario(nick, email, nomb, apell, pass, new GregorianCalendar(Integer.parseInt(fechaNac[0]),Integer.parseInt(fechaNac[1])-1, Integer.parseInt(fechaNac[2])),fotoDireccion, tipoUsuario.proveedor, "", desc, sitio);
			}
			response.sendRedirect("home");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
			request.getRequestDispatcher("/WEB-INF/altaUsuario/altaUsuario.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		processRequest(req, resp);

	}
	
}
