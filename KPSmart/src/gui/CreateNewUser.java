package gui;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateNewUser extends JInternalFrame {
	/**
	 * 
	 */  
	private static final long serialVersionUID = 1L;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtConfirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
	}

	/**
	 * Create the frame.
	 */
	public CreateNewUser() {
		setClosable(true);
		setBounds(100, 100, 450, 300);
		
		JPanel InputPanel = new JPanel();
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(InputPanel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(InputPanel, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		JLabel lblUserName = new JLabel("User Name");
		
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		
		txtConfirmPassword = new JTextField();
		txtConfirmPassword.setColumns(10);
		GroupLayout gl_InputPanel = new GroupLayout(InputPanel);
		gl_InputPanel.setHorizontalGroup(
			gl_InputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InputPanel.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_InputPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_InputPanel.createSequentialGroup()
							.addComponent(lblConfirmPassword)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtConfirmPassword))
						.addGroup(gl_InputPanel.createSequentialGroup()
							.addGroup(gl_InputPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUserName)
								.addComponent(lblPassword))
							.addGap(37)
							.addGroup(gl_InputPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtPassword)
								.addComponent(txtUserName, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		gl_InputPanel.setVerticalGroup(
			gl_InputPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_InputPanel.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_InputPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUserName))
					.addGap(23)
					.addGroup(gl_InputPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword)
						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_InputPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblConfirmPassword)
						.addComponent(txtConfirmPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		InputPanel.setLayout(gl_InputPanel);
		
		JButton btnAdd = new JButton("Add");
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pwd= txtConfirmPassword.getText();
				String confirmPwd= txtPassword.getText();
				
				if (txtUserName.getText().equals("")){
					JOptionPane.showMessageDialog(null,"The User Name and Password fields cannot be empty",null, 1);
				}
				if (pwd.equals("") && confirmPwd.equals("")){
					JOptionPane.showMessageDialog(null,"The password fields cannot be empty",null, 1);
				}
				if (!pwd.equals(confirmPwd)){
					JOptionPane.showMessageDialog(null,"The passwords you entered do not match. Please try again",null, 1);
				}else{
					JOptionPane.showMessageDialog(null,"Passwords matched!",null, 1);
				}
				
			}
		});
		
		JButton btnDelete = new JButton("Delete");
		
		//Close the window when clicking the close button
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAdd)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSave)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDelete)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancel)
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addComponent(btnClose)
					.addGap(39))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(18, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAdd)
						.addComponent(btnSave)
						.addComponent(btnDelete)
						.addComponent(btnCancel)
						.addComponent(btnClose))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}

}
