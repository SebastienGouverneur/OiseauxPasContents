package physics.body;

import physics.IBody;

/**
 * Body implementation
 *
 */
public class Body implements IBody {

	private double x = 0;
	private double y = 0;
	private double vx = 0;
	private double vy = 0;
	
	@Override
	public void update(float delta) {
		x += delta * vx/1000;
		y += delta * vy/1000;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public double getVx() {
		return vx;
	}

	@Override
	public double getVy() {
		return vy;
	}

	@Override
	public void setX(double x) {
		this.x = x;
	}

	@Override
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public void setVx(double vx) {
		this.vx = vx;
	}

	@Override
	public void setVy(double vy) {
		this.vy = vy;
	}

}
