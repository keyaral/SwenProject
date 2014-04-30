package gui;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.*;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

public class EventLogger extends JInternalFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea textLog;
	private JLabel lblRevenue;
	private JLabel lblExpenditure;
	private JLabel lblEventsReported;
	private JLabel lblAmountOfMail;
	private JLabel lblAverageDeliveryTimes;
	private JLabel lblCriticalRoutes;
	private JTextField textField;
	
	public EventLogger() {
		setTitle("Event Log");
		setIconifiable(true);
		setClosable(true);
		setBounds(0,0,532,336);
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
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(bottomLeftPane, 0, 0, Short.MAX_VALUE)
						.addComponent(scroller, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rightPane, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(rightPane, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
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
		
		JLabel lblTitle = new JLabel("Stats:");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		lblRevenue = new JLabel("Revenue:");
		
		lblExpenditure = new JLabel("Expenditure:");
		
		lblEventsReported = new JLabel("Events Reported:");
		
		lblAmountOfMail = new JLabel("Amount of Mail:");
		
		lblAverageDeliveryTimes = new JLabel("Average Delivery Times:");
		
		lblCriticalRoutes = new JLabel("Critical Routes:");
		GroupLayout gl_rightPane = new GroupLayout(rightPane);
		gl_rightPane.setHorizontalGroup(
			gl_rightPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_rightPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle)
					.addContainerGap(148, Short.MAX_VALUE))
				.addGroup(gl_rightPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRevenue)
					.addContainerGap(145, Short.MAX_VALUE))
				.addGroup(gl_rightPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblExpenditure)
					.addContainerGap(130, Short.MAX_VALUE))
				.addGroup(gl_rightPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEventsReported)
					.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(gl_rightPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAmountOfMail)
					.addContainerGap(117, Short.MAX_VALUE))
				.addGroup(gl_rightPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAverageDeliveryTimes)
					.addContainerGap(75, Short.MAX_VALUE))
				.addGroup(gl_rightPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCriticalRoutes)
					.addContainerGap(119, Short.MAX_VALUE))
				.addGroup(gl_rightPane.createSequentialGroup()
					.addContainerGap(119, Short.MAX_VALUE)
					.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_rightPane.setVerticalGroup(
			gl_rightPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRevenue)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblExpenditure)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEventsReported)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAmountOfMail)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAverageDeliveryTimes)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCriticalRoutes)
					.addPreferredGap(ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
					.addComponent(btnClose)
					.addContainerGap())
		);
		rightPane.setLayout(gl_rightPane);
		
		textLog = new JTextArea();
		textLog.setEditable(false);
		scroller.setViewportView(textLog);
		
		JButton btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		
		JButton btnGoTo = new JButton("Go To");
		btnGoTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		textLog.append(MainWindow.logic.getdetails());
		String[] statistics = MainWindow.logic.getStatistics().split(" ");
		lblRevenue.setText("Revenue: " + statistics[0]);
		lblExpenditure.setText("Expenditure: " + statistics[1]);
		lblEventsReported.setText("Events Reported: " + statistics[2]);
		lblAmountOfMail.setText("Amount of Mail: " + statistics[3]);
		lblAverageDeliveryTimes.setText("Average Delivery Times: " + statistics[4]);
		lblCriticalRoutes.setText("Critical Routes: " + statistics[5]);
	}
}
