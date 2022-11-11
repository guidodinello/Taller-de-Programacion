package logica.clases;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ActividadDao {
	
	@Id
	private int id;
	private String nombre;
	private String descripcion;
	private String duracion;
	private String costo;
	private String ciudad;
	
	
	public ActividadDao() {
		
	}
	
	public ActividadDao(String name, int id1) {
		nombre = name;
		id = id1;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
