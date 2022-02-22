package ensta.model.ship;


import ensta.util.Orientation;

public class Submarine extends AbstractShip {
	public Submarine() {
		super('S', "Submarine", 3, Orientation.EAST);
	}

	public Submarine(Orientation o) {
		super('S', "Submarine", 3, o);
	}
}
