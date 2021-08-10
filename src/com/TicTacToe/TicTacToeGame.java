package com.TicTacToe;

import java.util.Scanner;

/**
 * Program for TicTacToe Game playing with computer 
 * @author Sheetal
 * @since 2021-08-10
 */
public class TicTacToeGame {
	//variables
	static char userMark, computerMark;
	private static char[] element;
	
	public static void main(String[] args) {
		//displaying welcome message
		System.out.println("Welcome to Tic Tac Toe Game");
		//calling method to initialise the board
		createBoard();
		//for user to choose 'X' or 'O' mark
		choosingXorO();
		//for display the board
		currentBoard();
	}
	
	/**
	 * Creating method for empty board
	 * 0th index is ignored
	 */
	private static void createBoard() {
		element = new char[10];
		for (int i = 1; i < 10; i++) {
			element[i] = ' ';
		}
	}
	
	/**
	 * Asking user to choose X or O
	 * @param option
	 * @return userMark, computerMark
	 */
	private static void choosingXorO() {
		Scanner s = new Scanner(System.in);
		System.out.println("Choose 1 for 'X' or Choose 2 for 'O' as your mark");		
		int option = s.nextInt();
		switch (option) {
			case 1: userMark = 'X';
					computerMark = 'O';
					break;
			case 2: userMark = 'O';
					computerMark = 'X';
					break;
			default:
					System.out.println("Your input is invalid");
					choosingXorO();
			}
	}
	
	/**
	 * Displays board layout
	 * Elements are assigned with marks and numbers
	 */
	private static void displayingBoard() {
		System.out.println("\n  "+element[1]+" | "+element[2]+" | "+element[3]+" ");
		System.out.println(" ----------- ");
		System.out.println("  "+element[4]+" | "+element[5]+" | "+element[6]+" ");
		System.out.println(" ----------- ");
		System.out.println("  "+element[7]+" | "+element[8]+" | "+element[9]+" \n");
	}
	
	/**
	 * Assigning elements with numbers if it is not marked
	 * @param element[]
	 */
	private static void currentBoard() {
		for (int i=1;i<10;i++) {
			if (element[i] !='X'&&element[i] !='O') {
				element[i]=(char) (i+'0');
			}
		}
	    displayingBoard();
	}
}


