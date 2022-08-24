package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import logica.interfaces.ICtrlUsuario;

@SuppressWarnings("serial")
public class altaUsuario extends JInternalFrame {
	public altaUsuario() {
	}
	
    private ICtrlUsuario ctrlUsr;
    
    private JTextField textFieldNickName;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldEmail;
    //decidir como mostrar la fecha
    private JRadioButton usrTypeBtn;
    
    private JLabel lblIngreseNickName;
    private JLabel lblIngreseNombre;
    private JLabel lblIngreseApellido;
    private JLabel lblIngreseEmail;
    //label fecha
    private JLabel lblTipoUsuario;
    
    private JButton btnAceptar;
    private JButton btnCancelar;
    
    public altaUsuario(ICtrlUsuario icu) {
        ctrlUsr = icu;

        // Propiedades del JInternalFrame como dimensión, posición dentro del frame,
        // etc.
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Registrar un Usuario");
        setBounds(10, 40, 360, 150);

        // En este caso utilizaremos el GridBagLayout que permite armar una grilla
        // en donde las filas y columnas no son uniformes.
        // Conviene trabajar este componente desde la vista de diseño gráfico y sólo
        // manipular los valores para ajustar alguna cosa.
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 100, 120, 120, 0 };
        gridBagLayout.rowHeights = new int[] { 30, 30, 30, 0, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        getContentPane().setLayout(gridBagLayout);

        //================ NICKNAME ================//
        lblIngreseNickName = new JLabel("Nickname:");
        lblIngreseNickName.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseNickName = new GridBagConstraints();
        gbc_lblIngreseNickName.fill = GridBagConstraints.BOTH;
        gbc_lblIngreseNickName.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseNickName.gridx = 0;
        gbc_lblIngreseNickName.gridy = 0;
        getContentPane().add(lblIngreseNickName, gbc_lblIngreseNickName);

        textFieldNickName = new JTextField();
        GridBagConstraints gbc_textFieldNickName = new GridBagConstraints();
        gbc_textFieldNickName.gridwidth = 2;
        gbc_textFieldNickName.fill = GridBagConstraints.BOTH;
        gbc_textFieldNickName.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldNickName.gridx = 1;
        gbc_textFieldNickName.gridy = 0;
        getContentPane().add(textFieldNickName, gbc_textFieldNickName);
        textFieldNombre.setColumns(10);
        //================ NICKNAME ================//

        //================ NOMBRE ================//
        lblIngreseNombre = new JLabel("Nombre:");
        lblIngreseNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseNombre = new GridBagConstraints();
        gbc_lblIngreseNombre.fill = GridBagConstraints.BOTH;
        gbc_lblIngreseNombre.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseNombre.gridx = 0;
        gbc_lblIngreseNombre.gridy = 1;
        getContentPane().add(lblIngreseNombre, gbc_lblIngreseNombre);

        textFieldApellido = new JTextField();
        GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
        gbc_textFieldNombre.gridwidth = 2;
        gbc_textFieldNombre.fill = GridBagConstraints.BOTH;
        gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldNombre.gridx = 1;
        gbc_textFieldNombre.gridy = 1;
        getContentPane().add(textFieldNombre, gbc_textFieldNombre);
        textFieldNombre.setColumns(10);
        //================ NOMBRE ================//

        //================ APELLIDO ================//
        lblIngreseApellido = new JLabel("Apellido:");
        lblIngreseApellido.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseApellido = new GridBagConstraints();
        gbc_lblIngreseApellido.fill = GridBagConstraints.BOTH;
        gbc_lblIngreseApellido.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseApellido.gridx = 0;
        gbc_lblIngreseApellido.gridy = 2;
        getContentPane().add(lblIngreseApellido, gbc_lblIngreseApellido);

        textFieldApellido = new JTextField();
        textFieldApellido.setToolTipText("Ingrese su apellido");
        textFieldApellido.setColumns(10);
        GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
        gbc_textFieldApellido.gridwidth = 2;
        gbc_textFieldApellido.fill = GridBagConstraints.BOTH;
        gbc_textFieldApellido.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldApellido.gridx = 1;
        gbc_textFieldApellido.gridy = 2;
        getContentPane().add(textFieldApellido, gbc_textFieldApellido);
        //================ APELLIDO ================//
        
        //================ EMAIL ================//
        lblIngreseEmail = new JLabel("Email:");
        lblIngreseEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseEmail = new GridBagConstraints();
        gbc_lblIngreseEmail.fill = GridBagConstraints.BOTH;
        gbc_lblIngreseEmail.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseEmail.gridx = 0;
        gbc_lblIngreseEmail.gridy = 2;
        getContentPane().add(lblIngreseEmail, gbc_lblIngreseEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setToolTipText("Ingrese su email");
        textFieldEmail.setColumns(10);
        GridBagConstraints gbc_textFieldEmail = new GridBagConstraints();
        gbc_textFieldEmail.gridwidth = 2;
        gbc_textFieldEmail.fill = GridBagConstraints.BOTH;
        gbc_textFieldEmail.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldEmail.gridx = 1;
        gbc_textFieldEmail.gridy = 2;
        getContentPane().add(textFieldEmail, gbc_textFieldEmail);
        //================ EMAIL ================//
        
        //================ FECHA DE NACIMIENTO ================//
        
        //================ FECHA DE NACIMIENTO ================//
        
        
        //================ RADIO BUTTONS TURISTA_PROVEEDOR ================//
        
        //================ INFO TURISTA ================//
        //================ INFO TURISTA ================//
        //================ INFO PROVEEDOR ================//
        //================ INFO PROVEEDOR ================//
        //================ RADIO BUTTONS TURISTA_PROVEEDOR ================//

        // Un botón (JButton) con un evento asociado que permite registrar el usuario.
        // Dado que el código de registro tiene cierta complejidad, conviene delegarlo
        // a otro método en lugar de incluirlo directamente de el método actionPerformed 
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //cmdRegistroUsuarioActionPerformed(arg0);
            }
        });

        GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
        gbc_btnAceptar.fill = GridBagConstraints.BOTH;
        gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
        gbc_btnAceptar.gridx = 1;
        gbc_btnAceptar.gridy = 3;
        getContentPane().add(btnAceptar, gbc_btnAceptar);

        // Un botón (JButton) con un evento asociado que permite cerrar el formulario (solo ocultarlo).
        // Dado que antes de cerrar se limpia el formulario, se invoca un método reutilizable para ello. 
        btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //limpiarFormulario();
                setVisible(false);
            }
        });
        GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
        gbc_btnCancelar.fill = GridBagConstraints.BOTH;
        gbc_btnCancelar.gridx = 2;
        gbc_btnCancelar.gridy = 3;
        getContentPane().add(btnCancelar, gbc_btnCancelar);
    }

