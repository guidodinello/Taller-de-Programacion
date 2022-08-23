package logica.interfaces;
import excepciones.YaExisteException;


public interface ICtrlActividad {

	//departamento
	public abstract void altaDepartamento(String nombreDepartamento, String URL) throws YaExisteException;


}
