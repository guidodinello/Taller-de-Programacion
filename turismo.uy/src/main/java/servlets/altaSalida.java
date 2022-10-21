package servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.logica.interfaces.Fabrica;
import model.logica.interfaces.ICtrlActividad;


/**
 * Servlet implementation class altaSalida
 */
@WebServlet("/altaSalida")
public class altaSalida extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICtrlActividad iA = Fabrica.getInstance().getICtrlActividad();
	private String[] ext = {".icon", ".png", ".jpg"};
    private String udi = "media/imagenes/salDefault.png";
    private String rui = "media/imagenes/";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public altaSalida() {
        super();
    }

    private String guardarImg(Part p, HttpServletRequest req, String ext) {
        String dir = udi;
        try {
            String na = req.getParameter("nombre")+ "_sal" + ext; //nombre del archivo
            
            /*Si existe un archivo con el mismo nombre lo eliminamos*/
            File file = new File(req.getServletContext().getRealPath("/"+rui)+"/"+ na);
            System.out.println(file);
            if(file.delete())
                System.out.println("deleted");
            
            
            dir = req.getServletContext().getRealPath("/"+rui);
            File fil = new File(dir);
            
            
            InputStream ab = p.getInputStream(); 
            System.out.println(dir);
            
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
        Set<String> nomAct = iA.listarActividadesDepartamento(request.getParameter("nombreDep"));
        
        /*
         Con esto agregas la imagen
        String fd = udi;
        Part p = req.getPart("ImagenActividad"); //aca solo es poner el nombre de donde te viene la foto del form el file y listo fd es el string que pasas
        
        if(!extencionValida(p.getSubmittedFileName()).isEmpty()) {
            fd = guardarImg(p, req ,extencionValida(p.getSubmittedFileName()));
        }
       */
        
        
        request.setAttribute("listaAct", nomAct);
        request.getRequestDispatcher("/WEB-INF/altaSalida/altaSalida.jsp").forward(request, response);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setAttribute("fail", false);
	    
	    if(request.getParameter("nombreDep") != null) {
	       processRequest(request, response);
	    } else {
	        request.getRequestDispatcher("/WEB-INF/altaSalida/altaSalida.jsp").forward(request, response);

	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
