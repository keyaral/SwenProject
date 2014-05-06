package gui;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JTextField;

import Logic.Logic;

public class TransportCost extends JInternalFrame {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbCompany;
	
	@SuppressWarnings("rawtypes")
	private JComboBox cmbTo;
	
	@SuppressWarnings("rawtypes")
	private JComboBox cmbFrom;
	
	@SuppressWarnings("rawtypes")
	private JComboBox cmbType;
	private JTextField txtCostId;
	private JFormattedTextField txtFrequency;
	private JComboBox cmbDay;
	private JFormattedTextField txtVolumeCost;
	private JFormattedTextField txtMaxWeight;
	private JFormattedTextField txtDuration;
	private JFormattedTextField txtDate;
	private JFormattedTextField txtMaxVolume;
	private JFormattedTextField txtWeightCost_1;
	private JFormattedTextField txtWeightCost_1_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	//Generate Random integers numbers
		private  void generateRandomNumber(int number){
			 Random randomNumerGenerator = new Random();
			 int randomNumber=randomNumerGenerator.nextInt(number);
		     txtCostId.setText(Integer.toString(randomNumber));
		  }
		private  void generateRandomDurationAndFrequency(int number){
			 Random randomNumerGenerator = new Random();
			 int randomNumber=randomNumerGenerator.nextInt(number);
		     txtDuration.setText(Integer.toString(randomNumber));
		     txtFrequency.setText(Integer.toString(randomNumber));
	
		  }
		  //Generate Random Weight
		private  void generateRandomWeighCost(int number){
			 Random randomNumerGenerator = new Random();
			 double randomNumber=randomNumerGenerator.nextDouble();
			 double wCost=Math.round(randomNumber*100.0)/100.0;
		     txtWeightCost_1_1.setText(Double.toString(wCost*2));
		     txtVolumeCost.setText(Double.toString(wCost*5));
		     txtMaxWeight.setText(Double.toString(wCost*10));
		     txtMaxVolume.setText(Double.toString(wCost*10));
		     
		  }
	private void randomSelectionFromComboBox(int nmb){
		Random rand=new Random();
		int  randNumber=rand.nextInt(nmb);
		cmbFrom.setSelectedIndex(randNumber);
		cmbTo.setSelectedIndex(randNumber);
		cmbDay.setSelectedIndex(randNumber);
		
	}
	private void randomSelectionOfPriority(int nmb){
		Random rand=new Random();
		int  randNumber=rand.nextInt(nmb);
		cmbType.setSelectedIndex(randNumber);
		
	}
	private void randomSelectionOfCompany(int nmb){
		Random rand=new Random();
		int  randNumber=rand.nextInt(nmb);
		cmbCompany.setSelectedIndex(randNumber);
		
	}
	private void generateDate(){
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		Date date = new Date();
		txtDate.setText(dateFormat.format(date));
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TransportCost() {
		super("Transport Cost Update");
		setTitle("Transport Route");
		setClosable(true);
		setBounds(100, 100, 569, 411);
		setLocation(400,150);
		JPanel DataInputPanel = new JPanel();
		
		JPanel btnPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(DataInputPanel, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(btnPanel, GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(DataInputPanel, GroupLayout.PREFERRED_SIZE, 297, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnPanel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(29))
		);
		
		JButton btnClearFields = new JButton("Clear Fields");
		btnClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						txtCostId.setText("");
						cmbCompany.setSelectedIndex(-1);
						cmbTo.setSelectedIndex(-1);
						cmbFrom.setSelectedIndex(-1);
						cmbType.setSelectedIndex(-1);
						txtWeightCost_1.setText("");
						txtVolumeCost.setText("");
						txtMaxWeight.setText("");
						txtMaxVolume.setText("");
						txtDuration.setText("");
						txtFrequency.setText("");
						cmbDay.setSelectedIndex(-1);
						txtDate.setText("");
				MainWindow.logic.processform("Transport Route Form --> Fields Cleared.");
				//JOptionPane.showMessageDialog(null,"Clear Fields!",null, 1);
			}
		});
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String company=(String)cmbCompany.getSelectedItem();
				String to=(String)cmbTo.getSelectedItem();
				String from=(String)cmbFrom.getSelectedItem();
				String day=(String)cmbDay.getSelectedItem();
				if (txtCostId.getText().equals("")
						||company.equals("") 
						|| to.equals("")
						||from.equals("")
						||txtWeightCost_1.getText().equals("")
						|| txtVolumeCost.getText().equals("")
						||txtMaxWeight.getText().equals("")
						||txtMaxVolume.getText().equals("")
						|| txtDuration.getText().equals("")
						|| txtFrequency.getText().equals("")
						|| day.equals("")
						||txtDate.getText().equals("")){
					MainWindow.logic.processform("Route Form --> Some fields are empty...");
					JOptionPane.showMessageDialog(null,"Please enter all details required !",null, 1);
						
			}else
			{
					String values=
						txtCostId.getText()+"\t"+
						(String)cmbCompany.getSelectedItem().toString()+"\t"+
						(String)cmbTo.getSelectedItem().toString()+"\t"+
						(String)cmbFrom.getSelectedItem().toString()+"\t"+
						(String)cmbType.getSelectedItem().toString()+"\t"+
						txtWeightCost_1.getText()+"\t"+
						txtVolumeCost.getText()+"\t"+
						txtMaxWeight.getText()+"\t"+
						txtMaxVolume.getText()+"\t"+
						txtDuration.getText()+"\t"+
						txtFrequency.getText()+"\t"+
						(String)cmbDay.getSelectedItem().toString() +"\t"+
						txtDate.getText();
				
				JOptionPane.showMessageDialog(null,"Route Form: Save Details !",null, 1);
				MainWindow.logic.processform(values);
			}
			}
		});

		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logic logic=new Logic();
				logic.processform("\nClosing Transport Route Form...");
				dispose();
			}
		});
		
		JButton btnLoadTestData = new JButton("Load Test Data");
		btnLoadTestData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generateRandomNumber(1000);
				generateRandomWeighCost(1000);
				randomSelectionFromComboBox(5);
				randomSelectionOfPriority(cmbType.getItemCount());
				randomSelectionOfCompany(cmbCompany.getItemCount());
				generateDate();
				generateRandomDurationAndFrequency(70);
				String preLoadedData= txtCostId.getText()+"\t"+
						(String)cmbCompany.getSelectedItem().toString()+"\t"+
						(String)cmbTo.getSelectedItem().toString()+"\t"+
						(String)cmbFrom.getSelectedItem().toString()+"\t"+
						(String)cmbType.getSelectedItem().toString()+"\t"+
						txtWeightCost_1.getText()+"\t"+
						txtVolumeCost.getText()+"\t"+
						txtMaxWeight.getText()+"\t"+
						txtMaxVolume.getText()+"\t"+
						txtDuration.getText()+"\t"+
						txtFrequency.getText()+"\t"+
						(String)cmbDay.getSelectedItem().toString() +"\t"+
						txtDate.getText();
				MainWindow.logic.processform(preLoadedData);
				
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
					.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
					.addComponent(btnLoadTestData, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnClose)
					.addGap(43))
		);
		gl_btnPanel.setVerticalGroup(
			gl_btnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_btnPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnClearFields)
						.addComponent(btnClose)
						.addComponent(btnLoadTestData))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		btnPanel.setLayout(gl_btnPanel);
		
		JLabel lblCompany = new JLabel("Company");
		
		JLabel lblTo = new JLabel("To");
		
		JLabel lblFrom = new JLabel("From");
		
		JLabel lblType = new JLabel("Priority Type");
		
		JLabel lblWeightCost = new JLabel("Weight Cost");
		
		JLabel lblVolumeCost = new JLabel("Volume Cost");
		
		JLabel lblMaxWeight = new JLabel("Max Weight");
		
		JLabel lblMaxVolume = new JLabel("Max Volume");
		
		JLabel lblDuration = new JLabel("Duration");
		
		JLabel lblFrequency = new JLabel("Frequency");
		
		JLabel lblDay = new JLabel("Day");
		
		String[] company={"Test Company"};
		cmbCompany = new JComboBox(company);
		
		String[] destinations={"Rome","Sydney","London","New York","Singapore","Japan","Manila","Fiji","Hawaii","Moscow"};
		cmbTo = new JComboBox(destinations);
		String[] distributionCenters={"Auckland","Hamilton","Rotorua","Palmerston North","Wellington","Christ Church","Dunedin"};
		cmbFrom = new JComboBox(distributionCenters);
		String [] priority={"Domestic Air","International Air","Domestic Standard","Internation Standard Priority"};
		cmbType = new JComboBox(priority);
		
		txtWeightCost_1=new JFormattedTextField();
		txtWeightCost_1.addKeyListener(new KeyAdapter() { 
	         public void keyTyped(KeyEvent e) {  
	           char c = e.getKeyChar();  
	           if (!(Character.isDigit(c) ||  
	              (c == KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_PERIOD)||
	              (c == KeyEvent.VK_DELETE))) {  
	                e.consume();  
	              }  
	         }  
	   });  
		txtVolumeCost = new JFormattedTextField();
		txtVolumeCost.setText("");
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
		txtMaxWeight = new JFormattedTextField();
		 txtMaxWeight.addKeyListener(new KeyAdapter() { 
	         public void keyTyped(KeyEvent e) {  
	           char c = e.getKeyChar();  
	           if (!(Character.isDigit(c) ||  
	              (c == KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_PERIOD)||
	              (c == KeyEvent.VK_DELETE))) {  
	                e.consume();  
	              }  
	         }  
	   });  
		
		txtMaxVolume = new JFormattedTextField();
		txtMaxVolume.addKeyListener(new KeyAdapter() { 
	         public void keyTyped(KeyEvent e) {  
	           char c = e.getKeyChar();  
	           if (!(Character.isDigit(c) ||  
	              (c == KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_PERIOD)||
	              (c == KeyEvent.VK_DELETE))) {  
	                e.consume();  
	              }  
	         }  
	   });  
		
		txtDuration = new JFormattedTextField();
		txtDuration.addKeyListener(new KeyAdapter() { 
	         public void keyTyped(KeyEvent e) {  
	           char c = e.getKeyChar();  
	           if (!(Character.isDigit(c) ||  
	              (c == KeyEvent.VK_BACK_SPACE) ||
	              (c == KeyEvent.VK_DELETE))) {  
	                e.consume();  
	              }  
	         }  
	   });  
		
		txtFrequency = new JFormattedTextField();
		String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		cmbDay = new JComboBox(days);
		DateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
		 //txtDate = new JFormattedTextField(dateFormat);
		txtDate = new JFormattedTextField(dateFormat);
		//txtDate .addKeyListener(new KeyAdapter() { 
	   //      public void keyTyped(KeyEvent e) {  
	   //        char c = e.getKeyChar();  
	   //        if (!(Character.isDigit(c) ||  
	   //           (c == KeyEvent.VK_BACK_SPACE) ||
	   //           (c == KeyEvent.VK_DELETE))) {  
	  //              e.consume();  
	 //             }  
	  //       }  
	 //  });  
		txtDate.setToolTipText("Please enter date ");
		
		JLabel lblDate = new JLabel("Date");
		
		txtCostId = new JTextField();
		txtCostId.setColumns(10);
		
		JLabel lblTransportCostId = new JLabel("Route ID");
		
		txtWeightCost_1_1 = new JFormattedTextField();
		getContentPane().setLayout(groupLayout);
		//Clear all Combox Boxes on startup preloaded with data
		cmbCompany.setSelectedIndex(-1);
		cmbTo.setSelectedIndex(-1);
		cmbFrom.setSelectedIndex(-1);
		cmbType.setSelectedIndex(-1);
		cmbDay.setSelectedIndex(-1);
		GroupLayout gl_DataInputPanel = new GroupLayout(DataInputPanel);
		gl_DataInputPanel.setHorizontalGroup(
			gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DataInputPanel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCompany)
								.addComponent(lblTransportCostId))
							.addGap(55)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtCostId)
								.addComponent(cmbCompany, 0, 163, Short.MAX_VALUE)))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblWeightCost)
								.addComponent(lblDuration)
								.addComponent(lblMaxWeight)
								.addComponent(lblDay, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(44)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtWeightCost_1_1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblVolumeCost)
									.addGap(18)
									.addComponent(txtVolumeCost, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtMaxWeight, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtDuration, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
										.addComponent(cmbDay, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
									.addGap(25)
									.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_DataInputPanel.createSequentialGroup()
											.addComponent(lblMaxVolume)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtMaxVolume, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING, false)
											.addGroup(gl_DataInputPanel.createSequentialGroup()
												.addComponent(lblDate)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
											.addGroup(gl_DataInputPanel.createSequentialGroup()
												.addComponent(lblFrequency)
												.addGap(18)
												.addComponent(txtFrequency, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))))))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addComponent(lblType)
									.addGap(39)
									.addComponent(cmbType, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(Alignment.LEADING, gl_DataInputPanel.createSequentialGroup()
									.addComponent(lblTo, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(cmbTo, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)))
							.addGap(34)
							.addComponent(lblFrom)
							.addGap(18)
							.addComponent(cmbFrom, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
					.addGap(33))
		);
		gl_DataInputPanel.setVerticalGroup(
			gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DataInputPanel.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTransportCostId)
						.addComponent(txtCostId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCompany)
						.addComponent(cmbCompany, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(cmbTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addGap(6)
									.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(cmbFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFrom)))))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(12)
							.addComponent(lblTo)))
					.addGap(6)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(6)
							.addComponent(lblType)
							.addGap(24)
							.addComponent(lblWeightCost)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblVolumeCost)
								.addComponent(txtWeightCost_1_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtVolumeCost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(14)))
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(34)
							.addComponent(lblDuration))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtMaxWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblMaxWeight)
										.addComponent(lblMaxVolume)))
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addGap(4)
									.addComponent(txtMaxVolume, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtDuration, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFrequency)
								.addComponent(txtFrequency, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addGap(18)
									.addComponent(lblDay))
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblDate)
										.addComponent(cmbDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
					.addGap(39))
		);
		DataInputPanel.setLayout(gl_DataInputPanel);

	}
}