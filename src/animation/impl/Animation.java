package animation.impl;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import animation.IAnimation;

public class Animation implements IAnimation {

	public ArrayList<Image> images;
	private int currentFrame = 0;
	private int framerate = 15;
	private float delta = 0;
	private boolean looped;
	private boolean started = true;
	
	
	@Override
	public void draw(Graphics g, int x0, int y0) {
		Image img = images.get(currentFrame);
		g.drawImage(img, x0, y0, null);
	}

	@Override
	public void update(float delta) {
		if(!started) return;
		this.delta += delta;
		if(this.delta >= framerate) {
			nextFrame();
			this.framerate -= this.delta;
		}
	}
	
	private void nextFrame() {
		currentFrame++;
		if(currentFrame >= images.size()) {
			if(looped)  {
				currentFrame = 0;
			}
			else {
				currentFrame = images.size() - 1;
				this.stop();
			}
		}
	}

	@Override
	public void start() {
		this.started = true;
	}

	@Override
	public void stop() {
		this.started = false;
	}

	@Override
	public void addFrame(Image img) {
		this.images.add(img);
	}

	@Override
	public void setFramerate(int framerate) {
		this.framerate = framerate;
	}
	
	public void setLooped(boolean looped) {
		this.looped = looped;
	}

	@Override
	public void setFrame(int i) {
		this.currentFrame = i;
	}

}
