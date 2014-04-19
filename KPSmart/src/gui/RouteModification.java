package gui;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RouteModification extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtRouteNumber;
	private JTextField txtOriginationPort;
	private JTextField txtDestinationPort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public RouteModification() {
		setClosable(true);
		setTitle("Route Modification");
		setBounds(100, 100, 559, 308);
		setLocation(400,150);
		JPanel DataInputPanel = new JPanel();
		
		JPanel btnPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(DataInputPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnPanel, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
							.addGap(445))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(DataInputPanel, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(btnPanel, GroupLayout.PREFERRED_SIZE, 42, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnAdd = new JButton("Add");
		btnAdd .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Clicking on this button will clear fields for data entry",null, 1);
			}
		});
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Clicking on this button will update existing route",null, 1);
			}
		});
		
		JButton btnDisable = new JButton("Disable");
		btnDisable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Clicking on this button will disable existing route",null, 1);
			}
		});
		
		JButton btnEnable = new JButton("Enable");
		btnEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Clicking on this button will enable routes that are disabled in the system",null, 1);
			}
		});
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Clicking on this button will Delete routes in the system",null, 1);
			}
		});
		GroupLayout gl_btnPanel = new GroupLayout(btnPanel);
		gl_btnPanel.setHorizontalGroup(
			gl_btnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAdd)
					.addGap(10)
					.addComponent(btnUpdate)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDisable)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEnable)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDelete)
					.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
					.addComponent(btnClose)
					.addGap(19))
		);
		gl_btnPanel.setVerticalGroup(
			gl_btnPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_btnPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_btnPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDisable)
						.addComponent(btnUpdate)
						.addComponent(btnAdd)
						.addComponent(btnEnable)
						.addComponent(btnDelete)
						.addComponent(btnClose))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		btnPanel.setLayout(gl_btnPanel);
		
		JLabel lblRouteNumber = new JLabel("Route Number");
		
		txtRouteNumber = new JTextField();
		txtRouteNumber.setColumns(10);
		
		JLabel lblOriginatingPort = new JLabel("Originating Port");
		
		JLabel lblDestinationPort = new JLabel("Destination Port");
		
		txtOriginationPort = new JTextField();
		txtOriginationPort.setColumns(10);
		
		txtDestinationPort = new JTextField();
		txtDestinationPort.setText("");
		txtDestinationPort.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		
		JFormattedTextField txtPrice = new JFormattedTextField();
		//Format text box to accept digits only
		txtPrice.addKeyListener(new KeyAdapter() { 
			         public void keyTyped(KeyEvent e) {  
			           char c = e.getKeyChar();  
			           if (!(Character.isDigit(c) ||  
			              (c == KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_PERIOD)||
			              (c == KeyEvent.VK_DELETE))) {  
			                e.consume();  
			              }  
			         }  
			   });  
		
		JList listOfExistingRoutes = new JList();
		GroupLayout gl_DataInputPanel = new GroupLayout(DataInputPanel);
		gl_DataInputPanel.setHorizontalGroup(
			gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DataInputPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblOriginatingPort, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblRouteNumber, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtOriginationPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtRouteNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDestinationPort)
								.addComponent(lblPrice))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtPrice)
								.addComponent(txtDestinationPort))))
					.addGap(26)
					.addComponent(listOfExistingRoutes, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_DataInputPanel.setVerticalGroup(
			gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DataInputPanel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRouteNumber)
						.addComponent(txtRouteNumber))
					.addGap(18)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOriginatingPort)
						.addComponent(txtOriginationPort))
					.addGap(18)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDestinationPort)
						.addComponent(txtDestinationPort))
					.addGap(18)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPrice)
						.addComponent(txtPrice))
					.addGap(55))
				.addGroup(gl_DataInputPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(listOfExistingRoutes, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
					.addGap(27))
		);
		DataInputPanel.setLayout(gl_DataInputPanel);
		getContentPane().setLayout(groupLayout);

	}
}
