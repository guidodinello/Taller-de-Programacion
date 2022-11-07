package webservices;

import java.util.GregorianCalendar;
import java.util.Set;

import excepciones.YaExisteException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.xml.ws.Endpoint;
import logica.interfaces.ICtrlActividad;
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
    public String[] listarCategorias(){
    	ICtrlActividad ctrlAct = Fabrica.getInstance().getICtrlActividad();
    	Set<String> lista = ctrlAct.listarCategorias();
    	String[] res = new String[lista.size()];
    	lista.toArray(res);
    	return res;
    }
    
    @WebMethod
    public String[] listarActividadesDepartamento(String depto) {
    	ICtrlActividad ctrlAct = Fabrica.getInstance().getICtrlActividad();
    	Set<String> listado = ctrlAct.listarActividadesDepartamento(depto);
    	String[] resu = new String[listado.size()];
    	listado.toArray(resu);
    	return resu;
    }
    
    @WebMethod
	public void altaSalidaTuristica(String nombreSal, GregorianCalendar fechaSal, String lugarSal, int cantMaxTuristas, 
			GregorianCalendar fechaAlta, String  actividad, String img) throws YaExisteException {
    	ICtrlActividad ctrlAct = Fabrica.getInstance().getICtrlActividad();
    	ctrlAct.altaSalidaTuristica(nombreSal, fechaSal, lugarSal, cantMaxTuristas, fechaAlta, actividad, img);
    }
}