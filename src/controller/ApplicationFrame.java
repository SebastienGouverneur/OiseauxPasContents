package controller;

import java.awt.Dimension;

import javax.swing.JFrame;

public class ApplicationFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2057679725841274317L;
	private Area area;
	
	public ApplicationFrame() {
		this.setTitle("Oiseaux pas contents");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(800,600));
		area = new Area();
		this.setContentPane(area);
		this.setVisible(true);
	}
	
}
