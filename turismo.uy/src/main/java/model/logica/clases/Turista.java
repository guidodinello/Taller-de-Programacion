package model.logica.clases;

import java.io.InputStream;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import model.logica.clases.InscripcionSalida;

import java.util.HashSet;
import model.datatypes.DTSalida;

public class Turista extends Usuario {
	private Map<String, InscripcionSalida> inscripciones;
	private String nacionalidad;

	public Turista(String nickname, String email, String nombre, String apellido, String contrasena, GregorianCalendar fechaNac, String imgDir,byte [] imgBin, String nacionalidad) {
		super(nickname, email, nombre, apellido, contrasena, fechaNac, imgDir, imgBin);
		this.nacionalidad = nacionalidad;
		this.inscripciones = new HashMap<String, InscripcionSalida>();
	}

	public String getNacionalidad() {
		return nacionalidad;
	}
	
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public Set<DTSalida> getInfoInscripciones() {
		Set<DTSalida> resultado = new HashSet<DTSalida>();
		inscripciones.forEach((key, value)->{
			resultado.add(value.getDTSalida());
		});
		return resultado;
	}

	public void agregarInscripcion(InscripcionSalida insc) {
		inscripciones.put(insc.getSalida().getNombre(), insc);
	}
	
	public boolean inscriptoSalida(SalidaTuristica s) {
		return inscripciones.containsKey(s.getNombre());
	}
}
