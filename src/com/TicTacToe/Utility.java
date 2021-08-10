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
	
	/**
	 * Calling method for to get win pattern by sequential number
	 * @param number
	 * @return arrayWin
	 */
	public static int[] winArray(int number) {
		if (number==1) {
			int arrayWin[]= {1,2,3};
			return arrayWin;
		} else if (number==2) {
			int arrayWin[]= {4,5,6};
			return arrayWin;
		} else if (number==3) {
			int arrayWin[]= {7,8,9};
			return arrayWin;
		} else if (number==4) {
			int arrayWin[]= {1,4,7};
			return arrayWin;
		} else if (number==5) {
			int arrayWin[]= {2,5,8};
			return arrayWin;
		} else if (number==6) {
			int arrayWin[]= {3,6,9};
			return arrayWin;
		} else if (number==7) {
			int arrayWin[]= {1,5,9};
			return arrayWin;
		} else {
			int arrayWin[]= {3,5,7};
			return arrayWin;
		}
	}
	
}