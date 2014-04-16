package gui;
import javax.swing.*;
import java.awt.*;

public class ConfigurationPanel extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConfigurationPanel(String name, int width, int height, LayoutManager layout) {
		super(name);
		setLayout(layout);
		setSize(width, height);
	}
	
}
