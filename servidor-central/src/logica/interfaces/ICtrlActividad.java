package logica.interfaces;
import excepciones.YaExisteException;
import java.util.Set;
import datatypes.DTSalida;
import datatypes.DTPaquete;
import java.util.GregorianCalendar;
import datatypes.DTActividad;



public interface ICtrlActividad {

	public abstract void altaDepartamento(String nombreDepartamento, String descripcion,String URL) throws YaExisteException;
	public abstract DTActividad getInfoActividad(String actividad);
	public abstract void altaActividadTuristica(String nomDep, String nomActividad, String desc,int duraHs,float costo,String nombCiudad,String nickProv, GregorianCalendar fechaAlta)throws YaExisteException;
	public abstract Set<String> listarNombresSalidasDeActividad(String actividad);
	public abstract Set<DTSalida> listarInfoSalidasVigentes(String actividad,GregorianCalendar fechaSistema);
	public abstract void  altaSalidaTuristica(String nombreSal, GregorianCalendar fechaSal, String lugarSal,int cantMaxTuristas,GregorianCalendar fechaAlta, String actividad)throws YaExisteException;
	public abstract DTSalida getInfoCompletaSalida(String salida);
	public abstract Set<String> listarDepartamentos();
	public abstract Set<String> listarActividadesDepartamento(String depto);
	public abstract Set<String> listarActividadesDepartamentoMenosPaquete(String depto, String nombrePaquete);
	public abstract GregorianCalendar crearPaquete(String nombre,String descripcion,int validez,float descuento,GregorianCalendar fechaDeAlta);
	public abstract Set<String> listarPaquetes();
	public abstract void ingresarActividadAPaquete(String nombrePaquete,String nombreActividad);
	public abstract DTPaquete getInfoPaquete(String paqueteSeleccionado);
}
