package datatypes;

import logica.clases.Proveedor;

public class DTProveedor extends DTUsuario {
	private String descripcion;
	private String sitioWeb;
	
	public DTProveedor(Proveedor p){
		super(p);
		descripcion = p.getDescripcion();
		sitioWeb = p.getSitioWeb();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getLinkSitioWeb() {
		return sitioWeb;
	}
}
