package logica.clases;

import java.util.Date;
import java.util.Map;

public class Proveedor extends Usuario {
	private Map<String, ActividadTuristica> actividades;
	
	public Proveedor(String nickname, String email, String nombre, String apellido, Date fechaNac, String descripcion,
			String sitioWeb) {
		// TODO Auto-generated constructor stub
	}
	
	public void agregarActividad(ActividadTuristica actividad) {
		this.actividades.put(actividad.getNombre(), actividad);
	}

}
