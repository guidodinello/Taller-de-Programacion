package servlets;

import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.datatypes.DTActividad;
import model.datatypes.estadoActividad;
import model.datatypes.tipoInscripcion;
import excepciones.InscriptionFailException;
import excepciones.YaExisteException;
import model.logica.interfaces.ICtrlActividad;
import model.logica.interfaces.ICtrlUsuario;
import model.datatypes.tipoUsuario;
import model.logica.interfaces.Fabrica;

/**
 * Servlet implementation class index
 */
@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public index() {
        super();
        cargarDatos();
    }
    
    // Hard-Codeo de los datos
    protected void cargarDatos() {
        Fabrica fabrica = Fabrica.getInstance();
        ICtrlUsuario icu = fabrica.getICtrlUsuario();
        ICtrlActividad ica = fabrica.getICtrlActividad();
        String descripcion;
        
        //Alta Usuarios
        try {
            //turistas
            icu.altaUsuario("lachiqui","mirtha.legrand.ok@hotmail.com.ar", "Rosa María", "Martínez", "awdrg543", new GregorianCalendar(1927, 2, 23), "https://tinyurl.com/2e3s66tw", tipoUsuario.turista, "argentina", "", "");
            icu.altaUsuario("isabelita","isabelita@thecrown.co.uk", "Elizabeth", "Windsor", "r5t6y7u8", new GregorianCalendar(1926, 4, 21), "https://tinyurl.com/ycy8mbrn", tipoUsuario.turista, "inglesa", "", "");
            icu.altaUsuario("anibal","anibal@fing.edu.uy", "Aníbal", "Lecter", "edrft543", new GregorianCalendar(1937, 12, 31), "https://tinyurl.com/y2u3tybh", tipoUsuario.turista, "lituana", "", "");
            icu.altaUsuario("waston","e.waston@gmail.com", "Emma", "Waston", "poiuy987", new GregorianCalendar(1990, 4, 15), "https://tinyurl.com/2p9ed8et", tipoUsuario.turista, "inglesa", "", "");
            icu.altaUsuario("elelvis","suavemente@hotmail.com", "Elvis", "Lacio", "45idgaf67", new GregorianCalendar(1971, 7, 30), "https://tinyurl.com/mtwppxxz", tipoUsuario.turista, "estadounidense", "", "");
            icu.altaUsuario("eleven11","eleven11@gmail.com", "Eleven", "Once", "xdrgb657", new GregorianCalendar(2004, 2, 19), "https://tinyurl.com/3ztpasya", tipoUsuario.turista, "española", "", "");
            icu.altaUsuario("bobesponja","bobesponja@nickelodeon.com", "Bob", "Esponja", "sbsplol1", new GregorianCalendar(1999, 5, 1), "https://tinyurl.com/43zymcch", tipoUsuario.turista, "japonesa", "", "");
            icu.altaUsuario("tony","eltony@manya.org.uy", "Antonio", "Pacheco", "okmnji98", new GregorianCalendar(1976, 4, 11), "https://tinyurl.com/mr3a38w4", tipoUsuario.turista, "uruguaya", "", "");
            icu.altaUsuario("chino","chino@trico.org.uy", "Álvaro", "Recoba", "qsxcdw43", new GregorianCalendar(1976, 3, 17), "https://tinyurl.com/2b556k7t", tipoUsuario.turista, "uruguaya", "", "");
            icu.altaUsuario("mastropiero","johann.sebastian@gmail.com", "Johann Sebastian", "Mastropiero", "qpwoei586", new GregorianCalendar(1922, 2, 7), "https://tinyurl.com/3mbeyawm", tipoUsuario.turista, "austríaca", "", "");
            //proveedores
            descripcion = "Hola! me llamo Washington y soy el encargado del portal de turismo del departamento de Rocha - Uruguay";
            icu.altaUsuario("washington","washington@turismorocha.gub.uy", "Washington", "Rocha", "asdfg654", new GregorianCalendar(1970, 9, 14), "https://tinyurl.com/3whe8372", tipoUsuario.proveedor, "", descripcion, "http://turismorocha.gub.uy/");
            descripcion = "Pablo es el presidente de la Sociedad de Fomento Turístico de Rivera (conocida como Socfomturriv)";
            icu.altaUsuario("eldiez","eldiez@socfomturriv.org.uy", "Pablo", "Bengoechea", "ytrewq10", new GregorianCalendar(1965, 6, 27), "https://tinyurl.com/mu4jeas3", tipoUsuario.proveedor, "", descripcion, "http://wwww.socfomturriv.org.uy");
            descripcion = "Departamento de Turismo del Departamento de Colonia";
            icu.altaUsuario("meche","meche@colonia.gub.uy", "Mercedes", "Venn", "mnjkiu89", new GregorianCalendar(1990, 12, 31), "https://tinyurl.com/4hs4v9c5", tipoUsuario.proveedor, "", descripcion, "http://colonia.gub.uy/turismo/");
        } catch(YaExisteException e) {
            e.printStackTrace();
        }
        
        //Departamentos
        try {
            ica.altaDepartamento("Canelones", "División Turismo de la Intendencia", "https://www.imcanelones.gub.uy/es");
            ica.altaDepartamento("Maldonado", "División Turismo de la Intendencia", "https://www.maldonado.gub.uy/");
            ica.altaDepartamento("Treinta y Tres", "División Turismo de la Intendencia", "https://treintaytres.gub.uy");
            ica.altaDepartamento("Cerro Largo", "División Turismo de la Intendencia", "https://www.gub.uy/intendencia-cerro-largo/");
            ica.altaDepartamento("Artigas", "División Turismo de la Intendencia", "http://www.artigas.gub.uy");
            ica.altaDepartamento("Salto", "División Turismo de la Intendencia", "https://www.salto.gub.uy");
            ica.altaDepartamento("Paysandú", "División Turismo de la Intendencia", "https://www.paysandu.gub.uy");
            ica.altaDepartamento("Río Negro", "División Turismo de la Intendencia", "https://www.rionegro.gub.uy");
            ica.altaDepartamento("Soriano", "División Turismo de la Intendencia", "https://www.soriano.gub.uy");
            ica.altaDepartamento("San José", "División Turismo de la Intendencia", "https://sanjose.gub.uy");
            ica.altaDepartamento("Flores", "División Turismo de la Intendencia", "https://flores.gub.uy");
            ica.altaDepartamento("Florida", "División Turismo de la Intendencia", "http://florida.gub.uy");
            ica.altaDepartamento("Lavalleja", "División Turismo de la Intendencia", "http://lavalleja.gub.uy");
            ica.altaDepartamento("Durazno", "División Turismo de la Intendencia", "https://durazno.uy");
            ica.altaDepartamento("Tacuarembó", "División Turismo de la Intendencia", "https://tacuarembo.gub.uy");
            ica.altaDepartamento("Montevideo", "División Turismo de la Intendencia", "https://montevideo.gub.uy/areas-tematicas/turismo");
            descripcion = "La Organización de Gestión del Destino (OGD) Rocha es un ámbito de articulación público - privada en el sector turístico que integran la Corporación Rochense de Turismo y la Intendencia de Rocha a través de su Dirección de Turismo.";
            ica.altaDepartamento("Rocha", descripcion, "www.turismorocha.gub.uy");
            descripcion = "Promociona e implementa proyectos e iniciativas sostenibles de interés turístico con la participación institucional pública - privada en bien del desarrollo socioencoónomico de la comunidad.";
            ica.altaDepartamento("Rivera", descripcion, "www.rivera.gub.uy/social/turismo/");
            descripcion = "La propuesta del Departamento de Colonia divide en cuatro actos su espectáculo anual. Cada acto tiene su magia. Desde su naturaleza y playas hasta sus tradiciones y el patrimonio mundial. Todo el año se disfruta.";
            ica.altaDepartamento("Colonia", descripcion, "www.rivera.gub.uy/social/turismo/");
        } catch(YaExisteException e) {
            e.printStackTrace();
        }
        
        //Categorias
        try {
            ica.altaCategoria("Aventura y Deporte");
            ica.altaCategoria("Campo y Naturaleza");
            ica.altaCategoria("Cultura y Patrimonio");
            ica.altaCategoria("Gastronomia");
            ica.altaCategoria("Turismo Playas");
        } catch(YaExisteException e) {
            e.printStackTrace();
        }
        
        //Actividades
        try {
            String C1 = "Aventura y Deporte";
            String C2 = "Campo y Naturaleza";
            String C3 = "Cultura y Patrimonio";
            String C4 = "Gastronomia";
            String C5 = "Turismo Playas";
            
            Set<String> categorias;
            categorias = new HashSet<String>();
            categorias.add(C4);
            descripcion = "Festival gastronómico de productos locales en Rocha";
            ica.altaActividadTuristica("Rocha", "Degusta", descripcion, 3, 800, "Rocha", "washington", new GregorianCalendar(2022, 7, 20), "https://tinyurl.com/bdehz9bb", null, categorias, estadoActividad.confirmada);
            categorias.clear();
            categorias.add(C3);
            categorias.add(C4);
            descripcion = "En el mes aniversario del Club Deportivo Unión de Rocha te invitamos a una merienda deliciosa.";
            ica.altaActividadTuristica("Rocha", "Teatro con Sabores", descripcion, 3, 500, "Rocha", "washington", new GregorianCalendar(2022, 7, 21), "https://tinyurl.com/58fnr5j7", null, categorias, estadoActividad.confirmada);
            categorias.clear();
            categorias.add(C3);
            descripcion = "Con guía especializado y en varios idiomas. Varios circuitos posibles.";
            ica.altaActividadTuristica("Colonia", "Tour por Colonia del Sacramento", descripcion, 2, 400, "Colonia del Sacramento", "meche", new GregorianCalendar(2022, 8, 1), "https://tinyurl.com/3rp2vvjf", null, categorias, estadoActividad.confirmada);
            categorias.clear();
            categorias.add(C4);
            descripcion = "Restaurante en la renovada Plaza de Toros con menú internacional";
            ica.altaActividadTuristica("Colonia", "Almuerzo en el Real de San Carlos", descripcion, 2, 800, "Colonia del Sacramento", "meche", new GregorianCalendar(2022, 8, 1), "https://tinyurl.com/2yeu66vb", null, categorias, estadoActividad.confirmada);
            categorias.clear();
            categorias.add(C2);
            categorias.add(C4);
            descripcion = "Almuerzo en la Posada con ticket fijo. Menú que incluye bebida y postre casero.";
            ica.altaActividadTuristica("Rivera", "Almuerzo en Valle del Lunarejo", descripcion, 2, 300, "Tranqueras", "eldiez", new GregorianCalendar(2022, 8, 1), "https://tinyurl.com/4yrs8y2c", null, categorias, estadoActividad.confirmada);
            categorias.clear();
            categorias.add(C2);
            descripcion = "Cabalgata por el área protegida. Varios recorridos para elegir.";
            ica.altaActividadTuristica("Rivera", "Cabalgata en Valle del Lunarejo", descripcion, 2, 150, "Tranqueras", "eldiez", new GregorianCalendar(2022, 8, 1), "https://tinyurl.com/2vjd382t", null, categorias, estadoActividad.confirmada);
            categorias.clear();
            categorias.add(C3);
            descripcion = "Recorrida por los principales atractivos de la ciudad";
            ica.altaActividadTuristica("Colonia", "Bus turístico Colonia", descripcion, 3, 600, "Colonia del Sacramento", "meche", new GregorianCalendar(2022, 9, 1), "https://tinyurl.com/bdzyrm93", null, categorias, estadoActividad.agregada);
            categorias.clear();
            categorias.add(C3);
            descripcion = "Visita lugares exclusivos y relevantes";
            ica.altaActividadTuristica("Colonia", "Colonia Premium Tour", descripcion, 4, 2600, "Colonia del Sacramento", "meche", new GregorianCalendar(2022, 9, 3), "https://tinyurl.com/284kr973", null, categorias, estadoActividad.rechazada);
            categorias.clear();
            categorias.add(C5);
            categorias.add(C1);
            descripcion = "kitsurf - windsurf - kayakismo - canotaje en Rocha";
            ica.altaActividadTuristica("Rocha", "Deportes náuticos sin uso de motor", descripcion, 3, 1200, "Rocha", "washington", new GregorianCalendar(2022, 9, 5), "https://tinyurl.com/yck2a92h", null, categorias, estadoActividad.agregada);
            categorias.clear();
            categorias.add(C3);
            descripcion = "Rivera es un departamento de extraordinaria riqueza natural patrimonial y cultural con una ubicación geográfica privilegiada";
            ica.altaActividadTuristica("Rivera", "Descubre Rivera", descripcion, 2, 650, "Rivera", "eldiez", new GregorianCalendar(2022, 9, 16), "https://tinyurl.com/y4vbc4xc", null, categorias, estadoActividad.rechazada);
        } catch(YaExisteException e) {
            e.printStackTrace();
        }
        
        //Salidas
        try {
            ica.altaSalidaTuristica("Degusta Agosto", new GregorianCalendar(2022, 8, 20, 17, 0), "Sociedad Agropecuaria de Rocha", 20, new GregorianCalendar(2022, 7, 21), "Degusta", "tinyurl.com/4jwed4jx");
            ica.altaSalidaTuristica("Degusta Setiembre", new GregorianCalendar(2022, 9, 3, 17, 0), "Sociedad Agropecuaria de Rocha", 20, new GregorianCalendar(2022, 7, 22), "Degusta", "tinyurl.com/2maxmx6c");
            ica.altaSalidaTuristica("Teatro con Sabores 1", new GregorianCalendar(2022, 9, 4, 18, 0), "Club Deportivo Unión", 30, new GregorianCalendar(2022, 7, 23), "Teatro con Sabores", "tinyurl.com/2zturssk");
            ica.altaSalidaTuristica("Teatro con Sabores 2", new GregorianCalendar(2022, 9, 11, 18, 0), "Club Deportivo Unión", 30, new GregorianCalendar(2022, 7, 23), "Teatro con Sabores", "tinyurl.com/5d5vm953");
            ica.altaSalidaTuristica("Tour por Colonia del Sacramento 11-09", new GregorianCalendar(2022, 9, 11, 10, 0), "Encuentro en la base del Faro", 5, new GregorianCalendar(2022, 8, 5), "Tour por Colonia del Sacramento", "tinyurl.com/5n7ud8e7");
            ica.altaSalidaTuristica("Tour por Colonia del Sacramento 18-09", new GregorianCalendar(2022, 9, 18, 12, 0), "Encuentro en la base del Faro", 5, new GregorianCalendar(2022, 8, 5), "Tour por Colonia del Sacramento", "tinyurl.com/583b3mbs");
            ica.altaSalidaTuristica("Almuerzo 1", new GregorianCalendar(2022, 9, 18, 12, 0), "Restaurante de la Plaza de Toros", 5, new GregorianCalendar(2022, 8, 4), "Almuerzo en el Real de San Carlos", "");
            ica.altaSalidaTuristica("Almuerzo 2", new GregorianCalendar(2022, 9, 25, 12, 0), "Restaurante de la Plaza de Toros", 5, new GregorianCalendar(2022, 8, 4), "Almuerzo en el Real de San Carlos", "");
            ica.altaSalidaTuristica("Almuerzo 3", new GregorianCalendar(2022, 9, 10, 12, 0), "Posada Del Lunarejo", 4, new GregorianCalendar(2022, 8, 15), "Almuerzo en Valle del Lunarejo", "");
            ica.altaSalidaTuristica("Almuerzo 4", new GregorianCalendar(2022, 9, 11, 12, 0), "Posada Del Lunarejo", 4, new GregorianCalendar(2022, 8, 15), "Almuerzo en Valle del Lunarejo", "");
            ica.altaSalidaTuristica("Cabalgata 1", new GregorianCalendar(2022, 9, 10, 16, 0), "Posada Del Lunarejo", 4, new GregorianCalendar(2022, 8, 15), "Cabalgata en Valle del Lunarejo", "tinyurl.com/2p9he77w");
            ica.altaSalidaTuristica("Cabalgata 2", new GregorianCalendar(2022, 9, 11, 16, 0), "Posada Del Lunarejo", 4, new GregorianCalendar(2022, 8, 15), "Cabalgata en Valle del Lunarejo", "");
            ica.altaSalidaTuristica("Degusta Octubre", new GregorianCalendar(2022, 10, 30, 17, 0), "Sociedad Agropecuaria de Rocha", 20, new GregorianCalendar(2022, 9, 22), "Degusta", "tinyurl.com/mryhyr5f");
            ica.altaSalidaTuristica("Degusta Noviembre", new GregorianCalendar(2022, 11, 5, 17, 0), "Sociedad Agropecuaria de Rocha", 20, new GregorianCalendar(2022, 10, 2), "Degusta", "tinyurl.com/yzz6b7et");
            ica.altaSalidaTuristica("Teatro con Sabores 3", new GregorianCalendar(2022, 11, 11, 18, 0), "Club Deportivo Unión", 30, new GregorianCalendar(2022, 8, 25), "Teatro con Sabores", "");
            ica.altaSalidaTuristica("Tour por Colonia del Sacramento 30-10", new GregorianCalendar(30, 10, 2022, 10, 0), "Encuentro en la base del Faro", 10, new GregorianCalendar(2022, 9, 7), "Tour por Colonia del Sacramento", "tinyurl.com/mv7etjx2");
            ica.altaSalidaTuristica("Cabalgata Extrema", new GregorianCalendar(2022, 10, 30, 16, 0), "Posada Del Lunarejo", 4, new GregorianCalendar(2022, 9, 15), "Cabalgata en Valle del Lunarejo", "tinyurl.com/3vwzthcr");
            ica.altaSalidaTuristica("Almuerzo en el Real 1", new GregorianCalendar(2022, 10, 30, 12, 0), "Restaurante de la Plaza de Toros", 10, new GregorianCalendar(2022, 10, 10), "Almuerzo en el Real de San Carlos", "");
        }catch(YaExisteException e) {
            e.printStackTrace();
        }
        
        //Paquetes
        try {
            ica.crearPaquete("Disfrutar Rocha", "Actividades para hacer en familia y disfrutar arte y gastronomía", 60, 20, new GregorianCalendar(2022,8,10), "tinyurl.com/3ppwdca4");
            ica.crearPaquete("Un día en Colonia", "Paseos por el casco histórico y se puede terminar con Almuerzo en la Plaza de Toros", 45, 15, new GregorianCalendar(2022,8,1), "tinyurl.com/4yzrdt8b");
            ica.crearPaquete("Valle Del Lunarejo", "Visite un área protegida con un paisaje natural hermoso", 60, 15, new GregorianCalendar(2022,9,15), "tinyurl.com/mvteyv6y");
        } catch(YaExisteException e) {
            e.printStackTrace();
        }
        
        //Agregar Actividades a Paquetes
        ica.ingresarActividadAPaquete("Disfrutar Rocha", "Degusta");
        ica.ingresarActividadAPaquete("Disfrutar Rocha", "Teatro con Sabores");
        ica.ingresarActividadAPaquete("Un día en Colonia", "Tour por Colonia del Sacramento");
        ica.ingresarActividadAPaquete("Un día en Colonia", "Almuerzo en el Real de San Carlos");
        ica.ingresarActividadAPaquete("Valle Del Lunarejo", "Almuerzo en Valle del Lunarejo");
        ica.ingresarActividadAPaquete("Valle Del Lunarejo", "Cabalgata en Valle del Lunarejo");
        
        //Compra Paquetes
        //TO-DO
        
        //Inscripciones
        try {
            icu.ingresarInscripcion("lachiqui", "Degusta Agosto", 3, new GregorianCalendar(2022,8,15), tipoInscripcion.general, "");
        } catch(InscriptionFailException e) {
            e.printStackTrace();
        }
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICtrlActividad ICA = Fabrica.getInstance().getICtrlActividad();
	    Set<DTActividad> actividades = ICA.getDTActividadesConfirmadas();
	    request.setAttribute("act_confirmadas", actividades);
	    
        request.getRequestDispatcher("/WEB-INF/home/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
