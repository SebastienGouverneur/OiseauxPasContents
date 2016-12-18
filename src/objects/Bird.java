package objects;

import lib.GameObject.impl.Sprite;
import lib.render.Animation;
import lib.render.ImageFactory;

public class Bird extends Sprite{

	
	@Override
	public void init() {
		Animation anim = createAnimation("idle");
		anim.addImage(ImageFactory.getImage("./imageBird.png"));
		setAnimation("idle", false, 0);
		getBody().getPosition().setX(100);
		getBody().getPosition().setY(400);
		getBody().getSize().setX(40);
		getBody().getSize().setY(40);
		getBody().getAcceleration().setY(98); //gravity
	}
}
