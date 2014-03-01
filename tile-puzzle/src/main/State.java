package main;

import java.util.LinkedList;
import java.util.List;

/**
 * This is used by the A* solver. A state store a route, and two numbers (g and
 * h) which are heuristics
 */
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

	/**
	 * Clone the state, add a grid (the next move) to the route, and return the
	 * new state. The original is unchanged
	 * 
	 * @param next
	 *            the next move
	 * @param nextH
	 *            the heuristic h of the new grid
	 * @return the new state
	 */
	public State cloneAndAdd(Grid next, int nextH) {
		State clone = new State();
		clone.route = new LinkedList<>();

		for (Grid gr : route) {
			clone.route.add(gr);
		}
		clone.route.add(next);

		clone.g = this.g + 1;
		clone.h = nextH;

		return clone;
	}

	/**
	 * Used by PriorityQueue. States are ordered by the rank (g+h). lower =
	 * higher priority
	 */
	@Override
	public int compareTo(State other) {
		return Integer.compare(g + h, other.g + other.h);
	}

	/**
	 * @return the last grid in the route
	 */
	public Grid getLastGrid() {
		return route.get(route.size() - 1);
	}

	public List<Grid> getRoute() {
		return route;
	}

	/**
	 * @return string containing the rank (g+h) (debugging)
	 */
	@Override
	public String toString() {
		return "" + (g + h);
	}
}
