package logica.clases;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ContadorVisitas {
	private Map<String, Integer> registro;
	//private TreeMap<String, Integer> registro;
	private static ContadorVisitas instancia = null;
	
	private ContadorVisitas() {
		registro = new TreeMap<String, Integer>();
	}
	
	private static <K, V extends Comparable<V> > Map<K, V>
    valueSort(final Map<K, V> map){
        Comparator<K> valueComparator = new Comparator<K>() {
            
                  public int compare(K k1, K k2){
                      int comp = map.get(k1).compareTo(map.get(k2));
                      if (comp == 0)
                          return 1;
                      else
                          return comp;
                  }
            
              };
              
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);
        
        sorted.putAll(map);
        
        return sorted;
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
		res = valueSort(registro);
		
		int count = 0;
		for (Map.Entry<String,Integer> entry:registro.entrySet()) {
		     if (count >= 10) break;

		     res.put(entry.getKey(), entry.getValue());
		     count++;
		  }
			
		return res;
	}
}


