package gui;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public MainWindow() {
		super("KPSmart");
		setLayout(new BorderLayout());
		
		JMenuBar menuBar = new JMenuBar();
		JMenuItem[] menuItems = {new JMenuItem("Logout"), new JMenuItem("Quit")};
		setMenu(menuBar, new JMenu("File"), menuItems);
		
		add(menuBar, BorderLayout.NORTH);
		
		setSize(50, 50);
		setVisible(true);
	}
	
	private static void setMenu(JMenuBar menuBar, JMenu menu, JMenuItem[] menuItems) {
		for (JMenuItem menuItem: menuItems)
			menu.add(menuItem);
		menuBar.add(menu);
	}
	
	public static void main (String[] args) {
		new MainWindow();
	}

}
