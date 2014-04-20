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
		setTitle("Transport Cost Update");
		setClosable(true);
		setBounds(100, 100, 532, 399);
		setLocation(400,150);
		JPanel DataInputPanel = new JPanel();
		
		JPanel btnPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(DataInputPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
						.addComponent(btnPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(DataInputPanel, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(107))
		);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Clicking on this button will clear the fields to data entry",null, 1);
			}
		});
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Clicking on this button will save new details entered to data logger",null, 1);
			}
		});
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Clicking on this button will update existing details to data logger",null, 1);
			}
		});
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout gl_btnPanel = new GroupLayout(btnPanel);
		gl_btnPanel.setHorizontalGroup(
			gl_btnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAdd)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSave)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnUpdate)
					.addGap(18)
					.addComponent(btnClose)
					.addContainerGap(184, Short.MAX_VALUE))
		);
		gl_btnPanel.setVerticalGroup(
			gl_btnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_btnPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_btnPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnSave)
						.addComponent(btnUpdate)
						.addComponent(btnClose)))
		);
		btnPanel.setLayout(gl_btnPanel);
		
		JLabel lblCompany = new JLabel("Company");
		
		JLabel lblTo = new JLabel("To");
		
		JLabel lblFrom = new JLabel("From");
		
		JLabel lblType = new JLabel("Type");
		
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
		
		JFormattedTextField txtWeightCost = new JFormattedTextField();
		//Format text box to accept digits only
		 txtWeightCost = new JFormattedTextField();
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
		
		JFormattedTextField txtVolumeCost = new JFormattedTextField();
		txtVolumeCost.setText("");
		
		JFormattedTextField txtMaxWeight = new JFormattedTextField();
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
		
		JFormattedTextField txtMaxVolume = new JFormattedTextField();
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
		
		JFormattedTextField txtDuration = new JFormattedTextField();
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
		
		JFormattedTextField txtFrequency = new JFormattedTextField();
		
		
		JComboBox cmbDay = new JComboBox();
		
		DateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
		 //txtDate = new JFormattedTextField(dateFormat);
		JFormattedTextField txtDate = new JFormattedTextField(dateFormat);
		
		txtDate.setToolTipText("Please enter date ");
		
		JLabel lblDate = new JLabel("Date");
		GroupLayout gl_DataInputPanel = new GroupLayout(DataInputPanel);
		gl_DataInputPanel.setHorizontalGroup(
			gl_DataInputPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_DataInputPanel.createSequentialGroup()
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_DataInputPanel.createSequentialGroup()
											.addContainerGap()
											.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_DataInputPanel.createSequentialGroup()
													.addComponent(lblCompany, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addGap(43))
												.addGroup(gl_DataInputPanel.createSequentialGroup()
													.addComponent(lblTo, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
													.addGap(64))))
										.addGroup(gl_DataInputPanel.createSequentialGroup()
											.addContainerGap()
											.addComponent(lblType)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_DataInputPanel.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblWeightCost)
										.addGap(18)))
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addContainerGap()
									.addComponent(lblMaxWeight)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_DataInputPanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblDuration)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDay, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cmbTo, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(cmbCompany, 0, 126, Short.MAX_VALUE))
							.addGap(62)
							.addComponent(lblFrom)
							.addGap(18)
							.addComponent(cmbFrom, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(42))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addComponent(cmbType, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(cmbDay, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtDuration, Alignment.LEADING)
								.addComponent(txtMaxWeight, Alignment.LEADING)
								.addComponent(txtWeightCost, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
							.addGap(20)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblVolumeCost)
								.addComponent(lblMaxVolume)
								.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblDate)
									.addComponent(lblFrequency)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtFrequency, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
										.addComponent(txtMaxVolume, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
										.addComponent(txtVolumeCost))
									.addGap(31))
								.addGroup(gl_DataInputPanel.createSequentialGroup()
									.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))))
		);
		gl_DataInputPanel.setVerticalGroup(
			gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DataInputPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addComponent(cmbCompany, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cmbTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbFrom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblFrom)))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addComponent(lblCompany)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblTo)))
					.addGap(18)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblType)
						.addComponent(cmbType, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtWeightCost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWeightCost)
						.addComponent(txtVolumeCost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVolumeCost))
					.addGap(18)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMaxWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMaxWeight)
						.addComponent(txtMaxVolume, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMaxVolume))
					.addGap(18)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtDuration, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDuration)
						.addComponent(txtFrequency, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFrequency))
					.addGap(18)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDay)
						.addComponent(lblDate))
					.addContainerGap(134, Short.MAX_VALUE))
		);
		DataInputPanel.setLayout(gl_DataInputPanel);
		getContentPane().setLayout(groupLayout);

	}

}
