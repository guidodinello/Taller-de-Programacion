package logica.interfaces;
import java.util.Set;

import excepciones.YaExisteException;


public interface ICtrlActividad {

	//departamento
	public abstract void altaDepartamento(String nombreDepartamento, String URL) throws YaExisteException;
	public abstract Set<String> listarDepartamentos();

}
