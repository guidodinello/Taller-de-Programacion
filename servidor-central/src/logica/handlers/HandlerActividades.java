package logica.handlers;

import java.util.HashMap;
import java.util.Map;

import logica.clases.ActividadTuristica;

public class HandlerActividades {
	private Map<String, ActividadTuristica> actividades;
	
	private static HandlerActividades instancia = null;
	private HandlerActividades() {
		this.actividades = new HashMap<>();
	}
	public static HandlerActividades getInstance() {
		if (instancia == null) {
			instancia = new HandlerActividades();
		}
		return instancia;
	}
	
	public boolean existeActividad(String nombre) {
		return actividades.containsKey(nombre);
	}
	
	public void agregarActividad(ActividadTuristica actividad) {
		actividades.put(actividad.getNombre(), actividad);
	}
	
	public ActividadTuristica obtenerActividadTuristica(String nombre) {
		return actividades.get(nombre);
	}
}
