package logica.interfaces;

import java.util.Date;
import java.util.Set;

import datatypes.tipoUsuario;
import logica.clases.Proveedor;
import logica.clases.Turista;
import logica.clases.Usuario;

public interface ICtrlUsuario {

	public abstract void altaUsuario(String nickname,String email, String nombre, String apellido, Date fechaNac,
			tipoUsuario tipo, String nacionalidad, String desc, String sitioWeb);
	public abstract void ingresarInscripcion(String nickname, String salida, int cant, Date fecha);
	public abstract void listarTuristas();
	public abstract void altaActividadTuristica(String nomDep, String nomActividad, String desc, int duraHs, float costo, String nombCiudad, String nickProv, Date fechaAlta); 
	public abstract Set<String> listarProveedores();
	public abstract void actualizarUsuario(String nickname, String nombre, String apellido, Date fechaNac, tipoUsuario tipo, String nacionalidad, String desc, String sitioWeb);
	public abstract Set<DTSalida> listarInfoSalidasTurista(Turista t); 
	public abstract Set<DTActividad> listarInfoCompletaActividadesProveedor(Proveedor p);
	public abstract Set<String> listarUsuarios();
	public abstract DTUsuario getInfoBasicaUsuario(Usuario usr);
}
