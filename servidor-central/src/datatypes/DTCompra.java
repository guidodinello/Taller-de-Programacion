package datatypes;

import java.util.GregorianCalendar;
import java.util.Map;

public class DTCompra {
	private String paquete;
	private GregorianCalendar fechaCompra;
	private int cantidadTuristas;
	private boolean vigente;
	private Map<String, Integer> disponibles;
	
	public DTCompra(String p, GregorianCalendar g, int c, boolean vig, Map<String, Integer> dis) {
		paquete = p;
		fechaCompra = g;
		cantidadTuristas = c;
		vigente = vig;
		disponibles = dis;
	}
	
	public String getPaquete() {
		return paquete;
	}
	public GregorianCalendar getFechaCompra() {
		return fechaCompra;
	}
	public int getCantTuristas() {
		return cantidadTuristas;
	}
	public boolean getVigente() {
	    return vigente;
	}

    public int disponiblesEnActividad(String nomAct) {
        return disponibles.get(nomAct);
    }
    
    public boolean tieneActividad(String atividad) {
        return disponibles.containsKey(atividad);
    }
}
