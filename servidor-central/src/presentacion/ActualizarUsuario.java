package presentacion;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import datatypes.DTActividad;
import datatypes.DTUsuario;
import logica.interfaces.ICtrlUsuario;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ScrollPane;

public class ActualizarUsuario extends JInternalFrame {
	
	//Controlador
	private ICtrlUsuario ctrlUsuario;
	//Basicos
	private JLabel LabelSelcUsuario;
	private JComboBox<String> ComboBoxSelUsuario;
	private JButton btnSelecUsuario = new JButton("Seleccionar");
	//NO MODIFICABLES
	private JLabel LabelInfoUsuario;
	private JLabel LabelTipoUsuario;
	private JTextField TextTipoUsuario;
	private JLabel LabelNickname;
	private JTextField TextNickname;
	//DATOS MODIFICABLES
	private JLabel LabelDatosModificables;
	private JLabel LabelNombre;
	private JTextField TextNombre;
	private JLabel LabelApellido;
	private JTextField TextApellido;
	private JLabel LabelFechaNac;
	private JTextField TextFechaNac;
	//Turista
	private JLabel LabelNacionalidad;
	private JTextField TextNacionalidad;
	//Proveedor
	private JLabel LabelDescripcionProveedor;
	private JScrollPane ScrollPaneDescripcionProveedor;
	private JTextArea TextAreaDescripcion;
	private JLabel LabelSitioWeb;
	private JTextField TextSitioWeb;
	//borrando
	private boolean seteandoDatosIniciales = false;
	//Datos que interesa conservar temporalmente
	private DTUsuario dtU = null;
	//Botones
	private JButton btnModificarDatos;
	private JButton btnCancelar;

	
	public ActualizarUsuario(ICtrlUsuario iCU) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//meto la interfaz y la ventana de actividada
		this.ctrlUsuario = iCU;
		
		//Cuestiones de configuracion del frame
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Consultar un Usuario");
				
