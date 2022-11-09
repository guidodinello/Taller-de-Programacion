package webservices;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.GregorianCalendar;
import java.util.Set;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.xml.ws.Endpoint;
import logica.interfaces.ICtrlActividad;
import logica.interfaces.ICtrlUsuario;
import datatypes.tipoUsuario;
import excepciones.YaExisteException;
import logica.clases.Usuario;
import logica.handlers.HandlerUsuarios;
import logica.interfaces.Fabrica;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class WebServices {
	
	private Endpoint endpoint = null;
    //Constructor
    public WebServices(){}
    
    //Operaciones las cuales quiero publicar
    @WebMethod(exclude = true)
    public void publicar(){
         endpoint = Endpoint.publish("http://localhost:9128/webservices", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
            return endpoint;
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
    	ICtrlActividad ctrlAct = Fabrica.getInstance().getICtrlActividad();
    	Set<String> lista = ctrlAct.listarCategorias();
    	String[] res = new String[lista.size()];
    	lista.toArray(res);
    	return res;
    }
}