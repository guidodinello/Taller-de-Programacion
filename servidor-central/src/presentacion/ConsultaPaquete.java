package presentacion;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import logica.interfaces.ICtrlActividad;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class ConsultaPaquete extends JInternalFrame {
	
	private ICtrlActividad ctrlAct;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	private JComboBox<String> comboBoxPaquetes;
	private JLabel lblPaquetesRegistrados;
	private JLabel lblDatosDelPaquete;
	private JLabel lblDescripcion;
	private JLabel lblPeriodoDeValidez;
	private JLabel lblCosto;
	private JLabel lblFechaDeAlta;
	private JLabel lblActividadesTuristicasIncluidas;
	
	private JTextPane textPane; 
	private JPanel panel;
	private JButton btnSalir;
	
	public ConsultaPaquete(ICtrlActividad ica) {
		ctrlAct = ica;
		
		setIconifiable(true);
		setMaximizable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setClosable(true);
		setResizable(true);
		setTitle("Consulta de Paquete");
		
		lblPaquetesRegistrados = new JLabel("Paquetes Registrados");
		lblPaquetesRegistrados.setHorizontalAlignment(SwingConstants.CENTER);
		
		comboBoxPaquetes = new JComboBox<String>();
		
		lblDatosDelPaquete = new JLabel("Datos del Paquete");
		lblDescripcion = new JLabel("Descripcion");
		lblPeriodoDeValidez = new JLabel("Periodo de Validez");
		lblCosto = new JLabel("Costo");
		lblFechaDeAlta = new JLabel("Fecha de Alta");
		lblActividadesTuristicasIncluidas = new JLabel("Actividades Turisticas incluidas en el Paquete");
		
		textPane = new JTextPane();
		textPane.setEditable(false);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		panel = new JPanel();
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnSalir))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(36)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblPaquetesRegistrados)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(comboBoxPaquetes, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
									.addComponent(lblDatosDelPaquete)))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(24)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblDescripcion)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblCosto)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(textField_2, 0, 0, Short.MAX_VALUE))
											.addComponent(lblPeriodoDeValidez, Alignment.LEADING))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(textField, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblFechaDeAlta)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
										.addGap(2))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(lblActividadesTuristicasIncluidas)
										.addPreferredGap(ComponentPlacement.RELATED))))))
					.addGap(45))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPaquetesRegistrados)
						.addComponent(comboBoxPaquetes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblDatosDelPaquete)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(lblDescripcion))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPeriodoDeValidez)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCosto)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaDeAlta)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblActividadesTuristicasIncluidas)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSalir)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		
		
		Listeners();
		
		
		setVisible(true);
	}
	
	public void cargarDatosIniciales() {
		comboBoxPaquetes.removeAllItems();
		String[] paquetes = ctrlAct.listarPaquetes().toArray(String[]::new);
		for (String p : paquetes) {
			comboBoxPaquetes.addItem(p);
		}
	}
	
	private void Listeners() {
		
//		Whenever you get the selected item.
//
//		Object item = comboBox.getSelectedItem();
//		String value = ((ComboItem)item).getValue();

		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		
		
	}

	private boolean checkFormulario() {
		return true;
	}
	private void limpiarFormulario() {
		
	}
}
