package datosDePrueba;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.GregorianCalendar;

import datatypes.tipoUsuario;
import logica.interfaces.ICtrlActividad;
import logica.interfaces.ICtrlUsuario;

public class CargarDatosDePrueba {
	
	private ICtrlUsuario ICU;
    private ICtrlActividad ICA;
	
    /*
		"./src/datosDePrueba/Actividades.csv"
		"./src/datosDePrueba/ActividadesPaquetes.csv"
		
		"./src/datosDePrueba/Inscripciones.csv"
		"./src/datosDePrueba/Paquetes.csv"
	 	"./src/datosDePrueba/Salidas.csv"
	 	"./src/datosDePrueba/Usuarios.csv"

	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ICtrlUsuario ICU = ICU.;
	    //ICtrlActividad ICA = ;
		//cargarDepartamentos(); //funca
		//cargarUsuarios(); //funca
		
		//cargarActividades();
		//cargarSalidas();
		//cargarPaquetes();
		//cargarInscripciones();
	}
	
	public static void cargarDepartamentos() {
		String path = "./src/datosDePrueba/Departamentos.csv"; // poner path
		String line = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			line = br.readLine();
			
			for (int i = 0; i < 19; i++) {
				  line = br.readLine();
				  String[] values = line.split(",");
				  //ICA.altaDepartamento(values[1], values[2], values[3]);
				  	//nombre, descripcion, url
				  
				  //System.out.println("nombre: " + values[1] + " desc: "+ values[2]+ " url: "+ values[3]); //probando
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void cargarUsuarios() {
		String path = "./src/datosDePrueba/Usuarios.csv"; // poner path
	 	String pathP = "./src/datosDePrueba/Usuarios-Proveedores.csv";
	 	String pathT = "./src/datosDePrueba/Usuarios-Turistas.csv";
		String line = "";
		String lineExtra = "";
		
		try {
				BufferedReader br = new BufferedReader(new FileReader(path));
				BufferedReader brP = new BufferedReader(new FileReader(pathP));
				BufferedReader brT = new BufferedReader(new FileReader(pathT));
				
				line = br.readLine();
				line = brP.readLine();
				line = brT.readLine();
				
				//primero hagamos los turistas
				for (int i = 0; i < 10; i++) {
					  line = br.readLine();
					  lineExtra = brT.readLine();
					  String[] values = line.split(",");
					  String[] valuesExtra = lineExtra.split(",");
					  String[] valuesFecha = values[6].split("/");
					  //ICU.altaUsuario(values[2], values[5], values[3], values[4], new GregorianCalendar(Integer.parseInt(valuesFecha[2]), 
					  //Integer.parseInt(valuesFecha[1]), Integer.parseInt(valuesFecha[0])), tipoUsuario.turista, valuesExtra[1], "", "");
					  	//nick, email, nombre, apellido, fechaNac, tipoUsuario, naciona, descrip, url
					  
					  //System.out.println("nick: " + values[2] + " nombre: "+ values[3]+ " apellido: "+ values[4]+ " email: "+values[5]+
						//	  " fechaNac: "+ values[6]+" dia: "+valuesFecha[0]+" mes: "+valuesFecha[1]+" anio: "+valuesFecha[2]+ " nacio: "+ valuesExtra[1]); //probando
				}
				//a hora hagamos los proveedores
				for (int i = 0; i < 3; i++) {
					  line = br.readLine();
					  lineExtra = brP.readLine();
					  String[] values = line.split(",");
					  String[] valuesExtra = lineExtra.split(",");
					  String[] valuesFecha = values[6].split("/");
					  //ICU.altaUsuario(values[2], values[5], values[3], values[4], new GregorianCalendar(Integer.parseInt(valuesFecha[2]),
					  //Integer.parseInt(valuesFecha[1]), Integer.parseInt(valuesFecha[0])), tipoUsuario.proveedor, "", valuesExtra[1], valuesExtra[2]);
					  	//nick, email, nombre, apellido, fechaNac, tipoUsuario, naciona, descrip, url
					  
					  //System.out.println("nick: " + values[2] + " nombre: "+ values[3]+ " apellido: "+ values[4]+ " email: "+values[5]+
						//	  " fechaNac: "+ values[6]+" dia: "+valuesFecha[0]+" mes: "+valuesFecha[1]+" anio: "+valuesFecha[2]+ " desc: "
							//  + valuesExtra[1]+" url: "+ valuesExtra[2]); //probando
				}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
