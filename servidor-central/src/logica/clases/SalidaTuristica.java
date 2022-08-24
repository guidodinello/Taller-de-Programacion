package logica.clases;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;
import logica.handlers.HandlerUsuarios;

public class SalidaTuristica{
	
	 private String nombre;
	    private GregorianCalendar fechaSalida;
	    private GregorianCalendar fechaAlta;
	    private int cantidadMaximaDeTuristas;
	    private String lugarSalida;
	    private ActividadTuristica actividad;
		   
	    public SalidaTuristica(String Sn, GregorianCalendar Ds,String SlugarSal, int CmaxT,GregorianCalendar Da,ActividadTuristica actividad) {
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

	    public GregorianCalendar getfechaSalida() {
	        return fechaSalida;
	    }

	    public GregorianCalendar getfechaAlta() {
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

	    public void setfechaSalida(GregorianCalendar Dsalida ) {
	        fechaSalida = Dsalida;
	    }
	    public void setfechaAlta(GregorianCalendar Dalta ) {
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
		
		public Set<String> getTuristasInscriptos(){
			HandlerUsuarios hU = HandlerUsuarios.getInstance();
			Set<String> resultado = new HashSet<String>();
			Set<Turista> turistas = hU.listarTuristas();
			turistas.forEach((t)->{
				if(t.inscriptoSalida(this)) {
					resultado.add(t.getNombre());
				}
			});
			return resultado;
		}
}
