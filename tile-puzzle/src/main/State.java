package main;

import java.util.LinkedList;
import java.util.List;

public class State implements Comparable<State> {
	List<Grid> route; // From start to current grid
	int g; // Actual cost
	int h; // From current to goal (heuristic)

	private State() {
	}

	/**
	 * New state with a singleton route
	 * 
	 * @param start
	 * @param h
	 *            heuristic
	 */
	public State(Grid start, int h) {
		route = new LinkedList<>();
		route.add(new Grid(start));
		g = 0;
		this.h = h;
	}

	public State cloneAndAdd(Grid next, int nextH) {
		State clone = new State();

		for (Grid gr : route) {
			clone.route.add(gr);
		}
		clone.route.add(next);

		clone.g = this.g + 1;
		clone.h = nextH;

		return clone;
	}

	@Override
	public int compareTo(State other) {
		if (g + h > other.g + other.h)
			return 1;
		else if (g + h < other.g + other.h)
			return -1;
		return 0;
	}
}
