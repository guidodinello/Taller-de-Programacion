package logica.controladores;
import excepciones.YaExisteException;
import logica.clases.Departamento;
import logica.handlers.HandlerDepartamentos;
import logica.handlers.HandlerActividades;
import logica.clases.ActividadTuristica;
import logica.interfaces.*;
import java.util.Date;
import java.util.Set;
import logica.clases.SalidaTuristica;
import datatypes.DTActividad;
import datatypes.DTPaquete;
import datatypes.DTSalida;
import logica.handlers.HandlerSalidas;

public class CtrlActividad implements ICtrlActividad{
	
	
	public void altaDepartamento(String nombreDepartamento,String descripcion ,String URL) throws YaExisteException{
		HandlerDepartamentos hD = HandlerDepartamentos.getInstance();
		if(hD.existeDepartamento(nombreDepartamento)){
			throw new YaExisteException("El departamento " + nombreDepartamento + "ya se encuentra registrado.");
		}
		Departamento newD = new Departamento(nombreDepartamento, descripcion,URL);
		hD.add(newD);
		
	}
	public void altaSalidaTuristica(String nombreSal,Date fechaSal, String lugarSal,int cantMaxTuristas, Date fechaAlta,String  actividad) throws YaExisteException {
		HandlerSalidas hS = HandlerSalidas.getInstance();
		if (hS.existeSalida(nombreSal)) {
			throw new YaExisteException("La salida " + nombreSal + "ya se encuentra registrada");
			
		}
		HandlerActividades hA = HandlerActividades.getInstance();
		ActividadTuristica actividadAux = hA.obtenerActividadTuristica(actividad);
		
		SalidaTuristica newSal = new SalidaTuristica(nombreSal,fechaSal,lugarSal,cantMaxTuristas,fechaAlta,actividadAux);
		hS.addSalidas(newSal);
	
	}
	//public DTSalida getInfoCompletaSalida(salida: String): DTSalidapublic abstract void altaDepartamento(String nombreDepartamento, String URL) throws YaExisteException;
	public DTActividad getInfoActividad(String actividad) {
		return null;
		
	}
	public void altaActividadTuristica(String nomDep, String nomActividad, String desc,int duraHs,float costo,String nombCiudad,String nickProv, Date fechaAlta) {
		
	};
	public  Set<String> listarNombresSalidasDeActividad(String actividad){
		return null;
		
	}
	public Set<DTSalida> listarInfoSalidasVigentes(String actividad,Date fechaSistema){
		return null;
		
	}
	
	public DTSalida getInfoCompletaSalida(String salida) {
		return null;
		
	}
	public Set<String> listarDepartamentos(){
		return null;
		
	}
	public Set<String> listarActividadesDepartamento(String depto){
		return null;
		
	}
	public  Set<String> listarActividadesDepartamentoMenosPaquete(String depto, String nombrePaquete){
		return null;
		
	}
	
	public  Date crearPaquete(String nombre,String descripción,int validez,float descuento,Date fechaDeAlta) {
		return null;
		
	}
	public Set<String> listarPaquetes(){
		return null;
		
	}
	public  void ingresarActividadAPaquete(String nombrePaquete,String nombreActividad){
		
	}
	public DTPaquete getInfoPaquete(String paqueteSeleccionado) {
		return null;
		
	}

}
