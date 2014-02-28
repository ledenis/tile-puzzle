package main.solver;

import java.util.LinkedList;
import java.util.List;

import main.Grid;

public class DepthLimitedSolver {

	public void solve() {
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
