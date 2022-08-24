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
	private GregorianCalendar fechaNac;

	public Turista(String nickname, String email, String nombre, String apellido, GregorianCalendar fechaNac, String nacionalidad) {
		super(nickname, email, nombre, apellido, fechaNac);
		this.nacionalidad = nacionalidad;
		this.inscripciones = new HashMap<String, InscripcionSalida>();
	}

	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public GregorianCalendar getFechaNac() {
		return fechaNac;
	}

	public String getNacionalidad() {
		return nacionalidad;
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
		return this.inscripciones.containsValue(s);
	}

}
