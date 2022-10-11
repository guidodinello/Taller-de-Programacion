package datosDePrueba;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.GregorianCalendar;

import datatypes.estadoActividad;
import datatypes.tipoUsuario;
import excepciones.InscriptionFailException;
import excepciones.YaExisteException;
import logica.interfaces.ICtrlActividad;
import logica.interfaces.ICtrlUsuario;

public class CargarDatosDePrueba {
	
	private ICtrlUsuario ICU;
    private ICtrlActividad ICA;
	
	public  void cargarDatos(ICtrlUsuario icu, ICtrlActividad ica) {
		ICU = icu;
	    ICA = ica;
		cargarDepartamentos();
		cargarUsuarios();
		cargarActividades();
		cargarSalidas();
		cargarPaquetes(); 
		cargarInscripciones();
	}
	
	public void cargarDepartamentos() {
		String path = "./src/datosDePrueba/Departamentos.csv"; // poner path
		String line = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			line = br.readLine();
			
			for (int i = 0; i < 19; i++) {
				  line = br.readLine();
				  String[] values = line.split(",");
				  ICA.altaDepartamento(values[1].trim(), values[2].trim(), values[3].trim());
				  	//nombre, descripcion, url
				  
				  //System.out.println("nombre:" + values[1].trim() + "desc:"+ values[2].trim()+ "url:"+ values[3].trim()); //probando
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (YaExisteException e) {
			e.printStackTrace();
		}
	}
	
	public void cargarUsuarios() {
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
				lineExtra = brP.readLine();
				lineExtra = brT.readLine();
				
				//primero hagamos los turistas
				for (int i = 0; i < 10; i++) {
					  line = br.readLine();
					  lineExtra = brT.readLine();
					  String[] values = line.split(",");
					  String[] valuesExtra = lineExtra.split(",");
					  String[] valuesFecha = values[6].split("/");
					  //System.out.println("A continuacion vienen las fehcas:"+ valuesFecha[0]+valuesFecha[1]+valuesFecha[2]);
					  //System.out.println("A continuacion vienen los otros datos:"+values[1]+values[2]+values[3]+values[4]);
					  ICU.altaUsuario(values[2].trim(), values[5].trim(), values[3].trim(), values[4].trim(), "passowrd", new GregorianCalendar(Integer.parseInt(valuesFecha[2].trim()), 
							  Integer.parseInt(valuesFecha[1].trim()), Integer.parseInt(valuesFecha[0].trim())), "imagenPerfil", tipoUsuario.turista, valuesExtra[1].trim(), "", "");
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
					  ICU.altaUsuario(values[2].trim(), values[5].trim(), values[3].trim(), values[4].trim(), "password", new GregorianCalendar(Integer.parseInt(valuesFecha[2].trim()),
					  	Integer.parseInt(valuesFecha[1].trim()), Integer.parseInt(valuesFecha[0].trim())), "imagenPerfil", tipoUsuario.proveedor, "", valuesExtra[1].trim(), valuesExtra[2].trim());
					  	//nick, email, nombre, apellido, fechaNac, tipoUsuario, naciona, descrip, url
					  
					  //System.out.println("nick: " + values[2] + " nombre: "+ values[3]+ " apellido: "+ values[4]+ " email: "+values[5]+
						//	  " fechaNac: "+ values[6]+" dia: "+valuesFecha[0]+" mes: "+valuesFecha[1]+" anio: "+valuesFecha[2]+ " desc: "
							//  + valuesExtra[1]+" url: "+ valuesExtra[2]); //probando
				}
				br.close();
				brP.close();
				brT.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (YaExisteException e) {
			e.printStackTrace();
		}
	}

	public void cargarActividades() {
		String line = "";
		String path = "./src/datosDePrueba/Usuarios.csv"; 
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			for(int i = 0; i < 11; i++) {
				line = br.readLine();
			}
			line = br.readLine();
			String[] valuesU = line.split(",");
			String u11 = valuesU[2].trim();
			
			line = br.readLine();
			valuesU = line.split(",");
			String u12 = valuesU[2].trim();
			
			line = br.readLine();
			valuesU = line.split(",");
			String u13 = valuesU[2].trim();
			
			br.close();
			
			path = "./src/datosDePrueba/Actividades.csv"; // poner path
			br = new BufferedReader(new FileReader(path));
			line = br.readLine();
			String usu = u11;
			for (int i = 0; i < 6; i++) {
				  if(i<2) {
					  usu = u11;
				  }else if(i<4) {
					  usu = u13;
				  }else {
					  usu = u12;
				  }
				  line = br.readLine();
				  String[] values = line.split(",");
				  String[] valuesFecha = values[7].split("/");
				 ICA.altaActividadTuristica(values[6].trim(), values[1].trim(), values[2].trim() ,Integer.parseInt(values[3].trim()), Float.parseFloat(values[4].trim()) ,
						 values[5].trim() ,usu , new GregorianCalendar(Integer.parseInt(valuesFecha[2].trim()),Integer.parseInt(valuesFecha[1].trim()), 
								 Integer.parseInt(valuesFecha[0].trim())),estadoActividad.agregada);
				  	//nombreDep, nomActi, desc, duraHs, costo, nomCIudad, nickProveed, fechaAlta
				  
				  //System.out.println("nombre: " + values[1] + " desc: "+ values[2]+ " durac: "+ values[3]+ " costo: "+ values[4]+ " ciudad: "+ values[5]
						 // + " depart: "+ values[6]+ " fechaAlta: "+ values[7]+ " refProveedor: "+ values[8]+" nick: "+ usu); //probando
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (YaExisteException e) {
			e.printStackTrace();
		}	
	}

	public void cargarSalidas() {
		String path = "./src/datosDePrueba/Salidas.csv"; // poner path
		String pathA = "./src/datosDePrueba/Actividades.csv";
		String line = "";
		String nombreAct = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			line = br.readLine();
			
			BufferedReader brA = new BufferedReader(new FileReader(pathA));
			line = brA.readLine();
			
			for (int i = 0; i < 12; i++) {
				  line = br.readLine();
				  String[] values = line.split(",");
				  String[] valuesFecha = values[3].split("/");
				  String[] valuesFechaAlta = values[7].split("/");
				
				if(i % 2 == 0) {
					line = brA.readLine();
					String[] valuesAct = line.split(",");
					nombreAct = valuesAct[1].trim();
				}
				 ICA.altaSalidaTuristica(values[2].trim(), new GregorianCalendar(Integer.parseInt(valuesFecha[2].trim()), Integer.parseInt(valuesFecha[1].trim()) - 1, 
					Integer.parseInt(valuesFecha[0].trim()), Integer.parseInt((String) values[4].trim().subSequence(0, values[4].trim().length() -2)), 0), values[6].trim(), 
						 Integer.parseInt(values[5].trim()), new GregorianCalendar(Integer.parseInt(valuesFechaAlta[2].trim()), Integer.parseInt(valuesFechaAlta[1].trim()), 
								 Integer.parseInt(valuesFechaAlta[0].trim())), nombreAct);
				  			//Ref, RefActiv, Nombre, Fecha, Hora, TuristaMax, Lugar, FechaAlta
			}
			br.close();
			brA.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (YaExisteException e) {
			e.printStackTrace();
		}
	}
	
	public void cargarPaquetes() {
		String path = "./src/datosDePrueba/Paquetes.csv"; // poner path
		String pathA = "./src/datosDePrueba/Actividades.csv";
		String line = "";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			line = br.readLine();
			
			BufferedReader brA = new BufferedReader(new FileReader(pathA));
			line = brA.readLine();
			
			for (int i = 0; i < 2; i++) {
				  line = br.readLine();
				  String[] values = line.split(",");
				  String[] valuesFecha = values[4].split("/");
				  ICA.crearPaquete(values[1].trim() , values[5].trim(),Integer.parseInt(values[2].trim()),Float.parseFloat(values[3].trim()), 
						  new GregorianCalendar(Integer.parseInt(valuesFecha[2].trim()), Integer.parseInt(valuesFecha[1].trim()), Integer.parseInt(valuesFecha[0].trim())));
				  		//Ref, Nombre, Validez, Descuento, FechaAlta, Descripción -> como recibo
				  for(int j = 0; j < 2; j++) {
					line = brA.readLine();
					String[] valuesAct = line.split(",");
					ICA.ingresarActividadAPaquete(values[1].trim(), valuesAct[1].trim());  
				  }
			}
			br.close();
			brA.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cargarInscripciones() {
		try {
			ICU.ingresarInscripcion("lachiqui", "Degusta Agosto", 3, new GregorianCalendar(2022, 8 - 1, 15));
			ICU.ingresarInscripcion("elelvis", "Degusta Agosto", 5, new GregorianCalendar(16, 8 - 1, 2022));
			ICU.ingresarInscripcion("lachiqui", "Tour Colonia del Sacramento 18-09", 3, new GregorianCalendar(2022, 8 - 1, 18));
			ICU.ingresarInscripcion("isabelita", "Tour Colonia del Sacramento 18-09", 1, new GregorianCalendar(2022, 8 - 1, 19));
			ICU.ingresarInscripcion("mastropiero", "Almuerzo 2", 2, new GregorianCalendar(2022, 8 - 1, 19));
			ICU.ingresarInscripcion("chino", "Teatro con Sabores 1", 1, new GregorianCalendar(2022, 8 - 1, 19));
			ICU.ingresarInscripcion("chino", "Teatro con Sabores 2", 10, new GregorianCalendar(2022, 8 - 1, 20));
			ICU.ingresarInscripcion("bobesponja", "Teatro con Sabores 2", 2, new GregorianCalendar(2022, 8 - 1, 20));
			ICU.ingresarInscripcion("anibal", "Teatro con Sabores 2", 1, new GregorianCalendar(2022, 8 - 1, 21));
			ICU.ingresarInscripcion("tony", "Degusta Setiembre", 11, new GregorianCalendar(2022, 8 - 1, 21));
			//Ref, RefSal, RefTur, CantTur, Costo, FechaInscrip
		} catch(InscriptionFailException e) {
			e.printStackTrace();
		}
		

	}
}
