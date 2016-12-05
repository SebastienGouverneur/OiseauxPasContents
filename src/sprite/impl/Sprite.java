package sprite.impl;

import java.awt.Graphics;
import java.util.ArrayList;

import animation.IAnimation;
import physics.IBody;
import sprite.ISprite;

public class Sprite implements ISprite {
	
	private ArrayList<IAnimation> animations = new ArrayList<>();
	private int currentAnimation = 0;
	private IBody body;
	
	@Override
	public void draw(Graphics g, int x0, int y0) {
		int x = (int) (x0 + body.getX());
		int y = (int) (y0 + body.getY());
		animations.get(currentAnimation).draw(g, x, y);
	}

	@Override
	public void update(float delta) {
		animations.get(currentAnimation).update(delta);
		body.update(delta);
	}

	@Override
	public IAnimation getAnimations(int i) {
		return this.animations.get(i);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
