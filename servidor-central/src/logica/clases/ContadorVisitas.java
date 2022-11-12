package logica.clases;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class ContadorVisitas {
	//private Map<String, Integer> registro;
	private TreeMap<String, Integer> registro;
	private static ContadorVisitas instancia = null;
	
	private ContadorVisitas() {
		registro = new TreeMap<String, Integer>(new Comparator<String>() {
		    public int compare(String o1, String o2) {
		        return o1.toLowerCase().compareTo(o2.toLowerCase());
		    }
		});
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
	
	public TreeMap<String, Integer> getTop10(){
		TreeMap<String, Integer> res = new TreeMap<String, Integer>(new Comparator<String>() {
		    public int compare(String o1, String o2) {
		        return o1.toLowerCase().compareTo(o2.toLowerCase());
		    }
		});
		
		int count = 0;
		for (Map.Entry<String,Integer> entry:registro.entrySet()) {
		     if (count >= 10) break;

		     res.put(entry.getKey(), entry.getValue());
		     count++;
		  }
			
		return res;
	}
	
	
}
