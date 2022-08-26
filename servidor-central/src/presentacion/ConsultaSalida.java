package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import datatypes.DTSalida;
import excepciones.IncompleteException;
import excepciones.YaExisteException;
import logica.interfaces.ICtrlActividad;
import java.awt.Color;
import javax.swing.JButton;

public class ConsultaSalida extends JInternalFrame {

	//Controlador
	private ICtrlActividad ctrlSalida;
	//Basicos
	private JLabel LabelSelcDepartamento;


	//Si el usuario es proveedor

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_2;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	
	@SuppressWarnings("rawtypes")
	public ConsultaSalida(ICtrlActividad iCS) {
		getContentPane().setForeground(Color.PINK);
		//meto la interfaz
		this.ctrlSalida = iCS;
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
				
				@SuppressWarnings("unchecked")
				JComboBox <String> ComboBoxSelDepartamento = new JComboBox();
				GridBagConstraints gbc_comboBox = new GridBagConstraints();
				gbc_comboBox.gridwidth = 2;
				gbc_comboBox.insets = new Insets(0, 0, 5, 0);
				gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBox.gridx = 2;
				gbc_comboBox.gridy = 2;
				getContentPane().add(ComboBoxSelDepartamento, gbc_comboBox);
				Set<String> departamentos = iCS.listarDepartamentos();
		        departamentos.forEach((d)->{
		        	ComboBoxSelDepartamento.addItem(d);
		        });
				
				
				
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
				
				JLabel lblNewLabel_1 = new JLabel("Seleccionar Salida Turistica:");
				lblNewLabel_1.setEnabled(false);
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.gridx = 1;
				gbc_lblNewLabel_1.gridy = 4;
				getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
				
				JComboBox comboBoxSal = new JComboBox();
				comboBoxSal.setEnabled(false);
				GridBagConstraints gbc_comboBoxSal = new GridBagConstraints();
				gbc_comboBoxSal.gridwidth = 2;
				gbc_comboBoxSal.insets = new Insets(0, 0, 5, 0);
				gbc_comboBoxSal.fill = GridBagConstraints.HORIZONTAL;
				gbc_comboBoxSal.gridx = 2;
				gbc_comboBoxSal.gridy = 4;
				getContentPane().add(comboBoxSal, gbc_comboBoxSal);
				
				JLabel lblNewLabel_2 = new JLabel("INFORMACION DE LA SALIDA:");
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.gridwidth = 3;
				gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_2.gridx = 1;
				gbc_lblNewLabel_2.gridy = 6;
				getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
				
				JLabel lblNewLabel_3 = new JLabel("Nombre:");
				GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
				gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_3.gridx = 1;
				gbc_lblNewLabel_3.gridy = 7;
				getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
				
				textField_2 = new JTextField();
				GridBagConstraints gbc_textField_2 = new GridBagConstraints();
				gbc_textField_2.gridwidth = 2;
				gbc_textField_2.insets = new Insets(0, 0, 5, 0);
				gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_2.gridx = 2;
				gbc_textField_2.gridy = 7;
				getContentPane().add(textField_2, gbc_textField_2);
				textField_2.setColumns(10);
				
				JLabel lblNewLabel_4 = new JLabel("Lugar:");
				GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
				gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_4.gridx = 1;
				gbc_lblNewLabel_4.gridy = 8;
				getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
				
				textField_8 = new JTextField();
				GridBagConstraints gbc_textField_8 = new GridBagConstraints();
				gbc_textField_8.gridwidth = 2;
				gbc_textField_8.insets = new Insets(0, 0, 5, 0);
				gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_8.gridx = 2;
				gbc_textField_8.gridy = 8;
				getContentPane().add(textField_8, gbc_textField_8);
				textField_8.setColumns(10);
				
				JLabel lblNewLabel_5 = new JLabel("Cantidad max. Turistas:");
				GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
				gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_5.gridx = 1;
				gbc_lblNewLabel_5.gridy = 9;
				getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
				
				textField_7 = new JTextField();
				GridBagConstraints gbc_textField_7 = new GridBagConstraints();
				gbc_textField_7.gridwidth = 2;
				gbc_textField_7.insets = new Insets(0, 0, 5, 0);
				gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_7.gridx = 2;
				gbc_textField_7.gridy = 9;
				getContentPane().add(textField_7, gbc_textField_7);
				textField_7.setColumns(10);
				
				JLabel lblNewLabel_6 = new JLabel("Fecha Alta:");
				GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
				gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_6.gridx = 1;
				gbc_lblNewLabel_6.gridy = 10;
				getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
				
				textField_9 = new JTextField();
				GridBagConstraints gbc_textField_9 = new GridBagConstraints();
				gbc_textField_9.gridwidth = 2;
				gbc_textField_9.insets = new Insets(0, 0, 5, 5);
				gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_9.gridx = 2;
				gbc_textField_9.gridy = 10;
				getContentPane().add(textField_9, gbc_textField_9);
				textField_9.setColumns(10);
				
				JLabel lblNewLabel_7 = new JLabel("Fecha Salida:");
				GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
				gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_7.gridx = 1;
				gbc_lblNewLabel_7.gridy = 11;
				getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
				
				textField_10 = new JTextField();
				GridBagConstraints gbc_textField_10 = new GridBagConstraints();
				gbc_textField_10.gridwidth = 2;
				gbc_textField_10.insets = new Insets(0, 0, 5, 5);
				gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_10.gridx = 2;
				gbc_textField_10.gridy = 11;
				getContentPane().add(textField_10, gbc_textField_10);
				textField_10.setColumns(10);
				
				JLabel lblNewLabel_8 = new JLabel("Turistas Inscriptos:");
				GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
				gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_8.gridx = 1;
				gbc_lblNewLabel_8.gridy = 12;
				getContentPane().add(lblNewLabel_8, gbc_lblNewLabel_8);
				
				textField_11 = new JTextField();
				GridBagConstraints gbc_textField_11 = new GridBagConstraints();
				gbc_textField_11.gridwidth = 2;
				gbc_textField_11.insets = new Insets(0, 0, 5, 5);
				gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_11.gridx = 2;
				gbc_textField_11.gridy = 12;
				getContentPane().add(textField_11, gbc_textField_11);
				textField_11.setColumns(10);
				
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
		        	
				}); ///muestro salidas de esa actividad
				comboBox_1.addActionListener(new ActionListener() {
					
					
					@SuppressWarnings("unchecked")
					public void actionPerformed(ActionEvent e) {
						 Set<String> salidas = iCS.listarNombresSalidasDeActividad(comboBox_1.getSelectedItem().toString());
		        	        salidas.forEach((sal)->{
		        	        	comboBoxSal.setEnabled(true);
		        	        	comboBoxSal.addItem(sal);
		        	        });
					}
				});
				comboBoxSal.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					DTSalida res = iCS.getInfoCompletaSalida(comboBoxSal.getSelectedItem().toString());
					textField_2.setText(res.getNombre());
					textField_8.setText(res.getlugarSalida());
					//textField_7.setValue(res.getcantidadMaximaDeTuristas());
					textField_8.setText(res.getlugarSalida());
					
					
				}
				});
				
				
	}
}
		