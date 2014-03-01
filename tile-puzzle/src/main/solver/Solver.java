package main.solver;

import java.util.LinkedList;
import java.util.List;

import main.Grid;

/**
 * Base class for AStarSolver and DepthLimitedSolver
 */
public class Solver {
	
	/**
	 * @param grid
	 * @return list of grids corresponding to the next possible moves
	 */
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
