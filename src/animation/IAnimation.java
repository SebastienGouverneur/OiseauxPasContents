package animation;

import java.awt.Image;

import drawable.IDrawable;
import updatable.Updatable;

/**
 * Animation interface
 *
 */
public interface IAnimation extends IDrawable, Updatable {
	/**
	 * Start the animation
	 */
	public void start();
	
	/**
	 * Stop the animation
	 */
	public void stop();
	
	/**
	 * Add an image to the animation
	 * @param img
	 */
	public void addFrame(Image img);
	
	/**
	 * Set the framerate the animation run with
	 * @param framerate
	 */
	public void setFramerate(int framerate);
	
	
	/**
	 * Set the frame to display
	 * @param i
	 */
	public void setFrame(int i);
}
