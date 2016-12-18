package application;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import lib.engine.Game;
import state.IGameState;
import state.LevelState;

@SuppressWarnings("serial")
public class Application extends Game implements MouseListener, MouseMotionListener {

	private static Application instance = new Application();
	
	private boolean isInitialized = false;
	private IGameState gamestate;
	
	public static Application getInstance() {
		return instance;
	}
	
	private Application() {
		super(800, 600);
		
		this.init();
		this.start();
	}
	
	

	@Override
	public void render(Graphics g) {
		if(!isInitialized) return;
		gamestate.draw(g);
	}

	@Override
	public void update(float delta) {
		gamestate.update(delta);
	}
	
	public void init() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		gamestate = new LevelState();
		gamestate.init();
		isInitialized = true;
	}

	
	public void setGameState(IGameState gs) {
		this.gamestate = gs;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		gamestate.mouseDragged(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		gamestate.mouseMoved(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		gamestate.mouseClicked(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		gamestate.mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		gamestate.mouseExited(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		gamestate.mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		gamestate.mouseReleased(e);
	}
	
	public static void main(String[] args) { }
	
}
