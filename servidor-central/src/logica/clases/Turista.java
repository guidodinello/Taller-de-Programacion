package logica.clases;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

public class Turista extends Usuario {
	private Map<String, InscripcionSalida> inscripciones;
	private String nickname, email, nombre, apellido, nacionalidad;
	private Date fechaNac;

	public Turista(String nickname, String email, String nombre, String apellido, Date fechaNac, String nacionalidad) {
		this.nickname = nickname;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
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
	
	public Date getFechaNac() {
		return fechaNac;
	}
	
	public String getNacionalidad() {
		return nacionalidad;
	}

	public void agregarInscripcion(InscripcionSalida insc) {
		inscripciones.put(insc.getSalida().getNombre(), insc);
	}

}
