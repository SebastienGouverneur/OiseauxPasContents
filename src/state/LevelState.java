package state;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import lib.GameObject.ISprite;
import lib.physics.Vector2d;
import objects.Bird;
import objects.Launcher;
import objects.Pig;
import objects.Wall;

public class LevelState implements IGameState{

	private ISprite angrySprite;
	private ISprite pigSprite;
	private ISprite wall;
	
	private Launcher launcher;
	
	private final Vector2d mouse = new Vector2d();
	
	@Override
	public void update(float delta) {
		angrySprite.update(delta);
		pigSprite.update(delta);
		
		angrySprite.getBody().doCollide(pigSprite.getBody());
		angrySprite.getBody().doCollide(wall.getBody());
	}

	@Override
	public void draw(Graphics g) {
		wall.draw(g);
		angrySprite.draw(g);
		pigSprite.draw(g);
		
		launcher.draw(g);
		
	}

	private void randomPigPosition(ISprite sprite) {
		pigSprite.getBody().getPosition().setX((float) (Math.random() * 500 + 200));
		pigSprite.getBody().getPosition().setY(0);
	}
	
	@Override
	public void init() {
		angrySprite = new Bird();
		angrySprite.init();
		
		pigSprite = new Pig();
		pigSprite.init();
		randomPigPosition(pigSprite);
		
		launcher = new Launcher(mouse, angrySprite);
		
		wall = new Wall(200, 500, 400, 100);
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
