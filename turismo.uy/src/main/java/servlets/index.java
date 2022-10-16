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

import datatypes.DTActividad;
import datatypes.estadoActividad;
import datosDePrueba.CargarDatosDePrueba;
import logica.interfaces.ICtrlActividad;
import logica.interfaces.ICtrlUsuario;
import logica.clases.ActividadTuristica;
import logica.handlers.HandlerActividades;
import logica.interfaces.Fabrica;

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
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	    CargarDatosDePrueba cdp = new CargarDatosDePrueba();
//        Fabrica fabrica = Fabrica.getInstance();
//        ICtrlUsuario ICU = fabrica.getICtrlUsuario();
//        ICtrlActividad ICA = fabrica.getICtrlActividad();
//        cdp.cargarDatos(ICU, ICA);
//        request.setAttribute("act_confirmadas", ICA.getDTActividadesConfirmadas());
        
	    /* Hardcodeo de prueba hasta que tengamos datos cargados*/
	    Set<String> salidas = new HashSet<String>();
	    salidas.add("salida1");
	    Set<String> categorias = new HashSet<String>();
	    categorias.add("categoria1");
	    Set<DTActividad> actividades = new HashSet<DTActividad>();
	    DTActividad dta1 = new DTActividad("nombre1","descripcion","dpto","ciudad",
                new GregorianCalendar(),0,(float) 0.1,
                salidas,
                categorias,
                "",estadoActividad.confirmada );
       DTActividad dta2 = new DTActividad("nombre2","descripcion","dpto","ciudad",
                new GregorianCalendar(),0,(float) 0.1,
                salidas,
                categorias,
                "",estadoActividad.confirmada );
        DTActividad dta3 = new DTActividad("nombre3","descripcion","dpto","ciudad",
                new GregorianCalendar(),0,(float) 0.1,
                salidas,
                categorias,
                "",estadoActividad.confirmada );
	    actividades.add(dta1);
	    actividades.add(dta2);
	    actividades.add(dta3);
        request.setAttribute("act_confirmadas", actividades);
        /* Fin Hardcodeo*/
        
        //
        request.getRequestDispatcher("/WEB-INF/home/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
