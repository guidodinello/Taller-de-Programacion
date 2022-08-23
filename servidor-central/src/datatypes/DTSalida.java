package datatypes;
import java.util.*;
import java.util.Date;


public class DTSalida {
	private String nombre;
	private Date fechaSalida;
	private Date fechaAlta;
	private int maxTuristas;
	private String lugarSalida;
	private Set<String> turistasInscriptos; //va a ser set???
	
	 public DTSalida() {
		this.setNombre(new String());
		this.setfechaSalida(new Date());
	    this.setfechaAlta(new Date());
	    this.setmaxTuristas(0);
	    this.setlugarSalida(new String());
	    this.setTuristas(null);
	        
	        
	    }

	 public DTSalida(String Sn, Date Ds, Date Da,int CmaxT,String SlugarSal,Set<String> SSturistas) {
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

    public void setfechaSalida(Date Dsalida ) {
        fechaSalida = Dsalida;
    }
    public void setfechaAlta(Date Dalta ) {
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

    public Date getfechaSalida() {
        return fechaSalida;
    }

    public Date getfechaAlta() {
        return fechaAlta;
    }
    public int getcantidadMaximaDeTuristas() {
        return maxTuristas;
    }
    public String getlugarSalida() {
        return lugarSalida;
    }
////////////////////////////////////////////////////////////////////////////
    /* Sirve para mostrar textualmente la información del usuario, por ejemplo en un ComboBox
     */
   // String toString() {
       // return getCedulaIdentidad() + " (" + getNombre() + " " + getApellido() + ")";
    //}

}
