package logica.clases;

//importaciones
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Departamento {
	private String nombre;
	private String URL;
	private Map<String, ActividadTuristica> actividades;
	
	public Departamento(String nombre, String URL) {
		this.nombre = nombre;
		this.URL = URL;
		this.actividades = new HashMap<String, ActividadTuristica>();
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
