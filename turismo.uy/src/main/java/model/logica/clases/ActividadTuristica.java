package model.logica.clases;

import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.GregorianCalendar;

import model.datatypes.DTActividad;
import model.datatypes.DTSalida;
import model.datatypes.estadoActividad;
import model.logica.handlers.HandlerDepartamentos;
import model.logica.handlers.HandlerCategorias;

import java.util.HashMap;

public class ActividadTuristica{
	private String nombre, descripcion, nombreCiudad;
	private int duracionHs;
	private float costoPorTurista;
	private GregorianCalendar fechaAlta;
	private estadoActividad estado;
	private Map<String, SalidaTuristica> salidas;
	private String imgDir;
	
	public ActividadTuristica(String nombre, String descripcion, int duracionHs, float costoPorTurista, String nombreCiudad, GregorianCalendar fechaAlta, String imgDir, estadoActividad estado) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracionHs = duracionHs;
		this.costoPorTurista = costoPorTurista;
		this.nombreCiudad = nombreCiudad;
		this.fechaAlta = fechaAlta;
		this.estado = estado;
		salidas = new HashMap<String, SalidaTuristica>();
		this.imgDir = imgDir;
	}
	
	public String getNombre() {
		return nombre;
	}
	public estadoActividad getEstado() {
		return this.estado;
	}
	public void setEstado(estadoActividad estado) {
		 this.estado = estado;
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
	public Set<String>getSalidasNombre() {
		return this.salidas.keySet();
	}
	
	public String getImgDir() {
		return this.imgDir;
	}
	
	public void agregarSalida(SalidaTuristica s) {
		salidas.put(s.getNombre(), s);
	}

	public Set<DTSalida> getInfoBasicaSalidasVigentes(GregorianCalendar fechaSistema) {
		Set<DTSalida> res = new HashSet<DTSalida>();
		salidas.values().forEach((e) -> {
			if(e.getfechaSalida().after(fechaSistema)) {
				Set<String> turistas = new HashSet<String>();
				DTActividad dtAct = getDTActividad();
				DTSalida actual = new DTSalida(e.getNombre(), dtAct.getNombre(), dtAct.getDepartamento(),  e.getfechaSalida(), e.getfechaAlta(), e.getcantidadMaximaDeTuristas(), e.getlugarSalida(), turistas, e.getImg());
				res.add(actual);
			}
		});
		return res;
	}
	
	public DTActividad getDTActividad() {
		String n = this.nombre;
		String des =this.descripcion;
		String nombreCiudad = this.nombreCiudad;
		GregorianCalendar fechaAlta = this.fechaAlta;
		int dura = this.duracionHs;
		float costo = this.costoPorTurista;
		Set<String> salidas = new HashSet<String>();
 		this.salidas.forEach((key,value)->{
			salidas.add(value.getNombre());
		});
 		String imgDireccion = this.imgDir;
		Set<String> categorias = getCategorias();
		HandlerDepartamentos hD = HandlerDepartamentos.getInstance();
		String nombreDepto = hD.getDeptoContains(this);
		return new DTActividad(n, des, nombreDepto, nombreCiudad, fechaAlta, dura, costo, salidas, categorias, imgDireccion, estado);
	}

    public Set<String> getCategorias() {
        Set<String> res = new HashSet<String>();
        HandlerCategorias hC = HandlerCategorias.getInstance();
        Set<Categoria> categorias = hC.obtenerCategorias();
        categorias.forEach((e)->{if(e.tieneActividad(nombre)) res.add(e.getNombre());});
        return res;
    }

}
