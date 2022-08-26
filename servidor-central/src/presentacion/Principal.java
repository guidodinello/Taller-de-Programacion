package presentacion;

import logica.clases.Departamento; // testeando - borrar
import java.util.GregorianCalendar;

import logica.interfaces.Fabrica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//import logica.*;
//import presentacion.*;
import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import logica.controladores.*;
import logica.interfaces.ICtrlActividad;
import logica.interfaces.ICtrlUsuario;
//import javax.swing.JLabel;
//import java.awt.GridBagConstraints;
//import java.awt.Insets;
import javax.swing.JTextField;


import datatypes.tipoUsuario;
import excepciones.InvalidArgument;
import excepciones.YaExisteException;

//import javax.swing.BoxLayout;
//import java.awt.BorderLayout;
//import java.awt.GridBagLayout;

//import presentacion.altaUsuario;

public class Principal {

	//Frame principal
    private JFrame frmGestionDeTurismoUy;
    //interfaces
    private ICtrlUsuario ICU;
    private ICtrlActividad ICA;
    //frame altas
    private altaUsuario altaUsuario;
    private altaSalida altaSalida;
    private altaActividadTuristica crearActividadTuristica;
    private InscripcionSalidaTuristica creInscrInternalFrame;
    //frame consultas
    private ConsultaDeUsuario consultaDeUsuario;
    //private ConultaActividad consultaActividad;
    //private ConsultaSalida consultaSalida;
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal window = new Principal();
                    window.frmGestionDeTurismoUy.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Principal() {
        initialize();

        Fabrica fabrica = Fabrica.getInstance();
        ICU = fabrica.getICtrlUsuario();
        ICA = fabrica.getICtrlActividad();
        
        altaUsuario = new altaUsuario(ICU);
        altaUsuario.setVisible(false);
        frmGestionDeTurismoUy.add(altaUsuario);
        
        altaSalida = new altaSalida(ICA);
        altaSalida.setVisible(false);
        frmGestionDeTurismoUy.add(altaSalida);
        
        consultaDeUsuario = new ConsultaDeUsuario(ICU/*, consultaActividad, consultaSalida*/);
        consultaDeUsuario.setVisible(false);
        frmGestionDeTurismoUy.add(consultaDeUsuario);
        
        creInscrInternalFrame = new InscripcionSalidaTuristica(ICA,ICU);
        creInscrInternalFrame.setVisible(false);
        frmGestionDeTurismoUy.getContentPane().add(creInscrInternalFrame);
        
        crearActividadTuristica = new altaActividadTuristica(ICA, ICU);
        crearActividadTuristica.setVisible(false);
        frmGestionDeTurismoUy.getContentPane().add(crearActividadTuristica);
        
        try {
			ICU.altaUsuario("cris", "cris@", "Cristian", "Gonzalez", new GregorianCalendar(), tipoUsuario.proveedor, "uruguayo", "provee cosas", "cris.com");
			ICU.altaUsuario("agus", "agus@", "Agustin", "Franco", new GregorianCalendar(), tipoUsuario.turista, "uruguayo", "le gusta pasear", "agus.com");
			ICU.altaUsuario("eze", "eze@", "Ezequiel", "Medeiros", new GregorianCalendar(), tipoUsuario.turista, "uruguayo", "", "eze.com");
		} catch (YaExisteException e2) {
			e2.printStackTrace();
		}
		
		try {
			ICA.altaDepartamento("Montevideo", "Capital de Uruguay", "mvdeo.com.uy");
			ICA.altaDepartamento("Canelones", "Me gustan los canelones", "canelones.com.uy");
			ICA.altaDepartamento("Artigas", "El procer", "artigas.com.uy");
		} catch (YaExisteException e1) {
			e1.printStackTrace();
		}
		try {
			ICA.altaActividadTuristica("Montevideo", "Actividad 1", "act1 d", 2, 10, "Centro", "cris", null);
			ICA.altaActividadTuristica("Canelones", "Actividad 2", "act2 d", 2, 10, "Paso palomeque", "cris", null);
			ICA.altaActividadTuristica("Artigas", "Actividad 3", "act3 d", 2, 10, "Cerro Signorelli", "cris", null);
		} catch (YaExisteException e2) {
			e2.printStackTrace();
		}
		
		GregorianCalendar fecha = new GregorianCalendar(2022,8,30);
		try {
			ICA.altaSalidaTuristica("A Centro", fecha, "Centro", 10, new GregorianCalendar(), "Actividad 1");
			ICA.altaSalidaTuristica("A Palomeque", fecha, "Palomeque", 10, new GregorianCalendar(), "Actividad 2");
			ICA.altaSalidaTuristica("A Canelones", new GregorianCalendar(), "Canelones", 10, new GregorianCalendar(), "Actividad 2");
		} catch (YaExisteException e1) {
			e1.printStackTrace();
		}
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        
        // Se crea el Frame con las dimensiones indicadas.
        frmGestionDeTurismoUy = new JFrame();
        frmGestionDeTurismoUy.setTitle("Turismo.uy");
        frmGestionDeTurismoUy.setResizable(true);
        frmGestionDeTurismoUy.setBounds(100, 100, 700, 700);
        frmGestionDeTurismoUy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Se crea una barra de menú (JMenuBar) con dos menú (JMenu) desplegables.
        // Cada menú contiene diferentes opciones (JMenuItem), los cuales tienen un 
        // evento asociado que permite realizar una acción una vez se seleccionan. 
        JMenuBar menuBar = new JMenuBar();
        frmGestionDeTurismoUy.setJMenuBar(menuBar);

        JMenu menuSistema = new JMenu("Sistema");
        menuBar.add(menuSistema);

        JMenuItem menuSalir = new JMenuItem("Salir");
        menuSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Salgo de la aplicación
                frmGestionDeTurismoUy.setVisible(false);
                frmGestionDeTurismoUy.dispose();
            }
        });
        menuSistema.add(menuSalir);

        JMenu menuUsuarios = new JMenu("Usuarios");
        menuBar.add(menuUsuarios);

        // SE CREA EL ITEM REGISTRAR USUARIO
        
        JMenuItem menuItemRegistrar = new JMenuItem("Registrar Usuario");
        menuItemRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                altaUsuario.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemRegistrar);
        
        JMenuItem menuItemRegistrarSalida = new JMenuItem("Registrar Salida Turistica");
        menuItemRegistrarSalida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                altaSalida.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemRegistrarSalida);

        JMenuItem menuItemConsultaUsuario = new JMenuItem("Consultar Usuario");
        menuItemConsultaUsuario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		consultaDeUsuario.cargarDatosVentana();
        		consultaDeUsuario.setVisible(true);
        	};
        });
        menuUsuarios.add(menuItemConsultaUsuario);
        
        JMenu menuActividades = new JMenu("Actividades");
        menuBar.add(menuActividades);
        
        JMenuItem menuItemAltaActividadTuristica = new JMenuItem("Alta de Actividad Turistica");
        menuItemAltaActividadTuristica.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		crearActividadTuristica.setVisible(true);
        	};
        });
        menuActividades.add(menuItemAltaActividadTuristica);
        
        JMenuItem menuItemIngresarInscripcion = new JMenuItem("Registrar Inscripcion");
        menuItemIngresarInscripcion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Muestro el InternalFrame para ingresar inscripcion
        		creInscrInternalFrame.limpiarFormulario();
        		creInscrInternalFrame.cargarDepartamentos();
        		creInscrInternalFrame.cargarTuristas();
        		creInscrInternalFrame.setVisible(true);
        	}
        });
        menuActividades.add(menuItemIngresarInscripcion);

    }
}
