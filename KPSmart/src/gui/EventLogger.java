package gui;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.*;

public class EventLogger extends JInternalFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea log;
	
	public EventLogger() {
		setTitle("Event Log");
		setIconifiable(true);
		setClosable(true);
		setBounds(0,0,400,400);
		setLocation(400,150);
		
		log = new JTextArea();
		JScrollPane scroller = new JScrollPane(log);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JPanel bottomPane = new JPanel();
		
		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.CENTER)
				.addComponent(scroller, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
				.addComponent(bottomPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE));
		
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addComponent(scroller, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
				.addGap(25)
				.addComponent(bottomPane, GroupLayout.PREFERRED_SIZE, 75, Short.MAX_VALUE));
						
		GroupLayout gl_btnPanel = new GroupLayout(bottomPane);
		
		gl_btnPanel.setHorizontalGroup(gl_btnPanel.createSequentialGroup()
				.addContainerGap()
				.addComponent(btnUpdate)
				.addGap(20)
				.addComponent(btnClose)
				.addContainerGap());
		
		gl_btnPanel.setVerticalGroup(gl_btnPanel.createParallelGroup(Alignment.CENTER)
				.addComponent(btnUpdate)
				.addComponent(btnClose));
		
		bottomPane.setLayout(gl_btnPanel);
		getContentPane().setLayout(layout);
	}
	
	public final void update() {
		// TODO Need XML file to read from
	}
	
}
