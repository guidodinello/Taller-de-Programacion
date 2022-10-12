package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Set;

import logica.handlers.HandlerActividades;
import logica.handlers.HandlerDepartamentos;
import logica.handlers.HandlerPaquetes;
import logica.handlers.HandlerSalidas;
import logica.handlers.HandlerUsuarios;
import logica.interfaces.Fabrica;
import logica.interfaces.ICtrlUsuario;
import logica.interfaces.ICtrlActividad;
import datatypes.tipoUsuario;
import excepciones.InscriptionFailException;
import excepciones.YaExisteException;
import datatypes.DTActividad;
import datatypes.DTProveedor;
import datatypes.DTSalida;
import datatypes.DTTurista;
import datatypes.estadoActividad;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ctrlUsuarioTest {
	private static ICtrlUsuario controladorUsuario;
	private static ICtrlActividad controladorActividad;
	private static HandlerUsuarios hU;
	
	public ctrlUsuarioTest() {
	}
	@BeforeAll
	public static void iniciar() {
		//clear a los handler
		HandlerActividades.clear();
		HandlerSalidas.clear();
		HandlerDepartamentos.clear();
		HandlerUsuarios.clear();
		HandlerPaquetes.clear();
		Fabrica fabrica = Fabrica.getInstance();
		hU = HandlerUsuarios.getInstance();
		controladorUsuario = fabrica.getICtrlUsuario();
		controladorActividad = fabrica.getICtrlActividad();
			try {
				controladorActividad.altaDepartamento("Montevideo", "Capital de Uruguay", "mvdeo.com.uy");
				controladorActividad.altaDepartamento("Canelones", "Me gustan los canelones", "canelones.com.uy");
				controladorActividad.altaDepartamento("Artigas", "El procer", "artigas.com.uy");
			} catch (YaExisteException e1) {
				e1.printStackTrace();
			}
			
			/*try {

			} catch(InscriptionFailException e) {
				e.printStackTrace();
			}*/
		
	}
	
	@Test
	@Order(1)
	void testListarUsuariosVacia() {
		assertEquals(controladorUsuario.listarUsuarios().isEmpty(), true);
		assertEquals(controladorUsuario.listarTuristas().isEmpty(), true);
		assertEquals(controladorUsuario.listarProveedores().isEmpty(), true);
	}
	
	@Test
	@Order(2)
	void testAltaUsuariosOk() {
		try {
			//turistas
			String nickT1 = "agus";
			String nickT2 = "eze";
			String nickT3 = "manuT1";
			String nickT4 = "manuT2";
			
			String emailT1 = "agus@";
			String emailT2 = "eze@";
			String emailT3 = "emailT1";
			String emailT4 = "emailT2";
			
			String nombT1 = "Agustin";
			String nombT2 = "Ezequiel";
			String nombT3 = "nombreT1";
			String nombT4 = "nombreT2";
			
			String apT1 = "Franco";
			String apT2 = "Medeiros";
			String apT3 = "apellidT1";
			String apT4 = "apellidT2";
			
			GregorianCalendar fechaNac1 = new GregorianCalendar(2000, 2, 2);
			GregorianCalendar fechaNac2 = new GregorianCalendar(1955, 2, 2);
			GregorianCalendar fechaNac3 = new GregorianCalendar(2003, 3, 3);
			GregorianCalendar fechaNac4 = new GregorianCalendar(2022, 12, 1);
			
			String nacionalidadT1 = "uruguayo";
			String nacionalidadT2 = "argentina";
			String nacionalidadT3 = "japonesa";
			String nacionalidadT4 = "algomas";
			
			//Proveedores
			String nickP1 = "manuP1";
			String nickP2 = "manuP2";
			String nickP3 = "cris";
			String nickP4 = "prov_nick";
			
			String emailP1 = "emailP1";
			String emailP2 = "emailP2";
			String emailP3 = "cris@";
			String emailP4 = "prov_email";
			
			String nombP1 = "nombreP1";
			String nombP2 = "nombreP2";
			String nombP3 = "Cristian";
			String nombP4 = "prov_nombre";
			
			String apP1 = "apellidP1";
			String apP2 = "apellidP2";
			String apP3 = "Gonzalez";
			String apP4 = "prov_apellido";
			
			String descP1 = "descManuP1";
			String descP2 = "descManuP2";
			String descP3 = "provee cosas";
			String descP4 = "un proveedor";
			
			String linkP1 = "linkP1";
			String linkP2 = "linkP2";
			String linkP3 = "cris.com";
			String linkP4 = "google.com";

			String pass = "password";
			String perfilImg = "imagen";
			
			controladorUsuario.altaUsuario(nickT1, emailT1, nombT1, apT1, pass, fechaNac1, perfilImg, tipoUsuario.turista, nacionalidadT1, null, null);
			controladorUsuario.altaUsuario(nickT2, emailT2, nombT2, apT2, pass, fechaNac2, perfilImg, tipoUsuario.turista, nacionalidadT2, null, null);
			controladorUsuario.altaUsuario(nickT3, emailT3, nombT3, apT3, pass, fechaNac3, perfilImg, tipoUsuario.turista, nacionalidadT3, null, null);
			controladorUsuario.altaUsuario(nickT4, emailT4, nombT4, apT4, pass, fechaNac4, perfilImg, tipoUsuario.turista, nacionalidadT4, null, null );
			controladorUsuario.altaUsuario(nickP1, emailP1, nombP1, apP1, pass, fechaNac1, perfilImg, tipoUsuario.proveedor, null, descP1, linkP1);
			controladorUsuario.altaUsuario(nickP2, emailP2, nombP2, apP2, pass, fechaNac2, perfilImg, tipoUsuario.proveedor, null, descP2, linkP2);
			controladorUsuario.altaUsuario(nickP3, emailP3, nombP3, apP3, pass, fechaNac3, perfilImg, tipoUsuario.proveedor, null, descP3, linkP3);
			controladorUsuario.altaUsuario(nickP4, emailP4, nombP4, apP4, pass, fechaNac4, perfilImg, tipoUsuario.proveedor, null, descP4, linkP4);
			
			assertEquals(controladorUsuario.listarUsuarios().isEmpty(), false);
			assertEquals(controladorUsuario.listarTuristas().isEmpty(), false);
			assertEquals(controladorUsuario.listarProveedores().isEmpty(), false);
			assertEquals(hU.getTuristaByNickname(nickT1).getNickname(), nickT1);
			assertEquals(hU.getTuristaByNickname(nickT2).getNickname(), nickT2);
			assertEquals(hU.getTuristaByNickname(nickT3).getNickname(), nickT3);
			assertEquals(hU.getTuristaByNickname(nickT4).getNickname(), nickT4);
			
			assertEquals(hU.getTuristaByNickname(nickT1).getEmail(), emailT1);
			assertEquals(hU.getTuristaByNickname(nickT2).getEmail(), emailT2);
			assertEquals(hU.getTuristaByNickname(nickT3).getEmail(), emailT3);
			assertEquals(hU.getTuristaByNickname(nickT4).getEmail(), emailT4);
			
			assertEquals(hU.getTuristaByNickname(nickT1).getNombre(), nombT1);
			assertEquals(hU.getTuristaByNickname(nickT2).getNombre(), nombT2);
			assertEquals(hU.getTuristaByNickname(nickT3).getNombre(), nombT3);
			assertEquals(hU.getTuristaByNickname(nickT4).getNombre(), nombT4);
			
			assertEquals(hU.getTuristaByNickname(nickT1).getFechaNac(), fechaNac1);
			assertEquals(hU.getTuristaByNickname(nickT2).getFechaNac(), fechaNac2);
			assertEquals(hU.getTuristaByNickname(nickT3).getFechaNac(), fechaNac3);
			assertEquals(hU.getTuristaByNickname(nickT4).getFechaNac(), fechaNac4);
			
			assertEquals(hU.getTuristaByNickname(nickT1).getNacionalidad(), nacionalidadT1);
			assertEquals(hU.getTuristaByNickname(nickT2).getNacionalidad(), nacionalidadT2);
			assertEquals(hU.getTuristaByNickname(nickT3).getNacionalidad(), nacionalidadT3);
			assertEquals(hU.getTuristaByNickname(nickT4).getNacionalidad(), nacionalidadT4);

			assertEquals(hU.getProveedorByNickname(nickP1).getNickname(), nickP1);
			assertEquals(hU.getProveedorByNickname(nickP2).getNickname(), nickP2);
			assertEquals(hU.getProveedorByNickname(nickP3).getNickname(), nickP3);
			assertEquals(hU.getProveedorByNickname(nickP4).getNickname(), nickP4);
			
			assertEquals(hU.getProveedorByNickname(nickP1).getEmail(), emailP1);
			assertEquals(hU.getProveedorByNickname(nickP2).getEmail(), emailP2);
			assertEquals(hU.getProveedorByNickname(nickP3).getEmail(), emailP3);
			assertEquals(hU.getProveedorByNickname(nickP4).getEmail(), emailP4);
			
			assertEquals(hU.getProveedorByNickname(nickP1).getNombre(), nombP1);
			assertEquals(hU.getProveedorByNickname(nickP2).getNombre(), nombP2);
			assertEquals(hU.getProveedorByNickname(nickP3).getNombre(), nombP3);
			assertEquals(hU.getProveedorByNickname(nickP4).getNombre(), nombP4);
			
			assertEquals(hU.getProveedorByNickname(nickP1).getFechaNac(), fechaNac1);
			assertEquals(hU.getProveedorByNickname(nickP2).getFechaNac(), fechaNac2);
			assertEquals(hU.getProveedorByNickname(nickP3).getFechaNac(), fechaNac3);
			assertEquals(hU.getProveedorByNickname(nickP4).getFechaNac(), fechaNac4);
			
			assertEquals(hU.getProveedorByNickname(nickP1).getDescripcion(), descP1);
			assertEquals(hU.getProveedorByNickname(nickP2).getDescripcion(), descP2);
			assertEquals(hU.getProveedorByNickname(nickP3).getDescripcion(), descP3);
			assertEquals(hU.getProveedorByNickname(nickP4).getDescripcion(), descP4);
			
			assertEquals(hU.getProveedorByNickname(nickP1).getSitioWeb(), linkP1);
			assertEquals(hU.getProveedorByNickname(nickP2).getSitioWeb(), linkP2);
			assertEquals(hU.getProveedorByNickname(nickP3).getSitioWeb(), linkP3);
			assertEquals(hU.getProveedorByNickname(nickP4).getSitioWeb(), linkP4);
			
		} catch (YaExisteException e2) {
			e2.printStackTrace();
		}
	}
	
	@Test
	@Order(2)
	void testAltaUsuarioNicknameException() {
		//turistas
		String nickT1 = "agus";
		String nickT2 = "eze";
		String nickT3 = "manuT1";
		String nickT4 = "manuT2";
		//email distintos
		String emailT1 = "agus@1";
		String emailT2 = "eze@1";
		String emailT3 = "emailT11";
		String emailT4 = "emailT21";
		
		String nombT1 = "Agustin";
		String nombT2 = "Ezequiel";
		String nombT3 = "nombreT1";
		String nombT4 = "nombreT2";
		
		String apT1 = "Franco";
		String apT2 = "Medeiros";
		String apT3 = "apellidT1";
		String apT4 = "apellidT2";
		
		GregorianCalendar fechaNac1 = new GregorianCalendar(2000, 2, 2);
		GregorianCalendar fechaNac2 = new GregorianCalendar(1955, 2, 2);
		GregorianCalendar fechaNac3 = new GregorianCalendar(2003, 3, 3);
		GregorianCalendar fechaNac4 = new GregorianCalendar(2022, 12, 1);
		
		String nacionalidadT1 = "uruguayo";
		String nacionalidadT2 = "argentina";
		String nacionalidadT3 = "japonesa";
		String nacionalidadT4 = "algomas";
		
		//Proveedores
		String nickP1 = "manuP1";
		String nickP2 = "manuP2";
		String nickP3 = "cris";
		String nickP4 = "prov_nick";
		
		String emailP1 = "emailP11";
		String emailP2 = "emailP21";
		String emailP3 = "cris@1";
		String emailP4 = "prov_email1";
		
		String nombP1 = "nombreP1";
		String nombP2 = "nombreP2";
		String nombP3 = "Cristian";
		String nombP4 = "prov_nombre";
		
		String apP1 = "apellidP1";
		String apP2 = "apellidP2";
		String apP3 = "Gonzalez";
		String apP4 = "prov_apellido";
		
		String descP1 = "descManuP1";
		String descP2 = "descManuP2";
		String descP3 = "provee cosas";
		String descP4 = "un proveedor";
		
		String linkP1 = "linkP1";
		String linkP2 = "linkP2";
		String linkP3 = "cris.com";
		String linkP4 = "google.com";

		String pass = "contrasena";
		String imgPerfil = "imagen";

		
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nickT1, emailT1, nombT1, apT1, pass, fechaNac1, imgPerfil,tipoUsuario.turista, nacionalidadT1, null, null);});
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nickT2, emailT2, nombT2, apT2, pass, fechaNac2, imgPerfil,tipoUsuario.turista, nacionalidadT2, null, null);});	
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nickT3, emailT3, nombT3, apT3, pass, fechaNac3, imgPerfil,tipoUsuario.turista, nacionalidadT3, null, null);});	
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nickT4, emailT4, nombT4, apT4, pass, fechaNac4, imgPerfil,tipoUsuario.turista, nacionalidadT4, null, null );});	
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nickP1, emailP1, nombP1, apP1, pass, fechaNac1, imgPerfil,tipoUsuario.proveedor, null, descP1, linkP1);});	
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nickP2, emailP2, nombP2, apP2, pass, fechaNac2, imgPerfil,tipoUsuario.proveedor, null, descP2, linkP2);});	
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nickP3, emailP3, nombP3, apP3, pass, fechaNac3, imgPerfil,tipoUsuario.proveedor, null, descP3, linkP3);});	
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nickP4, emailP4, nombP4, apP4, pass, fechaNac4, imgPerfil,tipoUsuario.proveedor, null, descP4, linkP4);});	
		
		
		
	}
	
	@Test
	@Order(3)
	void testAltaUsuarioEmailException() {
		//turistas
		//nickname distintos email iguales
		String nickT1 = "agus1";
		String nickT2 = "eze1";
		String nickT3 = "manuT11";
		String nickT4 = "manuT21";
		
		String emailT1 = "agus@";
		String emailT2 = "eze@";
		String emailT3 = "emailT1";
		String emailT4 = "emailT2";
		
		String nombT1 = "Agustin";
		String nombT2 = "Ezequiel";
		String nombT3 = "nombreT1";
		String nombT4 = "nombreT2";
		
		String apT1 = "Franco";
		String apT2 = "Medeiros";
		String apT3 = "apellidT1";
		String apT4 = "apellidT2";
		
		GregorianCalendar fechaNac1 = new GregorianCalendar(2000, 2, 2);
		GregorianCalendar fechaNac2 = new GregorianCalendar(1955, 2, 2);
		GregorianCalendar fechaNac3 = new GregorianCalendar(2003, 3, 3);
		GregorianCalendar fechaNac4 = new GregorianCalendar(2022, 12, 1);
		
		String nacionalidadT1 = "uruguayo";
		String nacionalidadT2 = "argentina";
		String nacionalidadT3 = "japonesa";
		String nacionalidadT4 = "algomas";
		
		//Proveedores
		String nickP1 = "manuP11";
		String nickP2 = "manuP1";
		String nickP3 = "cris1";
		String nickP4 = "prov_nick1";
		
		String emailP1 = "emailP1";
		String emailP2 = "emailP2";
		String emailP3 = "cris@";
		String emailP4 = "prov_email";
		
		String nombP1 = "nombreP1";
		String nombP2 = "nombreP2";
		String nombP3 = "Cristian";
		String nombP4 = "prov_nombre";
		
		String apP1 = "apellidP1";
		String apP2 = "apellidP2";
		String apP3 = "Gonzalez";
		String apP4 = "prov_apellido";
		
		String descP1 = "descManuP1";
		String descP2 = "descManuP2";
		String descP3 = "provee cosas";
		String descP4 = "un proveedor";
		
		String linkP1 = "linkP1";
		String linkP2 = "linkP2";
		String linkP3 = "cris.com";
		String linkP4 = "google.com";
		
		String pass = "contrasena";
		String perfilImg = "imagen";

		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nickT1, emailT1, nombT1, apT1, pass, fechaNac1, perfilImg, tipoUsuario.turista, nacionalidadT1, null, null);});
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nickT2, emailT2, nombT2, apT2, pass, fechaNac2, perfilImg, tipoUsuario.turista, nacionalidadT2, null, null);});	
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nickT3, emailT3, nombT3, apT3, pass, fechaNac3, perfilImg, tipoUsuario.turista, nacionalidadT3, null, null);});	
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nickT4, emailT4, nombT4, apT4, pass, fechaNac4, perfilImg, tipoUsuario.turista, nacionalidadT4, null, null );});	
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nickP1, emailP1, nombP1, apP1, pass, fechaNac1, perfilImg, tipoUsuario.proveedor, null, descP1, linkP1);});	
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nickP2, emailP2, nombP2, apP2, pass, fechaNac2, perfilImg, tipoUsuario.proveedor, null, descP2, linkP2);});	
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nickP3, emailP3, nombP3, apP3, pass, fechaNac3, perfilImg, tipoUsuario.proveedor, null, descP3, linkP3);});	
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nickP4, emailP4, nombP4, apP4, pass, fechaNac4, perfilImg, tipoUsuario.proveedor, null, descP4, linkP4);});	
		
	}
	@Test
	@Order(4)
	void testIngresarInscripcionOK() {
		//seteo actividades y salidas
		try {
			Set<String> setString = new HashSet<String>();

			controladorActividad.altaActividadTuristica("Montevideo", "Actividad 1", "act1 d", 2, 10, "Centro", "cris", null, "", setString);
			controladorActividad.altaActividadTuristica("Canelones", "Actividad 2", "act2 d", 2, 10, "Paso palomeque", "cris", null, "", setString);
			controladorActividad.altaActividadTuristica("Artigas", "Actividad 3", "act3 d", 2, 10, "Cerro Signorelli", "cris", null, "", setString);
			controladorActividad.altaActividadTuristica("Montevideo", "Actividad 4", "descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga"
					+ "descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga"
					+ "descripcion larga descripcion larga descripcion larga descripcion larga", 3, 420, "Centro", "cris", null, "", setString);
		} catch (YaExisteException e2) {
			e2.printStackTrace();
		}
		GregorianCalendar fecha = new GregorianCalendar(2023,8,30);
		try {
			controladorActividad.altaSalidaTuristica("A Centro", fecha, "Centro", 10, new GregorianCalendar(), "Actividad 1");
			controladorActividad.altaSalidaTuristica("A Palomeque", fecha, "Palomeque", 10, new GregorianCalendar(), "Actividad 2");
			controladorActividad.altaSalidaTuristica("A Canelones", fecha, "Canelones", 10, new GregorianCalendar(1,1,1), "Actividad 2");
			controladorActividad.altaSalidaTuristica("Al Cerro", fecha, "Cerro Signorelli", 10, new GregorianCalendar(1,1,3), "Actividad 3");
		} catch (YaExisteException e1) {
			e1.printStackTrace();
		}
		
		
		String nick1 = "agus";
		String salida1 = "A Centro";
		int cant1 = 5;
		
		String nick2 = "eze";
		String salida2 = "Al Cerro";
		int cant2 = 5;
		
		//String nick3 = "eze";
		String salida3 = "A Canelones";
		int cant3 = 7;
		
		try {
			controladorUsuario.ingresarInscripcion(nick1, salida1, cant1, new GregorianCalendar());
			controladorUsuario.ingresarInscripcion(nick2, salida2, cant2, new GregorianCalendar(1,1,4));
			controladorUsuario.ingresarInscripcion(nick1, salida3, cant3, new GregorianCalendar(1,1,2));
			
			assertEquals(controladorUsuario.listarInfoSalidasTurista(nick1).isEmpty(), false);
			assertEquals(controladorUsuario.listarInfoSalidasTurista(nick1).size(), 2);
			assertEquals(controladorUsuario.listarInfoSalidasTurista(nick2).isEmpty(), false);
			
		} catch (InscriptionFailException e) {
			fail(e.getMessage());
			e.printStackTrace();
		} 
	}

	@Test
	@Order(5)
	void testInscripcionRepetida() {
		String nick1 = "agus";
		String salida1 = "A Centro";
		int cant1 = 5;
		
		String nick2 = "eze";
		String salida2 = "Al Cerro";
		int cant2 = 5;
		
		//String nick3 = "eze";
		String salida3 = "A Canelones";
		int cant3 = 7;
		
		assertThrows(InscriptionFailException.class, ()->{controladorUsuario.ingresarInscripcion(nick1, salida1, cant1, new GregorianCalendar());});
		assertThrows(InscriptionFailException.class, ()->{controladorUsuario.ingresarInscripcion(nick2, salida2, cant2, new GregorianCalendar(1,1,4));});
		assertThrows(InscriptionFailException.class, ()->{controladorUsuario.ingresarInscripcion(nick1, salida3, cant3, new GregorianCalendar(1,1,2));});
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
		assertEquals(controladorUsuario.listarProveedores().contains("prov_nick"), true);
	}
	
	@Test
	@Order(8)
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
	@Order(9)
	public void testactualizarUsuario() {
		String nickT = "manuT1";
		String nickP = "prov_nick";
		
		controladorUsuario.actualizarUsuario(nickT, "usr_nombre", "usr_apellido", new GregorianCalendar(1,1,1), "wakandiano", null, null);
		controladorUsuario.actualizarUsuario(nickP, "usr_nombre", "usr_apellido", new GregorianCalendar(1,1,1), "", "usr_descripcion", "usr_stiioWeb");
		
		DTTurista duT =(DTTurista)controladorUsuario.getInfoBasicaUsuario(nickT);
		DTProveedor duP = (DTProveedor)controladorUsuario.getInfoBasicaUsuario(nickP);
		
		assertEquals(duT.getNickname(), nickT);
		assertEquals(duT.getNombre(), "usr_nombre");
		assertEquals(duT.getApellido(), "usr_apellido");
		assertEquals(duT.getFechaNac(), new GregorianCalendar(1,1,1));
		assertEquals(duT.getNacionalidad(), "wakandiano");
		
		assertEquals(duP.getNickname(), nickP);
		assertEquals(duP.getNombre(), "usr_nombre");
		assertEquals(duP.getApellido(), "usr_apellido");
		assertEquals(duP.getFechaNac(), new GregorianCalendar(1,1,1));
		assertEquals(duP.getDescripcion(), "usr_descripcion");
		assertEquals(duP.getLinkSitioWeb(), "usr_stiioWeb");
	}
	
	@Test
	@Order(10)
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
	@Order(11)
	public void testlistarInfoCompletaActividadesProveedor() {
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
			for (String paquete : dta.getPaquetes()) {
				assertEquals(act.getPaquetes().contains(paquete), true);
			}
		}
	}
	
	@Test
	@Order(12)
	void testGetInfoBasicaUsuario() {
		String nickT = "agus";
		String nickP = "cris";
		
		DTTurista duT =(DTTurista)controladorUsuario.getInfoBasicaUsuario(nickT);
		DTProveedor duP = (DTProveedor)controladorUsuario.getInfoBasicaUsuario(nickP);
		
		assertEquals(duT.getNickname(), nickT);
		assertEquals(duT.getNombre(), hU.getTuristaByNickname(nickT).getNombre());
		assertEquals(duT.getEmail(), hU.getTuristaByNickname(nickT).getEmail());
		assertEquals(duT.getApellido(), hU.getTuristaByNickname(nickT).getApellido());
		assertEquals(duT.getFechaNac(), hU.getTuristaByNickname(nickT).getFechaNac());
		assertEquals(duT.getNacionalidad(), hU.getTuristaByNickname(nickT).getNacionalidad());
		
		assertEquals(duP.getNombre(), hU.getProveedorByNickname(nickP).getNombre());
		assertEquals(duP.getEmail(), hU.getProveedorByNickname(nickP).getEmail());
		assertEquals(duP.getApellido(), hU.getProveedorByNickname(nickP).getApellido());
		assertEquals(duP.getFechaNac(), hU.getProveedorByNickname(nickP).getFechaNac());
		assertEquals(duP.getDescripcion(), hU.getProveedorByNickname(nickP).getDescripcion());
		assertEquals(duP.getLinkSitioWeb(), hU.getProveedorByNickname(nickP).getSitioWeb());
	}
	
	
	/*@Test
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
		
		assertThrows(YaExisteException.class, ()->{controladorUsuario.altaUsuario(nick, em, nom, ap, fecha, tipo, nacio, desc, sitioweb);});	
	}

	
	@Test
	@Order(10)
	public void testactualizarUsuario() { 
		controladorUsuario.actualizarUsuario("usr_nick", "usr_nombre", "usr_apellido", new GregorianCalendar(1,1,1), "", "usr_descripcion", "usr_stiioWeb");
	}
	
	@Test
	@Order(11)
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
	@Order(12)
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
	}*/
	
}