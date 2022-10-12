package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datosDePrueba.CargarDatosDePrueba;
import model.logica.interfaces.ICtrlActividad;
import model.logica.interfaces.ICtrlUsuario;
import model.logica.clases.ActividadTuristica;
import model.logica.handlers.HandlerActividades;
import model.logica.interfaces.Fabrica;

/**
 * Servlet implementation class index
 */
@WebServlet("/")
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
	    CargarDatosDePrueba cdp = new CargarDatosDePrueba();
        Fabrica fabrica = Fabrica.getInstance();
        ICtrlUsuario ICU = fabrica.getICtrlUsuario();
        ICtrlActividad ICA = fabrica.getICtrlActividad();
        cdp.cargarDatos(ICU, ICA);
        // algo para generar la vista de adecuada de home.jsp
        request.setAttribute("act_confirmadas", ICA.getDTActividadesConfirmadas());
        //
        request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
