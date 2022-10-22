package servlets;

import java.io.IOException;
import java.util.Set;
import java.util.HashSet;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.CompraFailException;
import model.logica.interfaces.ICtrlActividad;
import model.logica.interfaces.ICtrlUsuario;
import model.logica.interfaces.Fabrica;
import model.logica.clases.Turista;
import model.logica.handlers.HandlerUsuarios;

import model.datatypes.DTPaquete;
import model.datatypes.estadoActividad;
import model.datatypes.DTActividad;
import model.datatypes.DTTurista;

@MultipartConfig
@WebServlet("/paquete")
public class paquete extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public paquete() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException ,IOException {
        ICtrlUsuario ctrlUsr = Fabrica.getInstance().getICtrlUsuario();
        HttpSession session = request.getSession();
        DTTurista tur = (DTTurista) session.getAttribute("usuario_logueado");
        
        String nomb = (String) request.getParameter("nombrePaquete");
        int cantTuristas = Integer.parseInt(request.getParameter("Cantidad"));
        
        try {
            ctrlUsr.ingresarCompra(tur.getNickname(), nomb, cantTuristas, new GregorianCalendar());
            HandlerUsuarios hU = HandlerUsuarios.getInstance();
            Turista t = hU.getTuristaByNickname(tur.getNickname());
            session.setAttribute("usuario_logueado", new DTTurista(t));
            response.sendRedirect("index");
        } catch(CompraFailException e){
            e.printStackTrace();
            request.setAttribute("fail", true);
            request.getRequestDispatcher("/WEB-INF/paquete/compraPaquete.jsp").
                forward(request, response);
        }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICtrlActividad ctrlActividad = Fabrica.getInstance().getICtrlActividad();
        if(request.getParameter("listar") != null) {
            Set<DTPaquete> paquetes = new HashSet<DTPaquete>();
            for(String paq : ctrlActividad.listarPaquetes()) {
                DTPaquete actual = ctrlActividad.getInfoPaquete(paq);
                if(!actual.getActividades().isEmpty())
                    paquetes.add(actual);
            }
            
            request.setAttribute("paquetes", paquetes);
            request.getRequestDispatcher("/WEB-INF/paquete/listadoPaquetes.jsp").forward(request, response);
        } else {
            String name = request.getParameter("nombrePaquete");
            DTPaquete paqueteT = ctrlActividad.getInfoPaquete(name);
            request.setAttribute("paquete", paqueteT);
            
            if(request.getParameter("COMPRA") != null && request.getSession().getAttribute("usuario_logueado") instanceof DTTurista) {
                request.setAttribute("fail", false);
                request.getRequestDispatcher("/WEB-INF/paquete/compraPaquete.jsp").
                    forward(request, response);
            } else {
                Set<DTActividad> datosActividades = new HashSet<DTActividad>();
                for(String actividad: paqueteT.getActividades()) {
                    DTActividad actual = ctrlActividad.getInfoActividad(actividad);
                    if(actual.getestado() == estadoActividad.confirmada)
                        datosActividades.add(actual);
                }
                
                request.setAttribute("datosActividadPaquete", datosActividades);
                
                request.getRequestDispatcher("/WEB-INF/paquete/consultaPaquete.jsp").
                    forward(request, response);
            }
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ICtrlActividad ctrlActividad = Fabrica.getInstance().getICtrlActividad();
        String name = request.getParameter("nombrePaquete");
        DTPaquete paqueteT = ctrlActividad.getInfoPaquete(name);
        request.setAttribute("paquete", paqueteT);
        processRequest(request, response);
    }
}