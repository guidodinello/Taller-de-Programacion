package logica.handlers;

import java.util.HashMap;
import java.util.Map;

import logica.clases.ActividadTuristica;

public class HandlerActividades{
    private Map<String,ActividadTuristica> actividadesTuristicas;
    private static HandlerActividades instancia = null;

    private HandlerActividades() {
        actividadesTuristicas = new HashMap<String, ActividadTuristica>();
    }

    public static HandlerActividades getInstance() {
        if (instancia == null)
            instancia = new HandlerActividades();
        return instancia;
    }

	public ActividadTuristica getActividad(String actividad) {
		return actividadesTuristicas.get(actividad);
	}
}
