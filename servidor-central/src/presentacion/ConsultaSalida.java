package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
import javax.swing.JRadioButton;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JPanel;

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
	private JComboBox<String> 	ComboBoxSelDepartamento;
	private boolean settear;
	
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
				
				/////////////////SELECCIONAR DEPARTAMENTO////////////////////////////////////
				LabelSelcDepartamento = new JLabel("Seleccionar departamento: ");
				LabelSelcDepartamento.setHorizontalAlignment(SwingConstants.RIGHT);
				
				
			 ComboBoxSelDepartamento = new JComboBox();
				Set<String> departamentos = iCS.listarDepartamentos();
		        departamentos.forEach((d)->{
		        	ComboBoxSelDepartamento.addItem(d);
		        });
				
				JRadioButton depto = new JRadioButton("Confirmar Depto.");
				
				
				
				/////////////////SELECCIONAR ACTIVIDAD//////////////////////////////////////////////
				
				JLabel lblNewLabel = new JLabel("Seleccionar Actividad:");
				lblNewLabel.setEnabled(false);
				
				JComboBox<String> comboBox_1 = new JComboBox();
				comboBox_1.setEnabled(false);
				
				JRadioButton rdbtnNewRadioButton = new JRadioButton("Confirmar Act.");
				rdbtnNewRadioButton.setEnabled(false);
				
				JLabel lblNewLabel_1 = new JLabel("Seleccionar Salida Turistica:");
				lblNewLabel_1.setEnabled(false);
				
				JComboBox<String> comboBoxSal = new JComboBox();
				comboBoxSal.setEnabled(false);
				
				JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Confirmar Salida");
				rdbtnNewRadioButton_1.setEnabled(false);
				
				JLabel lblNewLabel_2 = new JLabel("INFORMACION DE LA SALIDA:");
				
				JLabel lblNewLabel_3 = new JLabel("Nombre:");
				
				textField_2 = new JTextField();
				textField_2.setEnabled(false);
				textField_2.setColumns(10);
				
				JLabel lblNewLabel_4 = new JLabel("Lugar:");
				
				textField_8 = new JTextField();
				textField_8.setEnabled(false);
				textField_8.setColumns(10);
				
				JLabel lblNewLabel_5 = new JLabel("Cantidad max. Turistas:");
				
				textField_7 = new JTextField();
				textField_7.setEnabled(false);
				textField_7.setColumns(10);
				
				JLabel lblNewLabel_6 = new JLabel("Fecha Alta:");
				
				textField_9 = new JTextField();
				textField_9.setEnabled(false);
				textField_9.setColumns(10);
				
				JLabel lblNewLabel_7 = new JLabel("Fecha Salida:");
				
				textField_10 = new JTextField();
				textField_10.setEditable(false);
				//textField_10.setEnabled(false);
				textField_10.setColumns(10);
				
				JLabel lblNewLabel_8 = new JLabel("Turistas Inscriptos:");
				
				JButton btnNewButton = new JButton("Confirmar");
				btnNewButton.setEnabled(false);
				
				JButton btnNewButton_1 = new JButton("Cancelar");
				
				JPanel panelAux = new JPanel();
				GroupLayout groupLayout = new GroupLayout(getContentPane());
				groupLayout.setHorizontalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(LabelSelcDepartamento)
							.addGap(5)
							.addComponent(ComboBoxSelDepartamento, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(depto))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(67)
							.addComponent(lblNewLabel)
							.addGap(5)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(rdbtnNewRadioButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(lblNewLabel_1)
							.addGap(5)
							.addComponent(comboBoxSal, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(rdbtnNewRadioButton_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(129)
							.addComponent(lblNewLabel_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(151)
							.addComponent(lblNewLabel_3)
							.addGap(5)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(166)
							.addComponent(lblNewLabel_4)
							.addGap(5)
							.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(55)
							.addComponent(lblNewLabel_5)
							.addGap(5)
							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(136)
							.addComponent(lblNewLabel_6)
							.addGap(5)
							.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(124)
							.addComponent(lblNewLabel_7)
							.addGap(5)
							.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(83)
							.addComponent(lblNewLabel_8)
							.addGap(18)
							.addComponent(panelAux, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(198)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnNewButton_1))
				);
				groupLayout.setVerticalGroup(
					groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(15)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(LabelSelcDepartamento, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(ComboBoxSelDepartamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(depto)))
							.addGap(5)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(lblNewLabel))
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(rdbtnNewRadioButton)))
							.addGap(5)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(lblNewLabel_1))
								.addComponent(comboBoxSal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(2)
									.addComponent(rdbtnNewRadioButton_1)))
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addComponent(lblNewLabel_2)
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(lblNewLabel_3))
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(5)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(lblNewLabel_4))
								.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(5)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(lblNewLabel_5))
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(5)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(lblNewLabel_6))
								.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(5)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(5)
									.addComponent(lblNewLabel_7))
								.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(lblNewLabel_8))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(15)
									.addComponent(panelAux, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton_1)
								.addComponent(btnNewButton))
							.addContainerGap())
				);
				getContentPane().setLayout(groupLayout);
				pack();
				
				//////////////////////////////////Habilito actividad ///////////////////////////////////////////////////////
				
				
				   depto.addActionListener(new ActionListener(){
			    	    public void actionPerformed(ActionEvent e) {
			    	    if( ComboBoxSelDepartamento.getSelectedIndex() == -1) return;
			    	    comboBox_1.setEnabled(true);
			    	    lblNewLabel.setEnabled(true);
			    	    lblNewLabel_1.setEnabled(true);
			    	    rdbtnNewRadioButton.setEnabled(true);
			    	    
			    	    settear = false;
			    	    comboBox_1.removeAllItems();
			    	    Set<String> actividades = iCS.listarActividadesDepartamento(ComboBoxSelDepartamento.getSelectedItem().toString() );
			    	        actividades.forEach((act)->{
			    	        	
			    	           comboBox_1.addItem(act);
			    	          
			    	        });
			    	        settear =true;
			    	    }
			  
		        	
				}); ///muestro salidas de esa actividad
				   rdbtnNewRadioButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						if(!settear  || ComboBoxSelDepartamento.getSelectedIndex() == -1  || comboBox_1.getSelectedIndex()==-1)return;
						 rdbtnNewRadioButton_1.setEnabled(true);
							
						 settear =false;
						 comboBoxSal.removeAllItems();
						 
						 comboBoxSal.setEnabled(true);
					
						Set<String> salidas = iCS.listarNombresSalidasDeActividad(comboBox_1.getSelectedItem().toString());
						if (salidas.isEmpty())return;
		        	        salidas.forEach((sal)->{
		        	        
		        	        	comboBoxSal.addItem(sal);
		        	        });
		        	        settear =true;
					}
				});
				   rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						if(!settear || comboBox_1.getSelectedIndex()== -1 || ComboBoxSelDepartamento.getSelectedIndex() == -1 || comboBoxSal.getSelectedIndex()==-1) return;
					DTSalida res = iCS.getInfoCompletaSalida(comboBoxSal.getSelectedItem().toString());
					textField_2.setText(res.getNombre());
					textField_8.setText(res.getlugarSalida());
					textField_7.setText(String.valueOf(res.getcantidadMaximaDeTuristas()));
					textField_9.setText(String.valueOf(fechaStringFormato(res.getfechaAlta(), true)));
					textField_10.setText(String.valueOf(fechaStringFormato(res.getfechaSalida(), false)));
					Set<String > aux = res.getTuristasInscriptos();
					  String[] arrayOfString = new String[aux.size()];
					  
				        // Copy elements from set to string array
				        // using advanced for loop
				        int index = 0;
				        for (String str : aux)
				            arrayOfString[index++] = str;
				        
					JList auxx = (JList) Arrays.asList(arrayOfString);
					panelAux.add(auxx);
					
				}
				});
				
				
				
	}
	public void cargarDatos() {
		
		  Set<String> departamentos = ctrlSalida.listarDepartamentos();
	      departamentos.forEach((d)->{
	    		ComboBoxSelDepartamento.addItem(d);
	      });
	      
	     
	}
	
	public String fechaStringFormato(GregorianCalendar g, boolean conHora) {
		String dia = String.valueOf(g.get(g.DAY_OF_MONTH));
		String mes = String.valueOf(g.get(g.MONTH));
		String anio = String.valueOf(g.get(g.YEAR));
		String hora = String.valueOf(g.get(g.HOUR));
		String resultado = (conHora)?
				 dia + "/" + mes + "/" + anio + " " + hora + "hs": dia + "/" + mes + "/" + anio;
		return resultado;
	}
}
		