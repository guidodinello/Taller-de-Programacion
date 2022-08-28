package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import excepciones.YaExisteException;
import logica.handlers.HandlerActividades;
import logica.handlers.HandlerDepartamentos;
import logica.interfaces.Fabrica;
import logica.interfaces.ICtrlActividad;
import logica.interfaces.ICtrlUsuario;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartamentosTest {
	private static ICtrlActividad controladorActividad;
	private static ICtrlUsuario controladorUsuario;
	private static DepartamentosTest instancia = null;
	
	private DepartamentosTest() {
		Fabrica fabrica = Fabrica.getInstance();
		controladorActividad = fabrica.getICtrlActividad();
		controladorUsuario = fabrica.getICtrlUsuario();
	}
	public static DepartamentosTest getInstance() {
		if(instancia == null) {
			instancia = new DepartamentosTest();
		}
		return instancia;
	}
	
	@BeforeAll
	public static void iniciar() {
		Fabrica fabrica = Fabrica.getInstance();
		controladorActividad = fabrica.getICtrlActividad();
		controladorUsuario = fabrica.getICtrlUsuario();
		HandlerDepartamentos.clear();
		HandlerActividades.clear();
		//ctrlActividadTest testActividaes = new ctrlActividadTest();
		
		//Poner algunos usuarios cuando lo necesitemos

	}
	
	@Test
	@Order(1)
	void testListarDepartamentosVacio() {
		assertEquals(controladorActividad.listarDepartamentos().isEmpty(), true);
	}
	
	@Test
	@Order(2)
	public void testAltaDepartamentosOk() {
		try {
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
		}
	}
	
	@Test
	@Order(3)
	void testAltaDepartamentosRepetidos() {
		String nombreDepto1 = "Montevideo";
		String nombreDepto2 = "Canelones";
		String nombreDepto3 = "Artigas";
		assertEquals(controladorActividad.listarDepartamentos().isEmpty(), false);
		assertThrows(YaExisteException.class, ()->{controladorActividad.altaDepartamento(nombreDepto1, "Capital de Uruguay", "mvdeo.com.uy");});
		assertThrows(YaExisteException.class, ()->{controladorActividad.altaDepartamento(nombreDepto2, "Capital de Uruguay", "mvdeo.com.uy");});
		assertThrows(YaExisteException.class, ()->{controladorActividad.altaDepartamento(nombreDepto3, "Capital de Uruguay", "mvdeo.com.uy");});
		
	}
	
	@Test
	@Order(4)
	void testListarDepartamentos() {
		Set<String> deptos = controladorActividad.listarDepartamentos();
		assertEquals(deptos.contains("Montevideo"), true);
		assertEquals(deptos.contains("Canelones"), true);
		assertEquals(deptos.contains("Artigas"), true);
		assertEquals(deptos.contains("NoDepartamento"), false);
	}

	
}
