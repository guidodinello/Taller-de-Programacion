/*package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;
import java.util.Set;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import datatypes.tipoUsuario;
import excepciones.InscriptionFailException;
import excepciones.YaExisteException;
import logica.clases.SalidaTuristica;
import logica.handlers.HandlerSalidas;
import logica.interfaces.Fabrica;
import logica.interfaces.ICtrlActividad;
import logica.interfaces.ICtrlUsuario;
import datatypes.DTActividad;
import datatypes.DTSalida;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
		
public class ctrlActividad{
	private static ICtrlActividad controladorActividad;
	private static ICtrlUsuario controladorUsuario;
	
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		controladorActividad = fabrica.getICtrlActividad();
		controladorUsuario = fabrica.getICtrlUsuario();
		
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
			controladorActividad.altaSalidaTuristica("A Canelones", new GregorianCalendar(2021, 1, 20), "Canelones", 10, new GregorianCalendar(), "Actividad 2");
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
	
	@Test
	void testListarActividadesDepartamento() {
		Set<String> actMvdeo = controladorActividad.listarActividadesDepartamento("Montevideo");
		Set<String> actCane = controladorActividad.listarActividadesDepartamento("Canelones");
		Set<String> actArt = controladorActividad.listarActividadesDepartamento("Artigas");
		
		assertEquals(actMvdeo.contains("Actividad 1"), true);
		assertEquals(actMvdeo.contains("Actividad 2"), false);
		assertEquals(actMvdeo.contains("Actividad 3"), false);
		assertEquals(actMvdeo.contains("Actividad 4"), true);
		
		assertEquals(actCane.contains("Actividad 1"), false);
		assertEquals(actCane.contains("Actividad 2"), true);
		assertEquals(actCane.contains("Actividad 3"), false);
		assertEquals(actCane.contains("Actividad 4"), false);
		
		assertEquals(actArt.contains("Actividad 1"), false);
		assertEquals(actArt.contains("Actividad 2"), false);
		assertEquals(actArt.contains("Actividad 3"), true);
		assertEquals(actArt.contains("Actividad 4"), false);
	}
	
	@Test
	void testGetInfoActividad() {
		String actividad = "Actividad 1";
		DTActividad da = controladorActividad.getInfoActividad(actividad);
		
		assertEquals(da.getNombre(), "Actividad 1");
		assertEquals(da.getDescripcion(), "act1 d");
		assertEquals(da.getDuracionHs(), 2);
		assertEquals(da.getCosto(), 10);
		
		actividad = "Actividad 2";
		da = controladorActividad.getInfoActividad(actividad);
		assertEquals(da.getNombre(), "Actividad 2");
		assertEquals(da.getDescripcion(), "act2 d");
		assertEquals(da.getDuracionHs(), 2);
		assertEquals(da.getCosto(), 10);
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
		assertEquals("Canelones", nueva.getlugarSalida());
		assertEquals(10, nueva.getcantidadMaximaDeTuristas());
		assertEquals(nueva.getTuristasInscriptos().contains("agus"),false,"No hay turistas inscirptos");
		
	}
} */


