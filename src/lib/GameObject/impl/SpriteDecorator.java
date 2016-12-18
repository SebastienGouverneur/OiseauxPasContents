package lib.GameObject.impl;

import java.awt.Graphics;

import lib.GameObject.ISprite;
import lib.physics.Body;
import lib.render.Animation;

public abstract class SpriteDecorator implements ISprite{

	private ISprite sprite;
	
	public SpriteDecorator(ISprite sprite) {
		this.sprite = sprite;
	}
	
	@Override
	public void init() {
		sprite.init();
	}

	@Override
	public void update(float delta) {
		sprite.update(delta);
	}

	@Override
	public void draw(Graphics g) {
		sprite.draw(g);
	}

	@Override
	public Animation createAnimation(String name) {
		return sprite.createAnimation(name);
	}

	@Override
	public void setAnimation(String name, boolean play, int frame) {
		sprite.setAnimation(name, play, frame);
	}

	@Override
	public void startAnimation() {
		sprite.startAnimation();
	}

	@Override
	public void stopAnimation() {
		sprite.stopAnimation();
	}

	@Override
	public Body getBody() {
		return sprite.getBody();
	}

}
