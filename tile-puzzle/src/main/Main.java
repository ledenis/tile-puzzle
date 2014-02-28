package main;

import java.util.List;

import main.solver.DepthLimitedSolver;

public class Main {
	public static void main(String[] args) {
		System.out.println("hello");
		
		Grid grid = new Grid("dbad_caddbbd");
		Grid gridGoal = new Grid("_baddcaddbdb");
//		Grid gridOrig = new Grid("_1234679ABC0");
//		Grid grid = new Grid(gridOrig);
//		System.out.println(grid);
//		
//		System.out.println(grid.isMovable(Grid.NORTH));
//		System.out.println(grid.isMovable(Grid.EAST));
//		System.out.println(grid.isMovable(Grid.SOUTH));
//		System.out.println(grid.isMovable(Grid.WEST));
//		grid.move(Grid.EAST);
//		grid.move(Grid.SOUTH);
//		grid.move(Grid.WEST);
//		grid.move(Grid.NORTH);
//		grid.move(Grid.SOUTH);
//		System.out.println(grid);
//		System.out.println(grid.equalsStr("142_9637ABC0"));
		
		System.out.println("Solve");
		DepthLimitedSolver solver = new DepthLimitedSolver();
		List<Grid> sol = solver.solve(grid, gridGoal, 8);
		Grid.printSolution(sol);
		Grid g1 = sol.get(0);
		Grid g2 = sol.get(8);
		System.out.println(g1.wrongPlaced(g2));
		System.out.println(g1);
		System.out.println(g2);
//		System.out.println(solver.solve(gridOrig, grid, 5));
	}
}

/*
dbad_caddbbd2_baddcaddbdb.txt
dadcb_ddbdba2dba_adcdddbb.txt
c_baaddbddbd2acbda_dddbbd.txt
babaddd_bddc2a_babddbdddc.txt
a_cddbaddbbd2adcaddb_bbdd.txt
baadddddbc_b2aadbdd_bbddc.txt
bdbdbda_dcda2bddbaad_bcdd.txt
ddadddba_bbc2bd_ddabddbac.txt
acddda_bdbdb2_acdbdbadddb.txt
acd_dadbbbdd2d_aacddbdbbd.txt
bdddbbda_acd2_ddbdabdbacd.txt
a_ddbbdbdacd2adb_dbcadddb.txt
dda_dbacdbbd2dabddba_cbdd.txt
bddd_cadbbda2cbddbdadab_d.txt
abddabdbcd_d2_dbbabdacddd.txt
caaddddb_bbd2_caddabbddbd.txt
*/