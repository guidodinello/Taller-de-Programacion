package logica.clases;

import java.util.GregorianCalendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import datatypes.DTSalida;

public class Turista extends Usuario {
	private Map<String, InscripcionSalida> inscripciones;
	private String nacionalidad;
	private Map<String ,Compra> compras;

	public Turista(String nickname, String email, String nombre, String apellido, String contrasena, GregorianCalendar fechaNac, String img, String nacionalidad) {
		super(nickname, email, nombre, apellido, contrasena, fechaNac, img);
		this.nacionalidad = nacionalidad;
		this.inscripciones = new HashMap<String, InscripcionSalida>();
		//this.compras = vacio;
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
	public Map<String, Compra> getCompras() {
		if(compras!= null) {
			return this.compras;
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
