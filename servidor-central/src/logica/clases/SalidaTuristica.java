package logica.clases;
import java.util.Date;

public class SalidaTuristica{
	
	 private String nombre;
	    private Date fechaSalida;
	    private Date fechaAlta;
	    private int cantidadMaximaDeTuristas;
	    private String lugarSalida;
	    private ActividadTuristica actividadSalida;
		   
	    public SalidaTuristica(String Sn, Date Ds,String SlugarSal, int CmaxT,Date Da,ActividadTuristica actividad) {
	        this.nombre = Sn;
	        this.fechaSalida = Ds;
	        this.fechaAlta= Da;
	        this.cantidadMaximaDeTuristas = CmaxT;
	        this.lugarSalida = SlugarSal;
	        this.actividad = actividad;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public Date getfechaSalida() {
	        return fechaSalida;
	    }

	    public Date getfechaAlta() {
	        return fechaAlta;
	    }
	    public int getcantidadMaximaDeTuristas() {
	        return cantidadMaximaDeTuristas;
	    }
	    public String getlugarSalida() {
	        return lugarSalida;
	    }
	    
	    public ActividadTuristica getActividad() {
	    	return actividad;
	    }

	    public void setNombre(String Sn) {
	        nombre = Sn;
	    }

	    public void setfechaSalida(Date Dsalida ) {
	        fechaSalida = Dsalida;
	    }
	    public void setfechaAlta(Date Dalta ) {
	        fechaAlta = Dalta;
	    }


	    public void setCantidadMaximaDeTuristas(int IcmTurista) {
	        cantidadMaximaDeTuristas = IcmTurista;
	    }
	    public void setLugarSalida(String SlugarSal) {
	        lugarSalida = SlugarSal;
	    }

		public float calcularCosto(int cant) {
			
			return 0;
		}
	    

}
