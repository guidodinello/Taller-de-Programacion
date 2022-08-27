package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import logica.clases.Turista;
import logica.handlers.HandlerUsuarios;
import logica.interfaces.Fabrica;
import logica.interfaces.ICtrlUsuario;
import logica.interfaces.ICtrlActividad;
import datatypes.tipoUsuario;
import excepciones.InscriptionFailException;
import excepciones.YaExisteException;
import datatypes.DTUsuario;
import datatypes.DTActividad;
import datatypes.DTSalida;

public class ctrlUsuario {
	private static ICtrlUsuario controladorUsuario;
	private static ICtrlActividad controladorActividad;
	
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		controladorUsuario = fabrica.getICtrlUsuario();
		controladorActividad = fabrica.getICtrlActividad();
		 try {
				controladorUsuario.actualizarUsuario("usr_nick", "usr_nombre", "usr_apellido", new GregorianCalendar(1,1,1), tipoUsuario.turista, null, "usr_descripcion", "usr_stiioWeb");
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
				controladorActividad.altaSalidaTuristica("A Canelones", fecha, "Canelones", 10, new GregorianCalendar(1,1,1), "Actividad 2");
				controladorActividad.altaSalidaTuristica("Al Cerro", fecha, "Cerro Signorelli", 10, new GregorianCalendar(1,1,3), "Actividad 3");
			} catch (YaExisteException e1) {
				e1.printStackTrace();
			}
			
			try {
				controladorUsuario.ingresarInscripcion("eze", "Al Cerro", 5, new GregorianCalendar(1,1,4));
				controladorUsuario.ingresarInscripcion("eze", "A Canelones", 7, new GregorianCalendar(1,1,2));
			} catch(InscriptionFailException e) {
				e.printStackTrace();
			}
		
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
		
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nick, em, nom, ap, fecha, tipo, nacio, desc, sitioweb);});	
	}

	@Test
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
	void testInscripcionRepetida() {
		String nick = "eze";
		String salida = "Al Cerro";
		int cant = 1;
		
		assertThrows(InscriptionFailException.class, ()->{controladorUsuario.ingresarInscripcion(nick, salida, cant, new GregorianCalendar());});
	}
	
	@Test
	void testInscripcionPlazosExcedidos() {
		String nick = "agus";
		String salida = "Al Cerro";
		int cant = 6;
		
		assertThrows(InscriptionFailException.class, ()->{controladorUsuario.ingresarInscripcion(nick, salida, cant, new GregorianCalendar());});
	}
	
	@Test
	void testListarTuristas() {
		Set<String> turistas = controladorUsuario.listarTuristas();
		
		assertEquals(turistas.contains("agus"), true);
		assertEquals(turistas.contains("eze"), true);
		assertEquals(turistas.contains("manuT1"), true);
		assertEquals(turistas.contains("manuT2"), true);
		assertEquals(turistas.contains("cris"), false);
		assertEquals(turistas.contains("manuP1"), false);
	}
	
	@Test
	void testListarProveedores() {
		Set<String> proveedores = controladorUsuario.listarProveedores();
		
		assertEquals(proveedores.contains("agus"), false);
		assertEquals(proveedores.contains("eze"), false);
		assertEquals(proveedores.contains("manuT1"), false);
		assertEquals(proveedores.contains("manuT2"), false);
		assertEquals(proveedores.contains("cris"), true);
		assertEquals(proveedores.contains("manuP1"), true);
	}


	@Test
	void testlistarUsuarios() {
		Set<String> usuarios = controladorUsuario.listarUsuarios();
		
		assertEquals(usuarios.contains("cris"), true);
		assertEquals(usuarios.contains("agus"), true);
		assertEquals(usuarios.contains("eze"), true);
		assertEquals(usuarios.contains("manuT1"), true);
		assertEquals(usuarios.contains("manuT2"), true);
		assertEquals(usuarios.contains("manuP1"), true);
		assertEquals(usuarios.contains("manuP2"), true);
		
	}
	
	@Test
	public void testactualizarUsuario() { 
		controladorUsuario.actualizarUsuario("usr_nick", "usr_nombre", "usr_apellido", new GregorianCalendar(1,1,1), tipoUsuario.turista, "", "usr_descripcion", "usr_stiioWeb");
	}
	
	@Test
	public void testlistarInfoSalidasTurista(){ 
		String t = "eze";
		Set<DTSalida> obtenido = controladorUsuario.listarInfoSalidasTurista(t);
		
		Map<String, DTSalida> esperado = new HashMap<String, DTSalida>();
		
		esperado.put("A Canelones", controladorActividad.getInfoCompletaSalida("A Canelones"));
		esperado.put("Al Cerro", controladorActividad.getInfoCompletaSalida("Al Cerro"));

		for (DTSalida dts : obtenido) {
			DTSalida sal = esperado.get(dts.getNombre());
			assertEquals(dts.getfechaSalida(), sal.getfechaSalida());
			assertEquals(dts.getfechaAlta(), sal.getfechaAlta());
			assertEquals(dts.getcantidadMaximaDeTuristas(), sal.getcantidadMaximaDeTuristas());
			assertEquals(dts.getlugarSalida(), sal.getlugarSalida());
			
			for (String turistas : dts.getTuristasInscriptos()) {
				assertEquals(sal.getTuristasInscriptos().contains(turistas), true);
			}
		}
		
 	}
	
	
	@Test
	public void listarInfoCompletaActividadesProveedor() {
		String p = "cris";
		Set<DTActividad> obtenido = controladorUsuario.listarInfoCompletaActividadesProveedor(p);
		
		Map<String, DTActividad> esperado = new HashMap<String, DTActividad>();
		
		esperado.put("Actividad 1", controladorActividad.getInfoActividad("Actividad 1"));
		esperado.put("Actividad 2", controladorActividad.getInfoActividad("Actividad 2"));
		esperado.put("Actividad 3", controladorActividad.getInfoActividad("Actividad 3"));
		esperado.put("Actividad 4", controladorActividad.getInfoActividad("Actividad 4"));
		
		for (DTActividad dta : obtenido) {
			DTActividad act = esperado.get(dta.getNombre());
			assertEquals(dta.getDescripcion(),act.getDescripcion());
			assertEquals(dta.getDepartamento(),act.getDepartamento());
			assertEquals(dta.getDuracionHs(),act.getDuracionHs());
			assertEquals(dta.getCosto(),act.getCosto());
			
			for (String salida : dta.getSalidas()) {
				assertEquals(act.getSalidas().contains(salida), true);
			}

			// no hay paquetes asique no se ejecuta
//			for (String paquete : dta.getPaquetes()) {
//				assertEquals(act.getPaquetes().contains(paquete), true);
//			}
		}
	}
	
}