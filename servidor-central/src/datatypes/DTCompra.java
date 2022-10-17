package datatypes;

import java.util.GregorianCalendar;

public class DTCompra {
	private String paquete;
	private GregorianCalendar fechaCompra;
	private int cantidadTuristas;
	
	public DTCompra(String p, GregorianCalendar g, int c) {
		paquete = p;
		fechaCompra = g;
		cantidadTuristas = c;
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
}
