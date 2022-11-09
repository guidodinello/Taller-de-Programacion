package datatypes;

import java.util.GregorianCalendar;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import logica.clases.Usuario;

@XmlAccessorType(XmlAccessType.FIELD)
public class DTUsuario {
	private String nickname;
	private String email;
	private GregorianCalendar fechaNac;
	private String nombre;
	private String apellido;
    private String imgDir;

	
	public DTUsuario(Usuario usuario) {
		nickname = usuario.getNickname();
		email = usuario.getEmail();
		fechaNac = usuario.getFechaNac();
		nombre = usuario.getNombre();
		apellido = usuario.getApellido();
		imgDir = usuario.getImgDir();
	}

	public DTUsuario() {
	  
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
	
}
