package servlets;

import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.logica.interfaces.ICtrlActividad;
import model.logica.interfaces.Fabrica;

import model.datatypes.DTPaquete;
import model.datatypes.estadoActividad;
import model.datatypes.DTActividad;

@WebServlet("/paquete")
public class paquete extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public paquete() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
        
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("COMPRA") != null) {
            request.getRequestDispatcher("/WEB-INF/paquete/compraPaquete.jsp");
        } else {
            ICtrlActividad ctrlActividad = Fabrica.getInstance().getICtrlActividad();
            String name = request.getParameter("nombrePaquete");
            DTPaquete paqueteT = ctrlActividad.getInfoPaquete(name);
            
            Set<DTActividad> datosActividades = new HashSet<DTActividad>();
            for(String actividad: paqueteT.getActividades()) {
                DTActividad actual = ctrlActividad.getInfoActividad(actividad);
                if(actual.getestado() == estadoActividad.confirmada)
                    datosActividades.add(actual);
            }
            
            request.setAttribute("paquete", paqueteT);
            request.setAttribute("datosActividadPaquete", datosActividades);
            
            request.getRequestDispatcher("/WEB-INF/paquete/consultaPaquete.jsp").
                forward(request, response);
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}