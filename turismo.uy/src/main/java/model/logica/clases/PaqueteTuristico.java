package model.logica.clases;

//import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.GregorianCalendar;

import model.datatypes.DTPaquete;

public class PaqueteTuristico {
	private String nombre, descripcion;
	private int periodoValidez;
	private float costo;
	private GregorianCalendar fechaAlta;
	private Map<String, ActividadTuristica> actividades;
	private String img;
	
	public PaqueteTuristico(String nombre, String descripcion, int periodoValidez, float costo, GregorianCalendar fechaAlta, String img) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.periodoValidez = periodoValidez;
		this.costo = costo;
		this.fechaAlta = fechaAlta;
		actividades = new HashMap<String, ActividadTuristica>();
		this.img = img;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public int getPeriodoValidez() {
		return periodoValidez;
	}

	public float getCosto() {
		return costo;
	}
	
	public GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}
	
	public boolean tieneActividad(String nombre) {
		return actividades.containsKey(nombre);
	}
	
	public void agregarActividad(ActividadTuristica act) {
		actividades.put(act.getNombre(), act);
	}
	
	public String getImg() {
	    return img;
	}
	
	public DTPaquete getDTPaquete() {
	    Set<String> categorias = new HashSet<String>();
	    actividades.forEach((key, value)->{categorias.addAll(value.getCategorias());});
		return new DTPaquete(nombre, descripcion, periodoValidez, costo, fechaAlta, actividades.keySet(), categorias, img);
	}
}
