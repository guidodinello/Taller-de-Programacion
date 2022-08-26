package presentacion;

import logica.clases.Departamento; // testeando - borrar

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

    private JFrame frmGestionDeTurismoUy;
    private ICtrlUsuario ICU;
    private ICtrlActividad ICA;
    private altaUsuario altaUsuario;
    private altaSalida altaSalida;
    private ConsultaDeUsuario consultaDeUsuario;
    private altaActividadTuristica crearActividadTuristica;
    private InscripcionSalidaTuristica creInscrInternalFrame;
    private JTextField textField;
    private JTextField textField_1;
  //  private ConsultarUsuario conUsrInternalFrame;
   // private ListaUsuarios lisUsrInternalFrame;

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
        
        
        consultaDeUsuario = new ConsultaDeUsuario(ICU);
        consultaDeUsuario.setVisible(false);
        frmGestionDeTurismoUy.add(consultaDeUsuario);
        
        creInscrInternalFrame = new InscripcionSalidaTuristica(ICA,ICU);
        creInscrInternalFrame.setVisible(false);
        frmGestionDeTurismoUy.getContentPane().add(creInscrInternalFrame);
        
        crearActividadTuristica = new altaActividadTuristica(ICA, ICU);
        crearActividadTuristica.setVisible(false);
        frmGestionDeTurismoUy.getContentPane().add(crearActividadTuristica);
        
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
        		consultaDeUsuario.setVisible(true);
        	};
        });
        menuUsuarios.add(menuItemConsultaUsuario);
        
        JMenu menuActividades = new JMenu("Actividades");
        menuBar.add(menuActividades);
        
        JMenuItem menuItemAltaActividadTuristica = new JMenuItem("Alta de Actividad Tur�stica");
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
        		try {
					ICU.altaUsuario("cris", "cris@", "Cristian", "Gonzalez", null, tipoUsuario.proveedor, "uruguayo", "provee cosas", "cris.com");
				} catch (InvalidArgument e2) {
					e2.printStackTrace();
				} catch (YaExisteException e2) {
					e2.printStackTrace();
				}
        		
        		try {
					ICA.altaDepartamento("Montevideo", "Capital de Uruguay", "mvdeo.com.uy");
					ICA.altaDepartamento("Canelones", "Me gustan los canelones", "canelones.com.uy");
				} catch (YaExisteException e1) {
					e1.printStackTrace();
				}
        		try {
					ICA.altaActividadTuristica("Montevideo", "Actividad 1", "act1 d", 2, 10, "Centro", "cris", null);
				} catch (YaExisteException e2) {
					e2.printStackTrace();
				}
        		creInscrInternalFrame.cargarDepartamentos();
        		creInscrInternalFrame.setVisible(true);
        	}
        });
        menuActividades.add(menuItemIngresarInscripcion);

    }
}
