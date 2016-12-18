package objects;

import java.awt.Graphics;
import java.util.ArrayList;

import lib.GameObject.IGameObject;
import lib.GameObject.ISprite;

public class Group implements IGameObject{

	private ArrayList<IGameObject> sprites = new ArrayList<>();
	
	@Override
	public void update(float delta) {
		for(IGameObject s: sprites) {
			s.update(delta);
		}
	}

	@Override
	public void draw(Graphics g) {
		for(IGameObject s: sprites) {
			s.draw(g);
		}
	}

	public void addObject(IGameObject o) {
		sprites.add(o);
	}
	
	public void collide(ISprite sprite) {
		for(IGameObject i : sprites) {
			if(i == sprite) continue;
			if(i instanceof ISprite) {
				sprite.getBody().doCollide(((ISprite) i).getBody());
			}
		}
	}
	
	public void collide(Group other) {
		for(IGameObject i : sprites) {
			if(i instanceof ISprite) {
				other.collide((ISprite) i);
			}
		}
	}
	
	@Override
	public void init() {
	}

	


}
