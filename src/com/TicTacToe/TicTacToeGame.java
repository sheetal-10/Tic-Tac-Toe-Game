package com.TicTacToe;

import java.util.Scanner;

/**
 * Program for TicTacToe Game playing with computer 
 * @author Sheetal
 * @since 2021-08-10
 */
public class TicTacToeGame {
	
	static char[] board = new char[10];
	static char userMark, computerMark;
	
	public static void main(String[] args) {
		//displaying welcome message
		System.out.println("Welcome to Tic Tac Toe Game");
		//calling method to initialise the board
		createBoard();
		//for user to choose 'X' or 'O' mark
		choosingXorO();
	}
	
	/**
	 * Creating method for empty board
	 * 0th index is ignored
	 */
	private static void createBoard() {
		for (int i = 1; i < 10; i++) {
			board[i] = ' ';
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
}


