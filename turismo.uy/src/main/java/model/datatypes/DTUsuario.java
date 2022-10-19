package model.datatypes;

import java.util.GregorianCalendar;
import model.logica.clases.Usuario;

public class DTUsuario {
	private String nickname;
	private String email;
	private GregorianCalendar fechaNac;
	private String nombre;
	private String apellido;
<<<<<<< HEAD
	private String imgDir;
	private byte [] imgBin;
=======
	private String img;
>>>>>>> 9a74449 (Revert "Merge branch 'develop-web-test' of https://gitlab.fing.edu.uy/tprog/tpgr14 into develop-web-test")
	
	public DTUsuario(Usuario usuario) {
		nickname = usuario.getNickname();
		email = usuario.getEmail();
		fechaNac = usuario.getFechaNac();
		nombre = usuario.getNombre();
		apellido = usuario.getApellido();
<<<<<<< HEAD
		imgDir = usuario.getImgDir();
		imgBin = usuario.getImgBin();
=======
		img = usuario.getImg();
>>>>>>> 9a74449 (Revert "Merge branch 'develop-web-test' of https://gitlab.fing.edu.uy/tprog/tpgr14 into develop-web-test")
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
	
	public String getImg() {
	    return img;
	}
	
<<<<<<< HEAD
	public byte [] getImg() {
	    return imgBin;
	}
=======
>>>>>>> 9a74449 (Revert "Merge branch 'develop-web-test' of https://gitlab.fing.edu.uy/tprog/tpgr14 into develop-web-test")
}
