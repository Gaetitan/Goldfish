package com.polytech.goldfish.util;

/**
 * This class handles the errors
 * 
 * @author Ga�tan FRAN�OIS
 *
 */
public class GoldfishException extends Exception {

	private static final long serialVersionUID = 1L;

	public GoldfishException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return super.getMessage();
	}
	
}
