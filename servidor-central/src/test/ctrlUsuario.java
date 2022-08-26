package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import logica.interfaces.Fabrica;
import logica.interfaces.ICtrlUsuario;
import datatypes.tipoUsuario;
import excepciones.YaExisteException;
import datatypes.DTUsuario;

public class ctrlUsuario {
	private static ICtrlUsuario controladorUsuario;
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		controladorUsuario = fabrica.getICtrlUsuario();
	}
	
	@Test
	void testAltaProveedorOK() {
		String nick = "prov_nick";
		String em = "prov_email";
		String nom = "prov_nombre";
		String ap = "prov_apellido";
		GregorianCalendar fecha = new GregorianCalendar(2022, 12, 1);
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
	void testAltaTuristaOK() {
		String nick = "tur_nick";
		String em = "tur_email";
		String nom = "tur_nombre";
		String ap = "tur_apellido";
		GregorianCalendar fecha = new GregorianCalendar(2022, 12, 1);
		tipoUsuario tipo = tipoUsuario.turista;
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
	void testProveedorRepetido() {
		String nick = "prov_nick";
		String em = "prov_email";
		String nom = "prov_nombre";
		String ap = "prov_apellido";
		GregorianCalendar fecha = new GregorianCalendar(2022, 12, 1);
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
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nick, em, nom, ap, fecha, tipo, nacio, desc, sitioweb);});	
	}

	@Test
	void ingresarInscripcionOK() { 
		String nick = "tur_nick";
		String salida = "salida_test";
		int cant = 5;
		GregorianCalendar fecha = new GregorianCalendar(2022, 12, 1);
		
		controladorUsuario.ingresarInscripcion(nick, salida, cant, fecha); 
	}

}

//	@Test
//	void testGetUsuarios() {
//		fail("Not yet implemented");
//	}