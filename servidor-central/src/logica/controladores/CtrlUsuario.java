package logica.controladores;
import logica.interfaces.ICtrlUsuario;
import logica.clases.Proveedor;
import logica.clases.Turista;
import logica.clases.Usuario;
import logica.handlers.HandlerUsuarios;
import datatypes.tipoUsuario;

import java.util.Date;

public class CtrlUsuario implements ICtrlUsuario {
	
	public void altaUsuario(String nickname, String email, String nombre, String apellido, Date fechaNac, tipoUsuario tipo, String nacionalidad, String descripcion, String sitioWeb) {
		HandlerUsuarios hu = HandlerUsuarios.getInstance();
		Usuario usr;
		if (tipo == tipoUsuario.turista) {
			usr = new Turista(nickname, email, nombre, apellido, fechaNac, nacionalidad);
			hu.agregarTurista(usr);
		} else {
			usr = new Proveedor(nickname, email, nombre, apellido, fechaNac, descripcion, sitioWeb);
			hu.agregarProveedor(usr);
		}
		// cambiar hu.agregarUsuario
		hu.agregarUsuario(usr);
	}
}
