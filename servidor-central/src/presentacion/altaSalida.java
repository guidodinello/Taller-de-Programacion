package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

//import excepciones.IncompleteException;
//import excepciones.YaExisteException;
import logica.interfaces.ICtrlActividad;
import java.awt.Color;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class altaSalida extends JInternalFrame {

	//Controlador
	private ICtrlActividad ctrlSalida;
	//Basicos
	private JLabel LabelSelcDepartamento;


	//Si el usuario es proveedor

	private JComboBox<String> ComboBoxSelDepartamento;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	@SuppressWarnings("rawtypes")
	public altaSalida(ICtrlActividad iCS) {
		getContentPane().setForeground(Color.PINK);
		//meto la interfaz
		this.ctrlSalida = iCS;
		
		//Cuestiones de configuracion del frame
		setResizable(true);
		setIconifiable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setTitle("Alta de Salida turistica");
				
		setBounds(30, 30, 453, 431);
				
		GridBagLayout gbl = new GridBagLayout();
		gbl.columnWidths = new int[] { 0, 100, 120, 120, 0 };
		gbl.rowHeights = new int[] { 0, 0, 30, 30, 30, 30, 30, 30, 0, 30, 30, 30, 30, 30, 30, 0, 0 };
		gbl.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gbl);
		
		/////////////////SELECCIONAR DEPARTAMENTO////////////////////////////////////
		LabelSelcDepartamento = new JLabel("Seleccionar departamento: ");
		LabelSelcDepartamento.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_labelSelcDepartamento = new GridBagConstraints();
		gbc_labelSelcDepartamento.anchor = GridBagConstraints.EAST;
		gbc_labelSelcDepartamento.fill = GridBagConstraints.VERTICAL;
		gbc_labelSelcDepartamento.insets = new Insets(0, 0, 5, 5);
		gbc_labelSelcDepartamento.gridx = 1;
		gbc_labelSelcDepartamento.gridy = 2;
		getContentPane().add(LabelSelcDepartamento, gbc_labelSelcDepartamento);
		
		//@SuppressWarnings("unchecked")
		ComboBoxSelDepartamento = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 2;
		getContentPane().add(ComboBoxSelDepartamento, gbc_comboBox);
			
		
		/////////////////SELECCIONAR ACTIVIDAD//////////////////////////////////////////////
		
		JLabel lblNewLabel = new JLabel("Seleccionar Actividad:");
		lblNewLabel.setEnabled(false);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 3;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 2;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 3;
		getContentPane().add(comboBox_1, gbc_comboBox_1);
		
		//////////////////////////////////Habilito actividad ///////////////////////////////////////////////////////
		
		
		ComboBoxSelDepartamento.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		lblNewLabel.setEnabled(true);
        		comboBox_1.setEnabled(true);
        		comboBox_1.removeAllItems();
        		//cargo la lista de actividades 
        		 Set<String> actividades = iCS.listarActividadesDepartamento(ComboBoxSelDepartamento.getSelectedItem().toString() );
        	        actividades.forEach((act)->{
        	        	comboBox_1.addItem(act);
        	        });
        			
        		
        	}
        	
		});
		
		
	/////////////////////////////ALTA DE LA SALIDA////////////////////////////////////////////////////////////////////////////////////
		
		JLabel lblNewLabel_1 = new JLabel("DATOS DEL ALTA DE LA SALIDA:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 5;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setEnabled(false);
		lblNewLabel_2.setToolTipText("El nombre debe ser unico en el sistema");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 6;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField = new JTextField();
		textField.setEnabled(false);
		
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 6;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha:");
		lblNewLabel_4.setEnabled(false);
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 7;
		getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 7;
		getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Hora:");
		lblNewLabel_3.setEnabled(false);
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 8;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 8;
		getContentPane().add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Lugar:");
		lblNewLabel_5.setEnabled(false);
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 9;
		getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 9;
		getContentPane().add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Maxima cant. de Turistas");
		lblNewLabel_6.setEnabled(false);
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 10;
		getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 10;
		getContentPane().add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Facha de alta:");
		lblNewLabel_7.setEnabled(false);
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 11;
		getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 2;
		gbc_textField_6.gridy = 11;
		getContentPane().add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar ");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 13;
		
		getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 13;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		 btnNewButton.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e) {
				 
				//  altaSalidaTuristica(String nombreSal, GregorianCalendar fechaSal, String lugarSal,int cantMaxTuristas,GregorianCalendar fechaAlta, String actividad)throws YaExisteException;
		String nombreSal = textField.getSelectedText();
		String sAct = comboBox_1.getSelectedItem().toString();
		String fechaA= textField_6.getSelectedText();
		DateFormat df = new SimpleDateFormat("dd MM yyyy");
		//if(fechaA != null)
		//Date date = df.parse(fechaA);
		Calendar cal = new GregorianCalendar();
		String fechaS= textField_1.getSelectedText();
		DateFormat df2 = new SimpleDateFormat("dd MM yyyy");
		//if(fechaS != null)
		//Date date2 = df2.parse(fechaS);
		Calendar cal2 = new GregorianCalendar();
		String lugarS= textField_4.getSelectedText();
		String cantT =textField_5.getSelectedText();
	

					if(nombreSal != null && sAct != null && fechaA != null && fechaS != null && lugarS != null && cantT != null) {
						
						int CantT = Integer.parseInt(cantT);
						//TODO GREGORIAN CALENDAR INSTEAD OR CALENDAR
						//GregorianCalendar fechaSalida = new GregorianCalendar(anio, mes, dia, hora);//anio mes dia y hora vienen del cliente ingresnado
						 //iCS.altaSalidaTuristica(nombreSal,fechaSalida, lugarS,CantT, new GregorianCalendar(), sAct);	
					}
					
					//else throw new IncompleteException("rellene todos los campos");
				
			 }
		 });
		
		
		comboBox_1.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		lblNewLabel_2.setEnabled(true);
        		lblNewLabel_3.setEnabled(true);
        		lblNewLabel_4.setEnabled(true);
        		lblNewLabel_5.setEnabled(true);
        		lblNewLabel_6.setEnabled(true);
        		lblNewLabel_7.setEnabled(true);
        		textField.setEnabled(true);
        		textField_1.setEnabled(true);
        		textField_3.setEnabled(true);
        		textField_4.setEnabled(true);
        		textField_5.setEnabled(true);
        		textField_6.setEnabled(true);
        		
        			
        		
        	}
        	
		});
	
       
	}
	
	public void cargarDatos() {
        Set<String> departamentos = ctrlSalida.listarDepartamentos();
        departamentos.forEach((d)->{
        	ComboBoxSelDepartamento.addItem(d);
        });
	}
}
	
	
