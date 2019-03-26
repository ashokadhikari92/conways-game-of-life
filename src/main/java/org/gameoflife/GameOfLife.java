package org.gameoflife;


/**
 * The {@code GameOfLife} class implements Convey's game of life rules to find out the next generation for the game.
 * The playing field for this game is represented by two dimensional integer array and live and dead state are 
 * represented by 1 and 0 respectively. 
 * 
 * @author Ashok Adhikari
 * @since 03/25/2019
 * @version 1.0
 *
 */
public class GameOfLife {
	private int cols,rows;
	private int[][] nextGeneration;

	/**
	 * Generate a next generation based on the given state
	 * 
	 * @param currentGrid The current generation in the game.
	 * @return the next generation represented by 2 dimensional integer array.
	 * @throws InvalidGridSizeException 
	 */
	public int[][] getNextGeneration(int[][] currentGrid) throws InvalidGridSizeException {
		if(currentGrid.length == 0 || currentGrid[0].length == 0)
			throw new InvalidGridSizeException("Invalid lenght of playing field.");
		
		rows = currentGrid.length;
		cols = currentGrid[0].length;
		nextGeneration = new int[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				nextGeneration[i][j] = findNextState(currentGrid, i, j);
			}
		}

		return nextGeneration;

	}

	/**
	 * Find the next state of a given particular grid
	 * It calculates next state by using Conveny's rule of life
	 * 
	 * @param currentGrid The current generation in the game
	 * @param row Row index of the given grid
	 * @param col Column index of the given grid
	 * @return next state of given grid
	 */
	public int findNextState(int[][] currentGrid, int row, int col) {
		int state = currentGrid[row][col];
		int neighbours = countNeighbors(currentGrid, row, col);
		if (state == 0 && neighbours == 3) {
			return 1;
		}
		if (state == 1 && (neighbours > 3 || neighbours < 2)) {
			return 0;
		}

		return state;

	}

	/**
	 * A helper method to find the next state of a given gird
	 * It returns the sums of its neighbor grid values
	 * 
	 * @param currentGrid The current generation in the game
	 * @param row Row index of the given grid
	 * @param col Column index of the given grid
	 * @return sum of the neighbor grid value
	 */
	private int countNeighbors(int[][] currentGrid, int row, int col) {
		rows = currentGrid.length;
		cols = currentGrid[0].length;
		
		int sum = 0;
		int iStart = -1;
		int jStart = -1;
		int iEnd = 2;
		int jEnd = 2;

		if (row == 0) {
			iStart = 0;
		}
		if (row == rows - 1) {
			iEnd = 1;
		}

		if (col == 0) {
			jStart = 0;
		}

		if (col == cols - 1) {
			jEnd = 1;
		}
		for (int i = iStart; i < iEnd; i++) {
			for (int j = jStart; j < jEnd; j++) {

				int rowInd = (row + i );
				int colInd = (col + j );

				sum += currentGrid[rowInd][colInd];
			}
		}
		sum -= currentGrid[row][col];

		return sum;
	}

	/**
	 * Draw given grid with given alive and dead state symbol
	 * 
	 * @param currentGrid
	 * @param alive
	 * @param dead
	 */
	public void draw(int[][] currentGrid, String alive, String dead) {
		rows = currentGrid.length;
		cols = currentGrid[0].length;
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (currentGrid[i][j] == 1) {
					System.out.print("  " + alive + "  ");
				} else {
					System.out.print("  " + dead + "  ");
				}
			}
			System.out.println("\n");
		}
	}
}
