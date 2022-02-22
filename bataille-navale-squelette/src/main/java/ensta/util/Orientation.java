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
		if(o=="n") {return Orientation.NORTH;}
		else if (o=="w") {return Orientation.WEST;}
		else if (o=="e") {return Orientation.EAST;}
		else if(o=="s") {return Orientation.SOUTH;}
		return null;
	}
}
