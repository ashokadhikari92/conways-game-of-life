package org.gameoflife;

public class InvalidGridSizeException extends Exception {
	public InvalidGridSizeException(String errorMessage) {
		super(errorMessage);
	}

}
