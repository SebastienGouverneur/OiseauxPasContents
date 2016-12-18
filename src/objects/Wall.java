package objects;

import java.awt.Color;
import java.awt.Graphics;

import lib.GameObject.impl.Sprite;

public class Wall extends Sprite{

	
	public Wall(float x, float y, float width, float height) {
		this.getBody().getPosition().setX(x);
		this.getBody().getPosition().setY(y);
		this.getBody().getSize().setX(width);
		this.getBody().getSize().setY(height);
	}
	
	@Override
	public void update(float delta) {
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect((int)this.getBody().getPosition().getX(), 
				(int)this.getBody().getPosition().getY(), 
				(int)this.getBody().getSize().getX(), 
				(int)this.getBody().getSize().getY());
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
