package model.logica.controladores;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import model.datatypes.DTActividad;
import model.datatypes.DTPaquete;
import model.datatypes.DTSalida;
import model.datatypes.estadoActividad;

import java.util.GregorianCalendar;
import java.util.HashSet;

import excepciones.YaExisteException;
import model.logica.clases.Departamento;
import model.logica.clases.ActividadTuristica;
import model.logica.clases.Categoria;
import model.logica.clases.PaqueteTuristico;
import model.logica.handlers.HandlerDepartamentos;
import model.logica.handlers.HandlerPaquetes;
import model.logica.handlers.HandlerActividades;
import model.logica.handlers.HandlerCategorias;
import model.logica.interfaces.*;
import model.logica.clases.SalidaTuristica;
import model.logica.clases.Proveedor;
import model.logica.handlers.HandlerSalidas;
import model.logica.handlers.HandlerUsuarios;

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
	
	public void altaActividadTuristica(String nomDep, String nomActividad, String desc,int duraHs,float costo,String nombCiudad,String nickProv, GregorianCalendar fechaAlta, String imgDir, byte[] imgBin, Set<String> categorias, estadoActividad estado) throws YaExisteException {
		HandlerActividades hA = HandlerActividades.getInstance();
		if(hA.existeActividad(nomActividad)){
			throw new YaExisteException("Ya existe una actividad turistica " + nomActividad + " registrada.");
		}

		ActividadTuristica resu = new ActividadTuristica(nomActividad, desc, duraHs, costo, nombCiudad, fechaAlta, imgDir, imgBin, estado);

	    System.out.println(nomDep);
	    System.out.println(resu);
		HandlerDepartamentos hD = HandlerDepartamentos.getInstance();
		hD.getDepto(nomDep).agregarActividad(resu);

		
		HandlerCategorias hC = HandlerCategorias.getInstance();
		categorias.forEach(cat ->{
			hC.getCategoria(cat).agregarActividad(resu);
		});
		
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
	
	public void altaSalidaTuristica(String nombreSal,GregorianCalendar fechaSal, String lugarSal,int cantMaxTuristas, GregorianCalendar fechaAlta,String  actividad, String img) throws YaExisteException {
		HandlerSalidas hS = HandlerSalidas.getInstance();
		if (hS.existeSalida(nombreSal)) {
			throw new YaExisteException("La salida " + nombreSal + "ya se encuentra registrada");
			
		}
		HandlerActividades hA = HandlerActividades.getInstance();
		ActividadTuristica actividadAux = hA.obtenerActividadTuristica(actividad);
		
		SalidaTuristica newSal = new SalidaTuristica(nombreSal,fechaSal,lugarSal,cantMaxTuristas,fechaAlta,actividadAux,img);
		actividadAux.agregarSalida(newSal);
		hS.addSalidas(newSal);
	
	}
	
	public DTSalida getInfoCompletaSalida(String salida) {
	
		HandlerSalidas hS = HandlerSalidas.getInstance();
		SalidaTuristica sal = hS.obtenerSalidaTuristica(salida);
		DTActividad dtAct = getInfoActividad(sal.getActividad().getNombre());
		
		DTSalida nueva = new DTSalida(sal.getNombre(), dtAct.getNombre(), dtAct.getDepartamento(), sal.getfechaSalida(), sal.getfechaAlta(), sal.getcantidadMaximaDeTuristas(), sal.getlugarSalida(), sal.getTuristasInscriptos(), sal.getImg());
		
		
		return nueva;
	}
	
	//Paquetes
	public void crearPaquete(String nombre,String descripcion,int validez,float descuento,GregorianCalendar fechaDeAlta, String img) throws YaExisteException {
		HandlerPaquetes hP = HandlerPaquetes.getInstance();
		if(hP.existePaquete(nombre))
			throw new YaExisteException("El paquete " + nombre + " ya se encuentra registrado");
		PaqueteTuristico newPaquete = new PaqueteTuristico(nombre, descripcion, validez, descuento, fechaDeAlta, img);
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
		HandlerActividades hA = HandlerActividades.getInstance();
		Set<ActividadTuristica> actividades = new HashSet<ActividadTuristica>();
		for(String s: depAct) {
			ActividadTuristica act = hA.obtenerActividadTuristica(s);
			actividades.add(act);
		}
		
		HandlerPaquetes hP = HandlerPaquetes.getInstance();
		PaqueteTuristico pt = hP.obtenerPaqueteTuristico(nombrePaquete);
		
		actividades.forEach(e ->{
			if(!pt.tieneActividad(e.getNombre()) & e.getEstado() == estadoActividad.confirmada  ) {
				resu.add(e.getNombre());
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
	
	public <T> Set<T> filter(Function<ActividadTuristica, T> returnFunction, Predicate<ActividadTuristica> condition) {
	    Set<T> res = new HashSet<T>();
	    Set<ActividadTuristica> actividades = HandlerActividades.getInstance().obtenerActividadesTuristicas();
		for (ActividadTuristica act : actividades) {
			if (condition.test(act))
				res.add(returnFunction.apply(act));
		}
		return res;
	}
	
	public Set<DTActividad> getDTActividadesConfirmadas() {
		Function<ActividadTuristica, DTActividad> dts = (a) -> { return a.getDTActividad(); };
		Predicate<ActividadTuristica> confirmada = (a) -> { return a.getEstado().equals(estadoActividad.confirmada);  };                                                          
		return filter(dts, confirmada);
	}

    public Set<String> listarPaquetesCategoria(String categoria) {
        Set<String> res = new HashSet<String>();
        
        Set<String> paquetes = listarPaquetes();
        for(String paq : paquetes) {
            DTPaquete actual = getInfoPaquete(paq);
            if(actual.getCategorias().contains(categoria))
                res.add(paq);
        }
        
        return res;
    }
}