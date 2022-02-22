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
		return y-1;
	}
	public int getX() {
		return x-65; //A=65
	}
	
	
	public void setX(int i) {x = i+65;}

	public void setY(int i) {y=i+1;}
	
	private int x;
	private int y;

}
