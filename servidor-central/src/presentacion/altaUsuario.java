package presentacion;

import logica.clases.DatePicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import logica.clases.DatePicker;
//import excepciones.InvalidArgument;
//import excepciones.YaExisteException;
import logica.interfaces.ICtrlUsuario;
import datatypes.tipoUsuario;
//import excepciones.InvalidArgument;
import excepciones.YaExisteException;

import java.util.GregorianCalendar;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextPane;
import java.awt.CardLayout;
import java.awt.Color;


@SuppressWarnings("serial")
public class altaUsuario extends JInternalFrame {

	private ICtrlUsuario ctrlUsr;

	private JTextField textFieldNickName;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	// decidir como mostrar la fecha

	private JRadioButton provBtn;
	private JRadioButton turBtn;
	private ButtonGroup BtnGroup;

	private JTextField textFieldNacionalidad;
	private JTextField textFieldSitioWeb;
	private JTextPane textFieldDescripcion;

	private JLabel lblIngreseNickName;
	private JLabel lblIngreseNombre;
	private JLabel lblIngreseApellido;
	private JLabel lblIngreseEmail;

	private JLabel lblIngreseTipoUsuario;

	private JButton btnAceptar;
	private JButton btnCancelar;
	
	private JPanel turista_panel;
	private JPanel proveedor_panel;
	private JPanel blank_panel;
	private JPanel panel;
	private JButton btnNewButton;
	private GregorianCalendar fechaNac;

