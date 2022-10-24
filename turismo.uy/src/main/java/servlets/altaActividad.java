package servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
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
    private String[] ext = {".icon", ".png", ".jpg", ".jpeg"};
    private String udi = "media/imagenes/actDefault.jpg";
    private String rui = "media/imagenes/";
    
    public altaActividad() {
        super();
    }
    
    private String guardarImg(Part p, HttpServletRequest req, String ext) {
        String dir = udi;
        try {
            String na = req.getParameter("Nombre")+ "_act" + ext; //nombre del archivo
            
            /*Si existe un archivo con el mismo nombre lo eliminamos*/
            File file = new File(req.getServletContext().getRealPath("/"+rui)+"/"+ na);
            if(file.delete())
                System.out.println("deleted");
            
            
            dir = req.getServletContext().getRealPath("/"+rui);
            File fil = new File(dir);
            
            
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
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException ,IOException {
        HttpSession ses = req.getSession();
        DTProveedor prov = (DTProveedor) ses.getAttribute("usuario_logueado");
        
        String dpt =(String) req.getParameter("Departamento");
        String nom =(String) req.getParameter("Nombre");
        String des =(String) req.getParameter("Descripcion");
        int dhs = Integer.parseInt(req.getParameter("Duracion"));
        float cos = Float.parseFloat(req.getParameter("Costo"));
        String ciu = req.getParameter("Ciudad");
        Set<String> cat = new HashSet<String>(Arrays.asList(req.getParameterValues("Categorias")));
       
        //Foto de la actividad
        String fd = udi;
        Part p = req.getPart("ImagenActividad");
        
        if(p !=null && !extencionValida(p.getSubmittedFileName()).isEmpty()) {
            fd = guardarImg(p, req ,extencionValida(p.getSubmittedFileName()));
        }
        
        try {
            ctrlAct.altaActividadTuristica(dpt, nom, des, dhs, cos, ciu, prov.getNickname(), new GregorianCalendar(), fd, cat, estadoActividad.agregada);
            req.setAttribute("exito", "La actividad "+ nom + " se ha dado de alta exitosamente");
            req.getRequestDispatcher("/index").forward(req, res);
        } catch(YaExisteException e) {
            e.printStackTrace();
            req.setAttribute("AltaYaExiste", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/actividad/altaActividad.jsp").forward(req, res);
        }
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
        HttpSession ses = request.getSession();
        
        if(!(ses.getAttribute("usuario_logueado") instanceof DTProveedor)) {
            response.sendRedirect("index");
            return;
        } else {
        request.setAttribute("listaDepartamentos", ctrlAct.listarDepartamentos());
        request.setAttribute("listaCategorias", ctrlAct.listarCategorias());
        
        request.getRequestDispatcher("/WEB-INF/actividad/altaActividad.jsp").forward(request, response);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("listaDepartamentos", ctrlAct.listarDepartamentos());
        request.setAttribute("listaCategorias", ctrlAct.listarCategorias());
        processRequest(request, response);
    }
}