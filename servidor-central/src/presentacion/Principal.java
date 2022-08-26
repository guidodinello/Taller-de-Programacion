package presentacion;
import logica.interfaces.Fabrica;
import logica.interfaces.ICtrlActividad;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import logica.controladores.*;
//import logica.interfaces.ICtrlActividad;
import logica.interfaces.ICtrlUsuario;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.JButton;

//import presentacion.altaUsuario;

public class Principal {

    private JFrame frmGestionDeTurismoUy;
    private ICtrlUsuario ICU;
    private ICtrlActividad ICA;
    private altaUsuario creUsrInternalFrame;
    private JTextField textField;
    private JTextField textField_1;
    private JInternalFrame altaSalida;
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
        altaSalida = new altaSalida(ICA);
        altaSalida.setVisible(false);
        frmGestionDeTurismoUy.getContentPane().add(altaSalida);
        
        JButton btnNewButton = new JButton("Confirmar Alta");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 2;
        gbc_btnNewButton.gridy = 12;
        altaSalida.getContentPane().add(btnNewButton, gbc_btnNewButton);
        
        
    //    creUsrInternalFrame = new altaUsuario(ICU);
       /* GridBagLayout gridBagLayout = (GridBagLayout) creUsrInternalFrame.getContentPane().getLayout();
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0};
        creUsrInternalFrame.setVisible(false);

       // conUsrInternalFrame = new ConsultarUsuario(ICU);
        //conUsrInternalFrame.setVisible(false);

        //lisUsrInternalFrame = new ListaUsuarios(ICU);
        //lisUsrInternalFrame.setVisible(false);
        //frmGestionDeUsuarios.getContentPane().setLayout(null);

        //frmGestionDeUsuarios.getContentPane().add(conUsrInternalFrame);
        frmGestionDeTurismoUy.getContentPane().add(creUsrInternalFrame);
        
        JLabel lblNewLabel = new JLabel("New label");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
        gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 3;
        creUsrInternalFrame.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
        
        textField = new JTextField();
        GridBagConstraints gbc_textField = new GridBagConstraints();
        gbc_textField.insets = new Insets(0, 0, 0, 5);
        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField.gridx = 1;
        gbc_textField.gridy = 3;
        creUsrInternalFrame.getContentPane().add(textField, gbc_textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        GridBagConstraints gbc_textField_1 = new GridBagConstraints();
        gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_textField_1.gridx = 2;
        gbc_textField_1.gridy = 3;
        creUsrInternalFrame.getContentPane().add(textField_1, gbc_textField_1);
        textField_1.setColumns(10);
        //frmGestionDeUsuarios.getContentPane().add(lisUsrInternalFrame);
    }
*/
    }
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        
        // Se crea el Frame con las dimensiones indicadas.
        frmGestionDeTurismoUy = new JFrame();
        frmGestionDeTurismoUy.setTitle("Turismo.uy");
        frmGestionDeTurismoUy.setBounds(100, 100, 450, 400);
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
                // Muestro el InternalFrame para registrar un usuario
                creUsrInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemRegistrar);
        
        
        JMenuItem menuItemAltaSal = new JMenuItem("Alta de Salida");
        menuItemAltaSal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar un usuario
                altaSalida.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemAltaSal);
    }
}  

   
