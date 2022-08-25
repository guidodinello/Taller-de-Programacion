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
		setMaximizable(true);
		controlAct = ica;
		controlUsr = icu;
		
		setResizable(true);
        setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Inscripcion a Salida Turistica");
        setBounds(30, 30, 300, 274);
        
        lblDepartamentos = new JLabel("Departamentos");
        lblDepartamentos.setHorizontalAlignment(SwingConstants.CENTER);
        lblActividades = new JLabel("Actividades");
        lblActividades.setHorizontalAlignment(SwingConstants.CENTER);
        lblSalidasVigentes = new JLabel("Salidas vigentes");
        lblSalidasVigentes.setHorizontalAlignment(SwingConstants.CENTER);
        lblTuristas = new JLabel("Turistas");
        lblTuristas.setHorizontalAlignment(SwingConstants.CENTER);
        lblCantTuristas = new JLabel("Cantidad de Turistas");
        lblCantTuristas.setHorizontalAlignment(SwingConstants.CENTER);
        
        comboBoxDepartamentos = new JComboBox<String>();
        comboBoxActividades = new JComboBox<String>();
        comboBoxSalidasVigentes = new JComboBox<DTSalida>();
        comboBoxTuristas = new JComboBox<String>();
        
        textFieldCantTuristas = new JTextField();
        
        btnCerrar = new JButton("Cancelar");
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBoxDepartamentos.removeAllItems();
                comboBoxActividades.removeAllItems();
                comboBoxSalidasVigentes.removeAllItems();
                comboBoxTuristas.removeAllItems();
                textFieldCantTuristas.setText("");
                setVisible(false);
            }
        });
        
        btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		cmdInscripcionSalidaTuristicasActionPerformed(arg0);
        	}
        });
        
        //Layout
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addComponent(lblDepartamentos, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        		.addComponent(comboBoxDepartamentos, Alignment.LEADING, 0, 284, Short.MAX_VALUE)
        		.addComponent(lblActividades, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        		.addComponent(comboBoxActividades, Alignment.LEADING, 0, 284, Short.MAX_VALUE)
        		.addComponent(lblSalidasVigentes, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        		.addComponent(comboBoxSalidasVigentes, Alignment.LEADING, 0, 284, Short.MAX_VALUE)
        		.addComponent(lblTuristas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        		.addComponent(comboBoxTuristas, Alignment.LEADING, 0, 284, Short.MAX_VALUE)
        		.addComponent(textFieldCantTuristas, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        		.addComponent(btnCerrar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(lblDepartamentos)
        			.addComponent(comboBoxDepartamentos, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addComponent(lblActividades)
        			.addComponent(comboBoxActividades, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addComponent(lblSalidasVigentes)
        			.addComponent(comboBoxSalidasVigentes, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addComponent(lblTuristas)
        			.addComponent(comboBoxTuristas, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        			.addComponent(textFieldCantTuristas)
        			.addComponent(btnCerrar))
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
}