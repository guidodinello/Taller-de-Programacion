package logica.handlers;

import java.util.List;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import logica.clases.Usuario;
import logica.clases.Turista;
import logica.clases.Proveedor;
import excepciones.NoExisteUsuario;
import excepciones.YaExisteException;

public class HandlerUsuarios {
	
	private class DoubleKeyedHashMap <T> {
		private Map<String, T> hashByNickname;
		private Map<String, T> hashByEmail;
		
		public DoubleKeyedHashMap() {
			hashByNickname = new HashMap<String, T>();
			hashByEmail = new HashMap<String, T>();
		}
		
		public void add(String nickname, String email, T usr) throws YaExisteException {
			T repeated_nick_value = hashByNickname.get(usr);
			T repeated_email_value = hashByEmail.get(usr);
			if (repeated_nick_value != null) 
				throw new YaExisteException("el nickname " + nickname + " ya existe");
			if (repeated_email_value != null) 
				throw new YaExisteException("el email " + email + " introducidos ya existe");
			hashByNickname.put(nickname, usr);
			hashByEmail.put(email, usr);
		}
		
		public Collection<T> values() {
			return hashByNickname.values();
		}
		
		public T getByNickname(String nick) throws NoExisteUsuario {
			T usr = hashByNickname.get(nick);
			if (usr != null)
				return usr;
			throw new NoExisteUsuario("No existe usuario con nickname: " + nick);
		}
		
		public T getByEmail(String e) throws NoExisteUsuario {
			T usr = hashByEmail.get(e);
			if (usr != null)
				return usr;
			throw new NoExisteUsuario("No existe usuario con email: " + e);
		}
		
	}
	
	private static HandlerUsuarios instance = null;

	DoubleKeyedHashMap<Proveedor> proveedores;
	DoubleKeyedHashMap<Turista> turistas;
	
	private HandlerUsuarios() {
		proveedores = new DoubleKeyedHashMap<Proveedor>();
		turistas = new DoubleKeyedHashMap<Turista>();
	}

	public static HandlerUsuarios getInstance() {
        if (instance == null)
            instance = new HandlerUsuarios();
        return instance;
	}

	public void agregarTurista(Turista t) throws YaExisteException {
		turistas.add(t.getNickname(), t.getEmail(), t);
	}
	public void agregarProveedor(Proveedor p) throws YaExisteException {
		proveedores.add(p.getNickname(), p.getEmail(), p);
	}
	public void agregarUsuario(Usuario u) throws YaExisteException {
		if (u instanceof Proveedor) {
			Proveedor p = (Proveedor)u;
			proveedores.add(p.getNickname(), p.getEmail(), p);
		} else {
			Turista t = (Turista)u;
			turistas.add(t.getNickname(), t.getEmail(), t);
		}

	}
	
	public Usuario getUsuarioByNickname(String n) throws NoExisteUsuario {
		Proveedor p = proveedores.getByNickname(n);
		if (p != null)
			return (Usuario)p;
		return (Usuario)turistas.getByNickname(n);
	}
	public Usuario getUsuarioByEmail(String n) throws NoExisteUsuario {
		Proveedor p = proveedores.getByEmail(n);
		if (p != null)
			return (Usuario)p;
		return (Usuario)turistas.getByEmail(n);
	}
	
	public Turista getTuristaByNickname(String n) throws NoExisteUsuario { return turistas.getByNickname(n); }
	public Proveedor getProveedorByNickname(String n) throws NoExisteUsuario { return proveedores.getByNickname(n); }
	public Turista getTuristaByEmail(String e) throws NoExisteUsuario { return turistas.getByEmail(e); }
	public Proveedor getProveedorByEmail(String e) throws NoExisteUsuario { return proveedores.getByEmail(e); }

	public Set<Turista> listarTuristas() {
		Set<Turista> res = new HashSet<Turista>(turistas.values());
		return res;
	}
	public Set<Proveedor> listarProveedores() {
		Set<Proveedor> res = new HashSet<Proveedor>(proveedores.values());
		return res;
	}
	public Set<Usuario> listarUsuarios(){
		Set<Usuario> res = new HashSet<Usuario>(turistas.values());
		res.addAll(proveedores.values());
		return res;
	}
}
