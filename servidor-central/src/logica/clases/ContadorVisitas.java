package logica.clases;

import java.util.HashMap;
import java.util.Map;

public class ContadorVisitas {
	private Map<String, Integer> registro;
	private static ContadorVisitas instancia = null;
	
	private ContadorVisitas() {
		registro = new HashMap<String, Integer>();
	}
	
	public static ContadorVisitas getInstance() {
		if (instancia == null)
            instancia = new ContadorVisitas();
        return instancia;
	}

	public void agregar(String nombre) {
		if(registro.containsKey(nombre)) {
			int visitas = registro.get(nombre);
			registro.put(nombre, visitas + 1);
		}
		else {
			registro.put(nombre, 1);
		}
	}
	
	public Map<String, Integer> getTop10(){
		Map<String, Integer> res = new HashMap<String, Integer>();
		
		return res;
	}
	
	
}
