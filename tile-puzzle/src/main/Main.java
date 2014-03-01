package main;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import main.solver.AStarSolver;
import main.solver.DepthLimitedSolver;

/**
 * The program solves a 11-tile (3x4 including the free tile) puzzle with A* or
 * Depth limited according to the user choice When prompted, the format of the
 * problem is xxxxxxxxxx2yyyyyyyyyyyy.txt with xxxxxxxxxxxx = start and
 * yyyyyyyyyyyy = goal
 */
public class Main {
	public static void main(String[] args) {
		// Input
		Scanner sc = new Scanner(System.in);

		System.out.println("Please copy/paste the problem: ");
		String problem = sc.nextLine();

		System.out.println("1. A*\n2. Depth limited");
		int solver = sc.nextInt();

		int depth = 0;
		if (solver == 2) {
			System.out.println("Depth?");
			depth = sc.nextInt();
		}
		sc.close();

		Grid gridStart;
		Grid gridGoal;
		gridStart = new Grid(problem.substring(0, 12));
		gridGoal = new Grid(problem.substring(13, 13 + 12));

		System.out.println("Solve");

		List<Grid> sol;

		switch (solver) {
		case 1: // A*
			AStarSolver aSolver = new AStarSolver();
			sol = aSolver.solve(gridStart, gridGoal);
			break;
		case 2: // Depth limited
			DepthLimitedSolver dSolver = new DepthLimitedSolver();
			sol = dSolver.solve(gridStart, gridGoal, depth);
			if (sol != null)
				Collections.reverse(sol); // the list is reversed
			break;
		default:
			System.out.println("Please choose 1 or 2s");
			return;
		}

		Grid.printSolution(sol);
	}
}

/*
 * dbad_caddbbd2_baddcaddbdb.txt dadcb_ddbdba2dba_adcdddbb.txt
 * c_baaddbddbd2acbda_dddbbd.txt babaddd_bddc2a_babddbdddc.txt
 * a_cddbaddbbd2adcaddb_bbdd.txt baadddddbc_b2aadbdd_bbddc.txt
 * bdbdbda_dcda2bddbaad_bcdd.txt ddadddba_bbc2bd_ddabddbac.txt
 * acddda_bdbdb2_acdbdbadddb.txt acd_dadbbbdd2d_aacddbdbbd.txt
 * bdddbbda_acd2_ddbdabdbacd.txt a_ddbbdbdacd2adb_dbcadddb.txt
 * dda_dbacdbbd2dabddba_cbdd.txt bddd_cadbbda2cbddbdadab_d.txt
 * abddabdbcd_d2_dbbabdacddd.txt caaddddb_bbd2_caddabbddbd.txt
 */