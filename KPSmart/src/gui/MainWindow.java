
package gui;
import javax.swing.*;

import java.awt.event.*;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.GroupLayout.Alignment;

import Logic.Logic;

import javax.swing.border.LineBorder;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;

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
	
	public JMenuItem menuItemTransportRoute;
	public JMenuItem mntmCreateNewUser;
	public JMenuItem viewLog;
	private JMenuItem logOut;
	private JMenuItem exit;
	public JMenuItem mnuItemCostModification;
	public JDesktopPane desktopPane;
	public static final BusinessMonitoring bMonitoring = new BusinessMonitoring();
	public static final Logic logic = new Logic();
	 private final Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	 
	public MainWindow() {
		super("KPSmart");
		this.setExtendedState(MAXIMIZED_BOTH);
		setTitle("KPSmart Postal Services");
		initComponents();
		CreateEvent();
		if (bMonitoring==null || !bMonitoring.isClosable()){
			eventLogger= new EventLogger();
			bMonitoring.txtAverageDeliveryTimes.setEnabled(false);
			bMonitoring.txtRevenue.setEnabled(false);
			bMonitoring.txtProfit.setEnabled(false);
			bMonitoring.txtExpenditure.setEnabled(false);
			bMonitoring.txtAverageWeight.setEnabled(false);
			bMonitoring.txtAverageVolume.setEnabled(false);
			bMonitoring.txtAverageDeliveryTimes.setEnabled(false);
			desktopPane.add(bMonitoring);
			bMonitoring.setManager(eventLogger.manager);
			bMonitoring.updateMonitor();
			bMonitoring.setLocation(950,0);
			bMonitoring.setVisible(true);
		}
		
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
		
		mnuItemCostModification=new JMenuItem("Cost Modification");
		viewLog=new JMenuItem("View Log");
		
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
						JOptionPane.showMessageDialog(null,"Help is not available at this time...",null, 1);
				
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
		menuItemMailDelivery.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

			} 
			
		});
		
		desktopPane = new JDesktopPane();

        getContentPane().setVisible( true );  
		desktopPane.setBackground(Color.LIGHT_GRAY);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))
						.addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(menuBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
		);
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 391, Short.MAX_VALUE)
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 562, Short.MAX_VALUE)
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
		
		menuItemTransportRoute.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			if (transportCostUpdate==null || transportCostUpdate.isClosable()){ //only one instance to managerWindow
				TransportCost t = createTransportCostUpdate(); 
				desktopPane.add(t);
				t.show();
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
	protected TransportCost createTransportCostUpdate() {
		return new TransportCost(this.logic);
	}

	public static void main (String[] args) {
		new MainWindow();
		
	}
	
}
