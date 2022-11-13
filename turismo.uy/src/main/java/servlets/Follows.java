package servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservices.DtUsuario;

/**
 * Servlet implementation class Follows
 */
@WebServlet("/Follows")
public class Follows extends HttpServlet {
	private static final long serialVersionUID = 1L;
    webservices.WebServicesService service = new webservices.WebServicesService();
    webservices.WebServices port = service.getWebServicesPort();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Follows() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    for (Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
	        String name = entry.getKey();
	        String value = entry.getValue()[0];
	        System.out.println(name + ": " + value);
	    }
	    
	    DtUsuario usr = port.getUsuarioByNickName((String)request.getParameter("usr"));
	 
	    if (((String)request.getParameter("seguidores")).equals("true")) {
	        List<String> seguidores = usr.getSeguidores();
	        request.setAttribute("usuarios", seguidores);
	    } else {
	        List<String> seguidos = usr.getSeguidos();
	        request.setAttribute("usuarios", seguidos);
	    }
        request.getRequestDispatcher("/WEB-INF/consultaUsuario/FollowList.jsp").forward(request,
                response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
