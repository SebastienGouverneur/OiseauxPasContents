package objects;

import lib.GameObject.impl.Sprite;
import lib.render.Animation;
import lib.render.ImageFactory;

public class Pig extends Sprite{

	
	@Override
	public void init() {
		Animation anim = createAnimation("idle");
		anim.addImage(ImageFactory.getImage("./imagePig.png"));
		setAnimation("idle", false, 0);
		getBody().getSize().setX(40);
		getBody().getSize().setY(40);
	}
}
