 package gui;

import java.util.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.*;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;

import Log.event.*;


public class EventLogger extends JInternalFrame{


	/** 
	 *
	 */
	private static final long serialVersionUID = 1L;

	private EventLogManager manager = new EventLogManager();
	
	private JTextArea textLog;
	private JLabel lblRevenue;
	private JLabel lblExpenditure;
	private JLabel lblEventsReported;
	private JTextField textField;
	private JButton btnPrevious = new JButton("Previous");
	private JButton btnNext;

	private JTextArea amountOfMailList = new JTextArea();
	private JTextArea averageDeliveryTimesList = new JTextArea();
	private JTextArea criticalRoutesList = new JTextArea();

	public EventLogger() {
		setTitle("Event Log");
		setIconifiable(true);
		setClosable(true);
		setBounds(0,0,568,337);
		setLocation(400,150);
		JScrollPane scroller = new JScrollPane();

		JPanel bottomLeftPane = new JPanel();
		bottomLeftPane.setBorder(new LineBorder(Color.LIGHT_GRAY));

		JPanel rightPane = new JPanel();
		rightPane.setBorder(new LineBorder(Color.LIGHT_GRAY));

		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.CENTER)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(bottomLeftPane, 0, 0, Short.MAX_VALUE)
						.addComponent(scroller, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rightPane, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(rightPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
							.addComponent(scroller, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bottomLeftPane, GroupLayout.PREFERRED_SIZE, 71, Short.MAX_VALUE)))
					.addContainerGap())
		);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JTabbedPane bussinessPanel = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_rightPane = new GroupLayout(rightPane);
		gl_rightPane.setHorizontalGroup(
			gl_rightPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_rightPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_rightPane.createParallelGroup(Alignment.LEADING)
						.addComponent(bussinessPanel, GroupLayout.PREFERRED_SIZE, 198, Short.MAX_VALUE)
						.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_rightPane.setVerticalGroup(
			gl_rightPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_rightPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(bussinessPanel, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnClose)
					.addContainerGap())
		);

		JPanel statsPanel = new JPanel();
		bussinessPanel.addTab("Statistics", null, statsPanel, null);

		lblRevenue = new JLabel("Revenue:");

		lblExpenditure = new JLabel("Expenditure:");

		lblEventsReported = new JLabel("Events Reported:");
		GroupLayout gl_statsPanel = new GroupLayout(statsPanel);
		gl_statsPanel.setHorizontalGroup(
			gl_statsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_statsPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_statsPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblRevenue)
						.addComponent(lblExpenditure)
						.addComponent(lblEventsReported))
					.addContainerGap(122, Short.MAX_VALUE))
		);
		gl_statsPanel.setVerticalGroup(
			gl_statsPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_statsPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRevenue)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblExpenditure)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEventsReported)
					.addContainerGap(138, Short.MAX_VALUE))
		);
		statsPanel.setLayout(gl_statsPanel);
		amountOfMailList.setEditable(false);
		
		bussinessPanel.addTab("Amount Of Mail", null, amountOfMailList, null);
		averageDeliveryTimesList.setEditable(false);
		bussinessPanel.addTab("Average Delivery Times", null, averageDeliveryTimesList, null);
		criticalRoutesList.setEditable(false);
		bussinessPanel.addTab("Critical Routes", null, criticalRoutesList, null);
		rightPane.setLayout(gl_rightPane);

		textLog = new JTextArea();
		textLog.setEditable(false);
		scroller.setViewportView(textLog);

		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.previous();
				update();
			}
		});

		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.next();
				update();
			}
		});


		JButton btnGoTo = new JButton("Go To");
		btnGoTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String text = textField.getText();
				for (int i = 0; i < text.length(); i++) {
					if(!Character.isDigit(text.charAt(i))) {
						displayErrorMessage("Only numbers are permitted.");
					}
				}
				try {
					manager.goTo(Integer.parseInt(text));
					update();
				} catch (TransitionError e) {
					displayErrorMessage("Number exceeds highest possible event index.");
				}
			}
		});

		textField = new JTextField();
		textField.setColumns(10);

		GroupLayout gl_bottomLeftPane = new GroupLayout(bottomLeftPane);
		gl_bottomLeftPane.setHorizontalGroup(
			gl_bottomLeftPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bottomLeftPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_bottomLeftPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNext, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPrevious, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
					.addGroup(gl_bottomLeftPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnGoTo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textField))
					.addContainerGap())
		);
		gl_bottomLeftPane.setVerticalGroup(
			gl_bottomLeftPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_bottomLeftPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_bottomLeftPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPrevious)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_bottomLeftPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNext)
						.addComponent(btnGoTo))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);

		bottomLeftPane.setLayout(gl_bottomLeftPane);
		getContentPane().setLayout(layout);
	}

	/**
	 * Updates the log
	 */
	public void update() {
		textLog.setText(manager.getDetails());

		String[] statistics = manager.getStats();
		lblRevenue.setText("Revenue: " + statistics[0]);
		lblExpenditure.setText("Expenditure: " + statistics[1]);
		lblEventsReported.setText("Events Reported: " + statistics[2]);
		
		if (manager.atStart()) btnPrevious.setEnabled(false);
		else btnPrevious.setEnabled(true);
		
		if (manager.atEnd()) btnNext.setEnabled(false);
		else btnNext.setEnabled(true);
		
		amountOfMailList.setText("Key: Origin-Destination-Volume-Weight-Num");
		averageDeliveryTimesList.setText("Key: Origin-Destination-Priority-AverageTime");
		criticalRoutesList.setText("No mail or route has been created yet.");
		
		updateList(manager.getList(manager.getEvent().statistics.getMailAmounts()), amountOfMailList,
				"No mail has been sent yet.");
		updateList(manager.getList(manager.getEvent().statistics.getDeliveryTimes()), averageDeliveryTimesList,
				"No mail has been sent yet.");
	}
	
	private void updateList(List<String> ss, JTextArea list, String emptyMessage) {
		if (ss == null) list.setText(emptyMessage);
		else {
			for (String s: ss) {
				list.append("\n" + s);
			}
		}
	}
	
	private void displayErrorMessage(String message) {
		JOptionPane.showInternalMessageDialog(this, message, "Message", JOptionPane.PLAIN_MESSAGE);
	}
}
