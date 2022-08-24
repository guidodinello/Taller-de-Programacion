package logica.interfaces;
import excepciones.YaExisteException;
import java.util.Set;
import datatypes.DTSalida;
import datatypes.DTPaquete;
import java.util.Date;
import datatypes.DTActividad;



public interface ICtrlActividad{

	public abstract void altaDepartamento(String nombreDepartamento, String URL) throws YaExisteException;
	public abstract DTActividad getInfoActividad(String actividad);
	public abstract void altaActividadTuristica(String nomDep, String nomActividad, String desc,int duraHs,float costo,String nombCiudad,String nickProv, Date fechaAlta);
	public abstract Set<String> listarNombresSalidasDeActividad(String actividad);
	public abstract Set<DTSalida> listarInfoSalidasVigentes(String actividad,Date fechaSistema);
	public abstract void  altaSalidaTuristica(String nombreSal, Date fechaSal, String lugarSal,int cantMaxTuristas,Date fechaAlta, String activdiad);
	public abstract DTSalida getInfoCompletaSalida(String salida);
	public abstract Set<String> listarDepartamentos();
	public abstract Set<String> listarActividadesDepartamento(String depto);
	public abstract Set<String> listarActividadesDepartamentoMenosPaquete(String depto, String nombrePaquete);
	//public abstract void altaDepartamento(String nombreDepto,String descripcion,String URL); Dos altaDepartamento? (linea 13)
	public abstract Date crearPaquete(String nombre,String descripción,int validez,float descuento,Date fechaDeAlta);
	public abstract Set<String> listarPaquetes();
	public abstract void ingresarActividadAPaquete(String nombrePaquete,String nombreActividad);
	public abstract DTPaquete getInfoPaquete(String paqueteSeleccionado);
}
