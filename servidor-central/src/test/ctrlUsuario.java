package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Set;

import logica.interfaces.Fabrica;
import logica.interfaces.ICtrlUsuario;
import logica.interfaces.ICtrlActividad;
import datatypes.tipoUsuario;
import excepciones.InscriptionFailException;
import excepciones.YaExisteException;
import datatypes.DTUsuario;
import datatypes.DTSalida;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ctrlUsuario {
	private static ICtrlUsuario controladorUsuario;
	private static ICtrlActividad controladorActividad;
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		controladorUsuario = fabrica.getICtrlUsuario();
		controladorActividad = fabrica.getICtrlActividad();
		 try {
				controladorUsuario.altaUsuario("cris", "cris@", "Cristian", "Gonzalez", new GregorianCalendar(), tipoUsuario.proveedor, "uruguayo", "provee cosas", "cris.com");
				controladorUsuario.altaUsuario("agus", "agus@", "Agustin", "Franco", new GregorianCalendar(), tipoUsuario.turista, "uruguayo", null, null);
				controladorUsuario.altaUsuario("eze", "eze@", "Ezequiel", "Medeiros", new GregorianCalendar(), tipoUsuario.turista, "uruguayo", null, null);
				controladorUsuario.altaUsuario("manuT1", "emailT1", "nombreT1", "apellidT1", new GregorianCalendar(), tipoUsuario.turista, "uru", null, null);
				controladorUsuario.altaUsuario("manuT2", "emailT2", "nombreT2", "apellidT2", new GregorianCalendar(), tipoUsuario.turista, "uru", null, null );
				controladorUsuario.altaUsuario("manuP1", "emailP1", "nombreP1", "apellidP1", new GregorianCalendar(), tipoUsuario.proveedor, "uruguayo", "descManuP1", "linkP1" );
				controladorUsuario.altaUsuario("manuP2", "emailP2", "nombreP2", "apellidP2", new GregorianCalendar(), tipoUsuario.proveedor, "uruguayo", "descManuP2", "linkP2" );
			} catch (YaExisteException e2) {
				e2.printStackTrace();
			}
			
			try {
				controladorActividad.altaDepartamento("Montevideo", "Capital de Uruguay", "mvdeo.com.uy");
				controladorActividad.altaDepartamento("Canelones", "Me gustan los canelones", "canelones.com.uy");
				controladorActividad.altaDepartamento("Artigas", "El procer", "artigas.com.uy");
			} catch (YaExisteException e1) {
				e1.printStackTrace();
			}
			try {
				controladorActividad.altaActividadTuristica("Montevideo", "Actividad 1", "act1 d", 2, 10, "Centro", "cris", null);
				controladorActividad.altaActividadTuristica("Canelones", "Actividad 2", "act2 d", 2, 10, "Paso palomeque", "cris", null);
				controladorActividad.altaActividadTuristica("Artigas", "Actividad 3", "act3 d", 2, 10, "Cerro Signorelli", "cris", null);
				controladorActividad.altaActividadTuristica("Montevideo", "Actividad 4", "descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga"
						+ "descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga"
						+ "descripcion larga descripcion larga descripcion larga descripcion larga", 3, 420, "Centro", "cris", null);
			} catch (YaExisteException e2) {
				e2.printStackTrace();
			}
			
			GregorianCalendar fecha = new GregorianCalendar(2022,8,30);
			try {
				controladorActividad.altaSalidaTuristica("A Centro", fecha, "Centro", 10, new GregorianCalendar(), "Actividad 1");
				controladorActividad.altaSalidaTuristica("A Palomeque", fecha, "Palomeque", 10, new GregorianCalendar(), "Actividad 2");
				controladorActividad.altaSalidaTuristica("A Canelones", fecha, "Canelones", 10, new GregorianCalendar(), "Actividad 2");
				controladorActividad.altaSalidaTuristica("Al Cerro", fecha, "Cerro Signorelli", 10, new GregorianCalendar(), "Actividad 3");
			} catch (YaExisteException e1) {
				e1.printStackTrace();
			}
			
			try {
				controladorUsuario.ingresarInscripcion("eze", "Al Cerro", 5, new GregorianCalendar());
			} catch(InscriptionFailException e) {
				e.printStackTrace();
			}
		
	}
	
	@Test
	@Order(1)
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
	@Order(2)
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
			assertEquals(controladorUsuario.listarTuristas().contains(nick), true);
		} catch (YaExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		};
	}

	@Test
	@Order(3)
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

		/*try {
			controladorUsuario.altaUsuario(nick, em, nom, ap, fecha, tipo, nacio, desc, sitioweb);
		} catch (YaExisteException e) {
			fail(e.getMessage());
			e.printStackTrace();
		};*/ // Creo que con excepciones solo hay que llamar esto:
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nick, em, nom, ap, fecha, tipo, nacio, desc, sitioweb);});	
	}

	@Test
	@Order(4)
	void testIngresarInscripcionOK() { 
		String nick = "agus";
		String salida = "A Centro";
		int cant = 5;
		try {
			controladorUsuario.ingresarInscripcion(nick, salida, cant, new GregorianCalendar());
			
		} catch (InscriptionFailException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} 
	}
	
	@Test
	@Order(5)
	void testInscripcionRepetida() {
		String nick = "eze";
		String salida = "Al Cerro";
		int cant = 1;
		
		assertThrows(InscriptionFailException.class, ()->{controladorUsuario.ingresarInscripcion(nick, salida, cant, new GregorianCalendar());});
	}
	
	@Test
	@Order(6)
	void testInscripcionPlazosExcedidos() {
		String nick = "agus";
		String salida = "Al Cerro";
		int cant = 6;
		
		assertThrows(InscriptionFailException.class, ()->{controladorUsuario.ingresarInscripcion(nick, salida, cant, new GregorianCalendar());});
	}
	
	@Test
	@Order(7)
	void testListarTuristas() {
		Set<String> turistas = controladorUsuario.listarTuristas();
		
		assertEquals(turistas.contains("agus"), true);
		assertEquals(turistas.contains("eze"), true);
		assertEquals(turistas.contains("manuT1"), true);
		assertEquals(turistas.contains("manuT2"), true);
		assertEquals(turistas.contains("cris"), false);
		assertEquals(turistas.contains("manuP1"), false);
		assertEquals(controladorUsuario.listarTuristas().contains("tur_nick"), true);
		assertEquals(controladorUsuario.listarProveedores().contains("prov_nick"), true);
	}
	
	
	
}

//	@Test
//	void testGetUsuarios() {
//		fail("Not yet implemented");
//	}