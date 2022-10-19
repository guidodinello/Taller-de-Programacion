package model.logica.clases;

import java.util.GregorianCalendar;
import java.util.Set;

import model.datatypes.DTActividad;
import model.datatypes.DTSalida;

public class InscripcionSalida{
	
	private int cantTuristas;
	private GregorianCalendar fechaAlta;
	private float costo;
	private SalidaTuristica salida;

	public InscripcionSalida(int cant, GregorianCalendar fecha, SalidaTuristica salidaT, float costo) {
		this.cantTuristas = cant;
		this.fechaAlta = fecha;
		this.salida = salidaT;
		this.costo = costo;
	}

	public int getCantTuristas() {
		return cantTuristas;
	}
	
	public GregorianCalendar getFechaAlta() {
		return fechaAlta;
	}
	
	public float getCosto() {
		return costo;
	}
	
	public SalidaTuristica getSalida() {
		return salida;
	}
	
	public DTSalida getDTSalida() {
		String Sn = this.salida.getNombre();
		GregorianCalendar Ds = this.salida.getfechaSalida();
		GregorianCalendar Da = this.salida.getfechaAlta();
		int CmaxT  = this.salida.getcantidadMaximaDeTuristas();
		String SlugarSal = this.salida.getlugarSalida();
		Set<String> SSturistas = this.salida.getTuristasInscriptos();
		DTActividad actSalida = salida.getActividad().getDTActividad();
		return new DTSalida(Sn,actSalida.getNombre(), actSalida.getDepartamento(), Ds, Da, CmaxT, SlugarSal, SSturistas, this.salida.getImg());
	}
}
