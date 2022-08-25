package presentacion;

import java.util.Set;
import java.util.GregorianCalendar;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import logica.interfaces.ICtrlActividad;
import logica.interfaces.ICtrlUsuario;
import datatypes.DTSalida;

@SuppressWarnings("serial")
public class InscripcionSalidaTuristica extends JInternalFrame {
	//Interfaces
	private ICtrlActividad controlAct;
	private ICtrlUsuario controlUsr;
	
	//Componentes graficos
	private JComboBox<String> comboBoxDepartamentos;
	private JComboBox<String> comboBoxActividades;
	private JComboBox<DTSalida> comboBoxSalidasVigentes;
	private JComboBox<String> comboBoxTuristas;
	private JLabel lblDepartamentos;
	private JLabel lblActividades;
	private JLabel lblSalidasVigentes;
	private JLabel lblTuristas;
	private JTextField textFieldCantTuristas;
	private JLabel lblCantTuristas;
	private JButton btnAceptar;
	private JButton btnCerrar;
	
	public InscripcionSalidaTuristica(ICtrlActividad ica, ICtrlUsuario icu) {
		controlAct = ica;
		controlUsr = icu;
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Inscripcion a Salida Turistica");
        setBounds(30, 30, 345, 364);
        
        lblDepartamentos = new JLabel("Departamento:");
        lblDepartamentos.setHorizontalAlignment(SwingConstants.RIGHT);
        lblActividades = new JLabel("Actividad:");
        lblActividades.setHorizontalAlignment(SwingConstants.RIGHT);
        lblSalidasVigentes = new JLabel("Salida:");
        lblSalidasVigentes.setHorizontalAlignment(SwingConstants.RIGHT);
        lblTuristas = new JLabel("Turista:");
        lblTuristas.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCantTuristas = new JLabel("Cant. de Turistas:");
        lblCantTuristas.setHorizontalAlignment(SwingConstants.RIGHT);
        
        comboBoxDepartamentos = new JComboBox<String>();
        comboBoxDepartamentos.setEnabled(true);
        comboBoxDepartamentos.setToolTipText("Seleccione un departamento");
        comboBoxActividades = new JComboBox<String>();
        comboBoxActividades.setEnabled(false);
        comboBoxActividades.setToolTipText("Seleccione una actividad");
        comboBoxSalidasVigentes = new JComboBox<DTSalida>();
        comboBoxSalidasVigentes.setEnabled(false);
        comboBoxSalidasVigentes.setToolTipText("Seleccione una salida");
        comboBoxTuristas = new JComboBox<String>();
        comboBoxTuristas.setEnabled(false);
        comboBoxTuristas.setToolTipText("Seleccione un turista");
        
        textFieldCantTuristas = new JTextField();
        textFieldCantTuristas.setEnabled(false);
        textFieldCantTuristas.setToolTipText("Ingrese la cantidad de turistas a inscribir");
        
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
        		cmdInscripcionSalidaTuristicasActionPerformed(arg0);
        	}
        });
        
        comboBoxDepartamentos.addActionListener(new ActionListener( ) {
        	public void actionPerformed(ActionEvent arg0) {
        		cargarActividades(comboBoxDepartamentos.getSelectedItem().toString());
        	}
        });
        
        //Layout
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addContainerGap(39, Short.MAX_VALUE)
        					.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
        					.addGap(41)
        					.addComponent(btnCerrar, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lblTuristas, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
        						.addComponent(lblCantTuristas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(lblSalidasVigentes, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
        						.addComponent(lblActividades, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
        						.addComponent(lblDepartamentos, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(textFieldCantTuristas, GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
        						.addComponent(comboBoxTuristas, 0, 181, Short.MAX_VALUE)
        						.addComponent(comboBoxSalidasVigentes, 0, 181, Short.MAX_VALUE)
        						.addComponent(comboBoxActividades, 0, 181, Short.MAX_VALUE)
        						.addComponent(comboBoxDepartamentos, Alignment.LEADING, 0, 181, Short.MAX_VALUE))))
        			.addGap(41))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(comboBoxDepartamentos, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblDepartamentos))
        			.addGap(26)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(comboBoxActividades, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblActividades))
        			.addGap(26)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(comboBoxSalidasVigentes, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblSalidasVigentes))
        			.addGap(26)
        			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(comboBoxTuristas, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lblTuristas))
        			.addGap(20)
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(textFieldCantTuristas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblCantTuristas))
        					.addGap(64))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnAceptar)
        						.addComponent(btnCerrar))
        					.addContainerGap())))
        );
        getContentPane().setLayout(groupLayout);
	}
	
	protected void cmdInscripcionSalidaTuristicasActionPerformed(ActionEvent arg0) {
		//String departamento = this.comboBoxDepartamentos.getSelectedItem().toString();
		//String actividad = this.comboBoxActividades.getSelectedItem().toString();
		//DTSalida salida = this.comboBoxSalidasVigentes.getItemAt(this.comboBoxSalidasVigentes.getSelectedIndex());
		//String turista = this.comboBoxTuristas.getSelectedItem().toString();
		//String cantTuristas = this.textFieldCantTuristas.getText();
		
		
	}
	
	//Carga de ComboBoxes
	public void cargarDepartamentos() {
		DefaultComboBoxModel<String> model;
		//El ComboBox no soporta Sets, hay que decidir que hacer
		Set<String> setDeptos = controlAct.listarDepartamentos();
		String[] arrDeptos = new String[setDeptos.size()];
		setDeptos.toArray(arrDeptos);
		
		model = new DefaultComboBoxModel<String>(arrDeptos);
		comboBoxDepartamentos.setModel(model);
	}
	
	public void cargarActividades(String departamento) {
		DefaultComboBoxModel<String> model;
		//El ComboBox no soporta Sets, hay que decidir que hacer
		Set<String> setActs = controlAct.listarActividadesDepartamento(departamento);
		String[] arrActs = new String[setActs.size()];
		setActs.toArray(arrActs);
		
		model = new DefaultComboBoxModel<String>(arrActs);
		comboBoxActividades.setModel(model);
	}
	
	public void cargarSalidasVigentes(String actividad, GregorianCalendar fechaSistema) {
		DefaultComboBoxModel<DTSalida> model;
		//El ComboBox no soporta Sets, hay que decidir que hacer
		Set<DTSalida> setSalidas = controlAct.listarInfoSalidasVigentes(actividad, fechaSistema);
		DTSalida[] arrSalidas = new DTSalida[setSalidas.size()];
		setSalidas.toArray(arrSalidas);
		
		model = new DefaultComboBoxModel<DTSalida>(arrSalidas);
		comboBoxSalidasVigentes.setModel(model);
	}
	
	public void cargarTuristas(String nickname) {
		DefaultComboBoxModel<String> model;
		//El ComboBox no soporta Sets, hay que decidir que hacer
		Set<String> setTuristas = controlUsr.listarTuristas();
		String[] arrTuristas = new String[setTuristas.size()];
		setTuristas.toArray(arrTuristas);
		
		model = new DefaultComboBoxModel<String>(arrTuristas);
		comboBoxTuristas.setModel(model);
	}
	
	private void limpiarFormulario() {
		comboBoxDepartamentos.removeAllItems();
        comboBoxActividades.removeAllItems();
        comboBoxSalidasVigentes.removeAllItems();
        comboBoxTuristas.removeAllItems();
        textFieldCantTuristas.setText("");
	}
}