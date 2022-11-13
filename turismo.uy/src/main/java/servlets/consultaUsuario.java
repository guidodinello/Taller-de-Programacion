package servlets;


import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
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

import datatypes.DTActividad;
import webservices.DtActividad;
import webservices.DtProveedor;
import webservices.DtTurista;
import webservices.DtUsuario;
import net.java.dev.jaxb.array.StringArray;

@MultipartConfig
@WebServlet("/consultaUsuario")
public class consultaUsuario extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] ext = {".icon", ".png", ".jpg", ".jpeg"};
	/**
     * @see HttpServlet#HttpServlet()
     */
	public consultaUsuario() {
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
	
	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 * 
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	 protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     DtUsuario dtU = (DtUsuario) request.getSession().getAttribute("usuario_logueado");
	     
	     String nombre = request.getParameter("Nombre");
	     String apellido = request.getParameter("Apellido");
	     String [] nac = request.getParameter("FechaNacimiento").split("-");
	     //ICtrlUsuario ctrlUsr = Fabrica.getInstance().getICtrlUsuario();
	     
	   //Foto de perfil
	        Part p     = request.getPart("nuevaImagenPerfil");
	        byte [] fotoBin = null;  //guardar binario de la foto
	        if(p != null && !extencionValida(p.getSubmittedFileName()).isEmpty()) {
	            fotoBin = p.getInputStream().readAllBytes();
	        }
	     
	     if(dtU instanceof DtTurista) {
             webservices.WebServicesService service = new webservices.WebServicesService();
             webservices.WebServices port = service.getWebServicesPort();
             Date date = new Date(Integer.parseInt(nac[0]),Integer.parseInt(nac[1])-1,Integer.parseInt(nac[2]));
           //Create XMLGregorianCalendar
             GregorianCalendar c = new GregorianCalendar();

             c.setTime(date);
            
             XMLGregorianCalendar xCal = null;
            try {
                xCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            } catch (DatatypeConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
          //TODO change DTTurista to DtTurista 
            
           port.actualizarUsuario(dtU.getNickname(), nombre, apellido, xCal , fotoBin, extencionValida(p.getSubmittedFileName()), ((DtTurista)dtU).getNacionalidad(), "", "");
	        // ctrlUsr.actualizarUsuario(dtU.getNickname(), nombre, apellido, new GregorianCalendar(Integer.parseInt(nac[0]),Integer.parseInt(nac[1])-1, Integer.parseInt(nac[2])), fd, ((DTTurista)dtU).getNacionalidad(), "", "");
	        // HandlerUsuarios hU = HandlerUsuarios.getInstance();
	         //Turista t = hU.getTuristaByNickname(dtU.getNickname());
           
          DtTurista t =  port.getInfoTurista(dtU.getNickname());
	         request.getSession().setAttribute("usuario_logueado", t);
	     } else {
	         String descripcion = request.getParameter("Descripcion");
	         String link = request.getParameter("Link");
	         webservices.WebServicesService service = new webservices.WebServicesService();
             webservices.WebServices port = service.getWebServicesPort();
             Date date = new Date(Integer.parseInt(nac[0]),Integer.parseInt(nac[1])-1,Integer.parseInt(nac[2]));
             //Create XMLGregorianCalendar
               GregorianCalendar c = new GregorianCalendar();

               c.setTime(date);
              
               XMLGregorianCalendar xCal = null;
              try {
                  xCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
              } catch (DatatypeConfigurationException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
              }
             port.actualizarUsuario(dtU.getNickname(), nombre, apellido, xCal , fotoBin, extencionValida(p.getSubmittedFileName()), ((DtTurista)dtU).getNacionalidad(), "", "");
             
	       
             DtProveedor prov = port.getProveedorByNickname(dtU.getNickname());
             request.getSession().setAttribute("usuario_logueado", prov);
	     }
	     response.sendRedirect("consultaUsuario?STATE=INFO&&NICKNAME=" + dtU.getNickname());
	 }
	 
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
	            
		        Set<DtUsuario> usuariosRes = new HashSet<DtUsuario>();
		        webservices.WebServicesService service = new webservices.WebServicesService();
		        webservices.WebServices port = service.getWebServicesPort();
		        StringArray usuariosArray = port.listarUsuarios();
		        List<String> usuariosList = usuariosArray.getItem();
		        String[] usuarios = new String[usuariosList.size()];
		        usuarios = usuariosList.toArray(usuarios);
		        
		        for(int i = 0; i <usuarios.length; i++) {
		            usuariosRes.add(port.getInfoBasicaUsuario(usuarios[i]));
		        }
			
		        String estado;
		        if(request.getParameter("STATE") == null)
		            estado = "";
		        else
		            estado = request.getParameter("STATE");
		    switch (estado) {
		      case "LISTAR":
		        request.setAttribute("STATE", "LISTAR");
		        request.setAttribute("USUARIOS", usuariosRes);
		        request.getRequestDispatcher("/WEB-INF/consultaUsuario/consultaUsuario.jsp").forward(request,
		            response);
		        break;
		      case "INFO":
		        DtUsuario usuarioLogueado =
		            (DtUsuario) request.getSession().getAttribute("usuario_logueado");
		        String nombreUsuario = (String) request.getParameter("NICKNAME");
		        request.setAttribute("STATE", "INFO");
		        //no estoy logueada 
		        if(usuarioLogueado == null) {
		            request.setAttribute("PERFIL_USUARIO", (DtUsuario)
		                    port.getInfoBasicaUsuario(nombreUsuario));
		        }
		        //estoy logueada viendo otro perfil
		        else if(!usuarioLogueado.getNickname().equals(nombreUsuario)){
		        request.setAttribute("PERFIL_USUARIO", (DtUsuario)
                        port.getInfoBasicaUsuario(nombreUsuario));
		      
		        }
		        //estoy logueada viendo mi perfil
		        else{
		            request.setAttribute("MI_PERFIL_USUARIO", (DtUsuario)
                          port.getInfoBasicaUsuario(nombreUsuario));

		            
		           request.setAttribute("mis_actividades_finalizadas", 
		                   port.listarActividadesFinalizadas(nombreUsuario));
		           
		           DtActividad[] conf = port.listarActividadesConfirmadas(nombreUsuario);
		           DtActividad[] rechazadas = port.listarAgregadasRechazadas(nombreUsuario);
		           
		           DtActividad[] juntos = ArrayConcatUtil.concatWithCollection(conf, rechazadas); 
		           
		           request.setAttribute("mis_actividades_confirmadasYrechazadas", juntos);
		        }
		        request.getRequestDispatcher("/WEB-INF/consultaUsuario/consultaUsuario.jsp").forward(request,
		            response);
		        break;
		      default:
		        request.setAttribute("STATE", "DEFAULT");
		        request.getRequestDispatcher("/WEB-INF/error/error500.jsp").forward(request, response);
		    }
		  }

		  protected void doPost(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		      request.setCharacterEncoding("UTF-8");
		      processRequest(request, response);
		  }
}
