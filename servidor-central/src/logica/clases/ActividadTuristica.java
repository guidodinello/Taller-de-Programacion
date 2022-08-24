package logica.clases;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.GregorianCalendar;

import datatypes.DTActividad;
import datatypes.DTSalida;

import java.util.HashMap;

public class ActividadTuristica{
	private String nombre, descripcion, nombreCiudad;
	private int duracionHs;
	private float costoPorTurista;
	private GregorianCalendar fechaAlta;
	private Map<String, SalidaTuristica> salidas;
	
	public ActividadTuristica(String nombre, String descripcion, int duracionHs, float costoPorTurista, String nombreCiudad, GregorianCalendar fechaAlta) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracionHs = duracionHs;
		this.costoPorTurista = costoPorTurista;
		this.nombreCiudad = nombreCiudad;
		this.fechaAlta = fechaAlta;
		salidas = new HashMap<String, SalidaTuristica>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public int getDuracionHs() {
		return duracionHs;
	}
	
	public float getCostoPorTurista() {
		return costoPorTurista;
	}
	
	public String getNombreCiudad() {
		return nombreCiudad;
	}
	
	public GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}
	
	public void agregarSalida() {
		//to-do
	}

	public Set<DTSalida> getInfoBasicaSalidasVigentes(GregorianCalendar fechaSistema) {
		Set<DTSalida> res = new HashSet<DTSalida>();
		salidas.values().forEach((e) -> {
			if(e.getfechaSalida().after(fechaSistema)) {
				Set<String> turistas = new HashSet<String>();
				DTSalida actual = new DTSalida(e.getNombre(), e.getfechaSalida(), e.getfechaAlta(), e.getcantidadMaximaDeTuristas(), e.getlugarSalida(), turistas);
				res.add(actual);
			}
		});
		return res;
	}
	
	public DTActividad getDTActividad() {
		String n = this.nombre;
		String des =this.descripcion;
		int dura = this.duracionHs;
		float costo = this.costoPorTurista;
		Set<String> salidas = new HashSet<String>();
		this.salidas.forEach((key,value)->{
			salidas.add(value.getNombre());
		});
		return new DTActividad(n, des,dura, costo, salidas);
	}
}
