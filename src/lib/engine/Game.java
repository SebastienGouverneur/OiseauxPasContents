package lib.engine;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Game extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8921419424614180143L;

	private Image buffer;
	private int width, height;

	public Game(int width, int height) {
		this.width = width;
		this.height = height;

		JFrame frame = new JFrame("angry birds");
		frame.setContentPane(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
	}
	
	public void start() {
		new Thread(this).start();
	}

	
	
	public abstract void render(Graphics g);
	
	public abstract void update(float delta);
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
	@Override
	public void paint(Graphics g2) {

		if(buffer == null) buffer = createImage(width, height);
		
		Graphics2D g = (Graphics2D) buffer.getGraphics();

		// fond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		render(g);
		
		g2.drawImage(buffer, 0, 0, null);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}

	@Override
	public void run() {
		
		long elapsedTime = 0;
		long time1 = System.currentTimeMillis();
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			update(elapsedTime/1000.0f);
			repaint();
			long time2 = System.currentTimeMillis();
			elapsedTime = time2 - time1;
			time1 = time2;
		}
		
		
		
		
	}

}
