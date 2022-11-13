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
import webservices.DtUsuario;
import model.logica.interfaces.Fabrica;
import model.datatypes.DTUsuario;
import model.datatypes.tipoUsuario;

@MultipartConfig
@WebServlet("/altaUsuario")
public class altaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICtrlUsuario ctrlUsuario = Fabrica.getInstance().getICtrlUsuario();
	private String[] ext = {".icon", ".png", ".jpg", ".jpeg"};
	
	public altaUsuario() {
		super();
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
	    webservices.WebServicesService service = new webservices.WebServicesService();
	    webservices.WebServices port = service.getWebServicesPort();
		if(ses.getAttribute("usuario_logueado") != null) {
			response.sendRedirect("index");
			return;
		}
		 
		String nic     = request.getParameter("Nickname");
		String nom     = request.getParameter("Nombre");
		String ape    = request.getParameter("Apellido");
		String ema    = request.getParameter("Email");
		String nac = request.getParameter("FechaNacimiento");
		String tU  = request.getParameter("TipoUsuario");
		String pas     = request.getParameter("Contrasenia");
		//Foto de perfil
		Part p     = request.getPart("FotoPerfil");
		byte [] fotoBin = null;  //guardar binario de la foto
		if(p != null && !extencionValida(p.getSubmittedFileName()).isEmpty()) {
		    fotoBin = p.getInputStream().readAllBytes();
		}
		
		try {
			if(tU.equals("Turista")) {
			    String nacionalidad = request.getParameter("Nacionalidad");
                port.altaUsuario(nic, ema, nom, ape, pas, nac, fotoBin, extencionValida(p.getSubmittedFileName()), "Turista", nacionalidad, "", "");
			}else {
				String des = request.getParameter("Descripcion");
				String web = request.getParameter("LinkSitioWeb");
				port.altaUsuario(nic, ema, nom, ape, pas, nac, fotoBin, extencionValida(p.getSubmittedFileName()), "Turista", "", des, web);
			}
		    DtUsuario usr = port.getUsuarioByNickName(nic);
            ses.setAttribute("usuario_logueado", usr);
			response.sendRedirect("index?exito=Usuario registrado correctamente");
			
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("UsuarioYaExiste", e.getMessage());
			request.getRequestDispatcher("/WEB-INF/altaUsuario/altaUsuario.jsp").forward(request, response);
		}
	
	}
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException ,IOException {
	       webservices.WebServicesService service = new webservices.WebServicesService();
	       webservices.WebServices port = service.getWebServicesPort();
	       if(req.getParameter("existe") != null) {
	            boolean existe = port.existeUsuarioNick(req.getParameter("existe"));
	            boolean existe2 = port.existeUsuarioEmail(req.getParameter("existe"));
	            if(existe || existe2) {
	                res.sendError(400);
	            }
	            return;
	        }
			req.getRequestDispatcher("/WEB-INF/altaUsuario/altaUsuario.jsp").forward(req, res);
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException ,IOException {
	    req.setCharacterEncoding("UTF-8");
		processRequest(req, res);

	}
	
}