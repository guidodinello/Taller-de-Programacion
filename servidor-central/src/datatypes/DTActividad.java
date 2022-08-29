package datatypes;

import java.util.Set;
import java.util.HashSet;

public class DTActividad {
	
	private String nombre;
	private String descripcion;
	private String departamento;
	private int duracionHs;
	private float costo;
	private Set<String> salidas;
	private Set<String> paquetes;
	
	
	public DTActividad(String n, String des, String departamento, int dura, float costo, Set<String> salidas) {
		this.nombre = n;
		this.descripcion = des;
		this.departamento = departamento;
		this.duracionHs = dura;
		this.costo = costo;
		this.salidas = salidas;
		paquetes = new HashSet<String>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public String getDepartamento() {
		return departamento;
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
	
	public void setPaquetes(Set<String> paquetes) {
		this.paquetes = paquetes;
	}

	public String toString() {
		return "Nombre: " + getNombre();
	}



	
}
