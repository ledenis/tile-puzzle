package main;

public class Grid {
	private static final int HEIGHT = 4;
	private static final int WIDTH = 3;
	
	private String str;
	private int freeTile;
	
	// Directions
	public final static int NORTH = 0;
	public final static int EAST = 1;
	public final static int SOUTH = 2;
	public final static int WEST = 3;
	public final static int NB_DIR = 4;

	public Grid(String str) {
		this.str = str;
		
		if (str.length() != 12) {
			throw new RuntimeException("length != 12");
		}
		
		freeTile = str.indexOf('_');
		
		if (freeTile == -1) {
			throw new RuntimeException("Character '_' not found");
		}
	}
	
	public Grid(Grid original) {
		str = original.str; // Strings are immutable
		freeTile = original.freeTile;
	}

	@Override
	// Return a readable format of the grid
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(freeTile + "\n");
		for (int i = 0; i < HEIGHT; i++) {
			sb.append(str.substring(i * WIDTH, (i * WIDTH) + WIDTH) + "\n");
		}

		return sb.toString();
	}

	public int getFreeTile() {
		return freeTile;
	}
	
	/**
	 * @param direction Either NORTH, EAST, SOUTH or WEST
	 */
	public Grid move(int direction) {
		if (!isMovable(direction)) {
			throw new RuntimeException("Not movable");
		}
		
		int newFreeTile;
		
		switch(direction) {
		case NORTH:
			newFreeTile = freeTile - WIDTH;
			break;
		case EAST:
			newFreeTile = freeTile + 1;
			break;
		case SOUTH:
			newFreeTile = freeTile + WIDTH;
			break;
		case WEST:
			newFreeTile = freeTile - 1;
			break;
		default:
			throw new RuntimeException("Wrong direction");
		}
		
		swap(freeTile, newFreeTile);
		freeTile = newFreeTile;
		
		return this;
	}
	
	/**
	 * @param direction Either NORTH, EAST, SOUTH or WEST
	 */
	public boolean isMovable(int direction) {
		switch(direction) {
		case NORTH:
			if (freeTile / WIDTH == 0)
				return false;
			return true;
		case EAST:
			if (freeTile % WIDTH == WIDTH - 1)
				return false;
			return true;
		case SOUTH:
			if (freeTile / WIDTH == HEIGHT - 1)
				return false;
			return true;
		case WEST:
			if (freeTile % WIDTH == 0)
				return false;
			return true;
		default:
			throw new RuntimeException("Wrong direction");
		}
	}

	private void swap(int i, int j) {
		char[] array = str.toCharArray();
		
		char tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
		
		str = new String(array);
	}

	public boolean equalsStr(String state) {
		return str.equals(state);
	}
}
