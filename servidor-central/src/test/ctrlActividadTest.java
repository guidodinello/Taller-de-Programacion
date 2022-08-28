package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import datatypes.tipoUsuario;
import excepciones.InscriptionFailException;
import excepciones.YaExisteException;
import logica.clases.SalidaTuristica;
import logica.handlers.HandlerActividades;
import logica.handlers.HandlerDepartamentos;
import logica.handlers.HandlerSalidas;
import logica.interfaces.Fabrica;
import logica.interfaces.ICtrlActividad;
import logica.interfaces.ICtrlUsuario;
import datatypes.DTActividad;
import datatypes.DTSalida;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ctrlActividadTest{
	private static ICtrlActividad controladorActividad;
	private static ICtrlUsuario controladorUsuario;
	private static HandlerActividades hA;
	
	public void ctrlActividadTest() {}
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		//HandlerActividades.clear();
		hA = HandlerActividades.getInstance();
		controladorActividad = fabrica.getICtrlActividad();
		controladorUsuario = fabrica.getICtrlUsuario();
		HandlerDepartamentos.clear();
		DepartamentosTest testDepartamentos = DepartamentosTest.getInstance();
		testDepartamentos.testAltaDepartamentosOk();
		/*try {
			String nombreDepto1 = "Montevideo";
			String nombreDepto2 = "Canelones";
			String nombreDepto3 = "Artigas";
			controladorActividad.altaDepartamento(nombreDepto1, "Capital de Uruguay", "mvdeo.com.uy");
			controladorActividad.altaDepartamento(nombreDepto2, "Me gustan los canelones", "canelones.com.uy");
			controladorActividad.altaDepartamento(nombreDepto3, "El procer", "artigas.com.uy");
			assertEquals(controladorActividad.listarDepartamentos().isEmpty(), false);
			assertEquals(controladorActividad.listarDepartamentos().contains(nombreDepto1), true);
			assertEquals(controladorActividad.listarDepartamentos().contains(nombreDepto2), true);
			assertEquals(controladorActividad.listarDepartamentos().contains(nombreDepto3), true);
		}catch(Exception e) {
			e.printStackTrace();
		}*/
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
		
		//Poner algunos usuarios cuando lo necesitemos
		
		/*try {
			controladorUsuario.altaUsuario("cris", "cris@", "Cristian", "Gonzalez", new GregorianCalendar(), tipoUsuario.proveedor, "uruguayo", "provee cosas", "cris.com");
			controladorUsuario.altaUsuario("agus", "agus@", "Agustin", "Franco", new GregorianCalendar(), tipoUsuario.turista, "uruguayo", null, null);
			controladorUsuario.altaUsuario("eze", "eze@", "Ezequiel", "Medeiros", new GregorianCalendar(), tipoUsuario.turista, "uruguayo", null, null);
			controladorUsuario.altaUsuario("manuT1", "emailT1", "nombreT1", "apellidT1", new GregorianCalendar(), tipoUsuario.turista, "uru", null, null);
			controladorUsuario.altaUsuario("manuT2", "emailT2", "nombreT2", "apellidT2", new GregorianCalendar(), tipoUsuario.turista, "uru", null, null );
			controladorUsuario.altaUsuario("manuP1", "emailP1", "nombreP1", "apellidP1", new GregorianCalendar(), tipoUsuario.proveedor, "uruguayo", "descManuP1", "linkP1" );
			controladorUsuario.altaUsuario("manuP2", "emailP2", "nombreP2", "apellidP2", new GregorianCalendar(), tipoUsuario.proveedor, "uruguayo", "descManuP2", "linkP2" );
		} catch (YaExisteException e2) {
			e2.printStackTrace();
		}*/
		
		/*try {
			controladorActividad.altaDepartamento("Montevideo", "Capital de Uruguay", "mvdeo.com.uy");
			controladorActividad.altaDepartamento("Canelones", "Me gustan los canelones", "canelones.com.uy");
			controladorActividad.altaDepartamento("Artigas", "El procer", "artigas.com.uy");
		} catch (YaExisteException e1) {
			e1.printStackTrace();
		}*/
		/*try {
			controladorActividad.altaActividadTuristica("Montevideo", "Actividad 1", "act1 d", 2, 10, "Centro", "cris", null);
			controladorActividad.altaActividadTuristica("Canelones", "Actividad 2", "act2 d", 2, 10, "Paso palomeque", "cris", null);
			controladorActividad.altaActividadTuristica("Artigas", "Actividad 3", "act3 d", 2, 10, "Cerro Signorelli", "cris", null);
			controladorActividad.altaActividadTuristica("Montevideo", "Actividad 4", "descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga"
					+ "descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga"
					+ "descripcion larga descripcion larga descripcion larga descripcion larga", 3, 420, "Centro", "cris", null);
		} catch (YaExisteException e2) {
			e2.printStackTrace();
		}*/
		
		/*GregorianCalendar fecha = new GregorianCalendar(2022,8,30);
		try {
			controladorActividad.altaSalidaTuristica("A Centro", fecha, "Centro", 10, new GregorianCalendar(), "Actividad 1");
			controladorActividad.altaSalidaTuristica("A Palomeque", fecha, "Palomeque", 10, new GregorianCalendar(), "Actividad 2");
			controladorActividad.altaSalidaTuristica("A Canelones", new GregorianCalendar(2021, 1, 20), "Canelones", 10, new GregorianCalendar(), "Actividad 2");
			controladorActividad.altaSalidaTuristica("Al Cerro", fecha, "Cerro Signorelli", 10, new GregorianCalendar(), "Actividad 3");
		} catch (YaExisteException e1) {
			e1.printStackTrace();
		}*/
		
		/*try {
			controladorUsuario.ingresarInscripcion("eze", "Al Cerro", 5, new GregorianCalendar());
		} catch(InscriptionFailException e) {
			e.printStackTrace();
		}*/
	}
	
	@Test
	@Order(1)
	void testListarActividadesDepartamentoVacia() {
		String nombreDepto1 = "Montevideo";
		String nombreDepto2 = "Canelones";
		String nombreDepto3 = "Artigas";
		assertEquals(controladorActividad.listarActividadesDepartamento(nombreDepto1).isEmpty(), true);
		assertEquals(controladorActividad.listarActividadesDepartamento(nombreDepto2).isEmpty(), true);
		assertEquals(controladorActividad.listarActividadesDepartamento(nombreDepto3).isEmpty(), true);
	}
	
	@Test
	@Order(2)
	void testAltaActividadesOK() {
		try {
			String deptoActividad1 = "Montevideo";
			String deptoActividad2 = "Canelones";
			String deptoActividad3 = "Artigas";
			String deptoActividad4 = "Montevideo";
			
			String nombActividad1 = "Actividad 1";
			String nombActividad2 = "Actividad 2";
			String nombActividad3 = "Actividad 3";
			String nombActividad4 = "Actividad 4";
			
			String desActividad1 = "act1 d";
			String desActividad2 = "act2 d";
			String desActividad3 = "act3 d";
			String desActividad4 = "descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga"
					+ "descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga"
					+ "descripcion larga descripcion larga descripcion larga descripcion larga";
			
			int duraHsActividad1 = 2;
			int duraHsActividad2 = 3;
			int duraHsActividad3 = 4;;
			int duraHsActividad4 = 5;
			
			float costoActividad1 = 11;
			float costoActividad2 = 12;
			float costoActividad3 = 13;
			float costoActividad4 = 420;
			
			String ciudadActividad1 = "Centro";
			String ciudadActividad2 = "Paso palomeque";
			String ciudadActividad3 = "Cerro Signorelli";
			String ciudadActividad4 = "Centro";
			
			String nickProvAct1 = "cris";
			String nickProvAct2 = "cris";
			String nickProvAct3 = "cris";
			String nickProvAct4 = "cris";
			
			GregorianCalendar fechaAct1 = new GregorianCalendar(2000, 2, 2);
			GregorianCalendar fechaAct2 = new GregorianCalendar(2000, 3, 2);
			GregorianCalendar fechaAct3 = new GregorianCalendar(2001, 3, 2);
			GregorianCalendar fechaAct4 = new GregorianCalendar(2001, 3, 3);;
			
			
			controladorActividad.altaActividadTuristica(deptoActividad1, nombActividad1, desActividad1, duraHsActividad1, costoActividad1, ciudadActividad1, nickProvAct1, fechaAct1);
			controladorActividad.altaActividadTuristica(deptoActividad2, nombActividad2, desActividad2, duraHsActividad2, costoActividad2, ciudadActividad2, nickProvAct2, fechaAct2);
			controladorActividad.altaActividadTuristica(deptoActividad3, nombActividad3, desActividad3, duraHsActividad3, costoActividad3, ciudadActividad3, nickProvAct3, fechaAct3);
			controladorActividad.altaActividadTuristica(deptoActividad4, nombActividad4, desActividad4, duraHsActividad4, costoActividad4, ciudadActividad4, nickProvAct4, fechaAct4);
			assertEquals(hA.obtenerActividadTuristica(nombActividad1).getNombre(),nombActividad1);
			assertEquals(hA.obtenerActividadTuristica(nombActividad2).getNombre(),nombActividad2);
			assertEquals(hA.obtenerActividadTuristica(nombActividad3).getNombre(),nombActividad3);
			assertEquals(hA.obtenerActividadTuristica(nombActividad4).getNombre(),nombActividad4);
			
			assertEquals(hA.obtenerActividadTuristica(nombActividad1).getDescripcion(),desActividad1);
			assertEquals(hA.obtenerActividadTuristica(nombActividad2).getDescripcion(),desActividad2);
			assertEquals(hA.obtenerActividadTuristica(nombActividad3).getDescripcion(),desActividad3);
			assertEquals(hA.obtenerActividadTuristica(nombActividad4).getDescripcion(),desActividad4);
			
			assertEquals(hA.obtenerActividadTuristica(nombActividad1).getDuracionHs(),duraHsActividad1);
			assertEquals(hA.obtenerActividadTuristica(nombActividad2).getDuracionHs(),duraHsActividad2);
			assertEquals(hA.obtenerActividadTuristica(nombActividad3).getDuracionHs(),duraHsActividad3);
			assertEquals(hA.obtenerActividadTuristica(nombActividad4).getDuracionHs(),duraHsActividad4);
			
			assertEquals(hA.obtenerActividadTuristica(nombActividad1).getCostoPorTurista(),costoActividad1);
			assertEquals(hA.obtenerActividadTuristica(nombActividad2).getCostoPorTurista(),costoActividad2);
			assertEquals(hA.obtenerActividadTuristica(nombActividad3).getCostoPorTurista(),costoActividad3);
			assertEquals(hA.obtenerActividadTuristica(nombActividad4).getCostoPorTurista(),costoActividad4);
			
			assertEquals(hA.obtenerActividadTuristica(nombActividad1).getNombreCiudad(),ciudadActividad1);
			assertEquals(hA.obtenerActividadTuristica(nombActividad2).getNombreCiudad(),ciudadActividad2);
			assertEquals(hA.obtenerActividadTuristica(nombActividad3).getNombreCiudad(),ciudadActividad3);
			assertEquals(hA.obtenerActividadTuristica(nombActividad4).getNombreCiudad(),ciudadActividad4);
			
			assertEquals(hA.obtenerActividadTuristica(nombActividad1).getFechaAlta(),fechaAct1);
			assertEquals(hA.obtenerActividadTuristica(nombActividad2).getFechaAlta(),fechaAct2);
			assertEquals(hA.obtenerActividadTuristica(nombActividad3).getFechaAlta(),fechaAct3);
			assertEquals(hA.obtenerActividadTuristica(nombActividad4).getFechaAlta(),fechaAct4);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@Order(3)
	void testAltaActividadesRepetidas() {
		String deptoActividad1 = "Montevideo";
		String deptoActividad2 = "Canelones";
		String deptoActividad3 = "Artigas";
		String deptoActividad4 = "Montevideo";
		
		String nombActividad1 = "Actividad 1";
		String nombActividad2 = "Actividad 2";
		String nombActividad3 = "Actividad 3";
		String nombActividad4 = "Actividad 4";
		
		String desActividad1 = "act1 d";
		String desActividad2 = "act2 d";
		String desActividad3 = "act3 d";
		String desActividad4 = "descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga"
				+ "descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga descripcion larga"
				+ "descripcion larga descripcion larga descripcion larga descripcion larga";
		
		int duraHsActividad1 = 2;
		int duraHsActividad2 = 2;
		int duraHsActividad3 = 2;;
		int duraHsActividad4 = 3;
		
		float costoActividad1 = 10;
		float costoActividad2 = 10;
		float costoActividad3 = 10;
		float costoActividad4 = 420;
		
		String ciudadActividad1 = "Centro";
		String ciudadActividad2 = "Paso palomeque";
		String ciudadActividad3 = "Cerro Signorelli";
		String ciudadActividad4 = "Centro";
		
		String nickProvAct1 = "cris";
		String nickProvAct2 = "cris";
		String nickProvAct3 = "cris";
		String nickProvAct4 = "cris";
		
		GregorianCalendar fechaAct1 = new GregorianCalendar(2000, 2, 2);
		GregorianCalendar fechaAct2 = new GregorianCalendar(2000, 3, 2);
		GregorianCalendar fechaAct3 = new GregorianCalendar(2001, 3, 2);
		GregorianCalendar fechaAct4 = new GregorianCalendar(2001, 3, 3);
		
		assertThrows(YaExisteException.class, ()->{controladorActividad.altaActividadTuristica(deptoActividad1, nombActividad1, desActividad1, duraHsActividad1, costoActividad1, ciudadActividad1, nickProvAct1, fechaAct1);});
		assertThrows(YaExisteException.class, ()->{controladorActividad.altaActividadTuristica(deptoActividad2, nombActividad2, desActividad2, duraHsActividad2, costoActividad2, ciudadActividad2, nickProvAct2, fechaAct2);});
		assertThrows(YaExisteException.class, ()->{controladorActividad.altaActividadTuristica(deptoActividad3, nombActividad3, desActividad3, duraHsActividad3, costoActividad3, ciudadActividad3, nickProvAct3, fechaAct3);});
		assertThrows(YaExisteException.class, ()->{controladorActividad.altaActividadTuristica(deptoActividad4, nombActividad4, desActividad4, duraHsActividad4, costoActividad4, ciudadActividad4, nickProvAct4, fechaAct4);});
		
	}
	
	@Test
	@Order(4)
	void testListarActividadesDepartamento() {
		String nombreDepto1 = "Montevideo";
		String nombreDepto2 = "Canelones";
		String nombreDepto3 = "Artigas";
		String nombActividad1 = "Actividad 1";
		String nombActividad2 = "Actividad 2";
		String nombActividad3 = "Actividad 3";
		String nombActividad4 = "Actividad 4";
		
		assertEquals(controladorActividad.listarActividadesDepartamento(nombreDepto1).isEmpty(), false);
		assertEquals(controladorActividad.listarActividadesDepartamento(nombreDepto2).isEmpty(), false);
		assertEquals(controladorActividad.listarActividadesDepartamento(nombreDepto3).isEmpty(), false);
		
		assertEquals(controladorActividad.listarActividadesDepartamento(nombreDepto1).contains(nombActividad1), true);
		assertEquals(controladorActividad.listarActividadesDepartamento(nombreDepto1).contains(nombActividad2), false);
		assertEquals(controladorActividad.listarActividadesDepartamento(nombreDepto1).contains(nombActividad3), false);
		assertEquals(controladorActividad.listarActividadesDepartamento(nombreDepto1).contains(nombActividad4), true);
		
		assertEquals(controladorActividad.listarActividadesDepartamento(nombreDepto2).contains(nombActividad1), false);
		assertEquals(controladorActividad.listarActividadesDepartamento(nombreDepto2).contains(nombActividad2), true);
		assertEquals(controladorActividad.listarActividadesDepartamento(nombreDepto2).contains(nombActividad3), false);
		assertEquals(controladorActividad.listarActividadesDepartamento(nombreDepto2).contains(nombActividad4), false);
		
		assertEquals(controladorActividad.listarActividadesDepartamento(nombreDepto3).contains(nombActividad1), false);
		assertEquals(controladorActividad.listarActividadesDepartamento(nombreDepto3).contains(nombActividad2), false);
		assertEquals(controladorActividad.listarActividadesDepartamento(nombreDepto3).contains(nombActividad3), true);
		assertEquals(controladorActividad.listarActividadesDepartamento(nombreDepto3).contains(nombActividad4), false);
		
	}
	
	@Test
	@Order(5)
	void testGetInfoActividad() {
		String actividad = "Actividad 1";
		DTActividad da = controladorActividad.getInfoActividad(actividad);
		
		assertEquals(da.getNombre(), "Actividad 1");
		assertEquals(da.getDescripcion(), "act1 d");
		assertEquals(da.getDuracionHs(), 2);
		assertEquals(da.getCosto(), 11);
		
		actividad = "Actividad 2";
		da = controladorActividad.getInfoActividad(actividad);
		assertEquals(da.getNombre(), "Actividad 2");
		assertEquals(da.getDescripcion(), "act2 d");
		assertEquals(da.getDuracionHs(), 3);
		assertEquals(da.getCosto(), 12);
	}
	
	
	
	
	/*@Test
	void testAltaDepartamentoRepetido() {
		    assertThrows(YaExisteException.class, ()->{controladorActividad.altaDepartamento("Montevideo", "Capital de Uruguay", "mvdeo.com.uy");});			
	}
	
	@Test
	void testListarDepartamentos() {
		Set<String> deptos = controladorActividad.listarDepartamentos();
		assertEquals(deptos.contains("Montevideo"), true);
		assertEquals(deptos.contains("Canelones"), true);
		assertEquals(deptos.contains("Artigas"), true);
		assertEquals(deptos.contains("NoDepartamento"), false);
	}
	

	////////////////////////////////////////////TEST SALIDAS////////////////////////////////////////////////////////////////////////
	@Test
	void testListarInfoSalidasVigentes() {
		Set<DTSalida> salidasAct1 = controladorActividad.listarInfoSalidasVigentes("Actividad 1", new GregorianCalendar());
		Set<String> salidasAct1St = new HashSet<String>();
		salidasAct1.forEach((e) -> {salidasAct1St.add(e.getNombre());});
		
		assertEquals(salidasAct1St.contains("A Centro"), true);
		assertEquals(salidasAct1St.contains("Al Cerro"), false);
		
		Set<DTSalida> salidasAct2 = controladorActividad.listarInfoSalidasVigentes("Actividad 2", new GregorianCalendar());
		Set<String> salidasAct2St = new HashSet<String>();
		salidasAct2.forEach((e) -> {salidasAct2St.add(e.getNombre());});
		
		assertEquals(salidasAct2St.contains("A Canelones"), false);
		assertEquals(salidasAct2St.contains("A Palomeque"), true);
		assertEquals(salidasAct2St.contains("Al Cerro"), false);
		
	}
	
	@Test
	void testlistarNombresSalidasDeActividad(){
	
	 Set<String> salidas =  controladorActividad.listarNombresSalidasDeActividad("Actividad 1");
	
	 assertEquals(salidas.contains("A Centro"),true, "La salida asociada a la Actividad 1 es A centro");
		
	 Set<String> salidas2 =  controladorActividad.listarNombresSalidasDeActividad("Actividad 2");
	
	 assertEquals(salidas2.contains("A Palomeque"),true, "La salida asociada a la Actividad 2 es A Palomeque");
	 assertEquals(salidas2.contains("A Canelones"),true, "La salida asociada a la Actividad 2 es A Canelones");
		
	 Set<String> salidas3 =  controladorActividad.listarNombresSalidasDeActividad("Actividad 3");
	
	 assertEquals(salidas3.contains("Al Cerro"),true, "La salida asociada a la Actividad 3 es Al cerro");
	}
	
	@Test 
	void testAltaSalidaTuristicaFail() {
		assertThrows(YaExisteException.class,()->{controladorActividad.altaSalidaTuristica("A Centro", new GregorianCalendar(), "Centro", 10, new GregorianCalendar(), "Actividad 1");});
	}
	
	@Test
	void testgetInfoCompletaSalida() {

		
		DTSalida nueva =  controladorActividad.getInfoCompletaSalida("A Canelones");
		assertEquals("A Canelones", nueva.getNombre());
		assertEquals("Centro", nueva.getlugarSalida());
		assertEquals(10, nueva.getcantidadMaximaDeTuristas());
		assertEquals(nueva.getTuristasInscriptos().contains("agus"),false,"No hay turistas inscirptos");
		
	}*/
}


