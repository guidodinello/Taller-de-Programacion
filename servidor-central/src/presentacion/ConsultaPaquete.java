package presentacion;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import logica.interfaces.ICtrlActividad;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

import datatypes.DTPaquete;

import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class ConsultaPaquete extends JInternalFrame {
	
	private ICtrlActividad ctrlAct;
	private boolean cargandoDatos;
	
	private JTextField textFieldPeriodoValidez;
	private JTextField textFieldCosto;
	private JTextField textFieldFechaAlta;
	
	private JComboBox<String> comboBoxPaquetes;
	private JLabel lblPaquetesRegistrados;
	private JLabel lblDatosDelPaquete;
	private JLabel lblDescripcion;
	private JLabel lblPeriodoDeValidez;
	private JLabel lblCosto;
	private JLabel lblFechaDeAlta;
	private JLabel lblActividadesTuristicasIncluidas;
	
	private JTextPane textPaneDescripcion; 
	private JButton btnSalir;
	private JPanel panel;
	
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
		
		textPaneDescripcion = new JTextPane();
		textPaneDescripcion.setEditable(false);
		
		textFieldPeriodoValidez = new JTextField();
		textFieldPeriodoValidez.setEditable(false);
		textFieldPeriodoValidez.setColumns(10);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setEditable(false);
		textFieldCosto.setColumns(10);
		
		textFieldFechaAlta = new JTextField();
		textFieldFechaAlta.setEditable(false);
		textFieldFechaAlta.setColumns(10);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblPaquetesRegistrados)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(comboBoxPaquetes, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
										.addComponent(lblDatosDelPaquete)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(24)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblActividadesTuristicasIncluidas)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(lblCosto)
														.addPreferredGap(ComponentPlacement.UNRELATED)
														.addComponent(textFieldCosto, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
													.addComponent(lblFechaDeAlta))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addGroup(groupLayout.createSequentialGroup()
														.addGap(12)
														.addComponent(lblPeriodoDeValidez)
														.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
														.addComponent(textFieldPeriodoValidez, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(textFieldFechaAlta, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, 141, Short.MAX_VALUE))))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblDescripcion)
												.addPreferredGap(ComponentPlacement.UNRELATED)
												.addComponent(textPaneDescripcion, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE))
											.addComponent(panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)))))
							.addGap(179))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(btnSalir)
							.addGap(213))))
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
							.addComponent(textPaneDescripcion, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldFechaAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFechaDeAlta))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblCosto)
							.addComponent(textFieldCosto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPeriodoDeValidez)
							.addComponent(textFieldPeriodoValidez, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(lblActividadesTuristicasIncluidas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSalir)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		
		
		Listeners();
		
		setBounds(12, 6, 489, 429);
		//pack();
		setVisible(true);
	}
	
	public void cargarDatosIniciales() {
		cargandoDatos = true;
		comboBoxPaquetes.removeAllItems();
		comboBoxPaquetes.addItem("Elija un Paquete");
		String[] paquetes = ctrlAct.listarPaquetes().toArray(String[]::new);
		for (String p : paquetes) {
			comboBoxPaquetes.addItem(p);
		}
		cargandoDatos = false;
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
		
		comboBoxPaquetes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String p = (String) comboBoxPaquetes.getSelectedItem();
				boolean dummyItem = p == "Elija un Paquete";
				if (!cargandoDatos && !dummyItem) {
					DTPaquete dtp = ctrlAct.getInfoPaquete(p);
					textPaneDescripcion.setText(dtp.getDescripcion());
					textFieldPeriodoValidez.setText(String.valueOf(dtp.getPeriodoValidez()) + " dias");
					textFieldCosto.setText("$ " + String.valueOf(dtp.getCosto()));
					textFieldFechaAlta.setText(fechaStringFormato(dtp.getFechaAlta(), true));
					
					for (String act : dtp.getActividades()) {
						
					}
				}
			}
		});
		
	}
	
	private String fechaStringFormato(GregorianCalendar g, boolean conHora) {
		String dia = String.valueOf(g.get(g.DAY_OF_MONTH));
		String mes = String.valueOf(g.get(g.MONTH));
		String anio = String.valueOf(g.get(g.YEAR));
		String hora = String.valueOf(g.get(g.HOUR));
		String resultado = (conHora)?
				 dia + "/" + mes + "/" + anio + " " + hora + "hs": dia + "/" + mes + "/" + anio;
		return resultado;
	}

	private boolean checkFormulario() {
		return true;
	}
	private void limpiarFormulario() {
		textPaneDescripcion.setText("");
		textFieldPeriodoValidez.setText("");
		textFieldCosto.setText("");
		textFieldFechaAlta.setText("");
	}
}
