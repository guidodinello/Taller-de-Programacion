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
import model.datatypes.DTActividad;

@WebServlet("/departamento")
public class departamento extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public departamento() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICtrlActividad ctrlActividad = Fabrica.getInstance().getICtrlActividad();
        String name = (String) request.getParameter("nombreDpto");
        Set<String> actividades = ctrlActividad.listarActividadesDepartamento(name);
        
        Set<DTActividad> dtAct = new HashSet<DTActividad>();
        for(String act : actividades)
            dtAct.add(ctrlActividad.getInfoActividad(act));
        
        request.setAttribute("datosActividades", dtAct);
        
        request.getRequestDispatcher("/WEB-INF/actividad/listarActividadesPorDepto.jsp").
            forward(request, response);
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}