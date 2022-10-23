package datatypes;

import java.util.GregorianCalendar;
import java.util.Map;

public class DTCompra {
	private String paquete;
	private GregorianCalendar fechaCompra;
	private int cantidadTuristas;
	private boolean vigente;
	private Map<String, Integer> disponibles;
	
	public DTCompra(String nomPaq, GregorianCalendar fecha, int cantTur, boolean vig, Map<String, Integer> dis) {
		paquete = nomPaq;
		fechaCompra = fecha;
		cantidadTuristas = cantTur;
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
