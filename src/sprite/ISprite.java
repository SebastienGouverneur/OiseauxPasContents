package sprite;

import animation.IAnimation;
import drawable.IDrawable;
import physics.IBody;
import updatable.Updatable;

public interface ISprite extends IDrawable, Updatable{
	public IAnimation getAnimations(int i);
	public void init();
}
