package logica.clases;

import java.util.GregorianCalendar;
import java.util.Set;
import datatypes.DTActividad;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Proveedor extends Usuario {
	private Map<String, ActividadTuristica> actividades;
	private String descripcion, sitioWeb;
	
	public Proveedor(String nickname, String email, String nombre, String apellido, GregorianCalendar fechaNac, String descripcion, String sitioWeb) {
		super(nickname, email, nombre, apellido, fechaNac);
		this.descripcion = descripcion;
		this.sitioWeb = sitioWeb;
		actividades = new HashMap<String, ActividadTuristica>();
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getSitioWeb() {
		return sitioWeb;
	}
	

	public void agregarActividad(ActividadTuristica actividad) {
		this.actividades.put(actividad.getNombre(), actividad);
	}
	
	public Map<String, ActividadTuristica> getActividadesTuristicas(){
		Map<String, ActividadTuristica> resu = new HashMap<>();
		for(Map.Entry<String, ActividadTuristica> entry : actividades.entrySet()) {
			resu.put(entry.getKey(), entry.getValue());
		}
		return resu;
	}
	
	public Set<DTActividad> getDTActividades(){
		Set<DTActividad> resultado = new HashSet<DTActividad>();
		this.actividades.forEach((key, value)->{
			resultado.add(value.getDTActividad());
		});
		return resultado;
	}
}
