package logica.handlers;

import java.util.*;

import logica.clases.Usuario;
import logica.clases.Turista;
import logica.clases.Proveedor;

public class HandlerUsuarios {
	
	HandlerUsuarios instance;
	
	Map<String, Usuario> usuarios = new HashMap<Usuario>();
	Map<String, Proveedor> proveedores = new HashMap<Proveedor>();
	Map<String, Turista> turistas = new HashMap<Turista>();
	
	// map con dos keys (nickname, email) ? 
	// https://stackoverflow.com/questions/822322/how-to-implement-a-map-with-multiple-keys

	public static HandlerUsuarios getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean uniqueKeys(String nickname, String email, Map) {
        // Get the iterator over the HashMap
		// ver como solucionar lo del tipo del entry para tratar de hacerla generica 
		// y que funcione para los 3 hashmaps
        Iterator<Map.Entry<Integer, String> > iterator = map.entrySet().iterator();
 
        // flag to store result
        boolean isKeyPresent = false;
  
        // Iterate over the HashMap
        while (iterator.hasNext()) {
            // Get the entry at this iteration
            Map.Entry<Integer, String> entry = iterator.next();
            // Check if this key is the required key
            if (keyToBeChecked == entry.getKey()) {
                isKeyPresent = true;
            }
        }
	}

	public void agregarTurista(String nickname, String email, Turista turista) {
		if (uniqueKeys(turista, turistas))
		turistas.put(turista.getNickname(), turista);
	}

	public void agregarProveedor(String nickname, String email, Usuario prov) {
		proveedores.put(prov.getNickname(), prov);
	}

	public void agregarUsuario(String nickname, String email, Usuario usr) {
		usuarios.put(usr.getNickname(), usr);
	}

}
