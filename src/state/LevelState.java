package state;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import lib.GameObject.ISprite;
import lib.physics.Vector2d;
import objects.Bird;
import objects.Group;
import objects.Launcher;
import objects.Pig;
import objects.Wall;

public class LevelState implements IGameState{

	private ISprite angrySprite;
	private ISprite pigSprite;
	private ISprite wall;
	
	private Group pigs = new Group();
	private Group birds = new Group();
	private Group walls = new Group();
	
	private ArrayList<ISprite> sprites = new ArrayList<>();
	
	private Launcher launcher;
	
	private final Vector2d mouse = new Vector2d();
	
	@Override
	public void update(float delta) {
		birds.update(delta);
		pigs.update(delta);
		walls.update(delta);
		
		birds.collide(walls);
		
		pigs.collide(walls);
		birds.collide(pigs);
		
		pigs.collide(pigs);
	}

	@Override
	public void draw(Graphics g) {
		birds.draw(g);
		pigs.draw(g);
		walls.draw(g);
		launcher.draw(g);
		
	}

	
	@Override
	public void init() {
		angrySprite = new Bird();
		angrySprite.init();
		
		pigSprite = new Pig();
		pigSprite.init();
		pigSprite.getBody().getPosition().setX(550);
		pigSprite.getBody().getPosition().setY(150);
		pigs.addObject(pigSprite);
		
		pigSprite = new Pig();
		pigSprite.init();
		pigSprite.getBody().getPosition().setX(400);
		pigSprite.getBody().getPosition().setY(400);
		pigs.addObject(pigSprite);
		
		pigSprite = new Pig();
		pigSprite.init();
		pigSprite.getBody().getPosition().setX(750);
		pigSprite.getBody().getPosition().setY(500);
		pigs.addObject(pigSprite);
		
		launcher = new Launcher(mouse, angrySprite);
		
		
		birds.addObject(angrySprite);
		
		walls.addObject(new Wall(0, 500, 800, 100));
		walls.addObject(new Wall(400, 400, 200, 200));
		walls.addObject(new Wall(550, 200, 100, 20));
		walls.addObject(new Wall(550, 220, 20, 200));
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		launcher.lauch();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouse.setX(e.getX());
		mouse.setY(e.getY());
	}
	
}
