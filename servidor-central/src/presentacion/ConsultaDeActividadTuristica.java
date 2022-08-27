package presentacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import logica.interfaces.ICtrlActividad;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import datatypes.DTActividad;

@SuppressWarnings("serial")
public class ConsultaDeActividadTuristica extends JInternalFrame{
	//Interfaces
		private ICtrlActividad controlAct;
		//Componentes graficos
		private JComboBox<String> comboBoxDepartamentos;
		private JComboBox<String> comboBoxActividades;
		private JComboBox<String> comboBoxSalidas;
		private JLabel lblDepartamentos;
		private JLabel lblActividades;
		private JLabel lblSalidas;
		private JLabel lblNombre;
		private JLabel lblDescr;
		private JLabel lblDuracion;
		private JLabel lblCosto;
		private JTextField textFieldNombre;
		private JTextArea textAreaDescr;
		private JTextField textFieldDuracion;
		private JTextField textFieldCosto;
		private JButton btnCerrar;
		
		private boolean borrandoFormularios = false;
		
		public ConsultaDeActividadTuristica(ICtrlActividad ica) {
			setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			
			setMaximizable(true);
			controlAct = ica;
			setBounds(30, 30, 654, 501);
			setResizable(true);
	        setIconifiable(true);
	        
	        setClosable(true);
	        setTitle("Consulta de Actividad Turistica");
	        
	        
	        lblDepartamentos = new JLabel("Departamento:");
	        lblDepartamentos.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblActividades = new JLabel("Actividad:");
	        lblActividades.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblSalidas = new JLabel("Salidas:");
	        lblSalidas.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblNombre = new JLabel("Nombre:");
	        lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblDescr = new JLabel("Descripcion:");
	        lblDescr.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblDuracion = new JLabel("Duracion(hs):");
	        lblDuracion.setHorizontalAlignment(SwingConstants.RIGHT);
	        lblCosto = new JLabel("Costo:");
	        lblCosto.setHorizontalAlignment(SwingConstants.RIGHT);
	        
	        comboBoxDepartamentos = new JComboBox<String>();
	        comboBoxDepartamentos.setEnabled(true);
	        comboBoxDepartamentos.setToolTipText("Seleccione un departamento");
	        comboBoxActividades = new JComboBox<String>();
	        comboBoxActividades.setEnabled(false);
	        comboBoxActividades.setToolTipText("Seleccione una actividad");
	        comboBoxSalidas = new JComboBox<String>();
	        comboBoxSalidas.setEnabled(false);
	        comboBoxSalidas.setToolTipText("Seleccone una salida para consulta");
	        
	        textFieldNombre = new JTextField();
	        textFieldNombre.setEnabled(false);
	        textFieldNombre.setBackground(Color.LIGHT_GRAY);
	        textFieldNombre.setDisabledTextColor(Color.black);
	        textAreaDescr = new JTextArea();
	        textAreaDescr.setEnabled(false);
	        textAreaDescr.setDisabledTextColor(Color.black);
	        textAreaDescr.setBackground(Color.LIGHT_GRAY);
	        textFieldDuracion = new JTextField();
	        textFieldDuracion.setEnabled(false);
	        textFieldDuracion.setDisabledTextColor(Color.black);
	        textFieldDuracion.setBackground(Color.LIGHT_GRAY);
	        textFieldCosto = new JTextField();
	        textFieldCosto.setEnabled(false);
	        textFieldCosto.setDisabledTextColor(Color.black);
	        textFieldCosto.setBackground(Color.LIGHT_GRAY);
	        
	        textAreaDescr.setWrapStyleWord(true);
	        textAreaDescr.setLineWrap(true);
	        
	        btnCerrar = new JButton("Cerrar");
	        btnCerrar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	limpiarFormulario();
	                setVisible(false);
	            }
	        });
	        
	        comboBoxDepartamentos.addActionListener(new ActionListener( ) {
	        	public void actionPerformed(ActionEvent arg0) {
	        		if(!borrandoFormularios) {
	        			cargarActividades(comboBoxDepartamentos.getSelectedItem().toString());
	        			comboBoxActividades.setEnabled(true);
	        			borrandoFormularios = true;
	        			comboBoxSalidas.removeAllItems();
	        			borrandoFormularios = false;
	        			comboBoxSalidas.setEnabled(false);
	        			limpiarInformacion();
	        		}
	        	}
	        });
	        
	        comboBoxActividades.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		if(!borrandoFormularios) {
	        			cargarInformacionActividad(comboBoxActividades.getSelectedItem().toString());
	        			comboBoxSalidas.setEnabled(true);
	        		}
	        	}
	        });
	        
	        //Layout
	        GroupLayout groupLayout = new GroupLayout(getContentPane());
	        groupLayout.setHorizontalGroup(
	        	groupLayout.createParallelGroup(Alignment.TRAILING)
	        		.addGroup(groupLayout.createSequentialGroup()
	        			.addContainerGap()
	        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
	        				.addGroup(groupLayout.createSequentialGroup()
	        					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
	        						.addGroup(groupLayout.createSequentialGroup()
	        							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	        								.addComponent(lblDepartamentos)
	        								.addComponent(lblNombre)
	        								.addComponent(lblActividades)
	        								.addComponent(lblCosto))
	        							.addGap(18)
	        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
	        								.addGroup(groupLayout.createSequentialGroup()
	        									.addComponent(textFieldCosto, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
	        									.addPreferredGap(ComponentPlacement.RELATED)
	        									.addComponent(lblDuracion, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
	        									.addPreferredGap(ComponentPlacement.RELATED)
	        									.addComponent(textFieldDuracion, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
	        								.addComponent(comboBoxActividades, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
	        								.addComponent(comboBoxDepartamentos, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
	        								.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)))
	        						.addGroup(groupLayout.createSequentialGroup()
	        							.addGap(14)
	        							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	        								.addComponent(lblDescr)
	        								.addComponent(lblSalidas))
	        							.addGap(18)
	        							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
	        								.addComponent(comboBoxSalidas, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
	        								.addComponent(textAreaDescr, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE))))
	        					.addGap(82))
	        				.addGroup(groupLayout.createSequentialGroup()
	        					.addComponent(btnCerrar, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
	        					.addContainerGap())))
	        );
	        groupLayout.setVerticalGroup(
	        	groupLayout.createParallelGroup(Alignment.TRAILING)
	        		.addGroup(groupLayout.createSequentialGroup()
	        			.addGap(21)
	        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(lblDepartamentos)
	        				.addComponent(comboBoxDepartamentos, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
	        			.addGap(33)
	        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(lblActividades)
	        				.addComponent(comboBoxActividades, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
	        			.addGap(33)
	        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(textFieldNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(lblNombre))
	        			.addGap(18)
	        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(textFieldCosto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(lblCosto)
	        				.addComponent(lblDuracion)
	        				.addComponent(textFieldDuracion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	        			.addGap(18)
	        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	        				.addComponent(textAreaDescr, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(lblDescr))
	        			.addGap(37)
	        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	        				.addComponent(comboBoxSalidas, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
	        				.addComponent(lblSalidas))
	        			.addGap(18, 18, Short.MAX_VALUE)
	        			.addComponent(btnCerrar)
	        			.addGap(33))
	        );
	        getContentPane().setLayout(groupLayout);
		}
		
		public void cargarInformacionActividad(String actividad){
			DTActividad datosActividad = controlAct.getInfoActividad(actividad);
			cargarSalidas(datosActividad.getSalidas());
			textFieldNombre.setText(datosActividad.getNombre());
			textAreaDescr.setText(datosActividad.getDescripcion());
			textFieldDuracion.setText(String.valueOf(datosActividad.getDuracionHs()));
			textFieldCosto.setText(String.valueOf(datosActividad.getCosto()));
			
		}
		
		//Carga de ComboBoxes
		public void cargarDepartamentos() {
			borrandoFormularios = true;
			comboBoxDepartamentos.removeAllItems();
			borrandoFormularios = false;
			DefaultComboBoxModel<String> model;
			//El ComboBox no soporta Sets, hay que decidir que hacer
			Set<String> setDeptos = controlAct.listarDepartamentos();
			String[] arrDeptos = new String[setDeptos.size()];
			setDeptos.toArray(arrDeptos);
			
			model = new DefaultComboBoxModel<String>(arrDeptos);
			comboBoxDepartamentos.setModel(model);
			comboBoxActividades.setEnabled(false);
			comboBoxSalidas.setEnabled(false);
			borrandoFormularios = true;
			comboBoxDepartamentos.setSelectedItem(null);
			borrandoFormularios = false;
		}
		
		public void cargarActividades(String departamento) {
			borrandoFormularios = true;
			comboBoxActividades.removeAllItems();
			borrandoFormularios = false;
			DefaultComboBoxModel<String> model;
			//El ComboBox no soporta Sets, hay que decidir que hacer
			Set<String> setActs = controlAct.listarActividadesDepartamento(departamento);
			String[] arrActs = new String[setActs.size()];
			setActs.toArray(arrActs);
			
			model = new DefaultComboBoxModel<String>(arrActs);
			comboBoxActividades.setModel(model);
			comboBoxSalidas.setEnabled(false);
			borrandoFormularios = true;
			comboBoxActividades.setSelectedItem(null);
			borrandoFormularios = false;
		}
		
		public void cargarSalidas(Set<String> setSalidas) {
			borrandoFormularios = true;
			comboBoxSalidas.removeAllItems();
			borrandoFormularios = false;
			DefaultComboBoxModel<String> model;
			//El ComboBox no soporta Sets, hay que decidir que hacer
			String[] arrSalidas = new String[setSalidas.size()];
			setSalidas.toArray(arrSalidas);
			
			model = new DefaultComboBoxModel<String>(arrSalidas);
			comboBoxSalidas.setModel(model);
			borrandoFormularios = true;
			comboBoxSalidas.setSelectedItem(null);
			borrandoFormularios = false;
		}
		
		public void limpiarFormulario() {
			borrandoFormularios = true;
			limpiarInformacion();
			comboBoxDepartamentos.removeAllItems();
	        comboBoxActividades.removeAllItems();
	        comboBoxSalidas.removeAllItems();
	        borrandoFormularios = false;
		}
		
		private void limpiarInformacion() {
			textFieldNombre.setText("");
			textAreaDescr.setText("");
			textFieldDuracion.setText("");
			textFieldCosto.setText("");
		}
}