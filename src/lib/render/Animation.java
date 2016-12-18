package lib.render;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import lib.physics.Updatable;
import lib.physics.Vector2d;

public class Animation implements Drawable, Updatable{

	
	private int framerate;
	private float framecount = 0;
	private boolean isPlaying = true;
	private int currentFrame = 0;
	private boolean looped = true;
	private final ArrayList<Image> images = new ArrayList<>();
	private Vector2d pos;
	private Vector2d size;
	
	public Animation(final Vector2d pos, final Vector2d size) {
		this.pos = pos;
		this.size = size;
	}
	
	public boolean isPlaying() {
		return isPlaying;
	}
	
	public void start() {
		isPlaying = true;
	}
	
	public void stop() {
		isPlaying = false;
	}
	
	public void setFrame(int frame) {
		this.currentFrame = frame;
	}
	
	/**
	 * Set the framerate(frame change per second)
	 * @param framerate
	 */
	public void setFramerate(int framerate) {
		this.framerate = framerate;
	}
	
	@Override
	public void update(float delta) {
		if(!isPlaying) return;
		framecount += delta*1000;
		if(framecount >= framerate) {
			framecount -= framerate;
			currentFrame++;
		}
		if(currentFrame >= images.size() - 1) {
			if(!looped) {
				currentFrame = images.size() - 1;
				isPlaying = false;
			} else {
				currentFrame = 0;
			}
		}
	}
	
	public void addImage(Image i) {
		this.images.add(i);
	}

	@Override
	public void draw(Graphics g) {
		if(currentFrame >= 0 && currentFrame < images.size()) {
			g.drawImage(images.get(currentFrame), (int)pos.getX(), (int)pos.getY(), 
					(int)size.getX(), (int)size.getY(), null);
		}
	}

}
