package ensta.model;
import java.util.Random;

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
	
	public boolean isInBoard(int size) {
		return (x-65 < size) && (y-1 < size);
	}
	public static Coords randomCoords(int size) {
		Random r = new Random();
		int x = r.nextInt(size);
		int y = r.nextInt(size);
		Coords c = new Coords(x+65,y+1);
		return c;
	}
	public void setCoords(Coords res) {
		x = res.x;
		y = res.y;
		
	}

}
