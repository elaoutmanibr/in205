package ensta.model;

public class Coords {
	
	public Coords() {}
	public Coords(Coords coords) {
		x = coords.x;
		y = coords.y;
	}
	public Coords(int _x, int _y) {
		x = _x;
		y = _y;
		
	}

	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
	
	private int x;
	private int y;

}
