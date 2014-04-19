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

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MailDelivery extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JButton btnClose;
	private JButton btnAdd;
	private JButton btnSave;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnCancel;
	private JFormattedTextField txtVolume;
	private JFormattedTextField txtWeight;
	private JFormattedTextField txtDate;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxOrigin;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxDestination;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxDay;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBoxPriority;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MailDelivery() {
		setClosable(true);
		setTitle("Mail Delivery");
		setBounds(100, 100, 513, 356);
		setLocation(400,150);
		JPanel DataInputPanel = new JPanel();
		
		JPanel btnPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addComponent(DataInputPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(DataInputPanel, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPanel, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtWeight.setText("");
				txtVolume.setText("");
				txtDate.setText("");
				comboBoxOrigin.setSelectedIndex(0);
				comboBoxDestination.setSelectedIndex(0);;

				comboBoxDay.setSelectedIndex(0);;
				comboBoxPriority.setSelectedIndex(0);
				
			}
			
		});
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Clicking on this button will save new mail delivery details entered to data logger",null, 1);
			}
		});
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Clicking on this button will delete existing mail delivery details in data logger",null, 1);
			}
		});
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Clicking on this button will update existing mail delivery details in data logger",null, 1);
			}
		});
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Clicking on this button will cancel the current operation",null, 1);
			}
		});
		
		btnClose = new JButton("Close");
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
					.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSave)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnDelete)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUpdate)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancel)
					.addGap(27)
					.addComponent(btnClose)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_btnPanel.setVerticalGroup(
			gl_btnPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_btnPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_btnPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnSave)
						.addComponent(btnDelete)
						.addComponent(btnUpdate)
						.addComponent(btnCancel)
						.addComponent(btnClose))
					.addContainerGap())
		);
		btnPanel.setLayout(gl_btnPanel);

		JLabel lblOrigin = new JLabel("Origin");
		
		JLabel lblDestination = new JLabel("Destination");
		
		JLabel lblWeight = new JLabel("Weight");
		
		JLabel lblVolume = new JLabel("Volume");
		
		JLabel lblTimeOfEntry = new JLabel("Time Of Entry");
		
		JLabel lblPriority = new JLabel("Priority");
		
		//Define Distribution Centers
		String[] distributionCenters={"","Auckland","Hamilton","Rotorua","Palmerston North","Wellington","Christ Church","Dunedin"};
		comboBoxOrigin = new JComboBox(distributionCenters);
		comboBoxOrigin.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent ie) {
				String itemSelected=ie.getItem().toString();
				if (itemSelected==""){
					JOptionPane.showMessageDialog(null,"Please select port of orgin from the list.",null, 1);
				}
			}
			
		});
		
		
		
		comboBoxOrigin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		//Define the destinations
		
		String[] destinations={"","Rome","Sydney","London","New York","Singapore","Japan","Manila","Fiji","Hawaii","Moscow"};

		comboBoxDestination = new JComboBox(destinations);
		
		//Define Days of the week and loads them inot the combo box
		String[] days={"","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

		comboBoxDay = new JComboBox(days);
		
		
		//Format date field to accept 'dd-mm-yyyy' format
		DateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
		 txtDate = new JFormattedTextField(dateFormat);
		txtDate.setToolTipText("Enter Date");
		//Define Mail Priority
		
		String [] mailPriority={"","Domestic Air","Internal Air","Domestic Standard","Internation Standard Priority"};
		comboBoxPriority = new JComboBox(mailPriority);
		
		JLabel lblDeliveryId = new JLabel("Delivery ID");
		
		JLabel lblDeliveryID = new JLabel("");
		lblDeliveryID.setBackground(Color.PINK);
		lblDeliveryID.setForeground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("Delivery ID");
		lblNewLabel.setBackground(Color.GREEN);
		//Format Weight Text Box to allow numbers only
		txtWeight = new JFormattedTextField();
		txtWeight.addKeyListener(new KeyAdapter() { 
				         public void keyTyped(KeyEvent e) {  
				           char c = e.getKeyChar();  
				           if (!(Character.isDigit(c) ||  
				              (c == KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_PERIOD)||
				              (c == KeyEvent.VK_DELETE))) {  
				                e.consume();  
				              }  
				         }  
				   });  
					
		//Format text box to accept digits only
		txtVolume = new JFormattedTextField();
		txtVolume.addKeyListener(new KeyAdapter() { 
	         public void keyTyped(KeyEvent e) {  
	           char c = e.getKeyChar();  
	           if (!(Character.isDigit(c) ||  
	              (c == KeyEvent.VK_BACK_SPACE) || (c==KeyEvent.VK_PERIOD)||
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
						.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_DataInputPanel.createSequentialGroup()
								.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblPriority, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblTimeOfEntry, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblWeight)
									.addComponent(lblDestination, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
									.addComponent(lblOrigin))
								.addPreferredGap(ComponentPlacement.RELATED))
							.addGroup(gl_DataInputPanel.createSequentialGroup()
								.addComponent(lblDeliveryId)
								.addGap(47)))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addComponent(lblVolume, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(comboBoxOrigin, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(comboBoxPriority, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_DataInputPanel.createSequentialGroup()
								.addComponent(comboBoxDay, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
							.addComponent(comboBoxDestination, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblDeliveryID)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtVolume, Alignment.LEADING)
							.addComponent(txtWeight, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)))
					.addContainerGap(132, Short.MAX_VALUE))
		);
		gl_DataInputPanel.setVerticalGroup(
			gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DataInputPanel.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDeliveryId)
								.addComponent(lblNewLabel))
							.addGap(15))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addComponent(lblDeliveryID)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGap(11)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(comboBoxOrigin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOrigin))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxDestination, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDestination))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblWeight)
						.addComponent(txtWeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtVolume, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVolume))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTimeOfEntry))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxPriority, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPriority))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		DataInputPanel.setLayout(gl_DataInputPanel);
		getContentPane().setLayout(groupLayout);

	}
}
