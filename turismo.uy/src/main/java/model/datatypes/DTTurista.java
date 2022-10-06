package model.datatypes;

import model.logica.clases.Turista;


public class DTTurista extends DTUsuario {
	private String nacionalidad;
	
	public DTTurista(Turista t) {
		super(t);
		nacionalidad = t.getNacionalidad();
	}

	public String getNacionalidad() {
		return nacionalidad;
	}
}
