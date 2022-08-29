package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import datatypes.DTSalida;
import excepciones.YaExisteException;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import logica.handlers.HandlerActividades;
import logica.handlers.HandlerSalidas;
import logica.interfaces.Fabrica;
import logica.interfaces.ICtrlActividad;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestSalidas {
	  
	private static ICtrlActividad controladorActividad;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Fabrica fabrica = Fabrica.getInstance();
		controladorActividad = fabrica.getICtrlActividad();
		HandlerSalidas.clear();
		//TODO
		DepartamentosTest testDepartamentos = DepartamentosTest.getInstance();
		testDepartamentos.testAltaDepartamentosOk();
		ctrlActividadTest testAct = new ctrlActividadTest();
		testAct.testAltaActividadesOK();
	} 
///verifico que no hay salidas
	@Test
	@Order(1)
	void testListaSinSalidas() {
		HandlerSalidas hs = HandlerSalidas.getInstance();
		 assertEquals(hs.getSalidas().equals(null),true, "No hay salidas");
	}
	
	///verifico que se de de alta bien una salida
	@Test
	@Order(2)
	void testAltaSalidaOk() {
		GregorianCalendar fecha = new GregorianCalendar(2022,8,30);
		try {
			controladorActividad.altaSalidaTuristica("A Centro", fecha, "Centro", 10, new GregorianCalendar(), "Actividad 1");
			
		} catch (YaExisteException e1) {
			e1.printStackTrace();
		}
		DTSalida nueva =  controladorActividad.getInfoCompletaSalida("A Centro");
		assertEquals("A Centro", nueva.getNombre());
		assertEquals("Centro", nueva.getlugarSalida());
		assertEquals(10, nueva.getcantidadMaximaDeTuristas());
		assertEquals(nueva.getTuristasInscriptos().contains("agus"),false,"No hay turistas inscirptos");
	
		
	}
	
	//doy de alta salidas varias 
	@Test
	@Order(3)
	void testAltaSalidasOk() {
		GregorianCalendar fecha = new GregorianCalendar(2022,8,30);
		try {
			controladorActividad.altaSalidaTuristica("A Centro", fecha, "Centro", 10, new GregorianCalendar(), "Actividad 1");
			controladorActividad.altaSalidaTuristica("A Palomeque", fecha, "Palomeque", 10, new GregorianCalendar(), "Actividad 2");
			controladorActividad.altaSalidaTuristica("A Canelones", new GregorianCalendar(2021, 1, 20), "Canelones", 10, new GregorianCalendar(), "Actividad 2");
			controladorActividad.altaSalidaTuristica("Al Cerro", fecha, "Cerro Signorelli", 10, new GregorianCalendar(), "Actividad 3");
		} catch (YaExisteException e1) {
			e1.printStackTrace();
		}
	}
	//chequeo que me de una excepcion volver a dar de alta la salida
	@Test 
	@Order(4)
	void testAltaSalidaTuristicaFail() {
		assertThrows(YaExisteException.class,()->{controladorActividad.altaSalidaTuristica("A Centro", new GregorianCalendar(), "Centro", 10, new GregorianCalendar(), "Actividad 1");});
	}
	
	//chequeo salidas en act 
	@Test
	@Order(5)
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
	@Order(6)
	void testlistarNombresSalidasDeActividad(){
	
	 Set<String> salidas =  controladorActividad.listarNombresSalidasDeActividad("Actividad 1");
	
	 assertEquals(salidas.contains("A Centro"),true, "La salida asociada a la Actividad 1 es A centro");
		
	 Set<String> salidas2 =  controladorActividad.listarNombresSalidasDeActividad("Actividad 2");
	
	 assertEquals(salidas2.contains("A Palomeque"),true, "La salida asociada a la Actividad 2 es A Palomeque");
	 assertEquals(salidas2.contains("A Canelones"),true, "La salida asociada a la Actividad 2 es A Canelones");
		
	 Set<String> salidas3 =  controladorActividad.listarNombresSalidasDeActividad("Actividad 3");
	
	 assertEquals(salidas3.contains("Al Cerro"),true, "La salida asociada a la Actividad 3 es Al cerro");
	}
	
	
	

}
