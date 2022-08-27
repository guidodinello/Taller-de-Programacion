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
import datatypes.DTProveedor;
import datatypes.DTSalida;
import datatypes.DTTurista;
import datatypes.DTUsuario;
import datatypes.tipoUsuario;

import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;

//import excepciones.InvalidArgument;
//import excepciones.NoExisteUsuario;
import excepciones.YaExisteException;
import excepciones.InscriptionFailException;

public class CtrlUsuario implements ICtrlUsuario{
	
	public CtrlUsuario() {}
	
	public void altaUsuario(String nickname, String email, String nombre, String apellido, GregorianCalendar fechaNac, tipoUsuario tipo, String nacionalidad, String descripcion, String sitioWeb) throws YaExisteException {
		HandlerUsuarios hu = HandlerUsuarios.getInstance();
		if (tipo == tipoUsuario.turista) {
			Turista t = new Turista(nickname, email, nombre, apellido, fechaNac, nacionalidad);
			hu.agregarTurista(t);
		} else {
			Proveedor p = new Proveedor(nickname, email, nombre, apellido, fechaNac, descripcion, sitioWeb);
			hu.agregarProveedor(p);
		}
	}
	

	public void ingresarInscripcion(String nickname, String salida, int cant, GregorianCalendar fecha) throws InscriptionFailException { 
		HandlerUsuarios hU = HandlerUsuarios.getInstance();
		HandlerSalidas hS = HandlerSalidas.getInstance();
		Turista turista = hU.getTuristaByNickname(nickname);
		SalidaTuristica salidaT = hS.obtenerSalidaTuristica(salida);
		if(turista.inscriptoSalida(salidaT))
			throw new InscriptionFailException("El usuario " + turista.getNickname() + " ya se encuentra registrado en la salida seleccionada");
		if(salidaT.getPlazosDisponibles() - cant < 0)
			throw new InscriptionFailException("La salida " + salidaT.getNombre() + " no tiene los plazos suficientes para la inscripcion");
		float costo = salidaT.calcularCosto(cant);
		InscripcionSalida insc = new InscripcionSalida(cant, fecha, salidaT, costo);
		salidaT.reducirPlazos(cant);
		turista.agregarInscripcion(insc);
	
	}
	
	public Set<String> listarTuristas() {
		Set<String> res = new HashSet<String>();
		HandlerUsuarios hU = HandlerUsuarios.getInstance();
		Set<Turista> turistas = hU.listarTuristas();
		turistas.forEach((e) -> { res.add(e.getNickname()); });
		return res;
	}
	
	public Set<String> listarProveedores() { 
		HandlerUsuarios hU = HandlerUsuarios.getInstance();
		Set<String> res = new HashSet<String>();
		hU.listarProveedores().forEach(e->{
			res.add(e.getNickname());
		});
		return res;
	}
	
	public void actualizarUsuario(String nickname, String nombre, String apellido, GregorianCalendar fechaNac, String nacionalidad, String desc, String sitioWeb) { 
		HandlerUsuarios hU = HandlerUsuarios.getInstance();
		Usuario usuario = hU.getUsuarioByNickname(nickname);
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setFechaNac(fechaNac);
		if(usuario instanceof Turista) {
			((Turista) usuario).setNacionalidad(nacionalidad);
		}else {
			((Proveedor) usuario).setDescripcion(desc);
			((Proveedor) usuario).setSitioWeb(sitioWeb);
		}
		
	}
	
	public Set<DTSalida> listarInfoSalidasTurista(String t){ 
		HandlerUsuarios hU = HandlerUsuarios.getInstance();
		Set<DTSalida> resultado = null;
		Turista turis = hU.getTuristaByNickname(t);
		resultado = turis.getInfoInscripciones();
		return resultado;
 	}
	
	public Set<DTActividad> listarInfoCompletaActividadesProveedor(String p) {
		HandlerUsuarios hU = HandlerUsuarios.getInstance();
		Set<DTActividad> resultado = null;
		Proveedor prov = hU.getProveedorByNickname(p);
		if(prov == null) {
			System.out.print(prov);
		}
		resultado = prov.getDTActividades();
		return resultado;
	}
	
	public Set<String> listarUsuarios(){ 
		HandlerUsuarios hU = HandlerUsuarios.getInstance();
		Set<Usuario> usuarios = hU.listarUsuarios();
		Set<String> resultado = new HashSet<String>();
		usuarios.forEach((Usuario usuario) -> {
			resultado.add(usuario.getNickname());});
		return resultado;
	}
	
	public DTUsuario getInfoBasicaUsuario(String usr) {
		HandlerUsuarios hU = HandlerUsuarios.getInstance();
		DTUsuario resultado = null;
		Usuario usuario = hU.getUsuarioByNickname(usr);
		if(usuario instanceof Proveedor) {
			resultado = new DTProveedor((Proveedor)usuario);
		}else {
				resultado =  new DTTurista((Turista)usuario);
		}	
		return resultado;
	}
}
