package logica.clases;

import java.util.Date;

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
}
