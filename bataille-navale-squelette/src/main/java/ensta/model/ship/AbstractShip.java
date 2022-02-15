package ensta.model.ship;

import ensta.util.Orientation;

public abstract class AbstractShip {
	private Orientation orientation;
	private int length;
	private String nom;
	private String label;
	
	
	public AbstractShip() {}
	public AbstractShip(String _label, String _nom, int _length, Orientation o) {
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
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
}
