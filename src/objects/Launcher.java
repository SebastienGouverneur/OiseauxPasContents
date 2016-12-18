package objects;

import java.awt.Color;
import java.awt.Graphics;

import lib.GameObject.IGameObject;
import lib.GameObject.ISprite;
import lib.physics.Vector2d;

public class Launcher implements IGameObject{

	
	private Vector2d mouse;
	private ISprite sprite;
	private boolean active = true;
	
	public Launcher(Vector2d mouse, ISprite sprite) {
		this.mouse = mouse;
		this.sprite = sprite;
		sprite.getBody().setActive(false);
	}
	
	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}
	
	public void lauch() {
		if(!active) return;
		sprite.getBody().getVelocity().setX((sprite.getBody().getCenterPos().getX() - mouse.getX())*2);
		sprite.getBody().getVelocity().setY((sprite.getBody().getCenterPos().getY() - mouse.getY())*2);
		sprite.getBody().setActive(true);
		active = false;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		if(active) 
			g.drawLine((int) sprite.getBody().getCenterPos().getX(), 
				(int) sprite.getBody().getCenterPos().getY(), 
				(int)mouse.getX(), 
				(int)mouse.getY());
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
