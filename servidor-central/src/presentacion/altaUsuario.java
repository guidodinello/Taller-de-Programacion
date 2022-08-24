package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

import excepciones.InvalidArgument;
import excepciones.YaExisteException;
import logica.interfaces.ICtrlUsuario;
import datatypes.tipoUsuario;

import java.util.Date;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.FlowLayout;
import javax.swing.JTextPane;


@SuppressWarnings("serial")
public class altaUsuario extends JInternalFrame {
	
    private ICtrlUsuario ctrlUsr;
    
    private JTextField textFieldNickName;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldEmail;
    //decidir como mostrar la fecha
    
    private JRadioButton provBtn;
    private JRadioButton turBtn;
    private ButtonGroup BtnGroup;
    
    private JTextField textFieldNacionalidad;
    private JTextField textFieldSitioWeb;
    private JTextField textFieldDescripcion;
    
    private JLabel lblIngreseNickName;
    private JLabel lblIngreseNombre;
    private JLabel lblIngreseApellido;
    private JLabel lblIngreseEmail;
    //label fecha
    
    private JLabel lblIngreseTipoUsuario;
    private JLabel lblNacionalidad;
    private JLabel lblSitioWeb;
    private JLabel lblIngreseDescripcion;
    
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JPanel panel;
    private JLabel lblNacionalidad_1;
    private JTextField textField;
    private JTextField textField_1;
    
