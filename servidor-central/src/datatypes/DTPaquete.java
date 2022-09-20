package datatypes;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class DTPaquete {
	private String nombre, descripcion;
	private int periodoValidez;
	private float descuento;
	private GregorianCalendar fechaAlta;
	private Set<String> actividades;

	public DTPaquete(String nombre, String descripcion, int periodoValidez, float descuento, GregorianCalendar fechaAlta,
			Set<String> actividades) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.periodoValidez = periodoValidez;
		this.descuento = descuento;
		this.fechaAlta = fechaAlta;
		this.actividades = actividades;
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

	public float getDescuento() {
		return descuento;
	}
	
	public Set<String> getCategorias() {
		// sin implementar
		return new HashSet<String>();
	}

	public GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}

	public Set<String> getActividades() {
		return actividades;
	}

}
