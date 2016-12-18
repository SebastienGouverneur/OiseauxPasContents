package lib.physics;

public class Vector2d {
	private float x;
	private float y;
	
	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	
	public void add(float x, float y) {
		this.x += x;
		this.y += y;
	}
	
	public float distance(Vector2d v) {
		float dx = this.getX() - v.getX();
        float dy = this.getY() - v.getY();
        return (float) Math.sqrt(dx * dx + dy * dy);
	}
}
