package lib.physics;

public class Body implements Updatable{
	private final Vector2d position = new Vector2d();
	private final Vector2d velocity = new Vector2d();
	private final Vector2d acceleration = new Vector2d();
	
	public static final int COLLIDE_UP = 0;
	public static final int COLLIDE_LEFT = 1;
	public static final int COLLIDE_RIGHT = 2;
	public static final int COLLIDE_DOWN = 3;
	
	private int collideSize = -1;
	
	private final Vector2d size = new Vector2d();
	private boolean active = true;
	public Vector2d getPosition() {
		return position;
	}
	
	public Vector2d getVelocity() {
		return velocity;
	}
	
	public Vector2d getAcceleration() {
		return acceleration;
	}

	public Vector2d getSize() {
		return size;
	}
	
	/**
	 * Get the centered pos. Not updated after this call.
	 * @return
	 */
	public Vector2d getCenterPos() {
		Vector2d center = new Vector2d();
		center.setX(position.getX());
		center.setY(position.getY());
		center.add(size.getX()/2, size.getY()/2);
		return center;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * Return true if a vector2d(point) is inside the body
	 * @param v
	 * @return
	 */
	public boolean collide(Vector2d v) {
		if(v.getX() < position.getX()) return false;
		if(v.getY() < position.getY()) return false;
		if(v.getX() > position.getX() + size.getX()) return false;
		if(v.getY() > position.getY() + size.getY()) return false;
		return true;
	}
	
	
	private void checkCollideSide(Body other) {
		float depth = 99999;
		
		if(getLeft() < other.getLeft() && other.getLeft() < getRight() && getRight() < other.getRight()){   
		    this.collideSize = COLLIDE_RIGHT;
		    depth = getRight() - other.getLeft();
		}

		if(other.getLeft() < getLeft() && getLeft() < other.getRight() && other.getRight() < getRight()){
		    if(getLeft() - other.getRight() < depth) {
		    	depth = getLeft() - other.getRight();
		    	this.collideSize = COLLIDE_LEFT;
		    }
		}
		if(getTop() < other.getTop() && other.getTop() < getBottom() && getBottom() < other.getBottom()){
		    if(getBottom() - other.getTop() < depth) {
		    	depth = getBottom() - other.getTop();
		    	this.collideSize = COLLIDE_DOWN;
		    }
		}

		if(other.getTop() < getTop() && getTop() < other.getBottom() && other.getBottom() < getBottom()){
			 if(other.getBottom() - getTop() < depth) {
			    	this.collideSize = COLLIDE_UP;
			    }
		}
	}
	
	/**
	 * Return true if this body is colliding with other body
	 * @param other
	 * @return
	 */
	public boolean collide(Body other) {
		//fast checking
		if(position.getX() > other.getPosition().getX() + other.getSize().getX()) return false;
		if(position.getY() > other.getPosition().getY() + other.getSize().getY()) return false;
		if(position.getX() + size.getX() < other.position.getX()) return false;
		if(position.getY() + size.getY() < other.position.getY()) return false;
		
		
		checkCollideSide(other);
		
		return true;
	}
	
	/**
	 * If collide with other, the position is adjusted according to the position
	 * @param other
	 */
	public void doCollide(Body other) {
		if(collide(other)) {
			
			if(this.collideSize == COLLIDE_RIGHT) {
				this.position.setX(other.position.getX() - this.size.getX());
				this.velocity.setX(-this.velocity.getX()/2);
			}
			else if(this.collideSize == COLLIDE_LEFT) {
				this.position.setX(other.getRight());
				this.velocity.setX(-this.velocity.getX()/2);
			}
			else if(this.collideSize == COLLIDE_UP) {
				this.position.setY(other.getBottom());
				this.velocity.setY(-this.velocity.getY()/2);
			}
			else {
				this.position.setY(other.getTop() - size.getY());
				this.velocity.setY(-this.velocity.getY()/2);
			}
			
		}
	}
	
	public float getLeft() {
		return this.position.getX();
	}
	
	public float getRight() {
		return this.position.getX() + this.size.getX();
	}
	
	public float getTop() {
		return this.position.getY();
	}
	
	public float getBottom() {
		return this.position.getY() + this.size.getY();
	}

	@Override
	public void update(float delta) {
		if(!active) return;
		getVelocity().add(delta * getAcceleration().getX(), delta * getAcceleration().getY());
		getPosition().add(delta * getVelocity().getX(), delta * getVelocity().getY());
	}
	
	
}
