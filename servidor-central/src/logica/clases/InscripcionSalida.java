package logica.clases;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import datatypes.DTSalida;

public class InscripcionSalida{
	
	private int cantTuristas;
	private Date fechaAlta;
	private float costo;
	private SalidaTuristica salida;

	public InscripcionSalida(int cant, Date fecha, SalidaTuristica salidaT, float costo) {
		this.cantTuristas = cant;
		this.fechaAlta = fecha;
		this.salida = salidaT;
		this.costo = costo;
	}

	public int getCantTuristas() {
		return cantTuristas;
	}
	
	public Date getFechaAlta() {
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
		return new DTSalida(Sn, Ds, Da, CmaxT, SlugarSal, SSturistas);
	}
}
