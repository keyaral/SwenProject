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
import java.util.Random;

import javax.swing.JComboBox;

public class CostModification extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtRouteNumber;
	private JFormattedTextField txtWeightCost;
	private JFormattedTextField txtVolumeCost;
	private JComboBox cmbPriority;
	private JComboBox cmbOrigin;
	private JComboBox cmbDestination;
	//Generate Random integers numbers
	private  void generateRandomNumber(int number){
		 Random randomNumerGenerator = new Random();
		 int randomNumber=randomNumerGenerator.nextInt(number);
	     txtRouteNumber.setText(Integer.toString(randomNumber));
	  }
	  //Generate Random Weight
	private  void generateRandomCost(){
		 Random randomNumerGenerator = new Random();
		 double randomNumber=randomNumerGenerator.nextDouble();
		 double wCost=Math.round(randomNumber*100.0)/100.0;
	     txtWeightCost.setText(Double.toString(wCost*2));
	     txtVolumeCost.setText(Double.toString(wCost*5));
	     
	  }

	private void randomSelectionOfPriority(int nmb){
		Random rand=new Random();
		int  randNumber=rand.nextInt(nmb);
		cmbPriority.setSelectedIndex(randNumber);
		
	}
	private void randomSelectionOfOrigin(int nmb){
		Random rand=new Random();
		int  randNumber=rand.nextInt(nmb);
		cmbOrigin.setSelectedIndex(randNumber);
		
	}
	private void randomSelectionOfDestination(int nmb){
		Random rand=new Random();
		int  randNumber=rand.nextInt(nmb);
		cmbDestination.setSelectedIndex(randNumber);
		
	}
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
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(DataInputPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
						.addComponent(btnPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
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
				txtRouteNumber.setText("");
				cmbOrigin.setSelectedIndex(-1);
				cmbDestination.setSelectedIndex(-1);
				txtWeightCost.setText("");
				txtVolumeCost.setText("");
				cmbPriority.setSelectedIndex(-1);
				MainWindow.logic.processform("Cost Modification --> All fields cleared.");
				
				
			}
		});
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String priority=(String)cmbPriority.getSelectedItem();
				String origin=(String)cmbOrigin.getSelectedItem();
				String destination=(String)cmbDestination.getSelectedItem();
				
				
				if(txtRouteNumber.getText().equals("") || origin.equals("") || destination.equals("")
						|| txtWeightCost.getText().equals("") || txtVolumeCost.getText().equals("") ||priority.equals("")){
					System.out.println(MainWindow.logic.processform("Cost Modification -- > Data input fields are empty.Please fill in all fields..."));
					JOptionPane.showMessageDialog(null,"Please enter all details",null, 1);
					
				}else{
		
					String values=Integer.parseInt(txtRouteNumber.getText())+"\t"+Double.parseDouble(txtWeightCost.getText())+"\t"+
							Double.parseDouble(txtVolumeCost.getText())+"\t"+destination+"\t"+origin+"\t"+
							priority;
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
		
		JButton btnLoadTestData = new JButton("Load Test Data");
		btnLoadTestData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				randomSelectionOfPriority(cmbPriority.getItemCount());
				generateRandomNumber(1000);
				generateRandomCost();
				randomSelectionOfOrigin(cmbOrigin.getItemCount());
				randomSelectionOfDestination(cmbDestination.getItemCount());
				
			}
		});
		GroupLayout gl_btnPanel = new GroupLayout(btnPanel);
		gl_btnPanel.setHorizontalGroup(
			gl_btnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnClearFields)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSave)
					.addGap(71)
					.addComponent(btnLoadTestData)
					.addPreferredGap(ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
					.addComponent(btnClose)
					.addGap(19))
		);
		gl_btnPanel.setVerticalGroup(
			gl_btnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_btnPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClearFields)
						.addComponent(btnClose)
						.addComponent(btnSave)
						.addComponent(btnLoadTestData))
					.addContainerGap(14, Short.MAX_VALUE))
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
		String[] priority={"Domestic Air","International Air","Domestic Standard","Internation Standard Priority"};
		cmbPriority = new JComboBox(priority);
		//Define Distribution Centers
		String[] distributionCenters={"Auckland","Hamilton","Rotorua","Palmerston North","Wellington","Christ Church","Dunedin"};
		cmbOrigin = new JComboBox(distributionCenters);
		String[] destinations={"Rome","Sydney","London","New York","Singapore","Japan","Manila","Fiji","Hawaii","Moscow"};
		cmbDestination = new JComboBox(destinations);
		
		GroupLayout gl_DataInputPanel = new GroupLayout(DataInputPanel);
		gl_DataInputPanel.setHorizontalGroup(
			gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DataInputPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblOriginatingPort, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
										.addComponent(lblDestinationPort, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
									.addGap(18))
								.addComponent(lblWeightCost)
								.addComponent(lblVolumeCost, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_DataInputPanel.createSequentialGroup()
								.addComponent(lblRouteNumber, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addGap(12)))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addComponent(lblPriority)
							.addGap(61)))
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(cmbDestination, 0, 184, Short.MAX_VALUE)
						.addComponent(cmbPriority, 0, 184, Short.MAX_VALUE)
						.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtVolumeCost, Alignment.LEADING)
							.addComponent(txtWeightCost, Alignment.LEADING)
							.addComponent(txtRouteNumber, Alignment.LEADING))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addComponent(cmbOrigin, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGap(10)
					.addComponent(listOfExistingRoutes, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_DataInputPanel.setVerticalGroup(
			gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_DataInputPanel.createSequentialGroup()
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_DataInputPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(listOfExistingRoutes, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(26, 26, Short.MAX_VALUE)
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
								.addComponent(cmbDestination, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblOriginatingPort)
								.addComponent(cmbOrigin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPriority)
								.addComponent(cmbPriority, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(34))
		);
		DataInputPanel.setLayout(gl_DataInputPanel);
		getContentPane().setLayout(groupLayout);
		//Clear contents in the combox box on start up
		cmbPriority.setSelectedIndex(-1);
		cmbOrigin.setSelectedIndex(-1);
		cmbDestination.setSelectedIndex(-1);

	}
}
