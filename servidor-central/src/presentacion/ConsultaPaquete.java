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
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
	private JPanel panel_actividades;
	
	private ConsultaDeActividadTuristica consultaActividad;
	private JScrollPane scrollPane;
	private JLabel lblActividad_1;
	private JButton btnConsultarInfo_1;
	private JLabel lblActividad;
	private JButton btnConsultarInfo;
	
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
		
		panel_actividades = new JPanel();
		
		scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
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
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(lblCosto)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(textFieldCosto, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
												.addComponent(lblFechaDeAlta)
												.addComponent(lblDescripcion))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addGroup(groupLayout.createSequentialGroup()
														.addGap(12)
														.addComponent(lblPeriodoDeValidez)
														.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
														.addComponent(textFieldPeriodoValidez, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
													.addGroup(groupLayout.createSequentialGroup()
														.addComponent(textFieldFechaAlta, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED, 152, Short.MAX_VALUE)))))
										.addComponent(panel_actividades, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE))))
							.addGap(177))
						.addGroup(groupLayout.createSequentialGroup()
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
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblDatosDelPaquete)
							.addGap(24)
							.addComponent(lblDescripcion)
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
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
					.addComponent(panel_actividades, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSalir)
					.addGap(24))
		);
		GridBagLayout gbl_panel_actividades = new GridBagLayout();
		gbl_panel_actividades.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_actividades.rowHeights = new int[]{0, 0, 0};
		gbl_panel_actividades.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_actividades.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_actividades.setLayout(gbl_panel_actividades);
		
		textPaneDescripcion = new JTextPane();
		scrollPane.setViewportView(textPaneDescripcion);
		textPaneDescripcion.setEditable(false);
		getContentPane().setLayout(groupLayout);
		
		
		
		Listeners();
		
		setBounds(12, 6, 489, 429);
		//pack();
		setVisible(true);
	}
	
	public void cargarDatosIniciales() {
		cargandoDatos = true;
		limpiarFormulario();
		comboBoxPaquetes.setEnabled(true);
		comboBoxPaquetes.removeAllItems();
		comboBoxPaquetes.addItem("Elija un Paquete");
		String[] paquetes = ctrlAct.listarPaquetes().toArray(String[]::new);
		for (String p : paquetes) {
			comboBoxPaquetes.addItem(p);
		}
		cargandoDatos = false;
	}
	
	private void Listeners() {
		
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
					
					panel_actividades.removeAll();
					int y = 0;
					for (String act : dtp.getActividades()) {
						JButton act_btn = new JButton("consultar");
						JLabel act_lbl = new JLabel(act);

						GridBagConstraints gbc_actLbl = new GridBagConstraints();
						gbc_actLbl.gridx = 0;
						gbc_actLbl.gridy = y;
						panel_actividades.add(act_lbl, gbc_actLbl);
						
						GridBagConstraints gbc_btnConsultarInfo = new GridBagConstraints();
						gbc_btnConsultarInfo.gridx = 2;
						gbc_btnConsultarInfo.gridy = y;
						panel_actividades.add(act_btn, gbc_btnConsultarInfo);
						
						y+=1;
						
						act_btn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								// llamar a consulta actividad con la actividad como parametro
								consultaActividad.datosQueVienenDesdeConsultaPaquete(act);
							}
						});
					}
					panel_actividades.validate();
					panel_actividades.repaint();
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

	public void cargarConsultaActividadFrame(ConsultaDeActividadTuristica frame) {
		consultaActividad = frame;
	}
	private void limpiarFormulario() {
		textPaneDescripcion.setText("");
		textFieldPeriodoValidez.setText("");
		textFieldCosto.setText("");
		textFieldFechaAlta.setText("");
		
		panel_actividades.removeAll();
	}
	
	public void datosQueVienenDesdeConsultaActividad(String paquete) {
		setVisible(true);
		comboBoxPaquetes.addItem(paquete);
		comboBoxPaquetes.setEnabled(false);
		DTPaquete dtp = ctrlAct.getInfoPaquete(paquete);
		textPaneDescripcion.setText(dtp.getDescripcion());
		textFieldPeriodoValidez.setText(String.valueOf(dtp.getPeriodoValidez()) + " dias");
		textFieldCosto.setText("$ " + String.valueOf(dtp.getCosto()));
		textFieldFechaAlta.setText(fechaStringFormato(dtp.getFechaAlta(), true));
		
		
	}
}
