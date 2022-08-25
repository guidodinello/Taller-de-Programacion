package datatypes;
import java.util.*;
import java.util.GregorianCalendar;

//import logica.clases.SalidaTuristica;


public class DTSalida {
	private String nombre;
	private GregorianCalendar fechaSalida;
	private GregorianCalendar fechaAlta;
	private int maxTuristas;
	private String lugarSalida;
	private Set<String> turistasInscriptos; //va a ser set??? // resp: Creo que es suficiente con poner los nicks nomas
	
	 public DTSalida() {
		this.setNombre(new String());
		this.setfechaSalida(new GregorianCalendar());
	    this.setfechaAlta(new GregorianCalendar());
	    this.setmaxTuristas(0);
	    this.setlugarSalida(new String());
	    this.setTuristas(null);
	        
	        
	    }

	 public DTSalida(String Sn, GregorianCalendar Ds, GregorianCalendar Da,int CmaxT,String SlugarSal,Set<String> SSturistas) {
	        this.nombre = Sn;
	        this.fechaSalida = Ds;
	        this.fechaAlta= Da;
	        this.maxTuristas = CmaxT;
	        this.lugarSalida = SlugarSal;
	        this.turistasInscriptos = SSturistas;
	    }
	 
   ////////////////////////SETTERS////////////////////////////////////////////////
    public void setNombre(String Sn) {
        nombre = Sn;
    }

    public void setfechaSalida(GregorianCalendar Dsalida ) {
        fechaSalida = Dsalida;
    }
    public void setfechaAlta(GregorianCalendar Dalta ) {
        fechaAlta = Dalta;
    }
    public void setmaxTuristas(int ImaxT ) {
        maxTuristas = ImaxT;
    }
    public void setlugarSalida(String SLugarSal) {
        lugarSalida = SLugarSal;
    }
    
    public void setTuristas(Set<String> SSTuristas) {
        turistasInscriptos = SSTuristas;
    }
    
    //////////////////////GETTERS/////////////////////////////////////////////////
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
        return maxTuristas;
    }
    public String getlugarSalida() {
        return lugarSalida;
    }

	public Set<String> getTuristasInscriptos() {
		return turistasInscriptos;
	}
    
////////////////////////////////////////////////////////////////////////////
    /* Sirve para mostrar textualmente la información del usuario, por ejemplo en un ComboBox
     */
   // String toString() {
       // return getCedulaIdentidad() + " (" + getNombre() + " " + getApellido() + ")";
    //}

}
