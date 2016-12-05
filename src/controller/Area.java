package controller;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Area extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3204331027062351307L;
	
	public Area() {
	}
	
	@Override
	public void paintComponent(Graphics g) {
		draw(g);
	}
	
	public void draw(Graphics g) {
		
	}
	
	public void update() {
		this.repaint();
	}

}
