package model.datatypes;

import java.util.Set;
import java.util.GregorianCalendar;
import java.util.HashSet;

public class DTActividad {
	
	private String nombre;
	private String descripcion;
	private String departamento;
	private String imgDir;
	private String nombreCiudad;
	private GregorianCalendar fechaAlta;
	private int duracionHs;
	private float costo;
	private Set<String> nombCategorias;
	private Set<String> salidas;
	private Set<String> paquetes;
	private estadoActividad estado;
	

	
	public DTActividad(String n, String des, String departamento, String nombCiudad , GregorianCalendar fechaAlta, int dura, float costo, Set<String> salidas, Set<String> nombCat, String imgDir, estadoActividad estado) {
		this.nombre = n;
		this.descripcion = des;
		this.departamento = departamento;
		this.nombreCiudad =  nombCiudad;
		this.fechaAlta = fechaAlta;
		this.duracionHs = dura;
		this.costo = costo;
		this.nombCategorias = nombCat;
		this.salidas = salidas;
		this.estado = estado;
		paquetes = new HashSet<String>();
		this.imgDir = imgDir;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public String getDepartamento() {
		return departamento;
	}
	
	public int getDuracionHs() {
		return duracionHs;
	}
	
	public float getCosto() {
		return costo;
	}
	
	public Set<String> getSalidas() {
		return salidas;
	}
	
	public estadoActividad getestado() {
		return this.estado;
	}



	public Set<String> getPaquetes() {
		return paquetes;
	}
	
	public Set<String> getCategorias(){
		return nombCategorias;
	}
	
	public GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}
	
	public String getFechaAltaString() {
		String dia = String.valueOf(fechaAlta.get(fechaAlta.DAY_OF_MONTH));
		String mes = String.valueOf(fechaAlta.get(fechaAlta.MONTH) + 1);
		String anio = String.valueOf(fechaAlta.get(fechaAlta.YEAR));
		String hora = String.valueOf(fechaAlta.get(fechaAlta.HOUR));
		String resultado =	dia + "/" + mes + "/" + anio;
		return resultado;
	}
	
	public String getImgDir(){
		return imgDir;
	}
	
	public String getNombreCiudad(){
		return nombreCiudad;
	}
	
	public void setPaquetes(Set<String> paquetes) {
		this.paquetes = paquetes;
	}

	public String toString() {
		return "Nombre: " + getNombre();
	}



	
}
