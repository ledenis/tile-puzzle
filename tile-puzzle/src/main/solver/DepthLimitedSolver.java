package main.solver;

import java.util.LinkedList;
import java.util.List;

import main.Grid;

/**
 * Depth limited search solver
 */
public class DepthLimitedSolver extends Solver {

	public List<Grid> solve(Grid start, Grid dest, int depth) {
		// Stopping condition
		if (start.equals(dest)) { // found
			List<Grid> singleton = new LinkedList<>();
			singleton.add(new Grid(start));
			return singleton;
		}
		if (depth == 0) { // not found
			return null;
		}

		// Recursive call on next configs
		List<Grid> nextConfigs = nextConfigs(start);
		for (Grid next : nextConfigs) {
			List<Grid> route = solve(next, dest, depth - 1);

			// Found solution
			if (route != null) {
				route.add(start); // Add at the end
				return route;
			}
		}

		// Not found
		return null;
	}

}