	private JTextField date;
	private JInternalFrame f;
	private JTextField selectedDate;
	public altaUsuario(ICtrlUsuario icu) {

		ctrlUsr = icu;

		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Registrar un Usuario");
		setBounds(10, 40, 452, 341);

		// ================ NICKNAME ================//
		lblIngreseNickName = new JLabel("Nickname:");
		lblIngreseNickName.setHorizontalAlignment(SwingConstants.CENTER);

		textFieldNickName = new JTextField();
		//textFieldNombre.setColumns(10);
		// ================ NICKNAME ================//

		// ================ NOMBRE ================//
		lblIngreseNombre = new JLabel("Nombre:");
		lblIngreseNombre.setHorizontalAlignment(SwingConstants.CENTER);

		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		// ================ NOMBRE ================//

		// ================ APELLIDO ================//
		lblIngreseApellido = new JLabel("Apellido:");
		lblIngreseApellido.setHorizontalAlignment(SwingConstants.CENTER);

		textFieldEmail = new JTextField();
		textFieldEmail.setToolTipText("Ingrese su email");
		textFieldEmail.setColumns(10);

		String prov = "Proveedor";
		String tur = "Turista";

		BtnGroup = new ButtonGroup();
		// ================ RADIO BUTTONS TURISTA_PROVEEDOR ================//

		// ================ ACEPTAR-CANCELAR BUTTONS ================//
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdRegistroUsuarioActionPerformed(arg0);
			}
		});
		// ================ APELLIDO ================//

		// ================ EMAIL ================//
		lblIngreseEmail = new JLabel("Email:");
		lblIngreseEmail.setHorizontalAlignment(SwingConstants.CENTER);

		textFieldApellido = new JTextField();
		textFieldApellido.setToolTipText("Ingrese su apellido");
		textFieldApellido.setColumns(10);
		// ================ EMAIL ================//

		// ================ FECHA DE NACIMIENTO ================//

		// ================ FECHA DE NACIMIENTO ================//

		// ================ RADIO BUTTONS TURISTA_PROVEEDOR ================//
		lblIngreseTipoUsuario = new JLabel("Tipo Usuario:");
		lblIngreseTipoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		provBtn = new JRadioButton(prov);
		provBtn.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					proveedor_panel.setVisible(true);
					turista_panel.setVisible(false);
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					proveedor_panel.setVisible(false);
					turista_panel.setVisible(true);
				}
			}
		});
		provBtn.setMnemonic(KeyEvent.VK_P);
		provBtn.setActionCommand(prov);
		BtnGroup.add(provBtn);

		turBtn = new JRadioButton(tur);
		turBtn.setMnemonic(KeyEvent.VK_T);
		turBtn.setActionCommand(tur);
		BtnGroup.add(turBtn);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});

		panel = new JPanel();
		
		JPanel panel_fechaNac = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblIngreseTipoUsuario, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addGap(15)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(29)
											.addComponent(provBtn)
											.addGap(46)
											.addComponent(turBtn))))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblIngreseEmail, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(lblIngreseApellido, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGroup(groupLayout.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(lblIngreseNickName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
										.addComponent(lblIngreseNombre, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textFieldApellido)
										.addComponent(textFieldEmail)
										.addComponent(textFieldNombre)
										.addComponent(textFieldNickName, GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(panel_fechaNac, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addGap(51)))
							.addGap(95))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIngreseNickName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldNickName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIngreseNombre, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblIngreseApellido, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIngreseEmail, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
							.addGap(13))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_fechaNac, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIngreseTipoUsuario, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(provBtn)
						.addComponent(turBtn))
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		
		Icon icon = new ImageIcon("../icons/calendario.png");
		btnNewButton = new JButton(icon);
		
		JLabel lblFechaDeNacimiento = new JLabel("<html><p>Fecha de Nacimiento</p></html>");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		
		selectedDate = new JTextField();
		selectedDate.setHorizontalAlignment(SwingConstants.CENTER);
		selectedDate.setBackground(new Color(77, 147, 130)); 
		selectedDate.setText("None");
		selectedDate.setColumns(10);
		GroupLayout gl_panel_fechaNac = new GroupLayout(panel_fechaNac);
		gl_panel_fechaNac.setHorizontalGroup(
			gl_panel_fechaNac.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_fechaNac.createSequentialGroup()
					.addComponent(lblFechaDeNacimiento, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
					.addGap(4))
				.addGroup(gl_panel_fechaNac.createSequentialGroup()
					.addComponent(selectedDate, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel_fechaNac.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		gl_panel_fechaNac.setVerticalGroup(
			gl_panel_fechaNac.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_fechaNac.createSequentialGroup()
					.addComponent(lblFechaDeNacimiento, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(selectedDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
		);
		panel_fechaNac.setLayout(gl_panel_fechaNac);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.setVisible(true);
				date.setText(new DatePicker(f).setPickedDate());
				// string en formato dd-mm-yyyy
				int dia = Integer.parseInt(date.getText().substring(0,2));
				int mes = Integer.parseInt(date.getText().substring(4,5));
				int anio = Integer.parseInt(date.getText().substring(6,10));
				fechaNac = new GregorianCalendar(anio, mes, dia);
			}
		});
		
		date = new JTextField(20);
		f = new JInternalFrame();
		//f.getContentPane().add(p);
		f.pack();
		f.setVisible(false);
		
		panel.setLayout(new CardLayout(0, 0));

		turista_panel = new JPanel();
		panel.add(turista_panel, "name_32116916439377");

		JLabel lblNacionalidad_1 = new JLabel("Nacionalidad");
		lblNacionalidad_1.setHorizontalAlignment(SwingConstants.CENTER);

		textFieldNacionalidad = new JTextField();
		textFieldNacionalidad.setColumns(10);
		GroupLayout gl_turista_panel = new GroupLayout(turista_panel);
		gl_turista_panel.setHorizontalGroup(gl_turista_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_turista_panel.createSequentialGroup().addGap(1).addComponent(lblNacionalidad_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textFieldNacionalidad, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(66, Short.MAX_VALUE)));
		gl_turista_panel.setVerticalGroup(gl_turista_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_turista_panel.createSequentialGroup().addGap(31)
						.addGroup(gl_turista_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textFieldNacionalidad, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNacionalidad_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGap(43)));
		turista_panel.setLayout(gl_turista_panel);

		proveedor_panel = new JPanel();
		panel.add(proveedor_panel, "name_32131201451827");

		JLabel lblSitioWeb_1 = new JLabel("Sitio Web");
		lblSitioWeb_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblDescripcion = new JLabel("Descripcion");

		textFieldSitioWeb = new JTextField();
		textFieldSitioWeb.setColumns(10);

		textFieldDescripcion = new JTextPane();
		GroupLayout gl_proveedor_panel = new GroupLayout(proveedor_panel);
		gl_proveedor_panel.setHorizontalGroup(gl_proveedor_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_proveedor_panel.createSequentialGroup().addGap(21)
						.addGroup(gl_proveedor_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_proveedor_panel.createSequentialGroup().addComponent(lblDescripcion)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(textFieldDescripcion))
								.addGroup(gl_proveedor_panel.createSequentialGroup().addComponent(lblSitioWeb_1)
										.addGap(18).addComponent(textFieldSitioWeb, GroupLayout.PREFERRED_SIZE, 253,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(58, Short.MAX_VALUE)));
		gl_proveedor_panel.setVerticalGroup(gl_proveedor_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_proveedor_panel.createSequentialGroup().addGap(23)
						.addGroup(gl_proveedor_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblSitioWeb_1)
								.addComponent(textFieldSitioWeb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_proveedor_panel.createParallelGroup(Alignment.LEADING).addComponent(lblDescripcion)
								.addComponent(textFieldDescripcion, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
						.addContainerGap()));
		proveedor_panel.setLayout(gl_proveedor_panel);

		blank_panel = new JPanel();
		panel.add(blank_panel, "name_32883367802349");
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
		getContentPane().setLayout(groupLayout);
		
		// ================ ACEPTAR-CANCELAR BUTTONS ================//
	}

	protected void cmdRegistroUsuarioActionPerformed(ActionEvent arg0) {
		String nickname = this.textFieldNickName.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String email = this.textFieldEmail.getText();
		
        String descripcion = "";
        String sitioWeb = "";
        String nacionalidad = "";
		tipoUsuario tipo;


		if (checkFormulario()) {
			try {
				String stringTipo = BtnGroup.getSelection().getActionCommand();
				if (stringTipo == "Proveedor") {
					tipo = tipoUsuario.proveedor;
			        sitioWeb = this.textFieldSitioWeb.getText();
			        descripcion = this.textFieldDescripcion.getText();
				} else {
					tipo = tipoUsuario.turista;
		        	nacionalidad = this.textFieldNacionalidad.getText();
				}
				
				ctrlUsr.altaUsuario(nickname, email, nombre, apellido, fechaNac, tipo, nacionalidad, descripcion,
						sitioWeb);

				JOptionPane.showMessageDialog(this, "El Usuario se ha creado con éxito", "Registrar Usuario",
						JOptionPane.INFORMATION_MESSAGE);
				
				if (tipo == tipoUsuario.proveedor) {
					textFieldSitioWeb.setText("");
					textFieldDescripcion.setText("");
				} else
					textFieldNacionalidad.setText("");

			} catch (YaExisteException e) {
              JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
            }

			limpiarFormulario();
			setVisible(false);
		}
	}

	private boolean checkFormulario() {
		String nickname = this.textFieldNickName.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String email = this.textFieldEmail.getText();

		if (nickname.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Usuario",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		String usrTypeSelected = "";
		try {
			usrTypeSelected = BtnGroup.getSelection().getActionCommand();
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de Usuario", "Registrar Usuario",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if (usrTypeSelected == "Turista") {
			String nacionalidad = this.textFieldNacionalidad.getText();
			if (nacionalidad.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Debe especificar una nacionalidad", "Registrar Usuario",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		if (usrTypeSelected == "Proveedor") {
			String descripcion = this.textFieldDescripcion.getText();
			if (descripcion.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Debe dar una descripcion", "Registrar Usuario",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		return true;
	}

	private void limpiarFormulario() {
		textFieldNickName.setText("");
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldEmail.setText("");
	}
}
