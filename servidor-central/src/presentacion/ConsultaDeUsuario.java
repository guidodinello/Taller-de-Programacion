package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import datatypes.DTActividad;
import datatypes.DTProveedor;
import datatypes.DTSalida;
import datatypes.DTTurista;
import datatypes.DTUsuario;
import excepciones.InvalidArgument;
import logica.interfaces.ICtrlUsuario;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class ConsultaDeUsuario extends JInternalFrame {

	//Controlador
	private ICtrlUsuario ctrlUsuario;
	//Basicos
	private JLabel LabelSelcUsuario;
	private JComboBox<String> ComboBoxSelUsuario;
	private JButton btnSelecUsuario = new JButton("Seleccionar");
	private JLabel LabelInfoUsuario;
	private JLabel LabelTipoUsuario;
	private JTextField TextTipoUsuario;
	//Datos del usuario
	private JLabel LabelNickname;
	private JTextField TextNickname;
	private JLabel LabelEmail;
	private JTextField TextEmail;
	private JLabel LabelNombre;
	private JTextField TextNombre;
	private JLabel LabelApellido;
	private JTextField TextApellido;
	private JLabel LabelFechaNac;
	private JTextField TextFechaNac;
	//Si usuario es turista
	private JLabel LabelNacionalidad;
	private JTextField TextNacionalidad;
	private JLabel LabelSalidasInscripto;
	private JComboBox<String> ComboBoxSalidasInscripto;
	private JButton btnVerSalidaTurista;
	//Si el usuario es proveedor
	private JLabel LabelDescripcion;
	private JTextArea TextDescripcion;
	private JLabel LabelSitioWeb;
	private JTextField TextSitioWeb;
	private JLabel LabelActividadesProveedor;
	private JComboBox<String> ComboBoxActividadesProveedor;
	private JButton btnVerActividad;
	private JLabel LabelSalidasDeActividadesDelProveedor;
	private JComboBox<String> ComboBoxSalidasDeActividadesDelProveedor;
	private JButton btnVerSalidaProveedor;
	//borrando
	private boolean seteandoDatosIniciales = false;
	
	
	
	
	
	public ConsultaDeUsuario(ICtrlUsuario iCU) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//meto la interfaz
		this.ctrlUsuario = iCU;
		
		//Cuestiones de configuracion del frame
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setClosable(true);
		setTitle("Consultar un Usuario");
				
		setBounds(30, 30, 654, 431);
				
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[] { 41, 219, 134, 104, 43 };
		gbl.rowHeights = new int[] { 0, 0, 30, 30, 30, 30, 30, 30, 30, 47, 30, 30, 30, 30, 0, 0 };
		gbl.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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
        gbc_LabelInfoUsuario.gridx = 1;
        gbc_LabelInfoUsuario.gridy = 2;
        gbc_LabelInfoUsuario.gridwidth = 4;
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
        gbc_TextNickname.fill = GridBagConstraints.BOTH;
        gbc_TextNickname.insets = new Insets(0, 0, 5, 5);
        gbc_TextNickname.gridx = 2;
        gbc_TextNickname.gridy = 4;
        getContentPane().add(TextNickname, gbc_TextNickname);
		        
        //Label email
        LabelEmail = new JLabel("E-mail: ");
        LabelEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelEmail = new GridBagConstraints();
        gbc_LabelEmail.fill = GridBagConstraints.BOTH;
        gbc_LabelEmail.insets = new Insets(0, 0, 5, 5);
        gbc_LabelEmail.gridx = 1;
        gbc_LabelEmail.gridy = 5;
        getContentPane().add(LabelEmail, gbc_LabelEmail);
        //text box email
        TextEmail = new JTextField();
        TextEmail.setEditable(false);
        GridBagConstraints gbc_TextEmail = new GridBagConstraints();
        gbc_TextEmail.fill = GridBagConstraints.BOTH;
        gbc_TextEmail.insets = new Insets(0, 0, 5, 5);
        gbc_TextEmail.gridx = 2;
        gbc_TextEmail.gridy = 5;
	    getContentPane().add(TextEmail, gbc_TextEmail);
		        
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
        gbc_TextFechaNac.fill = GridBagConstraints.BOTH;
        gbc_TextFechaNac.insets = new Insets(0, 0, 5, 5);
        gbc_TextFechaNac.gridx = 2;
        gbc_TextFechaNac.gridy = 8;
        getContentPane().add(TextFechaNac, gbc_TextFechaNac);

        //Label Nacionalidad
        LabelNacionalidad = new JLabel("Nacionalidad: ");
        LabelNacionalidad.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelNacionalidad = new GridBagConstraints();
        gbc_LabelNacionalidad.fill = GridBagConstraints.BOTH;
        gbc_LabelNacionalidad.insets = new Insets(0, 0, 5, 5);
        gbc_LabelNacionalidad.gridx = 1;
        gbc_LabelNacionalidad.gridy = 9;
        getContentPane().add(LabelNacionalidad, gbc_LabelNacionalidad);
        LabelNacionalidad.setVisible(false);
        //text box nacionalidad
        TextNacionalidad = new JTextField();
        TextNacionalidad.setEditable(false);
        GridBagConstraints gbc_TextNacionalidad = new GridBagConstraints();
        gbc_TextNacionalidad.fill = GridBagConstraints.BOTH;
        gbc_TextNacionalidad.insets = new Insets(0, 0, 5, 5);
        gbc_TextNacionalidad.gridx = 2;
        gbc_TextNacionalidad.gridy = 9;
        getContentPane().add(TextNacionalidad, gbc_TextNacionalidad);
        TextNacionalidad.setVisible(false);
		        
        //Label salidas
        LabelSalidasInscripto = new JLabel("Salidas en las que esta inscripto: ");
	    LabelSalidasInscripto.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelSalidasInscripto = new GridBagConstraints();
        gbc_LabelSalidasInscripto.fill = GridBagConstraints.BOTH;
        gbc_LabelSalidasInscripto.insets = new Insets(0, 0, 5, 5);
        gbc_LabelSalidasInscripto.gridx = 1;
        gbc_LabelSalidasInscripto.gridy = 10;
        getContentPane().add(LabelSalidasInscripto, gbc_LabelSalidasInscripto);
        LabelSalidasInscripto.setVisible(false);
        //combo box salidas
        ComboBoxSalidasInscripto = new JComboBox<String>();
        GridBagConstraints gbc_ComboBoxSalidasInscripto = new GridBagConstraints();
        gbc_ComboBoxSalidasInscripto.gridwidth = 2;
        gbc_ComboBoxSalidasInscripto.fill = GridBagConstraints.BOTH;
        gbc_ComboBoxSalidasInscripto.insets = new Insets(0, 0, 5, 5);
        gbc_ComboBoxSalidasInscripto.gridx = 2;
        gbc_ComboBoxSalidasInscripto.gridy = 10;
        getContentPane().add(ComboBoxSalidasInscripto, gbc_ComboBoxSalidasInscripto);
        ComboBoxSalidasInscripto.setVisible(false);
		        
        //Label Descripcion
        LabelDescripcion = new JLabel("Descripcion: ");
        LabelDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelDescripcion = new GridBagConstraints();
        gbc_LabelDescripcion.fill = GridBagConstraints.BOTH;
        gbc_LabelDescripcion.insets = new Insets(0, 0, 5, 5);
        gbc_LabelDescripcion.gridx = 1;
        gbc_LabelDescripcion.gridy = 9; 
        getContentPane().add(LabelDescripcion, gbc_LabelDescripcion);
        LabelDescripcion.setVisible(false);
        //text box Descripcion
        TextDescripcion = new JTextArea();
        TextDescripcion.setWrapStyleWord(true);
        TextDescripcion.setLineWrap(true); 
        TextDescripcion.setEditable(false);
        GridBagConstraints gbc_TextDescripcion = new GridBagConstraints();
        gbc_TextDescripcion.fill = GridBagConstraints.BOTH;
        gbc_TextDescripcion.insets = new Insets(0, 0, 5, 5);
        gbc_TextDescripcion.gridx = 2;
        gbc_TextDescripcion.gridy = 9;
        getContentPane().add(TextDescripcion, gbc_TextDescripcion);
        TextDescripcion.setVisible(false);
        
        //Label sitio web
        LabelSitioWeb = new JLabel("Link del sitio Web: ");
        LabelSitioWeb.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelSitioWeb = new GridBagConstraints();
        gbc_LabelSitioWeb.fill = GridBagConstraints.BOTH;
        gbc_LabelSitioWeb.insets = new Insets(0, 0, 5, 5);
        gbc_LabelSitioWeb.gridx = 1;
        gbc_LabelSitioWeb.gridy = 10; 
        getContentPane().add(LabelSitioWeb, gbc_LabelSitioWeb);
        LabelSitioWeb.setVisible(false);
        //text box sitio web
        TextSitioWeb = new JTextField();
        TextSitioWeb.setEditable(false);
        GridBagConstraints gbc_TextSitioWeb = new GridBagConstraints();
        gbc_TextSitioWeb.fill = GridBagConstraints.BOTH;
        gbc_TextSitioWeb.insets = new Insets(0, 0, 5, 5);
        gbc_TextSitioWeb.gridx = 2;
        gbc_TextSitioWeb.gridy = 10;
        getContentPane().add(TextSitioWeb, gbc_TextSitioWeb);
        TextSitioWeb.setVisible(false);
        
        btnVerSalidaTurista = new JButton("Ver Detalles");
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton.gridx = 4;
        gbc_btnNewButton.gridy = 10;
        getContentPane().add(btnVerSalidaTurista, gbc_btnNewButton);
	       
        //Label actividades
        LabelActividadesProveedor = new JLabel("Actividades que provee: ");
        LabelActividadesProveedor.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelActividadesProveedor = new GridBagConstraints();
        gbc_LabelActividadesProveedor.fill = GridBagConstraints.BOTH;
        gbc_LabelActividadesProveedor.insets = new Insets(0, 0, 5, 5);
        gbc_LabelActividadesProveedor.gridx = 1;
        gbc_LabelActividadesProveedor.gridy = 11;
        getContentPane().add(LabelActividadesProveedor, gbc_LabelActividadesProveedor);
        LabelActividadesProveedor.setVisible(false);
        //combo box actividades
        ComboBoxActividadesProveedor = new JComboBox<String>();
        GridBagConstraints gbc_ComboBoxActividadesProveedor = new GridBagConstraints();
        gbc_ComboBoxActividadesProveedor.gridwidth = 2;
        gbc_ComboBoxActividadesProveedor.fill = GridBagConstraints.BOTH;
        gbc_ComboBoxActividadesProveedor.insets = new Insets(0, 0, 5, 5);
        gbc_ComboBoxActividadesProveedor.gridx = 2;
        gbc_ComboBoxActividadesProveedor.gridy = 11;
        getContentPane().add(ComboBoxActividadesProveedor, gbc_ComboBoxActividadesProveedor);
        ComboBoxActividadesProveedor.setVisible(false);
        
        btnVerActividad = new JButton("Ver Detalles");
        GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
        gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton_1.gridx = 4;
        gbc_btnNewButton_1.gridy = 11;
        getContentPane().add(btnVerActividad, gbc_btnNewButton_1);
        
        //Salidas de actividades del proveedor
        LabelSalidasDeActividadesDelProveedor = new JLabel("Salidas de la actividad: ");
        LabelSalidasDeActividadesDelProveedor.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_LabelSalidasDeActividadesDelProveedor = new GridBagConstraints();
        gbc_LabelSalidasDeActividadesDelProveedor.fill = GridBagConstraints.BOTH;
        gbc_LabelSalidasDeActividadesDelProveedor.insets = new Insets(0, 0, 5, 5);
        gbc_LabelSalidasDeActividadesDelProveedor.gridx = 1;
        gbc_LabelSalidasDeActividadesDelProveedor.gridy = 12;
        getContentPane().add(LabelSalidasDeActividadesDelProveedor, gbc_LabelSalidasDeActividadesDelProveedor);
        LabelSalidasDeActividadesDelProveedor.setVisible(false);
        //combo box de salidas de actividades del proveedor
        ComboBoxSalidasDeActividadesDelProveedor = new JComboBox<String>();
        GridBagConstraints gbc_ComboBoxSalidasDeActividadesDelProveedor = new GridBagConstraints();
        gbc_ComboBoxSalidasDeActividadesDelProveedor.gridwidth = 2;
        gbc_ComboBoxSalidasDeActividadesDelProveedor.fill = GridBagConstraints.BOTH;
        gbc_ComboBoxSalidasDeActividadesDelProveedor.insets = new Insets(0, 0, 5, 5);
        gbc_ComboBoxSalidasDeActividadesDelProveedor.gridx = 2;
        gbc_ComboBoxSalidasDeActividadesDelProveedor.gridy = 12;
        getContentPane().add(ComboBoxSalidasDeActividadesDelProveedor, gbc_ComboBoxSalidasDeActividadesDelProveedor);
        
        btnVerSalidaProveedor = new JButton("Ver Detalles");
        GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
        gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 0);
        gbc_btnNewButton_2.gridx = 4;
        gbc_btnNewButton_2.gridy = 12;
        getContentPane().add(btnVerSalidaProveedor, gbc_btnNewButton_2);
        ComboBoxSalidasDeActividadesDelProveedor.setVisible(false);
        
        //Eventos
        cargarEventos();
	}
	
	private void cargarEventos() {
        btnSelecUsuario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(ComboBoxSelUsuario.getSelectedItem() == null) 
        			return;
        		setDatosEnCampos();	
        	}
        });
        
        ComboBoxSelUsuario.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		limpiarCamposParaNuevoUsuario();
        		
        	}
        });
        
        btnVerSalidaTurista.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		pasarDatosConsultaSalida(e);	
        	}
        });
        
        btnVerSalidaProveedor.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		pasarDatosConsultaSalida(e);	
        	}
        });
        
        btnVerActividad.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		pasarDatosConsultaActividad();	
        	}
        });
	}
	
	public void cargarDatosVentana() {
		limpiarTodosCampos();
		Set<String> usuarios = ctrlUsuario.listarUsuarios();
        usuarios.forEach((u)->{
        	seteandoDatosIniciales = true;
        	ComboBoxSelUsuario.addItem(u);
        	seteandoDatosIniciales = false;
        });
        //Setea inicialmente las cosas de un usuario especifico en invisible
        visibleCamposTurista(false);
        visibleCamposProveedor(false);
        
	}
	
	public void setDatosEnCampos() {
		DTUsuario dtU = ctrlUsuario.getInfoBasicaUsuario(ComboBoxSelUsuario.getSelectedItem().toString());
		TextNickname.setText(dtU.getNickname());
		TextEmail.setText(dtU.getEmail());
		TextNombre.setText(dtU.getNombre());
		TextApellido.setText(dtU.getApellido());
		TextFechaNac.setText(dtU.getFechaNac().toString());
		if(dtU instanceof DTTurista) {
			TextTipoUsuario.setText("Turista");
			visibleCamposTurista(true);
			visibleCamposProveedor(false);
			
			DTTurista dtT = (DTTurista)dtU;
			TextNacionalidad.setText(dtT.getNacionalidad());
			/*Set<DTSalida> dtS = ctrlUsuario.listarInfoSalidasTurista(dtT.getNombre());
			dtS.forEach((dt)->{
				seteandoDatosIniciales = true;
				String infoSalida = "Nombre: "+ dt.getNombre() + ". Fecha salida: " + dt.getfechaSalida().toString() +
						". Lugar de salida: " + dt.getlugarSalida();
				ComboBoxSalidasInscripto.addItem(infoSalida);
				seteandoDatosIniciales = false;
			});*/
		}else {
			TextTipoUsuario.setText("Proveedor");
			visibleCamposTurista(false);
			visibleCamposProveedor(true);
			
			DTProveedor dtP = (DTProveedor)dtU;
			TextDescripcion.setText(dtP.getDescripcion());
			TextSitioWeb.setText(dtP.getLinkSitioWeb());
			/*Set<DTActividad> dtA = ctrlUsuario.listarInfoCompletaActividadesProveedor(dtP.getNombre());
			dtA.forEach((dt)->{
				seteandoDatosIniciales = true;
				String infoActividad = "Nombre: " + dt.getNombre() + ". Descripición: " + dt.getDescripcion();
				ComboBoxActividadesProveedor.addItem(infoActividad);
				seteandoDatosIniciales = false;
				String nombAct = dt.getNombre();
				Set<String> dtAS = dt.getSalidas();
				dtAS.forEach((s)->{
					seteandoDatosIniciales = true;
					ComboBoxSalidasDeActividadesDelProveedor.addItem("Nombre: "+ s + " Actividad asociada: " +
							nombAct);
					seteandoDatosIniciales = false;
				});
			});*/
			
		}
	}
	
	private void visibleCamposTurista(boolean b) {
		LabelNacionalidad.setVisible(b);
		TextNacionalidad.setVisible(b);
		LabelSalidasInscripto.setVisible(b);
		ComboBoxSalidasInscripto.setVisible(b);
		btnVerSalidaTurista.setVisible(b);
		
	}
	
	private void visibleCamposProveedor(boolean b) {
		LabelDescripcion.setVisible(b);
		TextDescripcion.setVisible(b);
		LabelSitioWeb.setVisible(b);
		TextSitioWeb.setVisible(b);
		LabelActividadesProveedor.setVisible(b);
		ComboBoxActividadesProveedor.setVisible(b);
		LabelSalidasDeActividadesDelProveedor.setVisible(b);
		ComboBoxSalidasDeActividadesDelProveedor.setVisible(b);
		btnVerActividad.setVisible(b);
		btnVerSalidaProveedor.setVisible(b);
		
	}
	
	private void limpiarCamposText() {
		seteandoDatosIniciales = true;
    	TextTipoUsuario.setText("");
    	TextNickname.setText("");
    	TextEmail.setText("");
    	TextNombre.setText("");
    	TextApellido.setText("");
    	TextFechaNac.setText("");
    	TextNacionalidad.setText("");
    	TextDescripcion.setText("");
    	TextSitioWeb.setText("");
    	seteandoDatosIniciales = false;
    }
	
	private void limpiarCamposCombobox() {
		seteandoDatosIniciales = true;
    	ComboBoxSelUsuario.removeAllItems();
    	ComboBoxSalidasInscripto.removeAllItems();
    	ComboBoxActividadesProveedor.removeAllItems();
    	ComboBoxSalidasDeActividadesDelProveedor.removeAllItems();
    	seteandoDatosIniciales = false;
	}
	
	private void limpiarTodosCampos() {
		limpiarCamposText();
		limpiarCamposCombobox();
	}
	
	private void limpiarCamposParaNuevoUsuario() {
		limpiarCamposText();
		//limpio combobox menos el de usuario
		seteandoDatosIniciales = true;
    	ComboBoxSalidasInscripto.removeAllItems();
    	ComboBoxActividadesProveedor.removeAllItems();
    	ComboBoxSalidasDeActividadesDelProveedor.removeAllItems();
    	seteandoDatosIniciales = false;
	}
	
	public void pasarDatosConsultaSalida(ActionEvent e){
		if(ComboBoxSalidasInscripto.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(this,
					"No hay salida para mostrar", "No hay salidas", JOptionPane.ERROR_MESSAGE);
		}else {
			return;
		}
		
	}
	
	public void pasarDatosConsultaActividad() {
		if(ComboBoxSalidasInscripto.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(this,
					"No hay actividad para mostrar", "No hay actividad", JOptionPane.ERROR_MESSAGE);
		}else {
			return;
		}
	}
	
	
}
