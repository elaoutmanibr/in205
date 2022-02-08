package ensta.model;

import ensta.model.ship.AbstractShip;
import ensta.util.Orientation;

public class Board implements IBoard {

	private static final int DEFAULT_SIZE = 10;
	private String name;
	private int size = DEFAULT_SIZE;
	
	private char[] tabNavire = new char[size*size];
	private boolean[] tabFrappes=new boolean[size*size];
	
	public Board() {
	}
	
	public Board(String _name, int _size) {
		this.name = _name;
		this.size = _size;
		for(int i=0;i<this.size;i++) {
			tabNavire[i] = '.';
			tabFrappes[i] = false;
		}
	}
	
	public Board(String _name) {
		this.name = _name;
		for(int i=0;i<this.size;i++) {
			tabNavire[i] = '.';
			tabFrappes[i] = false;
		}
	}

	public void print() {
		System.out.println("Navires:");
		System.out.print(" \t");
		for (int i=0; i<this.size;i++) {
			System.out.print((char)(65+i)+"\t");
		}
		System.out.print("\n");
		for (int i=1; i<this.size+1;i++) {
			System.out.print(i+"\t");
			for (int j=0; j<this.size;j++) {
				System.out.print(tabNavire[i-1]+"\t");
			}
			System.out.print("\n");
		}
		
		System.out.print("\n");
		System.out.println("Frappes:");
		System.out.print(" \t");
		for (int i=0; i<this.size;i++) {
			System.out.print((char)(65+i)+"\t");
		}
		System.out.print("\n");
		for (int i=1; i<this.size+1;i++) {
			System.out.print(i+"\t");
			for (int j=0; j<this.size;j++) {
				System.out.print(tabFrappes[i-1]+"\t");
			}
			System.out.print("\n");
		}
	}

	public boolean canPutShip(AbstractShip ship, Coords coords) {
		Orientation o = ship.getOrientation();
		int dx = 0, dy = 0;
		if (o == Orientation.EAST) {
			if (coords.getX() + ship.getLength() >= this.size) {
				return false;
			}
			dx = 1;
		} else if (o == Orientation.SOUTH) {
			if (coords.getY() + ship.getLength() >= this.size) {
				return false;
			}
			dy = 1;
		} else if (o == Orientation.NORTH) {
			if (coords.getY() + 1 - ship.getLength() < 0) {
				return false;
			}
			dy = -1;
		} else if (o == Orientation.WEST) {
			if (coords.getX() + 1 - ship.getLength() < 0) {
				return false;
			}
			dx = -1;
		}

		Coords iCoords = new Coords(coords);

		for (int i = 0; i < ship.getLength(); ++i) {
			if (this.hasShip(iCoords)) {
				return false;
			}
			iCoords.setX(iCoords.getX() + dx);
			iCoords.setY(iCoords.getY() + dy);
		}

		return true;
	}
}
