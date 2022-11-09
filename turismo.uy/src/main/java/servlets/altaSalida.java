package servlets;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import excepciones.YaExisteException;
import model.datatypes.DTActividad;
import model.datatypes.estadoActividad;
import model.logica.interfaces.Fabrica;
import model.logica.interfaces.ICtrlActividad;
import webservices.DtActividad;
import webservices.EstadoActividad;
import webservices.YaExisteException_Exception;


/**
 * Servlet implementation class altaSalida
 */
@MultipartConfig
@WebServlet("/altaSalida")
public class altaSalida extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICtrlActividad iA = Fabrica.getInstance().getICtrlActividad();
	private String[] ext = {".icon", ".png", ".jpg", ".jpeg"};
    private String udi = "media/imagenes/salDefault.png";
    private String rui = "media/imagenes/";
    webservices.WebServicesService service = new webservices.WebServicesService();
    webservices.WebServices port = service.getWebServicesPort();
    
    
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
    
    
    protected void cargarActividades(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {        
        List<String> nomAct = port.listarActividadesDepartamento(request.getParameter("nombreDep")).getItem();
        Set<String> nomActCon = new HashSet<String>();
        for(String act : nomAct) {
            DtActividad actual = port.getInfoActividad(act);
            if(actual.getEstado() == EstadoActividad.CONFIRMADA)
                nomActCon.add(actual.getNombre());
        }
        request.setAttribute("nombreDep", request.getParameter("nombreDep"));

        request.setAttribute("listaAct", nomActCon);
        request.getRequestDispatcher("/WEB-INF/altaSalida/altaSalida.jsp").forward(request, response);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setAttribute("fail", false);
        
	    List<String> deptos = port.listarDepartamentos().getItem();
	    request.setAttribute("listadoDepartamentos", deptos);
	    
	    if(request.getParameter("nombreDep") != null) {
	       cargarActividades(request, response);
	    } else {
	        request.getRequestDispatcher("/WEB-INF/altaSalida/altaSalida.jsp").forward(request, response);
	    }
	}

	/**
	 * @throws YaExisteException_Exception 
	 * @throws DatatypeConfigurationException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException, YaExisteException_Exception, DatatypeConfigurationException {
        String actividad = request.getParameter("actividad");
        String nombre = request.getParameter("nombre");
        
        String[] setFecha = request.getParameter("fechaNuevaYUnica").split("-");
        Integer hora = Integer.parseInt(request.getParameter("hora")); 
        GregorianCalendar fecha = new GregorianCalendar(Integer.parseInt(setFecha[0]), Integer.parseInt(setFecha[1])-1, Integer.parseInt(setFecha[2]), hora, 0);
        
        GregorianCalendar fechaDelDia = new GregorianCalendar();
        
        //paso a XMLGregorianCalendar
        XMLGregorianCalendar xmlFecha= DatatypeFactory.newInstance().newXMLGregorianCalendar(fecha);
        XMLGregorianCalendar xmlFechaDelDia= DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaDelDia);
        
        String lugar = request.getParameter("lugar");
        Integer cantMaxTur = Integer.parseInt(request.getParameter("cantMaxTur"));        
        
      //Con esto agregas la imagen
        String fd = udi;
        Part p = request.getPart("fotoDeLaSalida"); //aca solo es poner el nombre de donde te viene la foto del form el file y listo fd es el string que pasas
        
        if(p != null && !extencionValida(p.getSubmittedFileName()).isEmpty()) {
            fd = guardarImg(p, request ,extencionValida(p.getSubmittedFileName()));
        }
        
        try {
            port.altaSalidaTuristica(nombre, xmlFecha, lugar, cantMaxTur, xmlFechaDelDia, actividad, fd);
            request.setAttribute("exito", "Has registrado con exito la salida: " + nombre);
            request.getRequestDispatcher("/index").forward(request, response);
        }catch(YaExisteException_Exception e) {
            e.printStackTrace();
            request.setAttribute("SalidaFailedError", e.getMessage());
            List<String> deptos = port.listarDepartamentos().getItem();
            request.setAttribute("listadoDepartamentos", deptos);
            request.getRequestDispatcher("/WEB-INF/altaSalida/altaSalida.jsp").forward(request, response);
        }
	}
	   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		try {
            processRequest(request, response);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (YaExisteException_Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (DatatypeConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
