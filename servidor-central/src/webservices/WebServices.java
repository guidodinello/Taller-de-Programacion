package webservices;

import java.util.GregorianCalendar;
import java.util.Set;

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
         endpoint = Endpoint.publish("http://localhost:9128/webservices", this);
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
    public DTProveedor getDTProveedor() {
    	return new DTProveedor();
    }
}