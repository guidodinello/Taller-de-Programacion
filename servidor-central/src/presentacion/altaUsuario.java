package presentacion;

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

//import excepciones.InvalidArgument;
//import excepciones.YaExisteException;
import logica.interfaces.ICtrlUsuario;
import datatypes.tipoUsuario;

import java.util.GregorianCalendar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextPane;
import java.awt.CardLayout;

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
	//private JTextField textFieldSitioWeb;
	private JTextField textFieldDescripcion;

	private JLabel lblIngreseNickName;
	private JLabel lblIngreseNombre;
	private JLabel lblIngreseApellido;
	private JLabel lblIngreseEmail;
	// label fecha

	private JLabel lblIngreseTipoUsuario;
	//private JLabel lblNacionalidad;
	//private JLabel lblSitioWeb;
	//private JLabel lblIngreseDescripcion;

	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextField textField;
	private JTextField textField_1;
	
	private JPanel turista_panel;
	private JPanel proveedor_panel;
	private JPanel blank_panel;
	private JPanel panel;

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
		textFieldNombre.setColumns(10);
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
//                  //================ INFO PROVEEDOR ================//
//                  //================ INFO PROVEEDOR ================//
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
		turBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ================ INFO TURISTA ================//
				// CardLayout cl = (CardLayout)getContentPane()..getLayout();
				// ================ INFO TURISTA ================//
			}
		});

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});

		panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(6).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblIngreseNickName, GroupLayout.PREFERRED_SIZE, 95,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(textFieldNickName, GroupLayout.PREFERRED_SIZE, 248,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblIngreseNombre, GroupLayout.PREFERRED_SIZE, 95,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 248,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblIngreseApellido, GroupLayout.PREFERRED_SIZE, 95,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 248,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblIngreseEmail, GroupLayout.PREFERRED_SIZE, 95,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6).addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, 248,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblIngreseTipoUsuario, GroupLayout.PREFERRED_SIZE, 95,
												GroupLayout.PREFERRED_SIZE)
										.addGap(15)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
														.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 115,
																GroupLayout.PREFERRED_SIZE)
														.addGap(18).addComponent(btnCancelar,
																GroupLayout.PREFERRED_SIZE, 115,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup().addComponent(provBtn)
														.addGap(46).addComponent(turBtn))))))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap()
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(6)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIngreseNickName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNickName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGap(6)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIngreseNombre, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGap(6)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIngreseApellido, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGap(6)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblIngreseEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(textFieldApellido, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIngreseTipoUsuario, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(provBtn).addComponent(turBtn))
				.addGap(18).addComponent(panel, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
				.addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout
						.createParallelGroup(Alignment.BASELINE).addComponent(btnAceptar).addComponent(btnCancelar))
				.addContainerGap()));
		panel.setLayout(new CardLayout(0, 0));

		turista_panel = new JPanel();
		panel.add(turista_panel, "name_32116916439377");

		JLabel lblNacionalidad_1 = new JLabel("Nacionalidad");
		lblNacionalidad_1.setHorizontalAlignment(SwingConstants.CENTER);

		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout gl_turista_panel = new GroupLayout(turista_panel);
		gl_turista_panel.setHorizontalGroup(gl_turista_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_turista_panel.createSequentialGroup().addGap(1).addComponent(lblNacionalidad_1)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(66, Short.MAX_VALUE)));
		gl_turista_panel.setVerticalGroup(gl_turista_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_turista_panel.createSequentialGroup().addGap(31)
						.addGroup(gl_turista_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNacionalidad_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGap(43)));
		turista_panel.setLayout(gl_turista_panel);

		proveedor_panel = new JPanel();
		panel.add(proveedor_panel, "name_32131201451827");

		JLabel lblSitioWeb_1 = new JLabel("Sitio Web");
		lblSitioWeb_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblDescripcion = new JLabel("Descripcion");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JTextPane textPane = new JTextPane();
		GroupLayout gl_proveedor_panel = new GroupLayout(proveedor_panel);
		gl_proveedor_panel.setHorizontalGroup(gl_proveedor_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_proveedor_panel.createSequentialGroup().addGap(21)
						.addGroup(gl_proveedor_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_proveedor_panel.createSequentialGroup().addComponent(lblDescripcion)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(textPane))
								.addGroup(gl_proveedor_panel.createSequentialGroup().addComponent(lblSitioWeb_1)
										.addGap(18).addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 253,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(58, Short.MAX_VALUE)));
		gl_proveedor_panel.setVerticalGroup(gl_proveedor_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_proveedor_panel.createSequentialGroup().addGap(23)
						.addGroup(gl_proveedor_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblSitioWeb_1)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_proveedor_panel.createParallelGroup(Alignment.LEADING).addComponent(lblDescripcion)
								.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
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
//        castear la fecha a tipo Date
		GregorianCalendar fechaNac = new GregorianCalendar();
//        capturar radio button value para pasar tipo Usuaeio
		tipoUsuario tipo = tipoUsuario.turista;

//        String nacionalidad = this.textFieldNacionalidad.getText();
//        String descripcion = this.textFieldDescripcion.getText();
//        String sitioWeb = this.textFieldEmail.getText();
		String nacionalidad = "";
		String descripcion = "";
		String sitioWeb = "";

		if (checkFormulario()) {
			try {
				ctrlUsr.altaUsuario(nickname, email, nombre, apellido, fechaNac, tipo, nacionalidad, descripcion,
						sitioWeb);

				JOptionPane.showMessageDialog(this, "El Usuario se ha creado con éxito", "Registrar Usuario",
						JOptionPane.INFORMATION_MESSAGE);

//          } catch (YaExisteException e) {
//              JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
//          } catch (InvalidArgument e) {
//            	JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
//          }
			} catch (Exception e) {
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
		String usrTypeSelected = BtnGroup.getSelection().getActionCommand();
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
