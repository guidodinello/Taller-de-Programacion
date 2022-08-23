package logica.handlers;

import java.util.List;

import logica.clases.Usuario;
import logica.clases.Turista;
import logica.clases.Proveedor;

public class HandlerUsuarios {
	
	private static HandlerUsuarios instance = null;

	Map<List<String>, Proveedor> proveedores = new HashMap<Proveedor>();
	Map<List<String>, Turista> turistas = new HashMap<Turista>();
	
	private HandlerUsuarios() {}

	public static HandlerUsuarios getInstance() {
        if (instance == null)
            instance = new HandlerUsuarios();
        return instance;
	}
	
	/* Posible sol para error en add
	private <T> boolean uniqueKey(String nickname, String email, Map<List<String>, T> collection) {
		List<String> key = List.of(nickname, email);
        Iterator<Map.Entry<List<String>, String> > iterator = collection.entrySet().iterator();
        
        bool nickname_flag = false;
        bool email_flag = false;

        while (iterator.hasNext()) {
            Map.Entry<List<String>, String> entry = iterator.next();
            if (entry.getKey().get(0) == nickname)
            	nickname_flag = true;
            if (entry.getKey().get(1) == email)
            	email_flag = true;
            if (email_flag && nickname_flag)
            	throw YaExisteUsuario("el nickname y el email introducidos ya existen");
            else {
            	if (nickname_flag)
            		throw YaExisteUsuario("el nickname introducido ya existe");
            	else 
            		throw YaExisteUsuario("el email introducidos ya existe");
            }
        }
        return true;
	}
	*/
	
	private <T> void add(T usr, Map<List<String>, T> collection) {
		List<String> keys = List.of(usr.getNickname(), usr.getEmail());
		if (! collection.containsKey()) {
			collection.put(keys, usr);
		} else 
			throw YaExisteUsuario;
			// problema no sabemos si ya existia el noickname o el email o ambos 
	}

	public void agregarTurista(Turista turista) {
		add(turista, turistas);
	}

	public void agregarProveedor(Proveedor prov) {
		add(prov, proveedores);
	}
}
