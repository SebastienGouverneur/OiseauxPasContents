package lib.GameObject;

import lib.physics.Body;
import lib.render.Animation;

public interface ISprite extends IGameObject{
	public Animation createAnimation(String name);
	public void setAnimation(String name, boolean play, int frame);
	public void startAnimation();
	public void stopAnimation();
	public Body getBody();
}
