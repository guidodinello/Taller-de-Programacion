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

import logica.interfaces.ICtrlUsuario;
import datatypes.tipoUsuario;
import excepciones.YaExisteException;

import java.util.GregorianCalendar;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextPane;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;


@SuppressWarnings("serial")
public class altaUsuario extends JInternalFrame {

	private ICtrlUsuario ctrlUsr;

	private JTextField textFieldNickName;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;

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
	private JButton calendarBtn;
	private GregorianCalendar fechaNac;

	private JTextField date;
	private JInternalFrame f;
	private JTextField selectedDate;
	
	public altaUsuario(ICtrlUsuario icu) {

		ctrlUsr = icu;

		setIconifiable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Registrar un Usuario");
		//setBounds(10, 40, 605, 329);

		
		lblIngreseNickName = new JLabel("Nickname:");
		lblIngreseNickName.setBounds(18, 6, 110, 25);
		lblIngreseNickName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNickName = new JTextField();
		textFieldNickName.setBounds(140, 6, 300, 25);
		
		lblIngreseNombre = new JLabel("Nombre:");
		lblIngreseNombre.setBounds(18, 37, 110, 25);
		lblIngreseNombre.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(140, 37, 300, 25);
		
		lblIngreseApellido = new JLabel("Apellido:");
		lblIngreseApellido.setBounds(18, 68, 110, 25);
		lblIngreseApellido.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(140, 99, 300, 27);

		lblIngreseEmail = new JLabel("Email:");
		lblIngreseEmail.setBounds(18, 102, 110, 21);
		lblIngreseEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(140, 68, 300, 25);
		
		String prov = "Proveedor";
		String tur = "Turista";
		BtnGroup = new ButtonGroup();
		
		lblIngreseTipoUsuario = new JLabel("Tipo Usuario:");
		lblIngreseTipoUsuario.setBounds(33, 139, 95, 23);
		lblIngreseTipoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		provBtn = new JRadioButton(prov);
		provBtn.setBounds(186, 139, 98, 23);
		provBtn.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					proveedor_panel.setVisible(true);
					turista_panel.setVisible(false);
					blank_panel.setVisible(false);
				}
			}
		});
		provBtn.setMnemonic(KeyEvent.VK_P);
		provBtn.setActionCommand(prov);
		BtnGroup.add(provBtn);

		turBtn = new JRadioButton(tur);
		turBtn.setBounds(378, 139, 75, 23);
		turBtn.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					proveedor_panel.setVisible(false);
					turista_panel.setVisible(true);
					blank_panel.setVisible(false);
				}
			}
		});
		turBtn.setMnemonic(KeyEvent.VK_T);
		turBtn.setActionCommand(tur);
		BtnGroup.add(turBtn);
		
		
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(141, 254, 115, 25);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmdRegistroUsuarioActionPerformed(arg0);
			}
		});
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 254, 115, 25);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		

		panel = new JPanel();
		panel.setBounds(12, 180, 571, 68);
		
		JPanel panel_fechaNac = new JPanel();
		panel_fechaNac.setBounds(465, 6, 106, 124);
		
		
		JLabel lblFechaDeNacimiento = new JLabel("<html><p>Fecha de Nacimiento</p></html>");
		lblFechaDeNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		
		calendarBtn = new JButton("...");
		String icon_path = "src/icons/calendario.png";
		ImageIcon icon = new ImageIcon(icon_path,"calendario");
		Image img = icon.getImage();
		Image scaled_img = img.getScaledInstance( 15, 15,  java.awt.Image.SCALE_SMOOTH ) ;  
		calendarBtn.setIcon(new ImageIcon(scaled_img));
		
		selectedDate = new JTextField();
		selectedDate.setEditable(false);
		selectedDate.setHorizontalAlignment(SwingConstants.CENTER);
		selectedDate.setBackground(new Color(200,200,200)); 
		selectedDate.setColumns(10);
		GroupLayout gl_panel_fechaNac = new GroupLayout(panel_fechaNac);
		gl_panel_fechaNac.setHorizontalGroup(
			gl_panel_fechaNac.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_fechaNac.createSequentialGroup()
					.addGroup(gl_panel_fechaNac.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_fechaNac.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblFechaDeNacimiento, 0, 0, Short.MAX_VALUE))
						.addGroup(gl_panel_fechaNac.createSequentialGroup()
							.addGap(26)
							.addComponent(calendarBtn, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_fechaNac.createSequentialGroup()
							.addContainerGap()
							.addComponent(selectedDate, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_fechaNac.setVerticalGroup(
			gl_panel_fechaNac.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_fechaNac.createSequentialGroup()
					.addGap(6)
					.addComponent(lblFechaDeNacimiento, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
					.addGap(12)
					.addComponent(calendarBtn, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(selectedDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
		);
		panel_fechaNac.setLayout(gl_panel_fechaNac);
		calendarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.setVisible(true);
				date.setText(new DatePicker(f).setPickedDate());
				// string en formato dd-mm-yyyy
				if (!date.getText().isEmpty()) {
					selectedDate.setText(date.getText());
					int dia = Integer.parseInt(date.getText().substring(0,2));
					int mes = Integer.parseInt(date.getText().substring(4,5));
					int anio = Integer.parseInt(date.getText().substring(6,10));
					fechaNac = new GregorianCalendar(anio, mes, dia);
				}
			}
		});
		
		date = new JTextField(20);
		f = new JInternalFrame();
		f.setVisible(false);
		
		blank_panel = new JPanel();
		blank_panel.setBackground(new Color(200,200,200));
		blank_panel.setVisible(true);

		turista_panel = new JPanel();
		JLabel lblNacionalidad_1 = new JLabel("Nacionalidad");
		lblNacionalidad_1.setBounds(1, 38, 92, 15);
		lblNacionalidad_1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNacionalidad = new JTextField();
		textFieldNacionalidad.setBounds(105, 31, 247, 30);

		proveedor_panel = new JPanel();
		JLabel lblSitioWeb_1 = new JLabel("Sitio Web");
		lblSitioWeb_1.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSitioWeb = new JTextField();
		JLabel lblDescripcion = new JLabel("Descripcion");
		textFieldDescripcion = new JTextPane();
		GroupLayout gl_blank_panel = new GroupLayout(blank_panel);
		gl_blank_panel.setHorizontalGroup(
			gl_blank_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 643, Short.MAX_VALUE)
		);
		gl_blank_panel.setVerticalGroup(
			gl_blank_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 68, Short.MAX_VALUE)
		);
		blank_panel.setLayout(gl_blank_panel);
		GroupLayout gl_proveedor_panel = new GroupLayout(proveedor_panel);
		gl_proveedor_panel.setHorizontalGroup(
			gl_proveedor_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_proveedor_panel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_proveedor_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_proveedor_panel.createSequentialGroup()
							.addComponent(lblSitioWeb_1)
							.addGap(32))
						.addGroup(gl_proveedor_panel.createSequentialGroup()
							.addComponent(lblDescripcion)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_proveedor_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textFieldDescripcion)
						.addComponent(textFieldSitioWeb, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
					.addGap(218))
		);
		gl_proveedor_panel.setVerticalGroup(
			gl_proveedor_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_proveedor_panel.createSequentialGroup()
					.addGroup(gl_proveedor_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSitioWeb_1)
						.addComponent(textFieldSitioWeb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_proveedor_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldDescripcion, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDescripcion))
					.addContainerGap())
		);
		proveedor_panel.setLayout(gl_proveedor_panel);
		GroupLayout gl_turista_panel = new GroupLayout(turista_panel);
		gl_turista_panel.setHorizontalGroup(
			gl_turista_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_turista_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(lblNacionalidad_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldNacionalidad, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(215, Short.MAX_VALUE))
		);
		gl_turista_panel.setVerticalGroup(
			gl_turista_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_turista_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_turista_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldNacionalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNacionalidad_1))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		turista_panel.setLayout(gl_turista_panel);
		panel.setLayout(new CardLayout(0, 0));
		panel.add(blank_panel, "name_11119719302903");
		panel.add(proveedor_panel, "name_11119758041676");
		panel.add(turista_panel, "name_11119793380911");
		getContentPane().setLayout(null);
		getContentPane().add(lblIngreseTipoUsuario);
		getContentPane().add(provBtn);
		getContentPane().add(turBtn);
		getContentPane().add(btnAceptar);
		getContentPane().add(btnCancelar);
		getContentPane().add(lblIngreseNickName);
		getContentPane().add(lblIngreseNombre);
		getContentPane().add(lblIngreseApellido);
		getContentPane().add(lblIngreseEmail);
		getContentPane().add(textFieldNickName);
		getContentPane().add(textFieldNombre);
		getContentPane().add(textFieldEmail);
		getContentPane().add(textFieldApellido);
		getContentPane().add(panel_fechaNac);
		getContentPane().add(panel);
		
		//pack();
		setBounds(30, 30, 610, 320);
		
		setResizable(true);
		
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
		String fechaNac = this.selectedDate.getText();

		if (nickname.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || fechaNac.isEmpty()) {
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
		selectedDate.setText("");
		
		BtnGroup.clearSelection();
		
		blank_panel.setVisible(true);
		turista_panel.setVisible(false);
		proveedor_panel.setVisible(false);
		
	}
}
