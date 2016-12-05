package physics;

import updatable.Updatable;

/**
 * Body interface
 * A units are pixel and pixel/s
 *
 */
public interface IBody extends Updatable{
	
	public double getX();
	public double getY();
	
	public double getVx();
	public double getVy();
	
	public void setX(double x);
	public void setY(double y);
	
	public void setVx(double vx);
	public void setVy(double vy);
	
}
