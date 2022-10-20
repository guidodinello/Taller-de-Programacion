package servlets;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.logica.interfaces.Fabrica;
import model.logica.interfaces.ICtrlActividad;


/**
 * Servlet implementation class altaSalida
 */
@WebServlet("/altaSalida")
public class altaSalida extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICtrlActividad iA = Fabrica.getInstance().getICtrlActividad();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public altaSalida() {
        super();
    }

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {        
        Set<String> nomAct = iA.listarActividadesDepartamento(request.getParameter("nombreDep"));
                
        request.setAttribute("listaAct", nomAct);
        request.getRequestDispatcher("/WEB-INF/altaSalida/altaSalida.jsp").forward(request, response);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setAttribute("fail", false);
	    
	    if(request.getParameter("nombreDep") != null) {
	       processRequest(request, response);
	    } else {
	        request.getRequestDispatcher("/WEB-INF/altaSalida/altaSalida.jsp").forward(request, response);

	    }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
