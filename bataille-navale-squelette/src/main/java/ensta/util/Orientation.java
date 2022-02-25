package ensta.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Orientation {
	SOUTH(1), NORTH(-1), WEST(-1), EAST(1);

	private static final List<Orientation> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = VALUES.size();
	private static final Random RANDOM = new Random();
	private int increment;

	private Orientation(int increment) {
		this.increment = increment;
	}
	
	public int getIncrement() {
		return increment;
	}

	public static Orientation randomOrientation() {
		return VALUES.get(RANDOM.nextInt(SIZE));
	}
	
	public static Orientation str2orient(String o) {
		if(o.equals("north")) {return Orientation.NORTH;}
		else if (o.equals("west")) {return Orientation.WEST;}
		else if (o.equals("east")) {return Orientation.EAST;}
		else if(o.equals("south")) {return Orientation.SOUTH;}
		else {System.out.println("orientation non reconnue");}
		return null;
	}
}
