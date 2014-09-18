11-Tile Puzzle Solver
=====================

The program solves a 11-tile (3x4 including the free tile) puzzle with *A\** or *Depth limited* algorithms according to the user choice. The puzzle consists in moving the tiles of a board using the free tile from a start state to a given goal state.

When prompted, the format of the problem is *xxxxxxxxxx2yyyyyyyyyyyy.txt* with *xxxxxxxxxxxx* = *start* and *yyyyyyyyyyyy* = *goal*.

These *start* and *goal* each represent a 3x4 grid. Each character is a tile, with the free tile represented as '_'.

**Example:**

The following input:

	a_cddbaddbbd2adcaddb_bbdd.txt

...which means:

	a_c       adc
	ddb  ==>  add
	add       b_b
	bbd       bdd

... gives this output with the A* solver: 

	a_c adc adc adc adc adc adc adc adc adc adc 
	ddb d_b ddb ddb ddb ddb dd_ d_d _dd add add 
	add add a_d abd abd ab_ abb abb abb _bb b_b 
	bbd bbd bbd b_d bd_ bdd bdd bdd bdd bdd bdd
