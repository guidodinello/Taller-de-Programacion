package logica.controladores;
import java.util.Set;

import datatypes.DTActividad;
import datatypes.DTPaquete;
import datatypes.DTSalida;

import java.util.GregorianCalendar;
import java.util.HashSet;

import excepciones.YaExisteException;
import logica.clases.Departamento;
import logica.clases.ActividadTuristica;
import logica.clases.Categoria;
import logica.clases.PaqueteTuristico;
import logica.handlers.HandlerDepartamentos;
import logica.handlers.HandlerPaquetes;
import logica.handlers.HandlerActividades;
import logica.handlers.HandlerCategorias;
import logica.interfaces.*;
import logica.clases.SalidaTuristica;
import logica.clases.Proveedor;
import logica.handlers.HandlerSalidas;
import logica.handlers.HandlerUsuarios;

public class CtrlActividad implements ICtrlActividad{
	
	
	public void altaDepartamento(String nombreDepartamento,String descripcion ,String URL) throws YaExisteException{
		HandlerDepartamentos hD = HandlerDepartamentos.getInstance();
		if(hD.existeDepartamento(nombreDepartamento)){
			throw new YaExisteException("El departamento " + nombreDepartamento + "ya se encuentra registrado.");
		}
		Departamento newD = new Departamento(nombreDepartamento, descripcion,URL);
		hD.add(newD);
		
	}
	
	public void altaCategoria(String nombre) throws YaExisteException{
		HandlerCategorias hC = HandlerCategorias.getInstance();
		if(hC.existeCategoria(nombre)){
			throw new YaExisteException("La Categoria " + nombre + "ya se encuentra registrada.");
		}
		Categoria nuevaCat = new Categoria(nombre);
		hC.add(nuevaCat);
	}
	
	public Set<String> listarDepartamentos(){
		Set<String> departamentos = new HashSet<String>();
		HandlerDepartamentos hD = HandlerDepartamentos.getInstance();
		Set<Departamento> dep = hD.obtenerDepartamentos();
		dep.forEach((e) -> { departamentos.add(e.getNombre()); });
		return departamentos;
	}
	
	public Set<String> listarActividadesDepartamento(String depto){
		HandlerDepartamentos hD = HandlerDepartamentos.getInstance();
		Departamento d = hD.getDepto(depto);
		Set<String> actividades = d.listarActividades();
		return actividades;
	}
	//Actividades
	public DTActividad getInfoActividad(String actividad) {
		//Falta la parte de Paquetes
		HandlerActividades hA = HandlerActividades.getInstance();
		HandlerPaquetes hP = HandlerPaquetes.getInstance();
		ActividadTuristica at = hA.obtenerActividadTuristica(actividad);
		DTActividad res = at.getDTActividad();
		
		Set<PaqueteTuristico> p = hP.getPaquetes();
		Set<String> paquetes = new HashSet<String>();
		p.forEach((e) -> {if(e.tieneActividad(actividad)){paquetes.add(e.getNombre());}});
		res.setPaquetes(paquetes);
		return res;
	}
	
	public void altaActividadTuristica(String nomDep, String nomActividad, String desc,int duraHs,float costo,String nombCiudad,String nickProv, GregorianCalendar fechaAlta) throws YaExisteException {
		HandlerActividades hA = HandlerActividades.getInstance();
		if(hA.existeActividad(nomActividad)){
			throw new YaExisteException("Ya existe una actividad turistica " + nomActividad + " registrada.");
		}

		ActividadTuristica resu = new ActividadTuristica(nomActividad, desc, duraHs, costo, nombCiudad, fechaAlta);
		
		HandlerDepartamentos hD = HandlerDepartamentos.getInstance();
		hD.getDepto(nomDep).agregarActividad(resu);
		HandlerUsuarios hU = HandlerUsuarios.getInstance();
		Proveedor p = (Proveedor) hU.getProveedorByNickname(nickProv);
		p.agregarActividad(resu);
		hA.agregarActividad(resu);
	}
	
	
	public Set<String> listarNombresSalidasDeActividad(String actividad){

		HandlerActividades hA= HandlerActividades.getInstance();
		ActividadTuristica act = hA.obtenerActividadTuristica(actividad);
		return act.getSalidasNombre();
	
	}
	
