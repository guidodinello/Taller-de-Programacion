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
import javax.servlet.ServletOutputStream;
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
import model.datatypes.DTUsuario;
import model.datatypes.tipoUsuario;
import model.logica.clases.Proveedor;
import model.logica.clases.Usuario;

@WebServlet("/imagen")
public class imagen extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ICtrlUsuario ctrlUsuario = Fabrica.getInstance().getICtrlUsuario();
    private String[] extencionesValidas = {".icon", ".png", ".jpg"};
    
    public imagen() {
        super();
    }
    
    
    private void mostrarIMG(HttpServletRequest request, HttpServletResponse response, byte [] bytes) {
        response.resetBuffer();
        ServletOutputStream outputStream =null;
        BufferedOutputStream bufferedOutputStream =null;
        response.setContentType("image/*");
        try {
            outputStream = response.getOutputStream();
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.write(bytes);

            response.flushBuffer();
            bufferedOutputStream.flush();
            outputStream.flush();
            bufferedOutputStream.close();
            outputStream.close();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
        String nick = request.getParameter("nick");
        String nombreAct = request.getParameter("nombreAct");
        System.out.print(nombreAct);
        
        if(nick != null) {
            DTUsuario usr = ctrlUsuario.getInfoBasicaUsuario(nick);
            mostrarIMG(request, response, usr.getImg());
        }

        
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
        System.out.println("get IMG");
            processRequest(request, response);
    }
    
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
        System.out.println("post IMG");
        processRequest(req, resp);

    }
    
}