package logica.handlers;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Iterator;

import logica.clases.Usuario;
import logica.clases.Turista;
import logica.clases.Proveedor;
import excepciones.NoExisteUsuario;
import excepciones.YaExisteException;

public class HandlerUsuarios {
	
	private static HandlerUsuarios instance = null;

	Map<List<String>, Proveedor> proveedores;
	Map<List<String>, Turista> turistas;
	
	private HandlerUsuarios() {
		proveedores = new HashMap<List<String>, Proveedor>();
		turistas = new HashMap<List<String>, Turista>();
	}

	public static HandlerUsuarios getInstance() {
        if (instance == null)
            instance = new HandlerUsuarios();
        return instance;
	}
	
	private <T> boolean uniqueKey(List<String> key, Map<List<String>, T> collection) throws YaExisteException{
		String nickname = key.get(0);
		String email = key.get(1);

        Iterator<Entry<List<String>, T>> iterator = collection.entrySet().iterator();
        
        boolean nickname_flag = false;
        boolean email_flag = false;

        while (iterator.hasNext()) {
            Entry<List<String>, T> entry = iterator.next();
            if (entry.getKey().get(0) == nickname)
            	nickname_flag = true;
            if (entry.getKey().get(1) == email)
            	email_flag = true;
            if (email_flag && nickname_flag)
            	throw new YaExisteException("el nickname y el email introducidos ya existen");
            else {
            	if (nickname_flag)
            		throw new YaExisteException("el nickname " + nickname + " ya existe");
            	else 
            		throw new YaExisteException("el email " + email + " introducidos ya existe");
            }
        }
        return true;
	}
	
	private <T extends Usuario> void add(T usr, Map<List<String>, T> collection) throws YaExisteException {
		List<String> keys = List.of(usr.getNickname(), usr.getEmail());
		if (! uniqueKey(keys, collection)) {
			collection.put(keys, usr);
		}
	}

	public void agregarTurista(Turista turista) throws YaExisteException {
		add(turista, turistas);
	}

	public void agregarProveedor(Proveedor prov) throws YaExisteException {
		add(prov, proveedores);
	}
	
	public Usuario getUsuario(List<String> key) throws NoExisteUsuario {
		Proveedor p = proveedores.get(key);
		if (p != null)
			return (Usuario)p;
		Turista t = turistas.get(key);
		if (t != null)
			return (Usuario)t;
		throw new NoExisteUsuario("No existe usuario con nickname: " + key.get(0) + " e email: " + key.get(1));; 
	}
	
	public Turista getTurista(String nickname, String email) throws NoExisteUsuario {
		return (Turista)getUsuario(List.of(nickname, email));
	}
	
	public Proveedor getProveedor(String nickname, String email) throws NoExisteUsuario {
		return (Proveedor)getUsuario(List.of(nickname, email));
	}
}
