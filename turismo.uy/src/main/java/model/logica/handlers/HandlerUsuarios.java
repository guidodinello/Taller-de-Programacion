package model.logica.handlers;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
//import java.util.Collection;
//import java.util.GregorianCalendar;
import java.util.HashMap;

import model.logica.clases.Usuario;
import model.logica.clases.Turista;
import model.logica.clases.Proveedor;
import excepciones.YaExisteException;

public class HandlerUsuarios {
	private static HandlerUsuarios instance = null;
	
	private Map<String, Usuario> usuarios; //guarda todos por el nickname
	private Map<String, Proveedor> proveedores;//guarda por el email
	private Map<String, Turista> turistas;//guarda por el email

	private HandlerUsuarios() {
		usuarios = new HashMap<String, Usuario>();
		proveedores = new HashMap<String, Proveedor>();
		turistas = new HashMap<String, Turista>();
	}

	public static HandlerUsuarios getInstance() {
		if (instance == null)
			instance = new HandlerUsuarios();
		return instance;
	}

	public void agregarTurista(Turista t) throws YaExisteException {
		if(usuarios.containsKey(t.getNickname())) {
			throw new YaExisteException("El usuario con el nickname " +t.getNickname() + " ya se encuentra registrado.");
		}
		if(turistas.containsKey(t.getEmail())) {
			throw new YaExisteException("El usuario con el email " +t.getEmail() + " ya se encuentra registrado.");
		}
		if(proveedores.containsKey(t.getEmail())) {
			throw new YaExisteException("El usuario con el email " +t.getEmail() + " ya se encuentra registrado.");
		}
		usuarios.put(t.getNickname(), t);
		turistas.put(t.getEmail(), t);
	}

	public void agregarProveedor(Proveedor p) throws YaExisteException {
		if(usuarios.containsKey(p.getNickname())) {
			throw new YaExisteException("El usuario con el nickname " +p.getNickname() + " ya se encuentra registrado.");
		}
		if(proveedores.containsKey(p.getEmail())) {
			throw new YaExisteException("El usuario con el email " +p.getEmail() + " ya se encuentra registrado.");
		}
		if(turistas.containsKey(p.getEmail())) {
			throw new YaExisteException("El usuario con el email " +p.getEmail() + " ya se encuentra registrado.");
		}
		usuarios.put(p.getNickname(), p);
		proveedores.put(p.getEmail(), p);
	}
	
//  siempre sabemos de antemano el tipo de usuario
	public void agregarUsuario(Usuario u) throws YaExisteException {
		if (u instanceof Proveedor) {
			Proveedor p = (Proveedor) u;
			this.agregarProveedor((Proveedor)p);
		} else {
			Turista t = (Turista) u;
			this.agregarTurista((Turista)t);
		}
	}

	//tira null si no existe
	public Usuario getUsuarioByNickname(String n){
		return usuarios.get(n);
	}
	
	public Proveedor getProveedorByNickname(String n) {
		return (Proveedor)usuarios.get(n);
	}
	
	public Turista getTuristaByNickname(String n) {
		return (Turista)usuarios.get(n);
	}

//	siempre los pedimos por nickname
	public Usuario getUsuarioByEmail(String n){
		if(proveedores.get(n) != null) {
			return proveedores.get(n);
		}
		return turistas.get(n);
	}

	public Set<Turista> listarTuristas() {
		Set<Turista> res = new HashSet<Turista>(turistas.values());
		return res;
	}

	public Set<Proveedor> listarProveedores() {
		Set<Proveedor> res = new HashSet<Proveedor>(proveedores.values());
		return res;
	}

	public Set<Usuario> listarUsuarios() {
		Set<Usuario> res = new HashSet<Usuario>(usuarios.values());
		return res;
	}
	
	public static void clear() {
		instance = null;
	}
}
