package model.logica.handlers;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import model.logica.clases.PaqueteTuristico;

/*
 * Clase que contiene la coleccion global de Paquetes
 */
public class HandlerPaquetes {
	private Map<String, PaqueteTuristico> paquetes;
	private static HandlerPaquetes instancia = null;
	
	public HandlerPaquetes() {
		paquetes = new HashMap<String, PaqueteTuristico>();
	}
	
	public static HandlerPaquetes getInstance() {
		if(instancia == null)
			instancia = new HandlerPaquetes();
		return instancia;
	}
	
	public void addPaquete(PaqueteTuristico pt) {
		paquetes.put(pt.getNombre(), pt);
	}
	
	public PaqueteTuristico obtenerPaqueteTuristico(String nombre) {
		return paquetes.get(nombre);
	}
	
	public boolean existePaquete(String nombre) {
		return paquetes.containsKey(nombre);
	}
	
	public Set<PaqueteTuristico> getPaquetes(){
		return new HashSet<PaqueteTuristico>(paquetes.values());
	}
	
	public static void clear() {
		instancia = null;
	}
}
