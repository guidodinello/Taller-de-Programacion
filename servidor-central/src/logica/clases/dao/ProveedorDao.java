package logica.clases.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



import datatypes.DTActividad;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import logica.clases.Proveedor;

@Entity
@Table(name= "Prov_table")
public class ProveedorDao {
	
	@Id
	private String id_proveedor;
	
	private String descripcion;
	
	private String sitioWeb;
	
	//@OneToMany(mappedBy = "id_proveedor")
    //private List<ActividadDao> actividades = new ArrayList<ActividadDao>();
	
	public ProveedorDao() {
		
	}
	
	public ProveedorDao(Proveedor prov) {
		id_proveedor = prov.getNickname();
		descripcion = prov.getDescripcion();
		sitioWeb = prov.getSitioWeb();
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public String getId() {
		return id_proveedor;
	}
	
	//public void addActividad(ActividadDao act) {
	//	actividades.add(act);
	//}
	
}
