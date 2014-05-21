package gui;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Logic.Destination;
import Logic.Logic;
import Logic.Route;

public class RouteViewIDWindow extends JFrame {
	public HashSet<Route> routes = new HashSet<Route>();
	public HashMap<Integer,String> selectableRoutes = new HashMap<Integer,String>();
	public ArrayList<Destination> destinations = new ArrayList<Destination>();
	public JTextArea textArea;
	public int LineNumber;
	public JTextField textField;
	public Route currentRoute = null;
	public Point currentPoint = null;
	public TransportCost TC;
	/**
	 * 
	 */
	private static final long serialVersionUID = 715315804648325836L;
	private JPanel MainPanel;
	public Canvas canvas;
	
	@SuppressWarnings("serial")
	public RouteViewIDWindow(Logic l, TransportCost tc) {
		this.TC = tc;
		this.routes = l.eventProcessor.getRoutes().routes;
		for(Route r : this.routes) {if(!(this.destinations.contains(r.originD))) this.destinations.add(r.originD);if(!(this.destinations.contains(r.destinationD))) this.destinations.add(r.destinationD);}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100,800, 500);
		MainPanel = new JPanel();
		MainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		MainPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(MainPanel);
		
		JPanel buttonPanel = new JPanel();
		MainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		JButton btnSelect= new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fillTransportCost();
			}
		});
		buttonPanel.add(btnSelect);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RouteViewIDWindow.this.dispose();
			}
		});
		buttonPanel.add(btnClose);
		
		JPanel scrollPanel = new JPanel();
		MainPanel.add(scrollPanel, BorderLayout.CENTER);
		scrollPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 450, 385);
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
				textField.setText("Selected Route ID = "+currentRoute.ID+" Priority: "+currentRoute.priority);
				}
			}
		});
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(10, 400, 450, 20);
		scrollPanel.add(textField);
		textField.setColumns(10);
	
		this.canvas = new Canvas(){
		@Override
		public void paint(Graphics g){
			for(Destination d : destinations){
				if(d.isDomestic())g.setColor(Color.red);	
				else g.setColor(Color.BLUE); ;
				g.fillRect(d.GeographicalX,d.GeographicalY,2,2);
			}
			g.setColor(Color.BLACK);
			ArrayList<Point> p = getPoints();
			int count = 1;
			Point prior = null;
			
			for(Point x : p){
				if((count % 2) == 0) {
					if(prior == currentPoint && currentPoint != null) g.setColor(Color.GREEN);
					else g.setColor(Color.black);
					g.drawLine(x.x, x.y,prior.x, prior.y);
				}
				prior = x;
				count++;
			}
		}

		};
		canvas.setBackground(Color.WHITE);
		canvas.setBounds(480, 10, 400, 500);
		scrollPanel.add(canvas);
		
		populateTextArea(textArea);
	}

	private void updateCurrent(String text) {
		for(Route r : routes){
			if(r.ID == Integer.parseInt(text)) currentRoute = r;
		}
		this.canvas.repaint();
	}
	//
	private void fillTransportCost() {
		if(currentRoute != null){
		this.TC.cmbFrom.setSelectedIndex(TC.getDistributionCenIndex(currentRoute.origin));
		this.TC.cmbTo.setSelectedIndex(TC.getDestinationIndex(currentRoute.destination));
		this.TC.cmbCompany.setSelectedIndex(TC.getCompanyIndex(currentRoute.companyName ));
		this.TC.cmbType.setSelectedIndex(currentRoute.priority-1);
		this.TC.cmbDay.setSelectedItem(currentRoute.day);
		this.TC.txtCostId.setText(Integer.toString(currentRoute.ID));
		this.TC.txtDuration.setText(Double.toString(currentRoute.duration));
		this.TC.txtFrequency.setText(Double.toString(currentRoute.frequency));
		this.TC.txtMaxVolume.setText(Double.toString(currentRoute.maxVolume));
		this.TC.txtMaxWeight.setText(Double.toString(currentRoute.maxWeight));
		this.TC.txtVolumeCost.setText(Double.toString(currentRoute.costVolume));
		//this.TC.txtWeightCost_1.setText(Double.toString(currentRoute.costWeight));
		this.TC.txtWeightCosts.setText(Double.toString(currentRoute.costWeight));	
		}
	}
	//
	private void populateTextArea(JTextArea textArea) {
		int count = 0;
		for(Route r : routes){
			String Line = "ID: "+r.ID+" Assigned to: "+r.origin+" to "+r.destination;
			selectableRoutes.put(count,Line);
			if(count == 0)textArea.setText(Line);
			if(count != 0)textArea.setText(textArea.getText()+"\n"+Line);
			count++;
		}}
		
	private ArrayList<Point> getPoints() {
		ArrayList<Point> points = new ArrayList<Point>();
		for(Route r : routes){
			Point o = new Point(r.originD.GeographicalX,r.originD.GeographicalY);
			points.add(o);
			if(r.equals(currentRoute))currentPoint = o;
			Point d = new Point(r.destinationD.GeographicalX,r.destinationD.GeographicalY);
			points.add(d);
		}
		return points;
	}
}