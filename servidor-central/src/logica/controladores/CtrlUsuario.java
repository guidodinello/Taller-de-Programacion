package logica.controladores;
import logica.interfaces.ICtrlUsuario;
import logica.clases.Proveedor;
import logica.clases.Turista;
import logica.clases.Usuario;
import logica.clases.SalidaTuristica;
import logica.clases.InscripcionSalida;
import logica.handlers.HandlerSalidas;
import logica.handlers.HandlerUsuarios;
import datatypes.DTActividad;
import datatypes.DTSalida;
import datatypes.DTUsuario;
import datatypes.tipoUsuario;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;

import excepciones.InvalidArgument;
import excepciones.NoExisteUsuario;
import excepciones.YaExisteException;

public class CtrlUsuario implements ICtrlUsuario {
	
	public CtrlUsuario() {}
	
	public void altaUsuario(String nickname, String email, String nombre, String apellido, Date fechaNac, tipoUsuario tipo, String nacionalidad, String descripcion, String sitioWeb) throws InvalidArgument, YaExisteException {
		HandlerUsuarios hu = HandlerUsuarios.getInstance();
		if (tipo == tipoUsuario.turista) {
			Turista t = new Turista(nickname, email, nombre, apellido, fechaNac, nacionalidad);
			hu.agregarTurista(t);
		} else if (tipo == tipoUsuario.proveedor) {
			Proveedor p = new Proveedor(nickname, email, nombre, apellido, fechaNac, descripcion, sitioWeb);
			hu.agregarProveedor(p);
		} else 
			throw new InvalidArgument("El tipo de usuario especificado no pertence al enumerado");

	}
	

	public void ingresarInscripcion(String nickname, String salida, int cant, Date fecha) { 
		HandlerUsuarios hU = HandlerUsuarios.getInstance();
		HandlerSalidas hS = HandlerSalidas.getInstance();
		try {
			Turista turista = hU.getTurista(nickname, "email"); // No tengo email?
			SalidaTuristica salidaT = hS.obtenerSalidaTuristica(salida);
			float costo = salidaT.calcularCosto(cant);
			InscripcionSalida insc = new InscripcionSalida(cant, fecha, salidaT, costo);
			turista.agregarInscripcion(insc);
		} catch (NoExisteUsuario e) {
			e.printStackTrace();
		}
		
	}
	
	public Set<String> listarTuristas() {
		Set<String> res = new HashSet<String>();
		HandlerUsuarios hU = HandlerUsuarios.getInstance();
		Set<Turista> turistas = hU.listarTuristas();
		turistas.forEach((e) -> { res.add(e.getNickname()); });
		return res;
	}
	public void altaActividadTuristica(String nomDep, String nomActividad, String desc, int duraHs, float costo, String nombCiudad, String nickProv, Date fechaAlta) { 

	} 
	public Set<String> listarProveedores() { 
		return null;
	}
	public void actualizarUsuario(String nickname, String nombre, String apellido, Date fechaNac, tipoUsuario tipo, String nacionalidad, String desc, String sitioWeb) { 
	
	}
	
	public Set<DTSalida> listarInfoSalidasTurista(Turista t){ 
		return null;
 	}
	
	public Set<DTActividad> listarInfoCompletaActividadesProveedor(Proveedor p) {
		return null;
	}
	
	public Set<String> listarUsuarios(){ 
		HandlerUsuarios hU = HandlerUsuarios.getInstance();
		Set<Usuario> usuarios = hU.listarUsuarios();
		Set<String> resultado = new HashSet<String>();
		usuarios.forEach((Usuario usuario) -> {
			resultado.add(usuario.getNickname());});
		return resultado;
	}
	
	public DTUsuario getInfoBasicaUsuario(Usuario usr) {
		HandlerUsuarios hU = HandlerUsuarios.getInstance();
		Usuario usuario = hU.getUsuario(usr);
		
		return null;
	}
}