    public altaUsuario(ICtrlUsuario icu) {
        ctrlUsr = icu;

        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Registrar un Usuario");
        setBounds(10, 40, 452, 341);

        //================ NICKNAME ================//
        lblIngreseNickName = new JLabel("Nickname:");
        lblIngreseNickName.setHorizontalAlignment(SwingConstants.CENTER);

        textFieldNickName = new JTextField();
        textFieldNombre.setColumns(10);
        //================ NICKNAME ================//

        //================ NOMBRE ================//
        lblIngreseNombre = new JLabel("Nombre:");
        lblIngreseNombre.setHorizontalAlignment(SwingConstants.CENTER);

        textFieldNombre = new JTextField();
        textFieldNombre.setColumns(10);
        //================ NOMBRE ================//

        //================ APELLIDO ================//
        lblIngreseApellido = new JLabel("Apellido:");
        lblIngreseApellido.setHorizontalAlignment(SwingConstants.CENTER);

        textFieldEmail = new JTextField();
        textFieldEmail.setToolTipText("Ingrese su email");
        textFieldEmail.setColumns(10);
        
        String prov = "Proveedor";

        String tur = "Turista";
        
        BtnGroup = new ButtonGroup();
		//================ RADIO BUTTONS TURISTA_PROVEEDOR ================//
		
		//================ ACEPTAR-CANCELAR BUTTONS ================//
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		        cmdRegistroUsuarioActionPerformed(arg0);
		    }
		});
        //================ APELLIDO ================//
        
        //================ EMAIL ================//
        lblIngreseEmail = new JLabel("Email:");
        lblIngreseEmail.setHorizontalAlignment(SwingConstants.CENTER);
        
                textFieldApellido = new JTextField();
                textFieldApellido.setToolTipText("Ingrese su apellido");
                textFieldApellido.setColumns(10);
        //================ EMAIL ================//
        
        //================ FECHA DE NACIMIENTO ================//
        
        //================ FECHA DE NACIMIENTO ================//
        
        //================ RADIO BUTTONS TURISTA_PROVEEDOR ================//
        lblIngreseTipoUsuario = new JLabel("Tipo Usuario:");
        lblIngreseTipoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
        provBtn = new JRadioButton(prov);
        provBtn.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        	    if (e.getStateChange() == ItemEvent.SELECTED) {
        	    	//setVisible(true);
//                  //================ INFO PROVEEDOR ================//
//                  //================ INFO PROVEEDOR ================//
        	    }
        	    else if (e.getStateChange() == ItemEvent.DESELECTED) {
        	    	//setVisible(false);
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
                //================ INFO TURISTA ================//
                lblNacionalidad = new JLabel("Nacionalidad:");
                lblNacionalidad.setHorizontalAlignment(SwingConstants.RIGHT);
                GridBagConstraints gbc_lblNacionalidad = new GridBagConstraints();
                gbc_lblNacionalidad.fill = GridBagConstraints.BOTH;
                gbc_lblNacionalidad.insets = new Insets(0, 0, 5, 5);
                gbc_lblNacionalidad.gridx = 0;
                gbc_lblNacionalidad.gridy = 2;
                getContentPane().add(lblNacionalidad, gbc_lblNacionalidad);
                
                textFieldNacionalidad = new JTextField();
                textFieldNacionalidad.setToolTipText("Ingrese su Nacionalidad");
                textFieldNacionalidad.setColumns(10);
                GridBagConstraints gbc_textFieldNacionalidad = new GridBagConstraints();
                gbc_textFieldNacionalidad.gridwidth = 2;
                gbc_textFieldNacionalidad.fill = GridBagConstraints.BOTH;
                gbc_textFieldNacionalidad.insets = new Insets(0, 0, 5, 0);
                gbc_textFieldNacionalidad.gridx = 1;
                gbc_textFieldNacionalidad.gridy = 2;
                getContentPane().add(textFieldNacionalidad, gbc_textFieldNacionalidad);
                //================ INFO TURISTA ================//
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
                groupLayout.setHorizontalGroup(
                	groupLayout.createParallelGroup(Alignment.LEADING)
                		.addGroup(groupLayout.createSequentialGroup()
                			.addGap(6)
                			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                				.addGroup(groupLayout.createSequentialGroup()
                					.addComponent(lblIngreseNickName, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                					.addGap(6)
                					.addComponent(textFieldNickName, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
                				.addGroup(groupLayout.createSequentialGroup()
                					.addComponent(lblIngreseNombre, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                					.addGap(6)
                					.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
                				.addGroup(groupLayout.createSequentialGroup()
                					.addComponent(lblIngreseApellido, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                					.addGap(6)
                					.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
                				.addGroup(groupLayout.createSequentialGroup()
                					.addComponent(lblIngreseEmail, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                					.addGap(6)
                					.addComponent(textFieldApellido, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE))
                				.addGroup(groupLayout.createSequentialGroup()
                					.addComponent(lblIngreseTipoUsuario, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
                					.addGap(15)
                					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                						.addGroup(groupLayout.createSequentialGroup()
                							.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                							.addGap(18)
                							.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
                						.addGroup(groupLayout.createSequentialGroup()
                							.addComponent(provBtn)
                							.addGap(46)
                							.addComponent(turBtn)))))
                			.addContainerGap())
                );
                groupLayout.setVerticalGroup(
                	groupLayout.createParallelGroup(Alignment.LEADING)
                		.addGroup(groupLayout.createSequentialGroup()
                			.addGap(6)
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
                				.addComponent(lblIngreseEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                				.addComponent(textFieldApellido, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                			.addPreferredGap(ComponentPlacement.RELATED)
                			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
                				.addComponent(lblIngreseTipoUsuario, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                				.addComponent(provBtn)
                				.addComponent(turBtn))
                			.addPreferredGap(ComponentPlacement.RELATED)
                			.addComponent(panel, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                			.addPreferredGap(ComponentPlacement.UNRELATED)
                			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
                				.addComponent(btnAceptar)
                				.addComponent(btnCancelar))
                			.addContainerGap())
                );
                
                lblNacionalidad_1 = new JLabel("Nacionalidad");
                lblNacionalidad_1.setHorizontalAlignment(SwingConstants.CENTER);
                
                textField = new JTextField();
                textField.setColumns(10);
                
                JLabel lblSitioWeb_1 = new JLabel("Sitio Web");
                lblSitioWeb_1.setHorizontalAlignment(SwingConstants.CENTER);
                
                textField_1 = new JTextField();
                textField_1.setColumns(10);
                
                JLabel lblDescripcion = new JLabel("Descripcion");
                lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
                
                JTextPane textPane = new JTextPane();
                GroupLayout gl_panel = new GroupLayout(panel);
                gl_panel.setHorizontalGroup(
                	gl_panel.createParallelGroup(Alignment.LEADING)
                		.addGroup(gl_panel.createSequentialGroup()
                			.addGap(21)
                			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                				.addComponent(lblNacionalidad_1)
                				.addComponent(lblSitioWeb_1)
                				.addComponent(lblDescripcion))
                			.addPreferredGap(ComponentPlacement.RELATED)
                			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
                				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                				.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
                			.addContainerGap(270, Short.MAX_VALUE))
                );
                gl_panel.setVerticalGroup(
                	gl_panel.createParallelGroup(Alignment.LEADING)
                		.addGroup(gl_panel.createSequentialGroup()
                			.addGap(8)
                			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                				.addComponent(lblNacionalidad_1)
                				.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                			.addGap(8)
                			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
                				.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                				.addComponent(lblSitioWeb_1))
                			.addPreferredGap(ComponentPlacement.UNRELATED)
                			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
                				.addComponent(lblDescripcion)
                				.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                			.addContainerGap())
                );
                panel.setLayout(gl_panel);
                groupLayout.setAutoCreateGaps(true);
                groupLayout.setAutoCreateContainerGaps(true);
                getContentPane().setLayout(groupLayout);
        //================ ACEPTAR-CANCELAR BUTTONS ================//
    }

    protected void cmdRegistroUsuarioActionPerformed(ActionEvent arg0) {
    	String nickname = this.textFieldNickName.getText();
        String nombre = this.textFieldNombre.getText();
        String apellido = this.textFieldApellido.getText();
        String email = this.textFieldEmail.getText();
//        castear la fecha a tipo Date
        Date fechaNac = new Date();
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
                ctrlUsr.altaUsuario(nickname, email, nombre, apellido, fechaNac, tipo, nacionalidad, descripcion, sitioWeb);

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
                JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Usuario",
                        JOptionPane.ERROR_MESSAGE);
                return false;
        	}
        }
        if (usrTypeSelected == "Proveedor") {
        	String descripcion = this.textFieldDescripcion.getText();
        	if (descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Usuario",
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
