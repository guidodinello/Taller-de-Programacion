package logica.interfaces;

import excepciones.YaExisteException;

public interface ICtrlDepartamento {
	public abstract void altaDepartamento(String nombreDepartamento, String URL) throws YaExisteException;
}
