package presentacion;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import logica.interfaces.ICtrlUsuario;


import javax.swing.JButton;
import javax.swing.JFrame;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
@SuppressWarnings("serial")

public class CrearUsuario extends JInternalFrame  {
	
		 private ICtrlUsuario controlUsr;
		  private JTextField textFieldNombre;
		    private JTextField textFieldApellido;
		    private JTextField textFieldCI;
		    private JTextField textFieldNN;
		    private JLabel lblIngreseNombre;
		    private JLabel lblIngreseApellido;
		    private JLabel lblIngreseCi;
		    private JLabel lblIngreseNick;
		    private JButton btnAceptar;
		    private JButton btnCancelar;
		    
		 public CrearUsuario(ICtrlUsuario icu) {
		        // Se inicializa con el controlador de usuarios
		        controlUsr = icu;

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

		        // Una etiqueta (JLabel) indicandp que en el siguiente campo debe ingresarse 
		        // el nombre del usuario. El texto está alineado horizontalmente a la derecha para
		        // que quede casi pegado al campo de texto.
		        lblIngreseNombre = new JLabel("Nombre:");
		        lblIngreseNombre.setHorizontalAlignment(SwingConstants.RIGHT);
		        GridBagConstraints gbc_lblIngreseNombre = new GridBagConstraints();
		        gbc_lblIngreseNombre.fill = GridBagConstraints.BOTH;
		        gbc_lblIngreseNombre.insets = new Insets(0, 0, 5, 5);
		        gbc_lblIngreseNombre.gridx = 0;
		        gbc_lblIngreseNombre.gridy = 0;
		        getContentPane().add(lblIngreseNombre, gbc_lblIngreseNombre);

		        textFieldNombre = new JTextField();
		        GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
		        gbc_textFieldNombre.gridwidth = 2;
		        gbc_textFieldNombre.fill = GridBagConstraints.BOTH;
		        gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
		        gbc_textFieldNombre.gridx = 1;
		        gbc_textFieldNombre.gridy = 0;
		        getContentPane().add(textFieldNombre, gbc_textFieldNombre);
		        textFieldNombre.setColumns(10);

		        lblIngreseApellido = new JLabel("Apellido:");
		        lblIngreseApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		        GridBagConstraints gbc_lblIngreseApellido = new GridBagConstraints();
		        gbc_lblIngreseApellido.fill = GridBagConstraints.BOTH;
		        gbc_lblIngreseApellido.insets = new Insets(0, 0, 5, 5);
		        gbc_lblIngreseApellido.gridx = 0;
		        gbc_lblIngreseApellido.gridy = 1;
		        getContentPane().add(lblIngreseApellido, gbc_lblIngreseApellido);

		        textFieldApellido = new JTextField();
		        GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
		        gbc_textFieldApellido.gridwidth = 2;
		        gbc_textFieldApellido.fill = GridBagConstraints.BOTH;
		        gbc_textFieldApellido.insets = new Insets(0, 0, 5, 0);
		        gbc_textFieldApellido.gridx = 1;
		        gbc_textFieldApellido.gridy = 1;
		        getContentPane().add(textFieldApellido, gbc_textFieldApellido);
		        textFieldApellido.setColumns(10);

		        lblIngreseCi = new JLabel("Email:");
		        lblIngreseCi.setHorizontalAlignment(SwingConstants.RIGHT);
		        GridBagConstraints gbc_lblIngreseemail = new GridBagConstraints();
		        gbc_lblIngreseemail.fill = GridBagConstraints.BOTH;
		        gbc_lblIngreseemail.insets = new Insets(0, 0, 5, 5);
		        gbc_lblIngreseemail.gridx = 0;
		        gbc_lblIngreseemail.gridy = 2;
		        getContentPane().add(lblIngreseCi, gbc_lblIngreseemail);

		       
		        textFieldCI = new JTextField();
		        textFieldCI.setToolTipText("Ingrese un email valido");
		        textFieldCI.setColumns(10);
		        GridBagConstraints gbc_textFieldemail = new GridBagConstraints();
		        gbc_textFieldemail.gridwidth = 2;
		        gbc_textFieldemail.fill = GridBagConstraints.BOTH;
		        gbc_textFieldemail.insets = new Insets(0, 0, 5, 0);
		        gbc_textFieldemail.gridx = 1;
		        gbc_textFieldemail.gridy = 2;
		        getContentPane().add(textFieldCI, gbc_textFieldemail);

		        
		        
		        /////////////NICK/NAME////////////////////////////////////
		        
		        lblIngreseNick = new JLabel("Nick Name:");
		        lblIngreseNick.setHorizontalAlignment(SwingConstants.RIGHT);
		        GridBagConstraints gbc_lblIngresenickName = new GridBagConstraints();
		        gbc_lblIngresenickName.fill = GridBagConstraints.BOTH;
		        gbc_lblIngresenickName.insets = new Insets(0, 0, 5, 5);
		        gbc_lblIngresenickName.gridx = 0;
		        gbc_lblIngresenickName.gridy = 2;
		        getContentPane().add(lblIngreseNick, gbc_lblIngresenickName);

		        // Una campo de texto (JTextField) para ingresar la cédula del usuario. 
		        // Por defecto es posible ingresar cualquier string.
		        // Al campo se le incluye un Tooltip que, al pasar el mouse por encima, despliega un mensaje.
		        textFieldNN = new JTextField();
		        GridBagConstraints gbc_textFieldNickName = new GridBagConstraints();
		        gbc_textFieldNickName.gridwidth = 2;
		        gbc_textFieldNickName.fill = GridBagConstraints.BOTH;
		        gbc_textFieldNickName.insets = new Insets(0, 0, 5, 0);
		        gbc_textFieldNickName.gridx = 1;
		        gbc_textFieldNickName.gridy = 2;
		        getContentPane().add(textFieldCI, gbc_textFieldNickName);
		        
		        
		        
		        
		        
		        
		        // Un botón (JButton) con un evento asociado que permite registrar el usuario.
		        // Dado que el código de registro tiene cierta complejidad, conviene delegarlo
		        // a otro método en lugar de incluirlo directamente de el método actionPerformed 
		        btnAceptar = new JButton("Aceptar");
}
}