		setBounds(30, 30, 567, 454);
				
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[] { 41, 147, 281, 104, 43 };
		gbl.rowHeights = new int[] { 0, 0, 30, 30, 30, 30, 30, 30, 30, 35, 35, 30, -27, 36, 0, 0 };
		gbl.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gbl);
        
		//label seleccionar usuario
		LabelSelcUsuario = new JLabel("Seleccionar Usuario: ");
		LabelSelcUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_labelSelcUsuario = new GridBagConstraints();
		gbc_labelSelcUsuario.fill = GridBagConstraints.BOTH;
		gbc_labelSelcUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_labelSelcUsuario.gridx = 1;
		gbc_labelSelcUsuario.gridy = 1;
		getContentPane().add(LabelSelcUsuario, gbc_labelSelcUsuario);
        //Combo box seleccionar usuario
        ComboBoxSelUsuario = new JComboBox<String>();
        
        GridBagConstraints gbc_cBSelcUsuario = new GridBagConstraints();
        gbc_cBSelcUsuario.fill = GridBagConstraints.BOTH;
        gbc_cBSelcUsuario.insets = new Insets(0, 0, 5, 5);
        gbc_cBSelcUsuario.gridx = 2;
        gbc_cBSelcUsuario.gridy = 1;
        getContentPane().add(ComboBoxSelUsuario, gbc_cBSelcUsuario);
        GridBagConstraints gbc_btnSelecUsuario = new GridBagConstraints();
        gbc_btnSelecUsuario.anchor = GridBagConstraints.CENTER;
        gbc_btnSelecUsuario.insets = new Insets(0, 0, 5, 5);
        gbc_btnSelecUsuario.gridx = 3;
        gbc_btnSelecUsuario.gridy = 1;
        getContentPane().add(btnSelecUsuario, gbc_btnSelecUsuario);
        	        
        //label Informacion usuario
        LabelInfoUsuario = new JLabel("Informacion del usuario");
        LabelInfoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_LabelInfoUsuario = new GridBagConstraints();
        gbc_LabelInfoUsuario.fill = GridBagConstraints.BOTH;
        gbc_LabelInfoUsuario.insets = new Insets(0, 0, 5, 0);
        gbc_LabelInfoUsuario.gridx = 0;
        gbc_LabelInfoUsuario.gridy = 2;
        gbc_LabelInfoUsuario.gridwidth = 5;
        getContentPane().add(LabelInfoUsuario, gbc_LabelInfoUsuario);
			
		        
        //Label tipo usuario
        LabelTipoUsuario = new JLabel("Tipo de usuario: ");
        LabelTipoUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelTipoUsuario = new GridBagConstraints();
        gbc_LabelTipoUsuario.fill = GridBagConstraints.BOTH;
        gbc_LabelTipoUsuario.insets = new Insets(0, 0, 5, 5);
        gbc_LabelTipoUsuario.gridx = 1;
        gbc_LabelTipoUsuario.gridy = 3;
        getContentPane().add(LabelTipoUsuario, gbc_LabelTipoUsuario);
        //text box tipo usuario
        TextTipoUsuario = new JTextField();
        TextTipoUsuario.setEditable(false);
        GridBagConstraints gbc_TextTipoUsuario = new GridBagConstraints();
        gbc_TextTipoUsuario.gridwidth = 2;
        gbc_TextTipoUsuario.fill = GridBagConstraints.BOTH;
        gbc_TextTipoUsuario.insets = new Insets(0, 0, 5, 5);
        gbc_TextTipoUsuario.gridx = 2;
        gbc_TextTipoUsuario.gridy = 3;
        getContentPane().add(TextTipoUsuario, gbc_TextTipoUsuario);

        //Label nickname 
        LabelNickname = new JLabel("Nickname: ");
        LabelNickname.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelNickname = new GridBagConstraints();
        gbc_LabelNickname.fill = GridBagConstraints.BOTH;
        gbc_LabelNickname.insets = new Insets(0, 0, 5, 5);
        gbc_LabelNickname.gridx = 1;
        gbc_LabelNickname.gridy = 4;
        getContentPane().add(LabelNickname, gbc_LabelNickname);
        //text box nickname 
        TextNickname = new JTextField();
        TextNickname.setEditable(false);
        GridBagConstraints gbc_TextNickname = new GridBagConstraints();
        gbc_TextNickname.gridwidth = 2;
        gbc_TextNickname.fill = GridBagConstraints.BOTH;
        gbc_TextNickname.insets = new Insets(0, 0, 5, 5);
        gbc_TextNickname.gridx = 2;
        gbc_TextNickname.gridy = 4;
        getContentPane().add(TextNickname, gbc_TextNickname);
        
        LabelDatosModificables = new JLabel("Datos modificables");
        GridBagConstraints gbc_LabelDatosModificables = new GridBagConstraints();
        gbc_LabelDatosModificables.gridwidth = 5;
        gbc_LabelDatosModificables.insets = new Insets(0, 0, 5, 5);
        gbc_LabelDatosModificables.gridx = 0;
        gbc_LabelDatosModificables.gridy = 5;
        getContentPane().add(LabelDatosModificables, gbc_LabelDatosModificables);
		        
        //Label nombre
        LabelNombre = new JLabel("Nombre: ");
        LabelNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelNombre = new GridBagConstraints();
        gbc_LabelNombre.fill = GridBagConstraints.BOTH;
        gbc_LabelNombre.insets = new Insets(0, 0, 5, 5);
        gbc_LabelNombre.gridx = 1;
        gbc_LabelNombre.gridy = 6;
        getContentPane().add(LabelNombre, gbc_LabelNombre);
        //text box nombre
        TextNombre = new JTextField();
        TextNombre.setEditable(false);
        GridBagConstraints gbc_TextNombre = new GridBagConstraints();
        gbc_TextNombre.gridwidth = 2;
        gbc_TextNombre.fill = GridBagConstraints.BOTH;
        gbc_TextNombre.insets = new Insets(0, 0, 5, 5);
        gbc_TextNombre.gridx = 2;
        gbc_TextNombre.gridy = 6;
        getContentPane().add(TextNombre, gbc_TextNombre);
		        
        //Label apellido
        LabelApellido = new JLabel("Apellido: ");
        LabelApellido.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelApellido = new GridBagConstraints();
        gbc_LabelApellido.fill = GridBagConstraints.BOTH;
        gbc_LabelApellido.insets = new Insets(0, 0, 5, 5);
        gbc_LabelApellido.gridx = 1;
        gbc_LabelApellido.gridy = 7;
        getContentPane().add(LabelApellido, gbc_LabelApellido);
        //text box apellido
        TextApellido = new JTextField();
        TextApellido.setEditable(false);
        GridBagConstraints gbc_TextApellido = new GridBagConstraints();
        gbc_TextApellido.gridwidth = 2;
        gbc_TextApellido.fill = GridBagConstraints.BOTH;
        gbc_TextApellido.insets = new Insets(0, 0, 5, 5);
        gbc_TextApellido.gridx = 2;
        gbc_TextApellido.gridy = 7;
        getContentPane().add(TextApellido, gbc_TextApellido);
		        
        //Label FechaNac
        LabelFechaNac = new JLabel("Fecha de nacimiento: ");
        LabelFechaNac.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelFechaNac = new GridBagConstraints();
        gbc_LabelFechaNac.fill = GridBagConstraints.BOTH;
        gbc_LabelFechaNac.insets = new Insets(0, 0, 5, 5);
        gbc_LabelFechaNac.gridx = 1;
        gbc_LabelFechaNac.gridy = 8;
        getContentPane().add(LabelFechaNac, gbc_LabelFechaNac);
        //text box FechaNac
        TextFechaNac = new JTextField();
        TextFechaNac.setEditable(false);
        GridBagConstraints gbc_TextFechaNac = new GridBagConstraints();
        gbc_TextFechaNac.gridwidth = 2;
        gbc_TextFechaNac.fill = GridBagConstraints.BOTH;
        gbc_TextFechaNac.insets = new Insets(0, 0, 5, 5);
        gbc_TextFechaNac.gridx = 2;
        gbc_TextFechaNac.gridy = 8;
        getContentPane().add(TextFechaNac, gbc_TextFechaNac);
        
        LabelNacionalidad = new JLabel("Nacionalidad: ");
        LabelNacionalidad.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelNacionalidad = new GridBagConstraints();
        gbc_LabelNacionalidad.fill = GridBagConstraints.BOTH;
        gbc_LabelNacionalidad.insets = new Insets(0, 0, 5, 5);
        gbc_LabelNacionalidad.gridx = 1;
        gbc_LabelNacionalidad.gridy = 9; 
        getContentPane().add(LabelNacionalidad, gbc_LabelNacionalidad);
        //text box nacionalidad
        TextNacionalidad = new JTextField();
        TextNacionalidad.setEditable(true);
        GridBagConstraints gbc_TextNacionalidad = new GridBagConstraints();
        gbc_TextNacionalidad.gridwidth = 2;
        gbc_TextNacionalidad.fill = GridBagConstraints.BOTH;
        gbc_TextNacionalidad.insets = new Insets(0, 0, 5, 5);
        gbc_TextNacionalidad.gridx = 2;
        gbc_TextNacionalidad.gridy = 9;
        getContentPane().add(TextNacionalidad, gbc_TextNacionalidad);
        
        //Label sitio web
        LabelSitioWeb = new JLabel("Link del sitio Web: ");
        LabelSitioWeb.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelSitioWeb = new GridBagConstraints();
        gbc_LabelSitioWeb.fill = GridBagConstraints.BOTH;
        gbc_LabelSitioWeb.insets = new Insets(0, 0, 5, 5);
        gbc_LabelSitioWeb.gridx = 1;
        gbc_LabelSitioWeb.gridy = 9; 
        getContentPane().add(LabelSitioWeb, gbc_LabelSitioWeb);

        //text box sitio web
        TextSitioWeb = new JTextField();
        TextSitioWeb.setEditable(false);
        GridBagConstraints gbc_TextSitioWeb = new GridBagConstraints();
        gbc_TextSitioWeb.gridwidth = 2;
        gbc_TextSitioWeb.fill = GridBagConstraints.BOTH;
        gbc_TextSitioWeb.insets = new Insets(0, 0, 5, 5);
        gbc_TextSitioWeb.gridx = 2;
        gbc_TextSitioWeb.gridy = 9;
        getContentPane().add(TextSitioWeb, gbc_TextSitioWeb);
        
        LabelDescripcionProveedor = new JLabel("Descripción: ");
        GridBagConstraints gbc_LabelDescripcionProveedor = new GridBagConstraints();
        gbc_LabelDescripcionProveedor.anchor = GridBagConstraints.EAST;
        gbc_LabelDescripcionProveedor.insets = new Insets(0, 0, 5, 5);
        gbc_LabelDescripcionProveedor.gridx = 1;
        gbc_LabelDescripcionProveedor.gridy = 10;
        getContentPane().add(LabelDescripcionProveedor, gbc_LabelDescripcionProveedor);
        
        TextAreaDescripcion = new JTextArea();
        ScrollPaneDescripcionProveedor = new JScrollPane(TextAreaDescripcion);
        TextAreaDescripcion.setWrapStyleWord(true);
        TextAreaDescripcion.setLineWrap(true); 
        TextAreaDescripcion.setEditable(false);
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.gridheight = 2;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
        gbc_scrollPane.gridx = 2;
        gbc_scrollPane.gridy = 10;
        getContentPane().add(ScrollPaneDescripcionProveedor, gbc_scrollPane);
        
        btnModificarDatos = new JButton("Modificar Datos");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 2;
        gbc_btnNewButton.gridy = 13;
        getContentPane().add(btnModificarDatos, gbc_btnNewButton);
        
        btnCancelar = new JButton("Cancelar");
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton_1.gridx = 3;
        gbc_btnNewButton_1.gridy = 13;
        getContentPane().add(btnCancelar, gbc_btnNewButton_1);
        
        //Eventos
        cargarEventos();
	}
	
	private void cargarEventos() {
		return;
	};
	
}
