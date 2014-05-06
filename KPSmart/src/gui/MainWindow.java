package gui;
import javax.swing.*;

import java.awt.event.*;
import java.awt.Color;

import javax.swing.GroupLayout.Alignment;

import Logic.Logic;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuItem menuItemMailDelivery;
	private ManagerWindow managerWindow;
	private MailDelivery mailDelivery;
	private TransportCost transportCostUpdate;
	private CostModification costModification;
	private CreateNewUser createNewUser;
	private EventLogger eventLogger;
	
	private JMenuItem menuItemTransportRoute;
	private JMenuItem transaction;
	private JMenuItem mntmCreateNewUser;
	private JMenuItem viewLog;
	private JMenuItem logOut;
	private JMenuItem exit;
	private JMenuItem mnuItemCostModification;
	public JDesktopPane desktopPane;
	
	public static final Logic logic = new Logic();
	
	public MainWindow() {
		super("KPSmart");
		this.setExtendedState(MAXIMIZED_BOTH);
		setTitle("KPSmart Postal Services");
		initComponents();
		CreateEvent();
	}

	private void initComponents(){
		setLocation(350,250);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu=new JMenu("File");
		menuBar.add(fileMenu);
		logOut=new JMenuItem("Log Out");
		logOut.setMnemonic(KeyEvent.VK_L);
		fileMenu.add(logOut);
		
		//Create menu for Transactions
		//JFrame jtransactionFrame=new JFrame("Transaction");
		JMenu jMailMenu=new JMenu("Mail Processing");
		transaction=new JMenuItem("Transaction");
		
		mnuItemCostModification=new JMenuItem("Cost Modification");
		viewLog=new JMenuItem("View Log");
		jMailMenu.add(transaction);
		
		menuItemMailDelivery = new JMenuItem("Mail Delivery");
		menuItemMailDelivery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mailDelivery.show();
			}
		});
		jMailMenu.add(menuItemMailDelivery);
		
		menuItemTransportRoute = new JMenuItem("Transport Route");
		jMailMenu.add(menuItemTransportRoute);
		jMailMenu.add(mnuItemCostModification);
		jMailMenu.add(viewLog);
		menuBar.add(jMailMenu);
		
		JMenu mnTools = new JMenu("Tools");
		menuBar.add(mnTools);
		
		mntmCreateNewUser = new JMenuItem("Create New User");
		mnTools.add(mntmCreateNewUser);
		
		//Create menu for Help
		JMenu jHelpMenu=new JMenu("Help");
		JMenuItem jHelp=new JMenuItem("Help");
		jHelp.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null,"Help will be available soon",null, 1);
				
				}	
			}
			
		);
		
		JMenuItem jAbout=new JMenuItem("About");
		jAbout.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null,"SWEN301 GROUP PROJECT:\nMembers:\n1. Marian\n2.Tyler\n3.Alex\n3.Lenz\n4.Chong",null, 1);
				
				}	
			}
			
		);
		jHelpMenu.add(jHelp);
		jHelpMenu.add(jAbout);
		menuBar.add(jHelpMenu);
		
		exit = new JMenuItem("Exit");
		exit.setMnemonic(KeyEvent.VK_X);
		fileMenu.add(exit);
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
					int action=JOptionPane.showConfirmDialog(null, "Do you want to exit?");
					if (action==0){
						JOptionPane.showMessageDialog(null,"Exiting from KPSmart ",null, 1);
						System.exit(0);
						
					}	
				
				}	
			}
			
		);
		//This action is triggered when use clicks Log Out menu item
		logOut.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				LogonWindow lWindow=new LogonWindow();
				lWindow.setVisible(true);
				dispose();
			}
			
		});
		/**
		 * Add action listener to each time in the menu
		 */

		
		//This event is fired when the user clicks on the Transaction Menu Item
		transaction.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

			} 
			
		});
		menuItemMailDelivery.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

			} 
			
		});
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(desktopPane)
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(19)
					.addComponent(desktopPane)
					.addContainerGap())
		);
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 381, Short.MAX_VALUE)
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 365, Short.MAX_VALUE)
		);
		desktopPane.setLayout(gl_desktopPane);
		getContentPane().setLayout(groupLayout);
		setSize(417, 454);
		setVisible(true);
		
	}
	
	//This is where the actions are triggered
	private void CreateEvent(){
		menuItemMailDelivery.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if (mailDelivery==null ||mailDelivery.isClosable()){ //only one instance to mail Delivery
					mailDelivery= new MailDelivery();
					desktopPane.add(mailDelivery);
					mailDelivery.show();
				}
			}
		}); 
		
		transaction.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			if (managerWindow==null || managerWindow.isClosable()){ //only one instance to managerWindow
				managerWindow= new ManagerWindow();
				desktopPane.add(managerWindow);
				managerWindow.show();
			}
				
			}
			
		});
		
		menuItemTransportRoute.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			if (transportCostUpdate==null || transportCostUpdate.isClosable()){ //only one instance to managerWindow
				transportCostUpdate= new TransportCost();
				desktopPane.add(transportCostUpdate);
				transportCostUpdate.show();
			}
				
			}
			
		});
		
		mnuItemCostModification.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			if (costModification==null || costModification.isClosable()){ //only one instance to managerWindow
				costModification= new CostModification();
				desktopPane.add(costModification);
				costModification.show();
			}
				
			}
			
		});
		
		viewLog.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (eventLogger==null || eventLogger.isClosable()){ //only one instance to managerWindow
					eventLogger= new EventLogger();
					desktopPane.add(eventLogger);
					eventLogger.update();
					eventLogger.show();
				}
			}
			
		});
		
		//This action is fired when the user clicks the Create New User menu item from the menu bar
		mntmCreateNewUser.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			if (createNewUser==null || createNewUser.isClosable()){ //only one instance to managerWindow
				createNewUser= new CreateNewUser();
				desktopPane.add(createNewUser);
				createNewUser.show();
			}
				
			}
			
		});
		
		
					
	}
	public static void main (String[] args) {
		new MainWindow();
		
	}

	
}
