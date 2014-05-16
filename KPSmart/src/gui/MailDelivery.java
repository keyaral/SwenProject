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
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

import Logic.Logic;


public class MailDelivery extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private JButton btnClose;
	private JButton btnClearFields;
	private JButton btnSave;
	private JFormattedTextField txtVolume;
	private JFormattedTextField txtWeight;
	private JFormattedTextField txtDate;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbOrigin;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbDestination;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbDay;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbPriority;
	private JTextField txtMailId;
	public String[] mailDeliveryDetails;
	 
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {

	}
	//Generate Random ID
	private void generateRandomId(int rnd){
		Random random=new Random();
		int id=random.nextInt(rnd);
		txtMailId.setText(Integer.toString(id));
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
	private void randomDaySelection(int item){
		Random random=new Random();
		int id=random.nextInt(item);
		Calendar calendar = Calendar.getInstance();
		//int day = calendar.get(Calendar.DAY_OF_WEEK);
		//for (int i=0;i<cmbDay.getItemCount();i++){
		//if (day==i){
			cmbDay.setSelectedIndex(id);
		//}else{
		//	cmbDay.setSelectedIndex(id);
		//}
		}
	
	private void randomPrioritySelection(int item){
		Random random=new Random();
		int id=random.nextInt(item);
		cmbPriority.setSelectedIndex(id);
	}
	private void generateRandWeightAndVolume(){
		Random random=new Random();
		double number=random.nextDouble();
		txtWeight.setText(Double.toString(Math.round(number*100)));
		txtVolume.setText(Double.toString(Math.round(number*50)));
	}
	private void generateRandomDate(){
		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
		Date date = new Date();
		txtDate.setText(dateFormat.format(date));
	}
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MailDelivery() {
		setClosable(true);
		setTitle("Mail Delivery");
		setBounds(100, 100, 558, 356);
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
		
		btnClearFields = new JButton("Clear Fields");
		btnClearFields.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				txtMailId.setText("");
				txtWeight.setText("");
				txtVolume.setText("");
				txtDate.setText("");
				cmbDay.setSelectedIndex(-1);
				cmbDestination.setSelectedIndex(-1);
				cmbOrigin.setSelectedIndex(-1);
				cmbPriority.setSelectedIndex(-1);
				
				 btnSave.setEnabled(true);
				 btnClearFields.setEnabled(false);
				
			}
			
		});
		
		btnSave = new JButton("Send");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String destination=(String)cmbDestination.getSelectedItem();
				String origin=(String)cmbOrigin.getSelectedItem();
				String day=(String)cmbDay.getSelectedItem();
				String priority=(String)cmbPriority.getSelectedItem();
				int dialogButton = JOptionPane.YES_NO_OPTION;
				if (txtMailId.getText().equals("")|| destination.equals("") 
						|| origin.equals("")
						|| day.equals("")
						|| txtWeight.getText().equals("")
						|| txtVolume.getText().equals("")
						|| txtDate.getText().equals("")){
					
					JOptionPane.showMessageDialog(null,"Please enter all details",null, 1);
				}else{
					
					int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to send this mail item?","Confirmation",dialogButton);
					if(dialogResult == JOptionPane.YES_OPTION){
						btnSave.setEnabled(false);

							
							String[]  details ={ "5",txtMailId.getText(), destination ,
											origin, txtWeight.getText(),
											txtVolume.getText(),priority,txtDate.getText()  };
							
							JOptionPane.showMessageDialog(null,MainWindow.logic.processform(details),null, 1);
							MainWindow.bMonitoring.updateMonitor();
		

				//		String type= MainWindow.logic.switchEvents(3,"3a"); //Case 3: Type "3a" Send  Mail
						
					
							//}
					}else{	
						//Do nothing
						JOptionPane.showMessageDialog(null,"Canceled",null, 1);
						
						
					}
					
				}
				
			}
		});
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] close={"Closing Mail Delivery Form"};
			
				dispose();
			}
		});
		
		JButton btnLoadTestData = new JButton("Load Test Data");
		btnLoadTestData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 generateRandomId(1000);
				 randomDestinationSelection(cmbDestination.getItemCount());
				 randomOriginSelection(cmbOrigin.getItemCount());
				 randomDaySelection(cmbDay.getItemCount());
				 randomPrioritySelection(cmbPriority.getItemCount());
				 generateRandWeightAndVolume();
				 generateRandomDate();
				 generateRandWeightAndVolume();
				 btnSave.setEnabled(true);
				 btnClearFields.setEnabled(true);
			}
		});
		GroupLayout gl_btnPanel = new GroupLayout(btnPanel);
		gl_btnPanel.setHorizontalGroup(
			gl_btnPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_btnPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnClearFields)
					.addGap(5)
					.addComponent(btnSave)
					.addGap(59)
					.addComponent(btnLoadTestData, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addGap(58)
					.addComponent(btnClose)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		gl_btnPanel.setVerticalGroup(
			gl_btnPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_btnPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_btnPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClearFields)
						.addComponent(btnClose)
						.addComponent(btnSave)
						.addComponent(btnLoadTestData))
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
		String[] distributionCenters=MainWindow.logic.getNZDestinations();
		cmbOrigin = new JComboBox(distributionCenters);
		cmbOrigin.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent ie) {
				//String itemSelected=ie.getItem().toString();
				//if (itemSelected==""){
				//	JOptionPane.showMessageDialog(null,"Please select port of orgin from the list.",null, 1);
				//}
			}
			
		});
		
		
		
		cmbOrigin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		//Define the destinations
		
		
		String[] destinations= MainWindow.logic.getDestinations();
			//{"Rome","Sydney","London","New York","Singapore","Japan","Manila","Fiji","Hawaii","Moscow"};

		cmbDestination = new JComboBox(destinations);
		
		//Define Days of the week and loads them into the combo box
		String[] days={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

		cmbDay = new JComboBox(days);
		
		
		//Format date field to accept 'dd-mm-yyyy' format
		DateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
		 txtDate = new JFormattedTextField(dateFormat);
		txtDate.setToolTipText("Enter Date");
		//Define Mail Priority
		
		String [] mailPriority={"Domestic Standard","Domestic Air","International Standard Priority", "International Air",};
		cmbPriority = new JComboBox(mailPriority);
		
		JLabel lblDeliveryId = new JLabel("Delivery ID");
		
		JLabel lblDeliveryID = new JLabel("");
		lblDeliveryID.setBackground(Color.PINK);
		lblDeliveryID.setForeground(Color.BLACK);
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
		
		txtMailId = new JTextField();
		txtMailId.setColumns(10);
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
							.addComponent(cmbOrigin, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cmbPriority, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_DataInputPanel.createSequentialGroup()
								.addComponent(cmbDay, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
							.addComponent(cmbDestination, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(lblDeliveryID)
						.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtVolume, Alignment.LEADING)
							.addComponent(txtWeight, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
						.addComponent(txtMailId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
								.addComponent(txtMailId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(15))
						.addGroup(gl_DataInputPanel.createSequentialGroup()
							.addComponent(lblDeliveryID)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGap(11)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(cmbOrigin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblOrigin))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbDestination, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
						.addComponent(cmbDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTimeOfEntry))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_DataInputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbPriority, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPriority))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		DataInputPanel.setLayout(gl_DataInputPanel);
		getContentPane().setLayout(groupLayout);
		btnSave.setEnabled(false);
		btnClearFields.setEnabled(false);
		//Clear combo Boxes on startup.
		cmbDay.setSelectedIndex(-1);
		cmbDestination.setSelectedIndex(-1);
		cmbOrigin.setSelectedIndex(-1);
		cmbPriority.setSelectedIndex(-1);

	}
}
