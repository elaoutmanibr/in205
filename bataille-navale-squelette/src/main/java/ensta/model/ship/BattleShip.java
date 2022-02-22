package ensta.model.ship;

import ensta.util.Orientation;

public class BattleShip extends AbstractShip {
	public BattleShip() {
		super('B',"Battle Ship", 4, Orientation.EAST);
	}
	public BattleShip(Orientation o) {
		super('B',"Battle Ship", 4, o);
	}
	
	
}
