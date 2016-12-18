package lib.GameObject;

import lib.physics.Updatable;
import lib.render.Drawable;

public interface IGameObject extends Updatable, Drawable {
	public void init();
}
