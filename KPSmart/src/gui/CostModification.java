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

import Logic.Cost;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CostModification extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtRouteNumber;
	private JTextField txtOriginPort;
	private JTextField txtDestinationPort;
	private JFormattedTextField txtWeightCost;
	private JFormattedTextField txtVolumeCost;
	private JFormattedTextField txtPriority;

	@SuppressWarnings("rawtypes")
	public CostModification() {
		setClosable(true);
		setTitle("Cost Modification");
		setBounds(100, 100, 559, 325);
		setLocation(400,150);
		JPanel DataInputPanel = new JPanel();
		
		JPanel btnPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(DataInputPanel, GroupLayout.PREFERRED_SIZE, 514, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPanel, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(DataInputPanel, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPanel, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JButton btnClearFields = new JButton("Clear Fields");
		btnClearFields .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Fields cleared...",null, 1);
				txtRouteNumber.setText("");
				txtOriginPort.setText("");
				txtDestinationPort.setText("");
				txtWeightCost.setText("");
				txtVolumeCost.setText("");
				txtPriority.setText("");
				MainWindow.logic.processform("Cost Modification --> All fields cleared.");
				
				
			}
		});
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtRouteNumber.getText().equals("") || txtOriginPort.getText().equals("") || txtDestinationPort.getText().equals("")
						|| txtWeightCost.getText().equals("") || txtVolumeCost.getText().equals("") || txtPriority.getText().equals("")){
					System.out.println(MainWindow.logic.processform("Cost Modification -- > Data input fields are empty.Please fill in all fields..."));
					JOptionPane.showMessageDialog(null,"Please enter all details",null, 1);
					
				}else{
		
					String values=Integer.parseInt(txtRouteNumber.getText())+"\t"+Double.parseDouble(txtWeightCost.getText())+"\t"+
							Double.parseDouble(txtVolumeCost.getText())+"\t"+txtDestinationPort.getText()+"\t"+txtOriginPort.getText()+"\t"+
							Integer.parseInt(txtPriority.getText());
							//Cost cost=new Cost(values);
						JOptionPane.showMessageDialog(null, "Saved!",null, 1);
						System.out.println(MainWindow.logic.processform("Cost Modification--> Saving Details...\n" + values));
				}
				
			}
		});
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow.logic.processform("Closing Cost Modification Form.");
				dispose();
			}
		});
		GroupLayout gl_btnPanel = new GroupLayout(btnPanel);
		gl_btnPanel.setHorizontalGroup(
			gl_btnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnClearFields)
					.addGap(10)
					.addComponent(btnSave)
					.addPreferredGap(ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
					.addComponent(btnClose)
					.addGap(19))
		);
		gl_btnPanel.setVerticalGroup(
			gl_btnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_btnPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnClearFields)
						.addComponent(btnClose))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		btnPanel.setLayout(gl_btnPanel);
		
		JLabel lblRouteNumber = new JLabel("Route Number");
		
		txtRouteNumber = new JTextField();
		txtRouteNumber.setColumns(10);
		//
		txtRouteNumber.addKeyListener(new KeyAdapter() { 
	         public void keyTyped(KeyEvent e) {  
	           char c = e.getKeyChar();  
	           if (!(Character.isDigit(c) ||  
	              (c == KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_PERIOD)||
	              (c == KeyEvent.VK_DELETE))) {  
	                e.consume();  
	              }  
	         }  
	   });  
		
		JLabel lblOriginatingPort = new JLabel("Originating Port");
		
		JLabel lblDestinationPort = new JLabel("Destination Port");
		
		txtOriginPort = new JTextField();
		txtOriginPort.setColumns(10);
		
		txtDestinationPort = new JTextField();
		txtDestinationPort.setText("");
		txtDestinationPort.setColumns(10);
		
		JList listOfExistingRoutes = new JList();
		
		txtWeightCost = new JFormattedTextField();
		//Allow text box to accept digits only
		txtWeightCost.addKeyListener(new KeyAdapter() { 
	         public void keyTyped(KeyEvent e) {  
	           char c = e.getKeyChar();  
	           if (!(Character.isDigit(c) ||  
	              (c == KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_PERIOD)||
	              (c == KeyEvent.VK_DELETE))) {  
	                e.consume();  
	              }  
	         }  
	   });  
		
		JLabel lblWeightCost = new JLabel("Weight Cost");
		
		txtVolumeCost = new JFormattedTextField();
		//Allow text box to accept digits only
		txtVolumeCost.addKeyListener(new KeyAdapter() { 
	         public void keyTyped(KeyEvent e) {  
	           char c = e.getKeyChar();  
	           if (!(Character.isDigit(c) ||  
	              (c == KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_PERIOD)||
	              (c == KeyEvent.VK_DELETE))) {  
	                e.consume();  
	              }  
	         }  
	   });  
		
		
		JLabel lblVolumeCost = new JLabel("Volume Cost");
		
		JLabel lblPriority = new JLabel("Priority");
		//Allow text box to accept number only
		txtPriority = new JFormattedTextField();
		txtPriority.addKeyListener(new KeyAdapter() { 
	         public void keyTyped(KeyEvent e) {  
	           char c = e.getKeyChar();  
	           if (!(Character.isDigit(c) ||  
	              (c == KeyEvent.VK_BACK_SPACE)||
	              (c == KeyEvent.VK_DELETE))) {  
	                e.consume();  
	              }  
	         }  
	   });  
		
		GroupLayout gl_DataInputPanel = new GroupLayout(DataInputPanel);
		gl_DataInputPanel.setHorizontalGroup(
			gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DataInputPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPriority)
						.addGroup(Alignment.TRAILING, gl_DataInputPanel.createSequentialGroup()
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_DataInputPanel.createSequentialGroup()
										.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblOriginatingPort, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
											.addComponent(lblDestinationPort, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addGap(18))
									.addComponent(lblWeightCost)
									.addComponent(lblVolumeCost, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addComponent(lblRouteNumber, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
									.addGap(12)))
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(txtPriority, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtOriginPort, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtDestinationPort, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(txtVolumeCost, Alignment.LEADING)
									.addComponent(txtWeightCost, Alignment.LEADING)
									.addComponent(txtRouteNumber, Alignment.LEADING)))))
					.addGap(27)
					.addComponent(listOfExistingRoutes, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		gl_DataInputPanel.setVerticalGroup(
			gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DataInputPanel.createSequentialGroup()
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(26)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRouteNumber)
								.addComponent(txtRouteNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblWeightCost)
								.addComponent(txtWeightCost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblVolumeCost)
								.addComponent(txtVolumeCost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDestinationPort)
								.addComponent(txtDestinationPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtOriginPort, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblOriginatingPort))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPriority)
								.addComponent(txtPriority, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(19)
							.addComponent(listOfExistingRoutes, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		DataInputPanel.setLayout(gl_DataInputPanel);
		getContentPane().setLayout(groupLayout);

	}
}
