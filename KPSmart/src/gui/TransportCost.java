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
	private JFormattedTextField txtMaxVolume;
	private JFormattedTextField txtWeightCost_1;
	private JFormattedTextField txtWeightCosts;
	private JButton btnClearFields;

	private JButton btnSave;
	//Generate Random ID
	private void generateRandomId(int rnd){
		Random random=new Random();
		int id=random.nextInt(rnd);
		txtCostId.setText(Integer.toString(id));
		
	}
	private void randomCompanySelection(int item){
		Random random=new Random();
		int id=random.nextInt(item);
		cmbCompany.setSelectedIndex(id);
	}
	private void generateRadomDurationFrequency(int rnd){
		Random random=new Random();
		int number=random.nextInt(rnd);
		txtDuration.setText(Integer.toString(number));
		txtFrequency.setText(Integer.toString(number*2));
		
	}
	private void generateMaxRandWeightAndVolume(int rnd){
		Random random=new Random();
		int number=random.nextInt(rnd);
		txtMaxWeight.setText(Integer.toString(number));
		txtMaxVolume.setText(Integer.toString((number*2)));
	}
	private void randomDestinationSelection(int item){
		Random random=new Random();
		int id=random.nextInt(item);
		cmbFrom.setSelectedIndex(id);
	}
	private void randomOriginSelection(int item){
		Random random=new Random();
		int id=random.nextInt(item);
		cmbTo.setSelectedIndex(id);
	}
	private void randomDaySelection(int item){
		Random random=new Random();
		int id=random.nextInt(item);
			cmbDay.setSelectedIndex(id);
		}
	
	private void randomPrioritySelection(int item){
		Random random=new Random();
		int id=random.nextInt(item);
		cmbType.setSelectedIndex(id);
	}
	private void generateRandWeightAndVolume(int rnd){
		Random random=new Random();
		int number=random.nextInt(rnd);
		txtWeightCosts.setText(Integer.toString(number));
		txtVolumeCost.setText(Integer.toString(number*2));
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TransportCost() {
		super("Transport Cost Update");
		setTitle("Transport Route");
		setClosable(true);
		setBounds(100, 100, 532, 391);
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
							.addComponent(DataInputPanel, GroupLayout.PREFERRED_SIZE, 497, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(9)
							.addComponent(btnPanel, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(DataInputPanel, GroupLayout.PREFERRED_SIZE, 297, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPanel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(37))
		);
		
		btnClearFields = new JButton("Clear Fields");
		btnClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						txtCostId.setText("");
						txtWeightCosts.setText("");
						txtVolumeCost.setText("");
						txtMaxWeight.setText("");
						txtMaxVolume.setText("");
						txtDuration.setText("");
						txtFrequency.setText("");
						cmbFrom.setSelectedIndex(-1);
						cmbTo.setSelectedIndex(-1);
						cmbDay.setSelectedIndex(-1);
						cmbType.setSelectedIndex(-1);
						cmbCompany.setSelectedIndex(-1);
						btnSave.setEnabled(false);
						cmbType.setEnabled(true);
						txtCostId.setEnabled(true);
						txtFrequency.setEnabled(true);
						cmbDay.setEnabled(true);
						txtVolumeCost.setEnabled(true);
						txtMaxWeight.setEnabled(true);
						txtDuration.setEnabled(true);
						txtMaxVolume.setEnabled(true);
						txtWeightCosts.setEnabled(true);
						btnClearFields.setEnabled(true);
			}
		});
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String company=(String)cmbCompany.getSelectedItem();
				String to=(String)cmbTo.getSelectedItem().toString();
				String from=(String)cmbFrom.getSelectedItem().toString();
				String day=(String)cmbDay.getSelectedItem().toString();
				String priority=(String)cmbType.getSelectedItem().toString();
				int dialogButton = JOptionPane.YES_NO_OPTION;
				if (txtCostId.getText().equals("")
						||company.equals("") 
						|| to.equals("")
						||from.equals("")
						||txtWeightCosts.getText().equals("")
						|| txtVolumeCost.getText().equals("")
						||txtMaxWeight.getText().equals("")
						||txtMaxVolume.getText().equals("")
						|| txtDuration.getText().equals("")
						|| txtFrequency.getText().equals("")
						|| priority.equals("")
						|| day.equals("")){
					JOptionPane.showMessageDialog(null,"Please enter all details required !",null, 1);
						
			}else
			{
				
				int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to save the details?","Confirmation",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					String type=MainWindow.logic.switchEvents(0, "1a");//Case 0: Type "1a"-call route
					String values=type+
						txtCostId.getText()+"\t"+
						cmbTo.getSelectedItem().toString()+"\t"+
						cmbFrom.getSelectedItem().toString()+"\t"+
						txtWeightCosts.getText()+"\t"+
						txtVolumeCost.getText()+"\t"+
						txtMaxWeight.getText()+"\t"+
						txtMaxVolume.getText()+"\t"+
						cmbType.getSelectedIndex()+"\t"+
						cmbDay.getSelectedItem().toString() +"\t"+
						txtFrequency.getText()+"\t"+
						txtDuration.getText()+"\t"+
						cmbCompany.getSelectedItem().toString();
					//Disable the save buutton to avoid double entry
					btnSave.setEnabled(false);
					cmbType.setEnabled(false);
					txtCostId.setEnabled(false);
					txtFrequency.setEnabled(false);
					cmbDay.setEnabled(false);;
					txtVolumeCost.setEnabled(false);
					txtMaxWeight.setEnabled(false);
					txtDuration.setEnabled(false);
					txtMaxVolume.setEnabled(false);
					txtWeightCosts.setEnabled(false);
					cmbTo.setEnabled(false);
					cmbFrom.setEnabled(false);
					btnClearFields.setEnabled(false);
					cmbCompany.setEnabled(false);
					
					MainWindow.logic.processform(values);
				//JOptionPane.showMessageDialog(null,"Route Form: Save Details !",null, 1);
				}else{
					//Details not saved
					JOptionPane.showMessageDialog(null,"Details not saved !",null, 1);
					
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
			public void actionPerformed(ActionEvent e) {
				generateRandomId(100);
				randomCompanySelection(cmbCompany.getItemCount());
				generateRandWeightAndVolume(100);
				randomPrioritySelection(cmbType.getItemCount());
				randomDaySelection(cmbDay.getItemCount());
				randomOriginSelection(cmbTo.getItemCount());
				randomDestinationSelection(cmbFrom.getItemCount());
				generateRadomDurationFrequency(100);
				generateMaxRandWeightAndVolume(100);
				String values=
						txtCostId.getText()+"\t"+
						cmbTo.getSelectedItem().toString()+"\t"+
						cmbFrom.getSelectedItem().toString()+"\t"+
						txtWeightCosts.getText()+"\t"+
						txtVolumeCost.getText()+"\t"+
						txtMaxWeight.getText()+"\t"+
						txtMaxVolume.getText()+"\t"+
						cmbType.getSelectedIndex()+"\t"+
						cmbDay.getSelectedItem().toString() +"\t"+
						txtFrequency.getText()+"\t"+
						txtDuration.getText()+"\t"+
						cmbCompany.getSelectedItem().toString();
				btnSave.setEnabled(true);
				cmbType.setEnabled(true);
				txtCostId.setEnabled(true);
				txtFrequency.setEnabled(true);
				cmbDay.setEnabled(true);
				txtVolumeCost.setEnabled(true);
				txtMaxWeight.setEnabled(true);
				txtDuration.setEnabled(true);
				txtMaxVolume.setEnabled(true);
				txtWeightCosts.setEnabled(true);
				btnClearFields.setEnabled(true);
				cmbCompany.setEnabled(true);
				cmbTo.setEnabled(true);
				cmbFrom.setEnabled(true);

				System.out.println("Test Data Loaded onto Transport Route Cost Form...");
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
					.addPreferredGap(ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
					.addComponent(btnLoadTestData, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
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
		
		txtCostId = new JTextField();
		txtCostId.setColumns(10);
		
		JLabel lblTransportCostId = new JLabel("Transport Cost ID");
		
		txtWeightCosts = new JFormattedTextField();
		GroupLayout gl_DataInputPanel = new GroupLayout(DataInputPanel);
		gl_DataInputPanel.setHorizontalGroup(
			gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DataInputPanel.createSequentialGroup()
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblTransportCostId)
							.addGap(18)
							.addComponent(txtCostId, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addGap(10)
									.addComponent(lblType))
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addGap(10)
									.addComponent(lblTo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addGap(10)
									.addComponent(lblCompany))
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblWeightCost)))
							.addGap(39)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(cmbType, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cmbTo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cmbCompany, 0, 140, Short.MAX_VALUE))
									.addGap(18)
									.addComponent(lblFrom))
								.addComponent(txtMaxWeight, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMaxWeight)
								.addComponent(lblDuration)
								.addComponent(lblDay, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(43)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addGap(3)
									.addComponent(txtWeightCosts, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_DataInputPanel.createSequentialGroup()
											.addComponent(lblMaxVolume)
											.addGap(18)
											.addComponent(txtMaxVolume, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING)
											.addComponent(cmbFrom, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_DataInputPanel.createSequentialGroup()
												.addComponent(lblVolumeCost)
												.addGap(18)
												.addComponent(txtVolumeCost, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))))
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_DataInputPanel.createSequentialGroup()
											.addComponent(txtDuration, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
											.addGap(28)
											.addComponent(lblFrequency))
										.addComponent(cmbDay, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(txtFrequency, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))))
					.addGap(16))
		);
		gl_DataInputPanel.setVerticalGroup(
			gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DataInputPanel.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTransportCostId)
						.addComponent(txtCostId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCompany)
						.addComponent(cmbCompany, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(9)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addGap(3)
									.addComponent(lblTo))
								.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblFrom)
									.addComponent(cmbFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(cmbTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(12)
							.addComponent(lblType))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(6)
							.addComponent(cmbType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(16)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblVolumeCost)
								.addComponent(txtVolumeCost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblWeightCost)
								.addComponent(txtWeightCosts, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblMaxWeight))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMaxVolume)
								.addComponent(txtMaxVolume, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(txtMaxWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDuration))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFrequency)
								.addComponent(txtFrequency, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(txtDuration, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDay))
						.addComponent(cmbDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28))
		);
		DataInputPanel.setLayout(gl_DataInputPanel);
		getContentPane().setLayout(groupLayout);
		//Clear comboxboxes on startup
		cmbFrom.setSelectedIndex(-1);
		cmbTo.setSelectedIndex(-1);
		cmbDay.setSelectedIndex(-1);
		cmbType.setSelectedIndex(-1);
		cmbCompany.setSelectedIndex(-1);

	}
	
}