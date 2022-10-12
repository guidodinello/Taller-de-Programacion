package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.logica.interfaces.ICtrlActividad;
import model.logica.interfaces.Fabrica;

import model.datatypes.DTPaquete;

@WebServlet("/paquete")
public class paquete extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public paquete() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
        ICtrlActividad ctrlActividad = Fabrica.getInstance().getICtrlActividad();
        String name = request.getParameter("nombrePaquete");
        DTPaquete paqueteT = ctrlActividad.getInfoPaquete(name);
        
        request.setAttribute("paquete", paqueteT);
        
        request.getRequestDispatcher("/WEB-INF/altaUsuario/consultaPaquete.jsp").
            forward(request, response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}