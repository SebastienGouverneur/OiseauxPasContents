package lib.GameObject.impl;

import java.awt.Graphics;
import java.util.HashMap;

import lib.GameObject.IGameObject;
import lib.GameObject.ISprite;
import lib.physics.Body;
import lib.render.Animation;

public class Sprite implements ISprite{

	private final Body body = new Body();
	private HashMap<String, Animation> animations = new HashMap<>();
	private String currentAnim;
	
	@Override
	public void update(float delta) {
		body.update(delta);
		updateAnim(delta);
	}
	
	public Animation createAnimation(String name) {
		Animation anim = new Animation(this.body.getPosition(), this.body.getSize());
		animations.put(name, anim);
		return anim;
	}
	
	public void setAnimation(String anim, boolean play, int frame) {
		this.currentAnim = anim;
		
		if(play) {
			this.animations.get(currentAnim).start();
		} else {
			this.animations.get(currentAnim).stop();
		}
		
		this.animations.get(currentAnim).setFrame(frame);
		
	}
	
	protected void updateAnim(float delta) {
		if(currentAnim != null) {
			animations.get(currentAnim).update(delta);
		}
	}
	
	protected void drawAnim(Graphics g) {
		if(currentAnim != null) {
			animations.get(currentAnim).draw(g);
		}
	}
	
	public boolean collide(Sprite other) {
		return this.body.collide(other.body);
	}

	@Override
	public void draw(Graphics g) {
		drawAnim(g);
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopAnimation() {
		if(currentAnim == null) return;
		this.animations.get(currentAnim).stop();
	}

	@Override
	public Body getBody() {
		return this.body;
	}

	@Override
	public void startAnimation() {
		if(currentAnim == null) return;
		this.animations.get(currentAnim).start();
	}

}
