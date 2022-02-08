package ensta.model.ship;

import ensta.util.Orientation;

public abstract class AbstractShip {
	private abstract Orientation Or;
	private int length;
	

	protected abstract Orientation getOrientation();

	protected abstract int getLength();
	
}