	//Salidas
	public Set<DTSalida> listarInfoSalidasVigentes(String actividad,GregorianCalendar fechaSistema){
		HandlerActividades hA = HandlerActividades.getInstance();
		ActividadTuristica at = hA.obtenerActividadTuristica(actividad);
		return at.getInfoBasicaSalidasVigentes(fechaSistema);
	}
	
	public void altaSalidaTuristica(String nombreSal,GregorianCalendar fechaSal, String lugarSal,int cantMaxTuristas, GregorianCalendar fechaAlta,String  actividad) throws YaExisteException {
		HandlerSalidas hS = HandlerSalidas.getInstance();
		if (hS.existeSalida(nombreSal)) {
			throw new YaExisteException("La salida " + nombreSal + "ya se encuentra registrada");
			
		}
		HandlerActividades hA = HandlerActividades.getInstance();
		ActividadTuristica actividadAux = hA.obtenerActividadTuristica(actividad);
		
		SalidaTuristica newSal = new SalidaTuristica(nombreSal,fechaSal,lugarSal,cantMaxTuristas,fechaAlta,actividadAux);
		actividadAux.agregarSalida(newSal);
		hS.addSalidas(newSal);
	
	}
	
	public DTSalida getInfoCompletaSalida(String salida) {
	
		HandlerSalidas hS = HandlerSalidas.getInstance();
		
		DTSalida nueva =   new DTSalida();
		SalidaTuristica[] salidas=  hS.getSalidas();
		for (int i = 0; i < salidas.length; i++) {
			String nombreSal =salidas[i].getNombre();
			if(nombreSal == salida) {
				nueva.setNombre(nombreSal);
				nueva.setfechaAlta(salidas[i].getfechaAlta());
				nueva.setfechaSalida(salidas[i].getfechaSalida());
				nueva.setlugarSalida(salidas[i].getlugarSalida());
				nueva.setmaxTuristas(salidas[i].getcantidadMaximaDeTuristas());
				nueva.setTuristas(salidas[i].getTuristasInscriptos());
			}
		}
		
		
		return nueva;
	}
	
	//Paquetes
	public void crearPaquete(String nombre,String descripcion,int validez,float descuento,GregorianCalendar fechaDeAlta) throws YaExisteException {
		HandlerPaquetes hP = HandlerPaquetes.getInstance();
		if(hP.existePaquete(nombre))
			throw new YaExisteException("El paquete " + nombre + " ya se encuentra registrado");
		PaqueteTuristico newPaquete = new PaqueteTuristico(nombre, descripcion, validez, descuento, fechaDeAlta);
		hP.addPaquete(newPaquete);
	}
	
	public Set<String> listarPaquetes(){
		HandlerPaquetes hP = HandlerPaquetes.getInstance();
		Set<PaqueteTuristico> paquetes = hP.getPaquetes();
		Set<String> res = new HashSet<String>();
		paquetes.forEach((e) -> {res.add(e.getNombre());});
		return res;
	}
	
	public void ingresarActividadAPaquete(String nombrePaquete,String nombreActividad) {
		HandlerPaquetes hP = HandlerPaquetes.getInstance();
		HandlerActividades hA = HandlerActividades.getInstance();
		PaqueteTuristico pt = hP.obtenerPaqueteTuristico(nombrePaquete);
		ActividadTuristica at = hA.obtenerActividadTuristica(nombreActividad);
		pt.agregarActividad(at);
	}
	
	public DTPaquete getInfoPaquete(String paqueteSeleccionado) {
		HandlerPaquetes hP = HandlerPaquetes.getInstance();
		PaqueteTuristico pt = hP.obtenerPaqueteTuristico(paqueteSeleccionado);
		return pt.getDTPaquete();
	}
	
	public Set<String> listarActividadesDepartamentoMenosPaquete(String depto, String nombrePaquete){
		Set<String> resu = new HashSet<String>();
		Set<String> depAct = this.listarActividadesDepartamento(depto);
		
		HandlerPaquetes hP = HandlerPaquetes.getInstance();
		PaqueteTuristico pt = hP.obtenerPaqueteTuristico(nombrePaquete);
		
		depAct.forEach(e ->{
			if(!pt.tieneActividad(e)) {
				resu.add(e);
			}
		});
		return resu;
	}
	
	public Set<String> listarCategorias(){
		Set<String> resultado = new HashSet<String>();
		HandlerCategorias hC = HandlerCategorias.getInstance();
		Set<Categoria> categorias = hC.obtenerCategorias();
		categorias.forEach((e)->{
			resultado.add(e.getNombre());
		});
		return resultado;
	}
}