//
//    // Este método es invocado al querer registrar un usuario, funcionalidad
//    // provista por la operación del sistem registrarUsuario().
//    // Previamente se hace una verificación de los campos, particularmente que no sean vacíos
//    // y que la cédula sea un número. 
//    // Tanto en caso de que haya un error (de verificación o de registro) o no, se despliega
//    // un mensaje utilizando un panel de mensaje (JOptionPane).
//    protected void cmdRegistroUsuarioActionPerformed(ActionEvent arg0) {
//        // Obtengo datos de los controles Swing
//        String nombreU = this.textFieldNombre.getText();
//        String apellidoU = this.textFieldApellido.getText();
//        String ciU = this.textFieldCI.getText();
//
//        if (checkFormulario()) {
//            try {
//                controlUsr.registrarUsuario(nombreU, apellidoU, ciU);
//
//                // Muestro éxito de la operación
//                JOptionPane.showMessageDialog(this, "El Usuario se ha creado con éxito", "Registrar Usuario",
//                        JOptionPane.INFORMATION_MESSAGE);
//
//            } catch (UsuarioRepetidoException e) {
//                // Muestro error de registro
//                JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
//            }
//
//            // Limpio el internal frame antes de cerrar la ventana
//            limpiarFormulario();
//            setVisible(false);
//        }
//    }

}
