package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import excepciones.YaExisteException;
import model.logica.interfaces.ICtrlActividad;
import model.logica.interfaces.Fabrica;
import model.datatypes.estadoActividad;
import model.datatypes.DTProveedor;


@MultipartConfig
@WebServlet("/altaActividad")
public class altaActividad extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ICtrlActividad ctrlAct = Fabrica.getInstance().getICtrlActividad();
    private String[] extencionesValidas = {".icon", ".png", ".jpg"};
    
    public altaActividad() {
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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
        HttpSession session = request.getSession();
        DTProveedor prov = (DTProveedor) session.getAttribute("usuario_logueado");
        
        String departamento = request.getParameter("Departamento");
        String nombre = request.getParameter("Nombre");
        String descripcion = request.getParameter("Descripcion");
        int duracion = Integer.parseInt(request.getParameter("Duracion"));
        float costo = Float.parseFloat(request.getParameter("Costo"));
        String ciudad = request.getParameter("Ciudad");
        Set<String> categorias = new HashSet<String>(Arrays.asList(request.getParameterValues("Categorias")));
        
        System.out.println(categorias);
        
        
        //Foto de la actividad
        InputStream inputStreamFoto = null;
        String imgDir = "";
        byte [] imgBin = null;
        Part foto = request.getPart("ImagenActividad");
        
        if(foto.getInputStream() != null) {
            
            if(!extencionValida(foto.getSubmittedFileName()).isEmpty()) {
                inputStreamFoto = guardarImgBin(foto, request);
                imgBin = inputStreamFoto.readAllBytes();
                imgDir = "imagen?nombreAct="+nombre;
                
            }else {
                imgDir = "media/imagenes/actDefault.jpg";
                
            }
        }
        
        try {
            ctrlAct.altaActividadTuristica(departamento, nombre, descripcion, duracion, costo, ciudad, prov.getNickname(), new GregorianCalendar(), imgDir, imgBin, categorias, estadoActividad.agregada);
        } catch(YaExisteException e) {
            e.printStackTrace();
            request.setAttribute("fail", true);
            request.getRequestDispatcher("/WEB-INF/actividad/altaActividad.jsp").forward(request, response);
        }
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
        HttpSession session = request.getSession();
        
        if(!(session.getAttribute("usuario_logueado") instanceof DTProveedor)) {
            response.sendRedirect("index");
            return;
        }
        
        request.setAttribute("listaDepartamentos", ctrlAct.listarDepartamentos());
        request.setAttribute("listaCategorias", ctrlAct.listarCategorias());
        
        request.setAttribute("fail", false);
        request.getRequestDispatcher("/WEB-INF/actividad/altaActividad.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
        processRequest(request, response);
    }
}