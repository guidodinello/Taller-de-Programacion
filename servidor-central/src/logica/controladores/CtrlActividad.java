package logica.controladores;
import java.util.HashSet;
import java.util.Set;

import excepciones.YaExisteException;
import logica.clases.Departamento;
import logica.handlers.HandlerDepartamentos;
import logica.interfaces.*;

public class CtrlActividad implements ICtrlActividad{
	
	
	//Departamento
	public void altaDepartamento(String nombreDepartamento, String URL) throws YaExisteException{
		HandlerDepartamentos hD = HandlerDepartamentos.getInstance();
		if(hD.existeDepartamento(nombreDepartamento)){
			throw new YaExisteException("El departamento " + nombreDepartamento + "ya se encuentra registrado.");
		}
		Departamento newD = new Departamento(nombreDepartamento, URL);
		hD.add(newD);
		
	}
	
	public Set<String> listarDepartamentos(){
		HandlerDepartamentos hD = HandlerDepartamentos.getInstance();
		Set<String> resu = hD.listarDepartamentos();
		return resu;
	}
}
