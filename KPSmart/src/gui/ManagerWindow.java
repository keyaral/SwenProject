package gui;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.LayoutStyle.ComponentPlacement;
import log.reader.*;
import Log.Log;
import log.writer.*;

public class ManagerWindow extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	public ManagerWindow() {
		setTitle("Manager Access");
		setIconifiable(true);
		setClosable(true);
		setBounds(0,0, 465, 214);
		setLocation(400,150);
		JPanel btnPanel = new JPanel();
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnClose)
						.addComponent(btnPanel, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnPanel, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnClose)
					.addContainerGap(15, Short.MAX_VALUE))
		);
		
		JButton btnCreateNewShipment = new JButton("Create New Shipment");
		btnCreateNewShipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"New Shipment Window !" + MainWindow.logic.getdetails(),null, 1);
				Log.Cost cost = new Log.Cost();
				XmlReader reader = new XmlReader("file.xml");
				reader.FindAll();
				reader.FindCost();
				
				XmlWriter writer = new XmlWriter("file.xml");
				writer.InsertCost(cost);
			}
		});
		
		JButton btnCheckExistingShipment = new JButton("Check Existing Shipment");
		btnCheckExistingShipment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Existing Shipment Window !" + MainWindow.logic.getdetails(),null, 1);
			}
		});
		
		JButton btnRouteModification = new JButton("Route Modification");
		btnRouteModification.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Route Modification Window !" + MainWindow.logic.getdetails(),null, 1);
			}
		});

	
		
		JButton btnViewEventLog = new JButton("View Event Log");
		btnViewEventLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Log View Window !" + MainWindow.logic.getdetails(),null, 1);
			}
		});
		GroupLayout gl_btnPanel = new GroupLayout(btnPanel);
		gl_btnPanel.setHorizontalGroup(
			gl_btnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnPanel.createSequentialGroup()
					.addGroup(gl_btnPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCreateNewShipment, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCheckExistingShipment, GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_btnPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnViewEventLog, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
						.addComponent(btnRouteModification, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
					.addGap(2))
		);
		gl_btnPanel.setVerticalGroup(
			gl_btnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnPanel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_btnPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRouteModification)
						.addComponent(btnCreateNewShipment))
					.addGap(18)
					.addGroup(gl_btnPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnViewEventLog)
						.addComponent(btnCheckExistingShipment))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		btnPanel.setLayout(gl_btnPanel);
		getContentPane().setLayout(groupLayout);

	}
	
}
