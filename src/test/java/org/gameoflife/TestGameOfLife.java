package org.gameoflife;

import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestGameOfLife {
	private int[][] currentGrid, expectedNextGrid, wrongNextGrid;
	
	@BeforeEach
	void setup() {
		currentGrid = new int[][]{ 
				{ 0, 0, 0, 0, 0, 0, 1, 0 }, 
				{ 1, 1, 1, 0, 0, 0, 1, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 1, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 1, 1, 0, 0, 0 }, 
				{ 0, 0, 0, 1, 1, 0, 0, 0 } 
				};
		
		expectedNextGrid = new int[][]{ 
				{ 0, 1, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 1, 0, 0, 0, 1, 1, 1 }, 
				{ 0, 1, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 1, 1, 0, 0, 0 }, 
				{ 0, 0, 0, 1, 1, 0, 0, 0 } 
				};
				
		wrongNextGrid = new int[][]{ 
				{ 0, 1, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 1, 0, 0, 0, 1, 1, 1 }, 
				{ 0, 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 1, 1, 0, 0, 0 }, 
				{ 1, 0, 0, 1, 1, 0, 0, 0 } 
				};
	}
	
	@AfterEach
	void tearDown() {
		currentGrid = null;
		expectedNextGrid = null;
		wrongNextGrid = null;
	}
	

	@Test
	void testGetNextGeneration() {
		GameOfLife game = new GameOfLife();
		int[][] nextGrid = null;
		try {
			nextGrid = game.getNextGeneration(currentGrid);
		} catch (InvalidGridSizeException e) {
			e.printStackTrace();
		}
		
		assertTrue(Arrays.deepEquals(nextGrid, expectedNextGrid));
		assertFalse(Arrays.deepEquals(nextGrid, wrongNextGrid));
	}
	
	@Test
	void testGetNextGenerationWithException() {
		GameOfLife game = new GameOfLife();
		int[][] invalidGrid = new int[0][0];
		Assertions.assertThrows(InvalidGridSizeException.class, () -> {
			game.getNextGeneration(invalidGrid);
		});
	}
	
	@Test
	void testFindNextState() {
		GameOfLife game = new GameOfLife();
		int expectedState00 = 0;
		int expectedState17 = 1;
		int nextState00 = game.findNextState(currentGrid,0,0);
		int nextState17 = game.findNextState(currentGrid,1,7);
		
		assertEquals(expectedState00, nextState00);
		assertEquals(expectedState17, nextState17);
		
	}
}
