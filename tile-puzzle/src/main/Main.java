package main;

import java.util.List;
import java.util.Scanner;

import main.solver.AStarSolver;

public class Main {
	public static void main(String[] args) {
		// Input
		Scanner sc = new Scanner(System.in);
		System.out.println("Please copy/paste the problem: ");
		String problem = sc.nextLine();
		sc.close();

		Grid gridStart;
		Grid gridGoal;
		gridStart = new Grid(problem.substring(0, 12));
		gridGoal = new Grid(problem.substring(13, 13 + 12));

		System.out.println("Solve");

		// A*
		AStarSolver solver = new AStarSolver();
		List<Grid> sol = solver.solve(gridStart, gridGoal);

		// Depth limited
		// DepthLimitedSolver solver = new DepthLimitedSolver();
		// List<Grid> sol = solver.solve(gridStart, gridGoal, 8);
		// if (sol != null)
		// Collections.reverse(sol); // the list is reversed

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