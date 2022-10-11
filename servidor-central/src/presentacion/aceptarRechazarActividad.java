package presentacion;

import javax.swing.JInternalFrame;

import logica.clases.ActividadTuristica;
import logica.handlers.HandlerActividades;
import logica.interfaces.ICtrlActividad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import datatypes.estadoActividad;

import javax.swing.JCheckBox;
import javax.swing.JButton;

public class aceptarRechazarActividad extends JInternalFrame  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public aceptarRechazarActividad(ICtrlActividad icA) {
		
		JComboBox<String> comboBoxActividades = new JComboBox();
		
		JLabel lblActividades = new JLabel("Actividades en estado \"Agregada\"");
		   
		comboBoxActividades.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		HandlerActividades ha = HandlerActividades.getInstance();
	        		Set<ActividadTuristica> actividades = ha.obtenerActividadesTuristicas();
	   
	        		
					actividades.forEach((act) -> {
						if(act.getEstado() == estadoActividad.agregada)
						comboBoxActividades.addItem(act.getNombre());

					});
					
	        	}
	        });
		
		JButton btnConfirmar = new JButton("Confirmar");
		
		JButton btnRechazar = new JButton("Rechazar");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(280)
					.addComponent(btnConfirmar)
					.addGap(18)
					.addComponent(btnRechazar)
					.addContainerGap(59, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblActividades)
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addComponent(comboBoxActividades, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addGap(83))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(70, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxActividades, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblActividades))
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnConfirmar)
						.addComponent(btnRechazar))
					.addContainerGap(197, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
	}
}
