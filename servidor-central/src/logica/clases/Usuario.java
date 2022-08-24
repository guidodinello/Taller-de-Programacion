package logica.clases;

import java.util.GregorianCalendar;
import java.util.List;

public class Usuario {

	protected String nickname, email, nombre, apellido;
	protected GregorianCalendar fechaNac;
	
	public Usuario(String nickname, String email, String nombre, String apellido, GregorianCalendar fechaNac) {
		this.nickname = nickname;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac = fechaNac;
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
	
	public List<String> getKey() {
		return List.of(nickname, email);
	}

}
