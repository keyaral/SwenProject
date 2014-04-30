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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
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
		
		JButton btnClearFields = new JButton("Clear Fields");
		btnClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						txtCostId.setText("");
						cmbCompany.setSelectedItem("");
						cmbTo.setSelectedItem("");
						cmbFrom.setSelectedItem("");
						cmbType.setSelectedItem("");
						txtWeightCost_1.setText("");
						txtVolumeCost.setText("");
						txtMaxWeight.setText("");
						txtMaxVolume.setText("");
						txtDuration.setText("");
						txtFrequency.setText("");
						cmbDay.setSelectedItem("");
						txtDate.setText("");
				MainWindow.logic.processform("Transport Route Form --> Fields Cleared.");
				JOptionPane.showMessageDialog(null,"Clear Fields!",null, 1);
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
						cmbCompany.getSelectedItem().toString()+"\t"+
						cmbTo.getSelectedItem().toString()+"\t"+
						cmbFrom.getSelectedItem().toString()+"\t"+
						cmbType.getSelectedItem().toString()+"\t"+
						txtWeightCost_1.getText()+"\t"+
						txtVolumeCost.getText()+"\t"+
						txtMaxWeight.getText()+"\t"+
						txtMaxVolume.getText()+"\t"+
						txtDuration.getText()+"\t"+
						txtFrequency.getText()+"\t"+
						cmbDay.getSelectedItem().toString() +"\t"+
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
		GroupLayout gl_btnPanel = new GroupLayout(btnPanel);
		gl_btnPanel.setHorizontalGroup(
			gl_btnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnClearFields)
					.addGap(10)
					.addComponent(btnSave)
					.addGap(95)
					.addComponent(btnClose)
					.addContainerGap(178, Short.MAX_VALUE))
		);
		gl_btnPanel.setVerticalGroup(
			gl_btnPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_btnPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_btnPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSave)
						.addComponent(btnClearFields)
						.addComponent(btnClose))
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
		
		String[] company={"","Test Company"};
		cmbCompany = new JComboBox(company);
		
		String[] destinations={"","Rome","Sydney","London","New York","Singapore","Japan","Manila","Fiji","Hawaii","Moscow"};
		cmbTo = new JComboBox(destinations);
		String[] distributionCenters={"","Auckland","Hamilton","Rotorua","Palmerston North","Wellington","Christ Church","Dunedin"};
		cmbFrom = new JComboBox(distributionCenters);
		String [] priority={"","Domestic Air","International Air","Domestic Standard","Internation Standard Priority"};
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
		String[] days={"","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
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
		
		JLabel lblTransportCostId = new JLabel("Transport Cost ID");
		
		txtWeightCost_1 = new JFormattedTextField();
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
									.addComponent(txtWeightCost_1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
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
										.addGroup(gl_DataInputPanel.createSequentialGroup()
											.addComponent(cmbDay, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
											.addGap(28)
											.addComponent(lblDate)))
									.addGap(18)
									.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtDate)
										.addComponent(txtFrequency, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))))))
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
								.addComponent(txtWeightCost_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDate))
						.addComponent(cmbDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28))
		);
		DataInputPanel.setLayout(gl_DataInputPanel);
		getContentPane().setLayout(groupLayout);

	}
	
}