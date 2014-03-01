package main.solver;

import java.util.List;
import java.util.PriorityQueue;

import main.Grid;
import main.State;

/**
 * A* solver
 */
public class AStarSolver extends Solver {
	public List<Grid> solve(Grid start, Grid dest) {
		// Init
		PriorityQueue<State> states = new PriorityQueue<>();
		states.add(new State(start, start.wrongTiles(dest)));

		while (true) {
			// check finished?
			if (states.isEmpty())
				return null;

			// Select the best candidate
			dump(states); // debug
			State state = states.poll();
			Grid grid = state.getLastGrid();

			// check finished?2
			if (grid.equals(dest))
				return state.getRoute(); // solution found

			// Expand it
			for (Grid next : nextConfigs(grid)) {
				if (!state.getRoute().contains(next)) // check repetition
					states.add(state.cloneAndAdd(next, next.wrongTiles(dest)));
			}

		}

	}

	private void dump(PriorityQueue<State> states) {
		// Print in order
//		PriorityQueue<State> copy = new PriorityQueue<>(states);
//		int size = copy.size();
//		for (int i = 0; i < size; i++) {
//			System.out.print(copy.poll() + " ");
//		}
//		System.out.println();
		
		// Or print directly
//		System.out.println(states);
	}
}
