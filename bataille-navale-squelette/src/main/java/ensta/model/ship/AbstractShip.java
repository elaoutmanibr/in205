package ensta.model.ship;

import ensta.util.Orientation;

public abstract class AbstractShip {
	private Orientation orientation;
	private int length;
	private String nom;
	private char label;
	
	
	public AbstractShip() {}
	public AbstractShip(char _label, String _nom, int _length, Orientation o) {
		orientation = o;
		length = _length;
		nom = _nom;
		setLabel(_label);
	}
	public void setOrientation(Orientation _orientation) {
		this.orientation = _orientation;
	}
	
	public Orientation getOrientation() {
		return orientation;
	}

	public int getLength() {
		return length;
	}
	public String getNom() {
		return nom;
	}
	public char getLabel() {
		return label;
	}
	public void setLabel(char label) {
		this.label = label;
	}
	
	
	
}
