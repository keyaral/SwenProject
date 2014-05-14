package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class RouteViewIDWindow extends JFrame {

	public RouteViewIDWindow(){
	
	this.setLayout(new BorderLayout());
	this.setBounds(100, 100, 532, 391);
	this.setLocation(400,150);
	
	JPanel MainPanel = new JPanel();
	MainPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
	MainPanel.setLayout(new BorderLayout());
	
	JPanel DataInputPanel = new JPanel();
	DataInputPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
	DataInputPanel.setBounds(10,10, 200, 200);
 
	JScrollPane data = new JScrollPane();
	DataInputPanel.add(data);
	data.setBounds(10,10,200, 200);
	data.setVisible(true);
	
	JButton data2 = new JButton();
	DataInputPanel.add(data2);
	data.setBounds(10,10,200, 200);
	data.setVisible(true);
	
	MainPanel.add(DataInputPanel);
	this.add(MainPanel);
	}
	
	
}
