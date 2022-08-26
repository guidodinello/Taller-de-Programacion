package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import logica.controladores.CtrlUsuario;
import logica.interfaces.Fabrica;
import logica.interfaces.ICtrlUsuario;
import datatypes.tipoUsuario;
import excepciones.NoExisteUsuario;
import excepciones.YaExisteException;
import datatypes.DTUsuario;

public class altaUsuario {
	private static ICtrlUsuario controladorUsuario;
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		controladorUsuario = fabrica.getICtrlUsuario();
	}
	
	@Test
	void testRegistrarProveedorOK() {
		String nick = "prov_nick";
		String em = "prov_email";
		String nom = "prov_nombre";
		String ap = "prov_apellido";
		GregorianCalendar fecha = new GregorianCalendar();
		tipoUsuario tipo = tipoUsuario.proveedor;
		String nacio = "uruguaya";
		String desc = "un proveedor";
		String sitioweb = "google.com";
		
		try {
			controladorUsuario.altaUsuario(nick, em, nom, ap, fecha, tipo, nacio, desc, sitioweb);
			DTUsuario du = controladorUsuario.getInfoBasicaUsuario(nick);
			
			assertEquals(du.getNickname(), nick);
			assertEquals(du.getEmail(), em);
			assertEquals(du.getFechaNac(), fecha);
			assertEquals(du.getNombre(), nom);
			assertEquals(du.getApellido(), ap);
		} catch (YaExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		};
	}

	@Test
	void testRegistrarProveedorRepetido() {
		String nick = "prov_nick";
		String em = "prov_email";
		String nom = "prov_nombre";
		String ap = "prov_apellido";
		GregorianCalendar fecha = new GregorianCalendar();
		tipoUsuario tipo = tipoUsuario.proveedor;
		String nacio = "uruguaya";
		String desc = "un proveedor";
		String sitioweb = "google.com";

		try {
			controladorUsuario.altaUsuario(nick, em, nom, ap, fecha, tipo, nacio, desc, sitioweb);
		} catch (YaExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		};
		//esta es la prueba
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nick, em, nom, ap, fecha, tipo, nacio, desc, sitioweb);});	
	}

	@Test
	void testVerInfoUsuario() {
		fail("Not yet implemented");
	}

	@Test
	void testGetUsuarios() {
		fail("Not yet implemented");
	}


}