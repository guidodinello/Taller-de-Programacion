package webservices;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.GregorianCalendar;
import java.util.Set;

import com.itextpdf.text.DocumentException;

import excepciones.CompraFailException;
import excepciones.InscriptionFailException;
import excepciones.YaExisteException;
import datatypes.DTActividad;
import datatypes.DTPaquete;
import datatypes.DTProveedor;
import datatypes.DTSalida;
import datatypes.DTTurista;
import datatypes.DTUsuario;
import datatypes.tipoInscripcion;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.xml.ws.Endpoint;
import logica.interfaces.ICtrlActividad;
import logica.interfaces.ICtrlUsuario;
import datatypes.tipoUsuario;
import logica.clases.ComprobanteInscripcion;
import logica.clases.Configuracion;
import logica.clases.Proveedor;
import logica.clases.Usuario;
import logica.handlers.HandlerUsuarios;
import logica.interfaces.Fabrica;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class WebServices {
  ICtrlActividad ctrlAct = Fabrica.getInstance().getICtrlActividad();
  ICtrlUsuario ctrlUsr = Fabrica.getInstance().getICtrlUsuario();
	
	private Endpoint endpoint = null;
    //Constructor
    public WebServices(){}
    
    //Operaciones las cuales quiero publicar
    @WebMethod(exclude = true)
    public void publicar(){
    	Configuracion config = Configuracion.getInstance();
    	endpoint = Endpoint.publish(config.getPublishURL(), this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
    }
    
    @WebMethod(exclude = true)
    public String[] setToArray(Set<String> set) {
      return set.toArray(new String[set.size()]);
    }
    
    @WebMethod
    public void altaUsuario(String nic, String ema, String nomb, String ape, String pas, String nac, byte [] fotoBin, String ext , String tipo, String nacionalidad, String descripcion, String sitioWeb) throws Exception {
    	ICtrlUsuario ctrlUsuario = Fabrica.getInstance().getICtrlUsuario();
    	String [] fechaNac = nac.split("-");
    	String fotoDireccion = "media/imagenes/usuarioPerfil.png";
    	if (fotoBin != null) {
    		 try {
    			 String dir ="./files" + nic +"_usr" + ext;
    	         /*Si existe un archivo con el mismo nombre lo eliminamos*/
    	         File file = new File(dir);
    	         if(file.delete())
    	        	 System.out.println("deleted");
    	         File img = new File(dir);
    	         Files.write(img.toPath(), fotoBin);
    		 }catch (Exception e) {
    			 e.printStackTrace();
    	     }
    		 fotoDireccion = "imagen?usr=" + nic;
    	}
    	try {
    		if(tipo.equals("Turista")) {
    			ctrlUsuario.altaUsuario(nic, ema, nomb, ape, pas, new GregorianCalendar(Integer.parseInt(fechaNac[0]),Integer.parseInt(fechaNac[1])-1, Integer.parseInt(fechaNac[2])), fotoDireccion ,tipoUsuario.turista, nacionalidad, "", "");
    		}else {
    			ctrlUsuario.altaUsuario(nic, ema, nomb, ape, pas, new GregorianCalendar(Integer.parseInt(fechaNac[0]),Integer.parseInt(fechaNac[1])-1, Integer.parseInt(fechaNac[2])), fotoDireccion, tipoUsuario.proveedor, "", descripcion, sitioWeb);
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    		throw e;
    	}

    	
    }
    
    @WebMethod
    public boolean existeUsuario(String nick) {
    	Usuario usuario = HandlerUsuarios.getInstance().getUsuarioByNickname(nick);
    	if(usuario == null) {
    		return false;
    	}
    	return true;
    }
    
    @WebMethod
    public byte [] getFileImg(String filename) {
    	try {
        	File img = new File("./files/" + filename);
        	FileInputStream streamer = new FileInputStream(img);
        	byte [] byteArray = new byte[streamer.available()];
            streamer.read(byteArray);
        	return byteArray;
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }
    
    @WebMethod
    public String[] listarCategorias(){
    	return setToArray(ctrlAct.listarCategorias());
    }
    
    @WebMethod
    public String[] listarDepartamentos(){
      return setToArray(ctrlAct.listarDepartamentos());
    }
    
    @WebMethod
    public String[] listarActividadesDepartamento(String depto) {
    	return setToArray(ctrlAct.listarActividadesDepartamento(depto));
    }
    
    @WebMethod
    public String[] listarPaquetesCategoria(String categoria) {
      return setToArray(ctrlAct.listarPaquetesCategoria(categoria));
    }
    
    @WebMethod
    public String[] listarPaquetes() {
      return setToArray(ctrlAct.listarPaquetes());
    }
    
    @WebMethod
    public String[] listarActividadesConfirmadas() {
      return setToArray(ctrlAct.listarActividadesConfirmadas());
    }
    
    @WebMethod
	public void altaSalidaTuristica(String nombreSal, GregorianCalendar fechaSal, String lugarSal, int cantMaxTuristas, 
			GregorianCalendar fechaAlta, String  actividad, String img) throws YaExisteException {
    	ctrlAct.altaSalidaTuristica(nombreSal, fechaSal, lugarSal, cantMaxTuristas, fechaAlta, actividad, img);
    }
    
    @WebMethod
    public DTPaquete getInfoPaquete(String paq) {
    	return ctrlAct.getInfoPaquete(paq);
    }
    
    @WebMethod
    public DTActividad getInfoActividad(String actividad) {
    	return ctrlAct.getInfoActividad(actividad);
    }
    
    @WebMethod
    public DTSalida getInfoCompletaSalida(String salida) {
    	return ctrlAct.getInfoCompletaSalida(salida);
    }
    
    @WebMethod
    public DTUsuario getUsuarioByEmail(String email) {
      return ctrlUsr.getUsuarioByEmail(email);
    }
    
    @WebMethod
    public DTUsuario getUsuarioByNickName(String nickname) {
      return ctrlUsr.getUsuarioByNickName(nickname);
    }
    
    @WebMethod
    public boolean verifiedUserPassword(String usrNick, String attemptedPass) {
      return ctrlUsr.verifiedUserPassword(usrNick, attemptedPass);
    }
    
    @WebMethod
    public void ingresarCompra(String nickname, String paq, int cantTuristas, GregorianCalendar fechaCompra) throws CompraFailException {
    	ctrlUsr.ingresarCompra(nickname, paq, cantTuristas, fechaCompra);
    }
    
    @WebMethod
    public DTSalida[] listarInfoSalidasVigentes(String actividad, GregorianCalendar fecha){
    	Set<DTSalida> set = ctrlAct.listarInfoSalidasVigentes(actividad, fecha);
    	return set.toArray(new DTSalida[set.size()]);
    }
    
    @WebMethod
    public void ingresarInscripcion(String nickname, String salida, int cantTuristas, GregorianCalendar fecha, tipoInscripcion tipo, String paquete) throws InscriptionFailException {
    	ctrlUsr.ingresarInscripcion(nickname, salida, cantTuristas, fecha, tipo, paquete);
    }
    
    @WebMethod
    public DTTurista getDTTurista() {
    	return new DTTurista();
    }
        @WebMethod
    public 	DTActividad [] listarInfoCompletaActividadesProveedor(String nickname) {
    	Set<DTActividad>  actividades =  ctrlUsr.listarInfoCompletaActividadesProveedor(nickname);
    	int arraySize =actividades.size();
    	DTActividad[] actividadesArray = new DTActividad[arraySize];
    	actividadesArray = actividades.toArray(actividadesArray);
    	return actividadesArray;
    	
    }
        @WebMethod
    public DTUsuario getInfoBasicaUsuario(String usr) {
    	DTUsuario  usuario =  ctrlUsr.getInfoBasicaUsuario(usr) ;
    	return usuario;
    }
    @WebMethod
    public DTSalida []  listarInfoSalidasTurista(String nickname) {
    	Set<DTSalida>  salidas =  ctrlUsr.listarInfoSalidasTurista(nickname);
    	int arraySize =salidas.size();
    	DTSalida[] salidasArray = new DTSalida[arraySize];
    	salidasArray = salidas.toArray(salidasArray);
    	return salidasArray;
    	
    }
       @WebMethod
    public String[] listarUsuarios() {
    	Set<String > usuarios =  ctrlUsr.listarUsuarios();
    	int arraySize = usuarios.size();
    	String[] usuariosArray = new String[arraySize];
    	usuariosArray = usuarios.toArray(usuariosArray);
    	return usuariosArray;
    }
      @WebMethod
    public DTTurista getInfoTurista(String nickname) {
    	DTTurista turista = (DTTurista) ctrlUsr.getInfoBasicaUsuario(nickname);
    	return turista;
    }
     @WebMethod
    public void  actualizarUsuario(String nickname,String nombre,String apellido, GregorianCalendar date,String photo , String nacionalidad,String descripcion,String sitioWeb) {
    	
    	ctrlUsr.actualizarUsuario(nickname, nombre, apellido, date, photo, nacionalidad, "", "");
	       
    }
    @WebMethod
    public DTProveedor getProveedorByNickname(String nickname) {
    	HandlerUsuarios hU = HandlerUsuarios.getInstance();
    	Proveedor p = hU.getProveedorByNickname(nickname);
    	DTProveedor proveedor = new DTProveedor(p);
    	return proveedor;
    }
    
    @WebMethod
    public byte[] getFilePdf(String usuario, String salida) throws DocumentException, IOException {
    	byte[] res = ctrlUsr.obtenerComprobanteInscripcion(usuario, salida);
    	return res;
    }
    
}
