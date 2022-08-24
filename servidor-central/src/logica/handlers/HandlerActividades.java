package logica.handlers;

public class HandlerActividades {
	private Map<String, Departamento> departamentos;
	private static HandlerDepartamentos instancia = null;
	
	private HandlerDepartamentos() {
		this.departamentos = new HashMap<String, Departamento>();
	};
	
	public static HandlerDepartamentos getInstance() {
		if(HandlerDepartamentos.instancia == null) {
			HandlerDepartamentos.instancia = new HandlerDepartamentos();
		}
		return HandlerDepartamentos.instancia;
	}
	
	//Pre: no existe un departamento con nombre d.getNombre
	public void add(Departamento d) {
		String nombreDepartamento = d.getNombre();
		this.departamentos.put(nombreDepartamento, d);
	}
	
	public boolean existeDepartamento(String nombreDepartamento) {
		return this.departamentos.containsKey(nombreDepartamento);
	}
	
	public ActividadTuristica obtenerActividadTuristica(String nombre) {
		return actividades.get(nombre);
	}

}
