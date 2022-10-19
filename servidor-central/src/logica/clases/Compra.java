package logica.clases;

import java.util.GregorianCalendar;
import datatypes.DTCompra;

public class Compra {
	private GregorianCalendar fechaCompra;
	private int cantidadTuristas;
	private float costoTotal;
	private GregorianCalendar vencimiento;
	private PaqueteTuristico paquete;
	
	public Compra(GregorianCalendar fechaCompra, int cantidadTuristas ,PaqueteTuristico paquete) {
		this.fechaCompra = fechaCompra;
		this.cantidadTuristas = cantidadTuristas;
		this.paquete = paquete;
		this.vencimiento = fechaCompra;
		this.vencimiento.add(GregorianCalendar.DATE,paquete.getPeriodoValidez());
		this.costoTotal = cantidadTuristas * paquete.getCosto();
	}
	
	public DTCompra getDT() {
		return new DTCompra(paquete.getNombre(), fechaCompra, cantidadTuristas);
	}
	
	public PaqueteTuristico getPaquete() {
		return this.paquete;
		
	}
}
