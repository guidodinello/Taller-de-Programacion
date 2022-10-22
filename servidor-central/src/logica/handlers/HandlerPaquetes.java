package logica.handlers;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import logica.clases.Compra;
import logica.clases.Turista;
import logica.handlers.HandlerUsuarios;

import java.util.HashSet;

import logica.clases.PaqueteTuristico;

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
	    /*Set<PaqueteTuristico> paq = new HashSet<PaqueteTuristico> (paquetes.values());
        HandlerUsuarios hu = HandlerUsuarios.getInstance();
         Set<Turista> turistas = hu.listarTuristas();
         for (Turista t : turistas){
             Set<Compra> compras =  t.getCompras();
             if(compras != null)
                 for (Compra i : compras) {
                    PaqueteTuristico p =  i.getPaquete();
                    if(paq.contains(p)) {
                        paq.remove(p);
                    }
                 }
             
         }
         return paq;*/
	    Set<PaqueteTuristico> res = new HashSet<PaqueteTuristico>(paquetes.values());
	    return res;
	}
	
	public static void clear() {
		instancia = null;
	}
}
