package datatypes;

import java.util.HashSet;
import java.util.Set;

import datatypes.DTCompra;
import logica.clases.Compra;
import logica.clases.Turista;


public class DTTurista extends DTUsuario {
	private String nacionalidad;
	private Set<DTCompra> compras;
	
	public DTTurista(Turista t) {
		super(t);
		nacionalidad = t.getNacionalidad();
		compras = new HashSet<DTCompra>();
		for (Compra c : t.getCompras().values()) {
                compras.add(c.getDT());
        }
        
	}

	public String getNacionalidad() {
		return nacionalidad;
	}
	
	public Set<DTCompra> getCompras() {
        return new HashSet<DTCompra>(compras);
    }
}
