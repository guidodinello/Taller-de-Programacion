package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservices.DtActividad;
import webservices.DtPaquete;

@MultipartConfig
@WebServlet("/busquedaTexto")
public class busquedaTexto extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    webservices.WebServicesService service = new webservices.WebServicesService();
    webservices.WebServices port = service.getWebServicesPort();
    
    public busquedaTexto() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
        String busqueda = request.getParameter("busqueda");
        List<DtActividad> actividades = port.busquedaTextoActividades(busqueda).getItem();
        List<DtPaquete> paquetes = port.busquedaTextoPaquetes(busqueda).getItem();
        
        request.setAttribute("datosActividades", actividades);
        request.setAttribute("datosPaquetes", paquetes);
        
        request.getRequestDispatcher("/WEB-INF/busqueda/busquedaActividadesPaquetes.jsp").
        forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
        request.setCharacterEncoding("UTF-8");
        processRequest(request, response);
    }
}