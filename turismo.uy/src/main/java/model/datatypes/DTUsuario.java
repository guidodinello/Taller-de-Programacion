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
    private String imgDir;
	private byte [] imgBin;

	
	public DTUsuario(Usuario usuario) {
		nickname = usuario.getNickname();
		email = usuario.getEmail();
		fechaNac = usuario.getFechaNac();
		nombre = usuario.getNombre();
		apellido = usuario.getApellido();
		imgDir = usuario.getImgDir();
		imgBin = usuario.getImgBin();
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
	
	public String getImgDir() {
	    return imgDir;
	}
	
	public byte [] getImg() {
	    return imgBin;
	}
}
