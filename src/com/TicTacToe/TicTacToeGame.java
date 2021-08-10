package com.TicTacToe;

/**
 * Program for TicTacToe Game playing with computer 
 * @author Sheetal
 * @since 2021-08-10
 */
public class TicTacToeGame {
	
	public static void main(String[] args) {
		//displaying welcome message
		System.out.println("Welcome to Tic Tac Toe Game");
		//calling method to initialise the board
		boardLayout();
	}
	
	/**
	 * Creating method for empty board
	 * 0th index is ignored
	 */
	private static void boardLayout() {
		char[] empty_board = new char[10];
		for (int i = 1; i < 10; i++) {
			empty_board[i] = ' ';
		}
	}
}

