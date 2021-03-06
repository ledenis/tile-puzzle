package main;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Represent a grid 3x4 It is implemented as a String (each char is a tile) The
 * free tile is represented as '_'. Plus, its position is stored as an int. Can
 * be manipulated with move(), and check if it is movable()
 */
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

	/**
	 * @param str
	 *            The string that represents the grid. Its length must = 12,
	 *            must contains '_'
	 */
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

	/**
	 * Copy constructor. The original is unchanged
	 * 
	 * @param original
	 */
	public Grid(Grid original) {
		str = original.str; // Strings are immutable
		freeTile = original.freeTile;
	}

	/**
	 * @return a readable format of the grid (debugging)
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(freeTile + "\n");
		for (int i = 0; i < HEIGHT; i++) {
			sb.append(str.substring(i * WIDTH, (i * WIDTH) + WIDTH) + "\n");
		}

		return sb.toString();
	}

	/**
	 * @return position of the free tile '_'. start from 0
	 */
	public int getFreeTile() {
		return freeTile;
	}

	/**
	 * @param direction
	 *            Either NORTH, EAST, SOUTH or WEST
	 */
	public Grid move(int direction) {
		if (!isMovable(direction)) {
			throw new RuntimeException("Not movable");
		}

		int newFreeTile;

		switch (direction) {
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
	 * @param direction
	 *            Either NORTH, EAST, SOUTH or WEST
	 */
	public boolean isMovable(int direction) {
		switch (direction) {
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

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Grid)) {
			return false;
		}

		Grid other = (Grid) obj;

		// Check the string
		if (other.equalsStr(str)) {
			return true;
		}
		return false;
	}

	/**
	 * Print the solution to stdout and to the corresponding txt file
	 * 
	 * @param sol
	 *            the solution, ordered list of grids, from start to goal
	 */
	public static void printSolution(List<Grid> sol) {
		if (sol == null) {
			System.out.println("No solution");
			return;
		}

		StringBuilder sb = new StringBuilder();

		// For each line
		for (int i = 0; i < HEIGHT; i++) {

			// For each grid
			for (int g = 0; g < sol.size(); g++) {
				Grid grid = sol.get(g);

				// Print its line
				sb.append(grid.str.substring(i * WIDTH, i * WIDTH + WIDTH)
						+ " ");
			}
			sb.append('\n');
		}

		// Print
		System.out.print(sb.toString());
		System.out.println("" + (sol.size() - 1) + " moves");

		// Write to file
		try {
			PrintWriter out = new PrintWriter(sol.get(0).str + "2"
					+ sol.get(sol.size() - 1).str + ".txt");
			out.print(sb.toString());
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return Nb of out of place tiles, excluding the free tile
	 */
	public int wrongTiles(Grid dest) {
		int count = 0;

		// For each tile
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			// if not free tile && out of place
			if (c != '_' && c != dest.str.charAt(i)) {
				count++;
			}
		}
		return count;
	}
}
