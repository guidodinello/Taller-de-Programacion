package datatypes;

import java.util.Set;

public class DTActividad {
	private String nombre;
	private String descripcion;
	private int duracionHs;
	private float costo;
	private Set<String> salidas;
	private Set<String> paquetes;
	
	
	public DTActividad(String n, String des, int dura, float costo, Set<String> salidas) {
		this.nombre = n;
		this.descripcion = des;
		this.duracionHs = dura;
		this.costo = costo;
		this.salidas = salidas;
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
	
	public float getCosto() {
		return costo;
	}
	
	public Set<String> getSalidas() {
		return salidas;
	}


	public Set<String> getPaquetes() {
		return paquetes;
	}


	
}
