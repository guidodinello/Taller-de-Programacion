package servlets;

import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.logica.interfaces.Fabrica;
import model.logica.interfaces.ICtrlActividad;
import model.datatypes.DTPaquete;

@WebServlet("/categoria")
public class categoria extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public categoria() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICtrlActividad ctrlActividad = Fabrica.getInstance().getICtrlActividad();
        String name = (String) request.getParameter("nombreCat");
        Set<String> paquetes = ctrlActividad.listarPaquetesCategoria(name);
        
        Set<DTPaquete> dtPaq = new HashSet<DTPaquete>();
        for(String paq : paquetes)
            dtPaq.add(ctrlActividad.getInfoPaquete(paq));
        
        request.setAttribute("datosPaquetes", dtPaq);
        
        request.getRequestDispatcher("/WEB-INF/paquete/listarPaquetesPorCategoria.jsp").
            forward(request, response);
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}