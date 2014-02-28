package main.solver;

import java.util.LinkedList;
import java.util.List;

import main.Grid;

public class DepthLimitedSolver {

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
			List<Grid> result = solve(next, dest, depth - 1);
			
			// Found solution
			if (result != null) {
				result.add(start); // Add at the end
				return result;
			}
		}
		
		// Not found
		return null;
	}

	public List<Grid> nextConfigs(Grid grid) {
		List<Grid> nextConfigs = new LinkedList<>();

		for (int dir = 0; dir < Grid.NB_DIR; dir++) {
			if (grid.isMovable(dir)) {
				nextConfigs.add(new Grid(grid).move(dir));
			}
		}

		return nextConfigs;
	}
}
