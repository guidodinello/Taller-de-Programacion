package model.datatypes;

import java.io.InputStream;
import java.util.GregorianCalendar;
import model.logica.clases.Usuario;

public class DTUsuario {
	private String nickname;
	private String email;
	private GregorianCalendar fechaNac;
	private String nombre;
	private String apellido;
	private byte [] img;

	
	public DTUsuario(Usuario usuario) {
		nickname = usuario.getNickname();
		email = usuario.getEmail();
		fechaNac = usuario.getFechaNac();
		nombre = usuario.getNombre();
		apellido = usuario.getApellido();
		img = usuario.getImgagenPerfil();

	}

	public String getNickname() {
		return nickname;
	}
	
	public String getEmail() {
		return email;
	}

	public GregorianCalendar getFechaNac() {
		return fechaNac;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}
	
	public byte [] getImg() {
	    return img;
	}

}
