package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import excepciones.YaExisteException;

import javax.swing.JTextArea;

import logica.interfaces.ICtrlActividad;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class CrearPaquete extends JInternalFrame{
	//Interfaces
	private ICtrlActividad controlAct;
	
	//Componentes graficos
	private JLabel lblNombre;
	private JLabel lblDescripcion;
	private JLabel lblPeriodoValidez;
	private JLabel lblDescuento;
	private JTextField textFieldNombre;
	private JTextArea textAreaDescripcion;
	private JTextField textFieldPeriodoValidez;
	private JTextField textFieldDescuento;
	private JButton btnAceptar;
	private JButton btnCerrar;
	
	public CrearPaquete(ICtrlActividad ica) {
		setMaximizable(true);
		controlAct = ica;
		
		setResizable(true);
        setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Crear Paquete de Actividades Turisticas");
        setBounds(30, 30, 345, 341);
        
        lblNombre = new JLabel("Nombre:");
        lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDescripcion = new JLabel("Descripcion:");
        lblDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPeriodoValidez = new JLabel("Periodo de Validez:");
        lblPeriodoValidez.setHorizontalAlignment(SwingConstants.RIGHT);
        lblDescuento = new JLabel("Descuento:");
        lblDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
        
        textFieldNombre = new JTextField();
        textFieldNombre.setToolTipText("Ingrese el nombre del paquete");
        textAreaDescripcion = new JTextArea();
        textAreaDescripcion.setToolTipText("Ingrese la descripcion del paquete");
        textFieldPeriodoValidez = new JTextField();
        textFieldPeriodoValidez.setToolTipText("Ingrese el periodo de validez del paquete en dias");
        textFieldDescuento = new JTextField();
        textFieldDescuento.setToolTipText("Ingrese el costo del paquete");
        
        textAreaDescripcion.setWrapStyleWord(true);
        textAreaDescripcion.setLineWrap(true);
        
        btnCerrar = new JButton("Cancelar");
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	limpiarFormulario();
                setVisible(false);
            }
        });
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		cmdCrearPaqueteActionPerformed(arg0);
        	}
        });
        
        //Layout
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(24)
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblDescuento)
        				.addComponent(lblPeriodoValidez))
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(textFieldDescuento)
        				.addComponent(textFieldPeriodoValidez, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
        			.addGap(43))
        		.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
        			.addContainerGap(155, Short.MAX_VALUE)
        			.addComponent(btnAceptar)
        			.addGap(18)
        			.addComponent(btnCerrar)
        			.addContainerGap())
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(24)
        					.addComponent(lblNombre))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblDescripcion)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(textAreaDescripcion)
        				.addComponent(textFieldNombre, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
        			.addContainerGap(27, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(17)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblNombre))
        			.addGap(27)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(textAreaDescripcion, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblDescripcion))
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPeriodoValidez)
        				.addComponent(textFieldPeriodoValidez, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblDescuento)
        				.addComponent(textFieldDescuento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnCerrar)
        				.addComponent(btnAceptar))
        			.addContainerGap())
        );
        getContentPane().setLayout(groupLayout);
        
	}
	
	protected void cmdCrearPaqueteActionPerformed(ActionEvent arg0) {
		if(checkFormulario()) {
			String nombre = textFieldNombre.getText();
			String descripcion = textAreaDescripcion.getText();
			int periodoValidez = Integer.valueOf(textFieldPeriodoValidez.getText());
			float descuento = Float.valueOf(textFieldDescuento.getText());
			
			
			try {
				controlAct.crearPaquete(nombre, descripcion, periodoValidez, descuento, new GregorianCalendar());
				
				JOptionPane.showMessageDialog(this, "El paquete ha sido creado con exito", "Crear Paquete de Actividades Turisticas", JOptionPane.INFORMATION_MESSAGE);
				limpiarFormulario();
	            setVisible(false);
			} catch (YaExisteException e) {
				JOptionPane.showMessageDialog(this, e.getMessage(), "Inscripcion a Salida Turistica", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void limpiarFormulario() {
		textFieldNombre.setText("");
		textAreaDescripcion.setText("");
		textFieldPeriodoValidez.setText("");
		textFieldDescuento.setText("");
	}
	
	private boolean checkFormulario() {
		if(textFieldNombre.getText().isEmpty() || textAreaDescripcion.getText().isEmpty() || 
				textFieldDescuento.getText().isEmpty() || textFieldPeriodoValidez.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Crear Paquete de Actividades Turisticas", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			try {
				Integer number = Integer.valueOf(textFieldPeriodoValidez.getText());
				if(number <=0)
					throw new NumberFormatException();
				
				try {
					Float aux = Float.valueOf(textFieldDescuento.getText());
					if(aux<=0)
						throw new NumberFormatException();
					
				} catch(NumberFormatException ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(this, "El descuento debe ser un numero positivo", "Crear Paquete de Actividades Turisticas", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			} catch(NumberFormatException ex){
				ex.printStackTrace();
				JOptionPane.showMessageDialog(this, "El periodo de validez debe ser un numero entero positivo", "Crear Paquete de Actividades Turisticas", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		
		return true;
	}
}