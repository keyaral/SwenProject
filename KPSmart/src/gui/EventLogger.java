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
import javax.swing.border.BevelBorder;


public class EventLogger extends JInternalFrame{


	/** 
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel lblRevenue;
	private JLabel lblExpenditure;
	private JLabel lblEventsReported;
	private JButton btnPrevious = new JButton("Previous");
	private JButton btnNext;

	private JTextArea amountOfMailList = new JTextArea();
	private JTextArea averageDeliveryTimesList = new JTextArea();
	private JTextArea criticalRoutesList = new JTextArea();

	private JTextArea textLog = new JTextArea();
	private JTextField goTo;
	
	public final EventLogManager manager = new EventLogManager();

	public EventLogger() {
		setTitle("Event Log");
		setIconifiable(true);
		setClosable(true);
		setBounds(0,0,631,397);
		setLocation(400,150);

		JPanel bottomLeftPane = new JPanel();
		bottomLeftPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		JPanel rightPane = new JPanel();
		rightPane.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JScrollPane scroller = new JScrollPane();
		
		GroupLayout layout = new GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.CENTER)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(bottomLeftPane, 0, 0, Short.MAX_VALUE)
						.addComponent(scroller, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rightPane, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(rightPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
							.addComponent(scroller, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(bottomLeftPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		scroller.setViewportView(textLog);
		textLog.setEditable(false);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JTabbedPane bussinessPanel = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_rightPane = new GroupLayout(rightPane);
		gl_rightPane.setHorizontalGroup(
			gl_rightPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_rightPane.createParallelGroup(Alignment.LEADING)
						.addComponent(bussinessPanel, GroupLayout.PREFERRED_SIZE, 250, Short.MAX_VALUE)
						.addComponent(btnClose, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_rightPane.setVerticalGroup(
			gl_rightPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_rightPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(bussinessPanel, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
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
		
		JScrollPane CRScroller = new JScrollPane();
		bussinessPanel.addTab("Critical Routes", null, CRScroller, null);
		CRScroller.setViewportView(criticalRoutesList);
		criticalRoutesList.setEditable(false);
		
		JScrollPane ADTScroller = new JScrollPane();
		bussinessPanel.addTab("Average Delivery Times", null, ADTScroller, null);
		ADTScroller.setViewportView(averageDeliveryTimesList);
		averageDeliveryTimesList.setEditable(false);
		
		JScrollPane AMScroller = new JScrollPane();
		bussinessPanel.addTab("Amount Of Mail", null, AMScroller, null);
		AMScroller.setViewportView(amountOfMailList);
		amountOfMailList.setEditable(false);
		rightPane.setLayout(gl_rightPane);

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
				String text = goTo.getText();
				for (int i = 0; i < text.length(); i++) {
					if(!Character.isDigit(text.charAt(i))) {
						displayErrorMessage("Only numbers are permitted.");
						return;
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
		
		goTo = new JTextField();
		goTo.setColumns(10);

		GroupLayout gl_bottomLeftPane = new GroupLayout(bottomLeftPane);
		gl_bottomLeftPane.setHorizontalGroup(
			gl_bottomLeftPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_bottomLeftPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_bottomLeftPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNext, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPrevious, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(gl_bottomLeftPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(goTo, 0, 0, Short.MAX_VALUE)
						.addComponent(btnGoTo, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
					.addGap(23))
		);
		gl_bottomLeftPane.setVerticalGroup(
			gl_bottomLeftPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_bottomLeftPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_bottomLeftPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPrevious)
						.addComponent(goTo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
		manager.update();
		textLog.setText(manager.getDetails());

		String[] statistics = manager.getStats();
		lblRevenue.setText("Revenue: " + statistics[0]);
		lblExpenditure.setText("Expenditure: " + statistics[1]);
		lblEventsReported.setText("Events Reported: " + statistics[2]);
		
		if (manager.atStart()) btnPrevious.setEnabled(false);
		else btnPrevious.setEnabled(true);
		
		if (manager.atEnd()) btnNext.setEnabled(false);
		else btnNext.setEnabled(true);
		
		if (manager.hasNoEvents()) {
			amountOfMailList.setText("There are no events processed yet.");
			averageDeliveryTimesList.setText("There are no events processed yet.");
			criticalRoutesList.setText("There are no events processed yet.");
		}
		else {
			amountOfMailList.setText("");
			averageDeliveryTimesList.setText("Key: (Priority, Origin, Destination) - AverageTime");
			criticalRoutesList.setText("Key: (Destination, Origin, Priority)");
			
			updateListOfLists(manager.processMailAmounts(manager.getEvent().statistics.getMailAmounts()), amountOfMailList,
					"No mail has been sent yet.");
			updateList(manager.getTriplesList(manager.getEvent().statistics.getDeliveryTimes()), averageDeliveryTimesList,
					"No mail has been sent yet.");
			updateList(manager.getTriplesList(manager.getEvent().statistics.getCriticalRoutes()), criticalRoutesList,
					"There are no critical routes.");
		}
	}
	
	private void updateListOfLists(List<List<String[]>> sss, JTextArea list, String emptyMessage) {
		if (sss == null || sss.isEmpty()) list.setText(emptyMessage);
		else {
			for (List<String[]> ss: sss) {
				list.append("To " + ss.get(0)[0] + " - Volume: " + ss.get(0)[1] +
						"/Weight: " + ss.get(0)[2] + "/Items: " + ss.get(0)[3] + "\n");
				for (int j = 1; j < ss.size(); j++) {
					list.append("  From " + ss.get(j)[0] + " - Volume: " + ss.get(j)[1] +
							"/Weight: " + ss.get(j)[2] + "/Items: " + ss.get(j)[3] + "\n");
				}
				
			}
		}
	}
	
	private void updateList(List<String> ss, JTextArea list, String emptyMessage) {
		if (ss == null || ss.isEmpty()) list.setText(emptyMessage);
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
