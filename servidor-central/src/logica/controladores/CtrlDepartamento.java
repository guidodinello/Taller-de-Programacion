package logica.controladores;
import logica.interfaces.ICtrlDepartamento;
import excepciones.YaExisteException;
import logica.clases.Departamento;
import logica.handlers.HandlerDepartamentos;


public class CtrlDepartamento implements ICtrlDepartamento {
	
	public CtrlDepartamento(){}
	
	public void altaDepartamento(String nombreDepartamento, String URL) throws YaExisteException{
		HandlerDepartamentos hD = HandlerDepartamentos.getInstance();
		if(hD.existeDepartamento(nombreDepartamento)){
			throw new YaExisteException("El departamento " + nombreDepartamento + "ya se encuentra registrado.");
		}
		Departamento newD = new Departamento(nombreDepartamento, URL);
		hD.add(newD);
		
	}
	
}
