package gui;

import java.awt.BorderLayout;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Logic.Route;

public class RouteViewIDWindow extends JFrame {
	public ArrayList<Route> routes = new ArrayList<Route>();
	public HashMap<Integer,String> selectableRoutes = new HashMap<Integer,String>();
	public JTextArea textArea;
	public int LineNumber;
	public JTextField textField;
	public Route currentRoute = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 715315804648325836L;
	private JPanel MainPanel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList<Route> test = new ArrayList<Route>();
					test.add(new Route(1,"Auckland","Wellington",10,15,200,200,1,"Thursday",2,3,"TylerCorp"));
					test.add(new Route(2,"Auckland","Wellington",10,15,200,200,1,"Thursday",2,3,"TylerCorp"));
					RouteViewIDWindow frame = new RouteViewIDWindow(test);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RouteViewIDWindow(ArrayList<Route> routes) {
		this.routes = routes;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		MainPanel = new JPanel();
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);
		
		JPanel buttonPanel = new JPanel();
		MainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		JButton btnClose = new JButton("Select");
		buttonPanel.add(btnClose);
		
		JButton btnNewButton_1 = new JButton("Close");
		buttonPanel.add(btnNewButton_1);
		
		JPanel scrollPanel = new JPanel();
		MainPanel.add(scrollPanel, BorderLayout.CENTER);
		scrollPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 10, 250, 185);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPanel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Point p = textArea.getCaret().getMagicCaretPosition();
				if(p != null){ 
				LineNumber = p.y/16;
				String text = (selectableRoutes.get(LineNumber));
				text = text.substring(4);
				String[] textArray = text.split("\\s");
				text = textArray[0];
				updateCurrent(text);
				textField.setText("Selected Route ID = "+currentRoute.ID);
				}
			}

			
		});
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(100, 200, 250, 20);
		scrollPanel.add(textField);
		textField.setColumns(10);
		
		populateTextArea(textArea);
	}

	private void updateCurrent(String text) {
		for(Route r : routes){
			if(r.ID == Integer.parseInt(text)) currentRoute = r;
		}
	}
	
	private void populateTextArea(JTextArea textArea) {
		int count = 0;
		for(Route r : routes){
			String Line = "ID: "+r.ID+" Assigned to: "+r.origin+" to "+r.destination;
			selectableRoutes.put(count,Line);
			if(count == 0)textArea.setText(Line);
			if(count != 1)textArea.setText(textArea.getText()+"\n"+Line);
			count++;
		}
	}
	
}
