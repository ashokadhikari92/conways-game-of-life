package org.gameoflife;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		int[][] givenGrid = { 
				{ 0, 0, 0, 0, 0, 0, 1, 0 }, 
				{ 1, 1, 1, 0, 0, 0, 1, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 1, 1, 0, 0, 0 }, 
				{ 0, 0, 0, 1, 1, 0, 0, 0 } 
				};

		System.out.println("First Generation: ");
		System.out.println("===========================================\n\n");

		GameOfLife game = new GameOfLife();
		game.draw(givenGrid, "o", ".");

		System.out.println("\n\nNext Generation: ");
		System.out.println("===========================================\n\n");
		int[][] nextGrid;
		try {
			nextGrid = game.getNextGeneration(givenGrid);
			game.draw(nextGrid, "o", ".");
			int[][] val = new int[0][0];
			int[][] nextGrid1 = game.getNextGeneration(val);
		} catch (InvalidGridSizeException e) {
			System.out.println("Exception occured.");
		}
		
		
	}
}
