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
	private String[] extencionesValidas = {".icon", ".png", ".jpg"};
	
	public altaUsuario() {
		super();
	}
	
	private InputStream guardarImgBin(Part part, HttpServletRequest request) {
		try {
			InputStream archivoBits = part.getInputStream();
			if(archivoBits != null) {
			    return archivoBits;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String extencionValida(String fileName) {
	    String resultado = "";
		for(String es : extencionesValidas) {
			if(fileName.toLowerCase().endsWith(es)) {
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
		String nick     = request.getParameter("Nickname");
		String nomb     = request.getParameter("Nombre");
		String apell    = request.getParameter("Apellido");
		String email    = request.getParameter("Email");
		String [] fechaNac = request.getParameter("FechaNacimiento").split("-");
		String tipoUsu  = request.getParameter("TipoUsuario");
		String pass     = request.getParameter("Contrasenia");
		//Foto de perfil
		Part foto     = request.getPart("FotoPerfil");
		InputStream inputStreamFoto = null; //para guardar el binario;
		byte [] fotoBin = null;
		String fotoDir = ""; //para guardar la direccion;
		
		if(foto.getInputStream() != null) {
		    System.out.println(foto.getInputStream());
			if(!extencionValida(foto.getSubmittedFileName()).isEmpty()) {
			    inputStreamFoto = guardarImgBin(foto, request);
			    fotoBin = inputStreamFoto.readAllBytes();
				fotoDir = "imagen?nick="+nick;
				System.out.println("entra if");
			}else {
			    fotoDir = "media/imagenes/usuarioPerfil.png";
			    System.out.println("entra else");
			}
		}
		try {
			if(tipoUsu.equals("Turista")) {
				String nacionalidad = request.getParameter("Nacionalidad");
				ctrlUsuario.altaUsuario(nick, email, nomb, apell, pass, new GregorianCalendar(Integer.parseInt(fechaNac[0]),Integer.parseInt(fechaNac[1])-1, Integer.parseInt(fechaNac[2])), fotoDir, fotoBin ,tipoUsuario.turista, nacionalidad, "", "");
			}else {
				String desc = request.getParameter("Descripcion");
				String sitio = request.getParameter("LinkSitioWeb");
				ctrlUsuario.altaUsuario(nick, email, nomb, apell, pass, new GregorianCalendar(Integer.parseInt(fechaNac[0]),Integer.parseInt(fechaNac[1])-1, Integer.parseInt(fechaNac[2])), fotoDir, fotoBin, tipoUsuario.proveedor, "", desc, sitio);
			}
		    DTUsuario newUsr = Fabrica.getInstance().getICtrlUsuario().getInfoBasicaUsuario(nick);
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