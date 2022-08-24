package datatypes;

import java.util.GregorianCalendar;
import logica.clases.Usuario;

public class DTUsuario {
	private String nickname;
	private String email;
	private GregorianCalendar fechaDeNacimiento;
	private String nombre;
	private String apellido;
	
	public DTUsuario(Usuario usuario) {
		nickname = usuario.getNickname();
		email = usuario.getEmail();
		fechaDeNacimiento = usuario.getFechaDeNacimiento();
		nombre = usuario.getNombre();
		apellido = usuario.getApellido();
	}
	
}
