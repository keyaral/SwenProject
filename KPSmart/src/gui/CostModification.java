package gui;

import javax.swing.DefaultListModel;
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
import javax.swing.ListSelectionModel;

import java.util.*;

import Logic.Cost;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class CostModification extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtRouteNumber;
	private JFormattedTextField txtWeightCost;
	private JFormattedTextField txtVolumeCost;
	private JComboBox cmbPriority;
	private JComboBox cmbDestination;
	private JComboBox cmbOrigin;
	private JList<String> listOfExistingRoutes = new JList();
	//Generate Random ID
	
	private void generateRandomId(int rnd){
		Random random=new Random();
		int id=random.nextInt(rnd);
		txtRouteNumber.setText(Integer.toString(id));
	}
	private void randomDestinationSelection(int item){
		Random random=new Random();
		int id=random.nextInt(item);
		cmbDestination.setSelectedIndex(id);
	}
	private void randomOriginSelection(int item){
		Random random=new Random();
		int id=random.nextInt(item);
		cmbOrigin.setSelectedIndex(id);
	}
	private void randomPrioritySelection(int item){
		Random random=new Random();
		int id=random.nextInt(item);
		cmbPriority.setSelectedIndex(id);
	}
	private void generateRandWeightAndVolumeCost(){
		Random random=new Random();
		double number=random.nextDouble();
		txtWeightCost.setText(Double.toString(Math.round(number*100)));
		txtVolumeCost.setText(Double.toString(Math.round(number*50)));
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
				cmbOrigin.setSelectedIndex(-1);
				cmbDestination.setSelectedIndex(-1);
				txtWeightCost.setText("");
				txtVolumeCost.setText("");
				cmbPriority.setSelectedIndex(-1);
				
			
				
				
			}
		});
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String priority=(String)cmbPriority.getSelectedItem();
				String origin=(String)cmbOrigin.getSelectedItem();
				String destination=(String)cmbDestination.getSelectedItem();
				

			//	String type=MainWindow.logic.switchEvents(2,"2a");//Case 2: Type "2a" Add cost

				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				if(txtRouteNumber.getText().equals("") || origin.equals("") || destination.equals("")
						|| txtWeightCost.getText().equals("") || txtVolumeCost.getText().equals("") || priority.equals("")){
					JOptionPane.showMessageDialog(null,"Please enter all details",null, 1);
				}
				else{
					int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to save the changes?","Confirmation",dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION){
						String[] values={ "4", txtRouteNumber.getText(),txtWeightCost.getText(),
						txtVolumeCost.getText(),destination,origin,	priority }; 
						JOptionPane.showMessageDialog(null,MainWindow.logic.processform(values),null, 1);
						MainWindow.bMonitoring.updateMonitor();
						updateList();
					}
					else{
						//Changes are not saved
						JOptionPane.showMessageDialog(null,"Details not saved.",null, 1);
					}
				}
				
			}
		});
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String priority=(String)cmbPriority.getSelectedItem();
				String origin=(String)cmbOrigin.getSelectedItem();
				String destination=(String)cmbDestination.getSelectedItem();
				
			//	String type=MainWindow.logic.switchEvents(2,"2a");//Case 2: Type "2a" Add cost
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				if(txtRouteNumber.getText().equals("") || origin.equals("") || destination.equals("")
						|| txtWeightCost.getText().equals("") || txtVolumeCost.getText().equals("") || priority.equals("")){
					JOptionPane.showMessageDialog(null,"Please enter all details",null, 1);
					
				}else{
					int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want add this Cost?","Confirmation",dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION){
						
					String[] values={ "3", txtRouteNumber.getText(),txtWeightCost.getText(),
							txtVolumeCost.getText(),destination,origin,	priority }; 
					JOptionPane.showMessageDialog(null,MainWindow.logic.processform(values),null, 1);
					MainWindow.bMonitoring.updateMonitor();
					updateList();
					}else{
						//Changes are not saved
						JOptionPane.showMessageDialog(null,"Cost not added.",null, 1);
					}
				}
				
			}
		});
		
		
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnLoadTestData = new JButton("Load Test Data");
		btnLoadTestData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generateRandomId(1000);
				generateRandWeightAndVolumeCost();
				if (cmbDestination.getItemCount()==0){
					cmbDestination.setSelectedIndex(-1);
					cmbDestination.addItem("No Destination Defined");
					randomDestinationSelection(1);
				
				}else{
					randomDestinationSelection(cmbDestination.getItemCount());
					System.out.println("Test Data Loaded...");
				}
				if (cmbOrigin.getItemCount()==0){
					cmbOrigin.setSelectedIndex(-1);
					cmbOrigin.addItem("No Origin Defined");
					randomDestinationSelection(1);
				}else{
					randomOriginSelection(cmbOrigin.getItemCount());
				}
				if (cmbPriority.getItemCount()==0){
					cmbPriority.setSelectedIndex(-1);
					cmbPriority.addItem("No Priority Defined");
					randomDestinationSelection(1);
				}else{
					randomPrioritySelection(cmbPriority.getItemCount());
				}
				
				
			}
		});
		
		GroupLayout gl_btnPanel = new GroupLayout(btnPanel);
		gl_btnPanel.setHorizontalGroup(
			gl_btnPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_btnPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAdd)
					.addGap(18)
					.addComponent(btnSave)
					.addGap(18)
					.addComponent(btnLoadTestData, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnClearFields)
					.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
					.addComponent(btnClose)
					.addGap(19))
		);
		gl_btnPanel.setVerticalGroup(
			gl_btnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_btnPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClose)
						.addComponent(btnAdd)
						.addComponent(btnSave)
						.addComponent(btnLoadTestData)
						.addComponent(btnClearFields))
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
		String [] mailPriority={"Domestic Standard","Domestic Air","International Standard Priority", "International Air",};
		cmbPriority = new JComboBox( mailPriority);
		
		//TODO
		String[] destinations= MainWindow.logic.getDestinations();
			//{"Rome","Sydney","London","New York","Singapore","Japan","Manila","Fiji","Hawaii","Moscow"};
		cmbDestination = new JComboBox(destinations);
		String[] distributionCenters = MainWindow.logic.getNZDestinations();
		//	{"Auckland","Hamilton","Rotorua","Palmerston North","Wellington","Christ Church","Dunedin"};
		cmbOrigin = new JComboBox(distributionCenters);
		
		JScrollPane scrollPane = new JScrollPane();
		
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
										.addComponent(lblOriginatingPort, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
										.addComponent(lblDestinationPort, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(18))
								.addComponent(lblWeightCost)
								.addComponent(lblVolumeCost, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_DataInputPanel.createSequentialGroup()
								.addComponent(lblRouteNumber, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addGap(12)))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addComponent(lblPriority)
							.addGap(61)))
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(cmbOrigin, 0, 138, Short.MAX_VALUE)
						.addComponent(cmbDestination, 0, 138, Short.MAX_VALUE)
						.addComponent(cmbPriority, 0, 138, Short.MAX_VALUE)
						.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtVolumeCost, Alignment.LEADING)
							.addComponent(txtWeightCost, Alignment.LEADING)
							.addComponent(txtRouteNumber, Alignment.LEADING)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
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
								.addComponent(cmbDestination, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblOriginatingPort)
								.addComponent(cmbOrigin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPriority)
								.addComponent(cmbPriority, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, gl_DataInputPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		listOfExistingRoutes.setLayoutOrientation(JList.VERTICAL);
		listOfExistingRoutes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listOfExistingRoutes.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (listOfExistingRoutes.getSelectedValue() != null) {
					Cost selected = null;
					int ID = Integer.parseInt(listOfExistingRoutes.getSelectedValue().split(" ")[0]);
					Map<String, Cost> costList = MainWindow.logic.eventProcessor.getCosts().costs;
					for (Cost c: costList.values()) {
						if (c.ID == ID) {
							selected = c;
							break;
						}
					}
					if (selected != null) {
						txtRouteNumber.setText(String.valueOf(selected.ID));
						txtWeightCost.setText(String.valueOf(selected.weight));
						txtVolumeCost.setText(String.valueOf(selected.volume));
					}
				}
			}
			
		});
		scrollPane.setViewportView(listOfExistingRoutes);
		DataInputPanel.setLayout(gl_DataInputPanel);
		getContentPane().setLayout(groupLayout);
		updateList();
	}
	
	private void updateList() {
		DefaultListModel<String> list = new DefaultListModel<String>();
		listOfExistingRoutes.setModel(list);
		Map<String, Cost> costList = MainWindow.logic.eventProcessor.getCosts().costs;
		for (Cost c: costList.values()) {
			list.addElement(c.ID + " / From " + c.origin + " To " + c.destination);
		}
	}
}
