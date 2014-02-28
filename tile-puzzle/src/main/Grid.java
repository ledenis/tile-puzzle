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
	public void move(int direction) {
		switch(direction) {
		case NORTH:
			break;
		case EAST:
			break;
		case SOUTH:
			break;
		case WEST:
			break;
		default:
		}
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

}
