package logica.clases;

import java.util.GregorianCalendar;

public class Proveedor extends Usuario {
	
	String descripcion, sitioWeb;
	
	public Proveedor(String nickname, String email, String nombre, String apellido, GregorianCalendar fechaNac, String descripcion, String sitioWeb) {
		super(nickname, email, nombre, apellido, fechaNac);
		this.descripcion = descripcion;
		this.sitioWeb = sitioWeb;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getSitioWeb() {
		return sitioWeb;
	}

}
