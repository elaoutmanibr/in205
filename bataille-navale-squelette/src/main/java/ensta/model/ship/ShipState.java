package ensta.model.ship;
import ensta.util.ColorUtil;

public class ShipState {
	private AbstractShip ship;
	private boolean struck;
	
	public ShipState(AbstractShip s) {
		ship = s;
		struck = false;
	}
	
	public void addStrike() {
		if (!struck) {
			ship.addStrike();
			struck = true;
		}
	}
	
	public boolean isStruck(){
		return struck;
	}
	
	public String toString() {
		return ColorUtil.colorize(this.ship.getLabel(), ((this.struck) ? ColorUtil.Color.RED : ColorUtil.Color.WHITE));
	}
	public boolean isSunk() {
		return ship.isSunk();
	}
	
	public AbstractShip getShip() {
		return ship;
	}

}

