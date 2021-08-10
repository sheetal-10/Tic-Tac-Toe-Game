package com.TicTacToe;

import java.util.Random;
import java.util.Scanner;

/**
 * Program for making Utility of repeating functions or equations
 * @author Sheetal
 * @since 2021-08-10
 */
public class Utility {
	
	/**
	 * Scanner which can parse primitive types and strings
	 */
	private static final Scanner scan = new Scanner(System.in);

	/**
	 * Scanning of User input which is integer type
	 * @return assigned integer value
	 */
	public static int getUserInteger() {
		return scan.nextInt();
	}
	
	/**
	 * Random for calling different random numbers
	 */
	private static final Random random= new Random();
	
	public static int getRandomInt(int number) {
		return random.nextInt(number);
	}
	
}