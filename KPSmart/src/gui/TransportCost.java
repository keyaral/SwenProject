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
	private JFormattedTextField txtWeightCost_1;
	private JTextField txtCostId;
	private JFormattedTextField txtFrequency;
	private JComboBox cmbDay;
	private JFormattedTextField txtVolumeCost;
	private JFormattedTextField txtMaxWeight;
	private JFormattedTextField txtDuration;
	private JFormattedTextField txtDate;
	private JFormattedTextField txtWeightCost;
	private JFormattedTextField txtMaxVolume;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("rawtypes")
	public TransportCost() {
		super("Transport Cost Update");
		setTitle("Transport Cost Update");
		setClosable(true);
		setBounds(100, 100, 532, 420);
		setLocation(400,150);
		JPanel DataInputPanel = new JPanel();
		
		JPanel btnPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(DataInputPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(DataInputPanel, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnPanel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
		);
		
		JButton btnClearFields = new JButton("Clear Fields");
		btnClearFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logic logic=new Logic();
				logic.processform("\nProcessing Transport Cost Form");
				JOptionPane.showMessageDialog(null,"Clear Fields!"+ logic.getdetails(),null, 1);
			}
		});
		
		JButton btnSave = new JButton("Send/Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtCostId.getText().equals("") || txtWeightCost_1.getText().equals("") ||
						txtVolumeCost.getText().equals("") || txtMaxVolume.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Enter all Details !"+MainWindow.logic.getdetails(),null, 1);
					
				}else{
					String values=MainWindow.logic.getTransporCostDetails(
						Integer.parseInt(txtCostId.getText()),
						cmbCompany.getSelectedItem().toString(),
						cmbTo.getSelectedItem().toString(),
						cmbFrom.getSelectedItem().toString(),
						cmbType.getSelectedItem().toString(),
						Double.parseDouble(txtWeightCost_1.getText()),
						Double.parseDouble(txtVolumeCost.getText()),
						Double.parseDouble(txtMaxWeight.getText()),
						Double.parseDouble(txtMaxVolume.getText()),
						Integer.parseInt(txtDuration.getText()),
						Integer.parseInt(txtFrequency.getText()),
						txtDate.getText());
				
				JOptionPane.showMessageDialog(null,"Save Details !"+MainWindow.logic.getdetails() + values,null, 1);
				}
				
			}
		});
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logic logic=new Logic();
				logic.processform("\nClosing Transport Cost Form");
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
		
		cmbCompany = new JComboBox();
		
		cmbTo = new JComboBox();
		
		cmbFrom = new JComboBox();
		
		cmbType = new JComboBox();
		
		txtWeightCost = new JFormattedTextField();
		//Format text box to accept digits only
		 txtWeightCost_1 = new JFormattedTextField();
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
	              (c == KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_PERIOD)||
	              (c == KeyEvent.VK_DELETE))) {  
	                e.consume();  
	              }  
	         }  
	   });  
		
		txtFrequency = new JFormattedTextField();
		cmbDay = new JComboBox();
		DateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
		 //txtDate = new JFormattedTextField(dateFormat);
		txtDate = new JFormattedTextField(dateFormat);
		
		txtDate.setToolTipText("Please enter date ");
		
		JLabel lblDate = new JLabel("Date");
		
		txtCostId = new JTextField();
		txtCostId.setColumns(10);
		
		JLabel lblTransportCostId = new JLabel("Transport Cost ID");
		GroupLayout gl_DataInputPanel = new GroupLayout(DataInputPanel);
		gl_DataInputPanel.setHorizontalGroup(
			gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DataInputPanel.createSequentialGroup()
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, gl_DataInputPanel.createSequentialGroup()
									.addGap(10)
									.addComponent(lblTransportCostId)
									.addGap(18)
									.addComponent(txtCostId))
								.addGroup(Alignment.LEADING, gl_DataInputPanel.createSequentialGroup()
									.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_DataInputPanel.createSequentialGroup()
											.addGap(21)
											.addComponent(lblWeightCost))
										.addGroup(gl_DataInputPanel.createSequentialGroup()
											.addGap(10)
											.addComponent(lblType))
										.addGroup(gl_DataInputPanel.createSequentialGroup()
											.addGap(10)
											.addComponent(lblTo, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_DataInputPanel.createSequentialGroup()
											.addGap(10)
											.addComponent(lblCompany)))
									.addGap(30)
									.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(txtWeightCost_1)
										.addComponent(cmbType, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cmbTo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(cmbCompany, 0, 140, Short.MAX_VALUE))))
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addGap(20)
									.addComponent(lblVolumeCost)
									.addGap(10)
									.addComponent(txtVolumeCost, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_DataInputPanel.createSequentialGroup()
									.addGap(44)
									.addComponent(lblFrom)
									.addGap(10)
									.addComponent(cmbFrom, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMaxWeight)
								.addComponent(lblDuration)
								.addComponent(lblDay, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(43)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addComponent(cmbDay, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addComponent(lblDate)
									.addGap(38)
									.addComponent(txtDate))
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addComponent(txtDuration, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addComponent(lblFrequency)
									.addGap(10)
									.addComponent(txtFrequency, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addComponent(txtMaxWeight, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
									.addGap(22)
									.addComponent(lblMaxVolume)
									.addGap(10)
									.addComponent(txtMaxVolume, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))))
					.addGap(31))
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
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addGap(3)
									.addComponent(lblFrom))
								.addComponent(cmbFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtWeightCost_1)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblWeightCost))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblVolumeCost))
						.addComponent(txtVolumeCost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblMaxWeight))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblMaxVolume))
						.addComponent(txtMaxVolume, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtMaxWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDuration))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblFrequency))
						.addComponent(txtFrequency, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDuration, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDay))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDate))
						.addComponent(cmbDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28))
		);
		DataInputPanel.setLayout(gl_DataInputPanel);
		getContentPane().setLayout(groupLayout);

	}
}
