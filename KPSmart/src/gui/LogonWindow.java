package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LogonWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String UserName;
	JButton loginButton;
	JButton cancelButton;
	JTextField txtUserId;
	JPasswordField txtPassword;
	public LogonWindow() {
		super("KPSmart Logon");
		setResizable(false);
		//setUndecorated(true);
		setVisible(true);
		loginButton = new JButton("Login");
		cancelButton=new JButton("Cancel");
		JLabel lblUserId=new JLabel("User ID");
		JLabel lblPassword=new JLabel("Password");
		JPanel panel = new JPanel();
		txtUserId = new JTextField(15);
		txtPassword = new JPasswordField(15);
		
		getContentPane().setLayout(new BorderLayout());
		setSize(324, 177);
		setLocation(500,250);
		panel.setLayout(null);
		txtUserId.setBounds(94,29,181,20);
		txtPassword.setBounds(94,60,181,20);
		cancelButton.setBounds(195,91,80,23);
		loginButton.setBounds(94, 91, 91, 23);
		lblUserId.setBounds(30,30 , 150, 20);
		lblPassword.setBounds(20,40,150,20);
		
		panel.add(loginButton);
		panel.add(cancelButton);
		panel.add(txtUserId);
		panel.add(txtPassword);
		panel.add(txtUserId);
		panel.add(txtPassword);
		getContentPane().add(panel);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(10, 32, 74, 14);
		panel.add(lblUserName);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(20, 63, 74, 14);
		panel.add(lblPassword_1);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Calling the authentication method
		LoginAuthentication();

	}
	/**
	 * Login Authentication. Username and passwword validation
	 */
	public void LoginAuthentication(){
		loginButton.addActionListener(new ActionListener() {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent ae) {
		String username = txtUserId.getText();
		String password = txtPassword.getText();
		
		//Statically assigned username and password. Need to validate from a file
		if (username.equals("manager") && password.equals("manager1")){
			MainWindow mWindow =new MainWindow();
			//UserName=username;
			mWindow.setVisible(true);
			dispose();
		}
		else if(username.equals("clerk") && password.equals("12345")) {
		MainWindow mWindow =new MainWindow();
		//UserName=username;
		mWindow.setVisible(true);
		mWindow.menuItemTransportRoute.setEnabled(false);
		mWindow.mntmCreateNewUser.setEnabled(false);
		mWindow.mnuItemCostModification.setEnabled(false);
		mWindow.viewLog.setEnabled(false);
		dispose();
		} else {
		JOptionPane.showMessageDialog(null,"Wrong Password / Username");
		txtUserId.setText("");
		txtPassword.setText("");
		txtUserId.requestFocus();
		}

		}
		});
		//When the user clicks the cancel button, this event is fired.
		cancelButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//Dispose the password entry screen
				dispose();
				
			}
			
		});
		
		
	}
	public static void main (String[] args) {
		new LogonWindow();
		
		
	}
}