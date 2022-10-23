package datatypes;

import logica.clases.Proveedor;

public class DTProveedor extends DTUsuario {
	private String descripcion;
	private String sitioWeb;
	
	public DTProveedor(Proveedor prov){
		super(prov);
		descripcion = prov.getDescripcion();
		sitioWeb = prov.getSitioWeb();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getLinkSitioWeb() {
		return sitioWeb;
	}
}
