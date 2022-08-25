package logica.interfaces;

import java.util.GregorianCalendar;
import java.util.Set;

import datatypes.DTActividad;
import datatypes.DTSalida;
import datatypes.DTUsuario;
import datatypes.tipoUsuario;

import excepciones.InvalidArgument;
import excepciones.YaExisteException;

//import logica.clases.Proveedor;
//import logica.clases.Turista;
//import logica.clases.Usuario;

public interface ICtrlUsuario {

	public abstract void altaUsuario(String nickname,String email, String nombre, String apellido, GregorianCalendar fechaNac,
			tipoUsuario tipo, String nacionalidad, String desc, String sitioWeb) throws InvalidArgument, YaExisteException;
	public abstract void ingresarInscripcion(String nickname, String salida, int cant, GregorianCalendar fecha);
	public abstract Set<String> listarTuristas();
//	public abstract void altaActividadTuristica(String nomDep, String nomActividad, String desc, int duraHs, float costo, String nombCiudad, String nickProv, GregorianCalendar fechaAlta);
	public abstract Set<String> listarProveedores();
	public abstract void actualizarUsuario(String nickname, String nombre, String apellido, GregorianCalendar fechaNac, tipoUsuario tipo, String nacionalidad, String desc, String sitioWeb);
	public abstract Set<DTSalida> listarInfoSalidasTurista(String t); 
	public abstract Set<DTActividad> listarInfoCompletaActividadesProveedor(String p);
	public abstract Set<String> listarUsuarios();
	public abstract DTUsuario getInfoBasicaUsuario(String usr);
}
