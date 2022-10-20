package model.logica.clases;

import java.util.GregorianCalendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

import model.logica.clases.Compra;

import java.util.HashSet;
import model.datatypes.DTSalida;

public class Turista extends Usuario {
	private Map<String, InscripcionSalida> inscripciones;
	private String nacionalidad;
	private Map<String ,Compra> compras;

	public Turista(String nickname, String email, String nombre, String apellido, String contrasena, GregorianCalendar fechaNac, String imgDir,byte [] imgBin, String nacionalidad) {
		super(nickname, email, nombre, apellido, contrasena, fechaNac, imgDir, imgBin);
		this.nacionalidad = nacionalidad;
		this.inscripciones = new HashMap<String, InscripcionSalida>();
		this.compras = new HashMap<String, Compra>();
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
	
	public Set<Compra> getCompras() {
        if(compras!= null) {
            return new HashSet<Compra>(this.compras.values());
        }
        else {
            return null;
        }
    }

	public void agregarInscripcion(InscripcionSalida insc) {
		inscripciones.put(insc.getSalida().getNombre(), insc);
	}
	
	public boolean inscriptoSalida(SalidaTuristica s) {
		return inscripciones.containsKey(s.getNombre());
	}
}
