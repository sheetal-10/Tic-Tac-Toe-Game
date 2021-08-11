package com.TicTacToe;

import java.util.Scanner;

/**
 * Program for TicTacToe Game playing with computer 
 * @author Sheetal
 * @since 2021-08-10
 */
public class TicTacToeGame {
	//variables
		private static char[] element;
		static char userMark, computerMark;
		static int userNumber, computerNumber;
		static int turn = 1, flag = 0;
		
		public static void main(String[] args) {
			System.out.println("Welcome to TicTacToe Game");
			//for creating empty elements
			createBoard();
			//to display the game layout
			displayingBoard();
			//for user to choose 'X' or 'O' mark
			choosingXorO();
			// For making toss to check who plays first
			tossCoin();
			// to to play the game until some one wins i.e. flag=1
			outerloop:
			while(flag==0) {
				if((turn+1)%2==0) {
					//for display the current board
					currentBoard();
					//for calling the user for number
					userCall();
					//for making the mark on user number
					userMove();
					//After user making move showing the board
					currentBoard();
					//to check whether user is winner or not
					flag=checkWin();
					if (flag==1) {
						System.out.println("Excellent! You are the winner");
						break outerloop;
					}
					//to check whether game is tie or not
					flag=checkTie();
					if (flag==1) {
						System.out.println("Nice Play! It's Tie");;
						break outerloop;
					}
					turn++;
				} else {
					//To check whether computer is winning or not
					flag=computerWin();
					if (flag==1) break outerloop;
					flag=computerBlock();
					if (flag==1) {
						turn++;
						flag=0;
						return;
					}
				}
			}
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
			System.out.println("Choose 1 for 'X' or Choose 2 for 'O' as your mark");
			int option = Utility.getUserInteger();
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
			System.out.println("\nUser Mark: '"+userMark+"' and Computer Mark: '"+computerMark+"'");
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
		
		/**
		 * Asking user for a number and checks whether the number is with in the board
		 * @param userNumber
		 */
		private static void userCall() {
		    System.out.println("\nEnter a number from board to make the mark:\n");
		    userNumber = Utility.getUserInteger();
		    if (userNumber < 1 || userNumber > 9) {
		    	currentBoard();
		    	System.out.println("Your input is Invalid");
		    	userCall();
		    }
		}
		
		/**
		 * Checking whether the user number is free or not 
		 * If user number is available, making the move
		 */
		private static void userMove() {
			if(element[userNumber]=='X' || element[userNumber]=='O') {
				currentBoard();
				System.out.println("Number which is selected is not free");
				userCall();
				userMove();
			} else {
				element[userNumber]=userMark;
			}
		}
		
		/**
		 * Determining who's is starting, user or computer by tossing a coin
		 * @param Head and Tail
		 */
		private static void tossCoin() {   
		    System.out.println("\nMaking a toss to check who plays first\nChoose 1 for Head or 2 for Tail");
		    int option = Utility.getUserInteger();;
		    if ( option==1 || option==2 ) {
		    	int flip = Utility.getRandomInt(2)+1;
		    	if (flip==1) {
		    		System.out.println("\nBy tossing Coin it shows HEAD\n");
		    	} else {
		    		System.out.println("\nBy tossing Coin it shows TAIL\n");
		    	}
		    	if (flip == option) {
		    		System.out.println("User will start the game\n");
		    	} else {
		    		System.out.println("Computer will start the game\n");
		    		computerFirstTurn();
		    	}
		    } else {
		    	System.out.println("\nInvalid input Again");
		    	tossCoin();
		    }
		}
		
		/**
		 * Making Computer First Turn as random from 1 to 9 and makes the mark
		 * @param compuerNumber
		 */
		private static void computerFirstTurn() {
			computerNumber = Utility.getRandomInt(9)+1;
			element[computerNumber]=computerMark;
			System.out.println("Computer choses '"+computerNumber+"' now user turn");
		}
		
		/**
		 * Checking either user is winning or not
		 * Calling winArray method for winning choices
		 * @param win[]
		 */
		private static int checkWin() {
		    for (int i=1;i<9;i++) {
		    	int win[]= Utility.winArray(i);
		    	if (element[win[0]]==element[win[1]]&&element[win[1]]==element[win[2]]) {
		    		flag=1;
		    	}
		    }
		    return flag; 
		}
		
		/**
		 * Checking either game is tie or not
		 */
		private static int checkTie() {
			for (int i=1; i<10; i++) {
				if (element[i]=='X' || element[i]=='O') {
					if (i==9) {
						flag=1;
					}
				}
			}
			return flag;
		}
		

		/**
		 * checks for in winning pattern any of 2 cells are same and other is empty 
		 * @param playerMark, opponentMark
		 * @return flag
		 */
		private static int winBlock(char playerMark, char opponentMark) {
			int winBlock[] = new int[3];
			for (int i=1;i<9;i++) {
		    	winBlock=Utility.winArray(i);
		    }
		    if (element[winBlock[0]]==element[winBlock[1]]&&element[winBlock[0]]==playerMark&&element[winBlock[2]]!=opponentMark) {
		    	flag=winBlock[2];
		    } else if (element[winBlock[0]]==element[winBlock[2]]&&element[winBlock[2]]==playerMark&&element[winBlock[1]]!=opponentMark) {
		       flag=winBlock[1];
		    } else if (element[winBlock[1]]==element[winBlock[2]]&&element[winBlock[2]]==playerMark&&element[winBlock[0]]!=opponentMark) {
		       flag=winBlock[0];
		    }
		    return flag;
		}
		
		/**
		 * Checking for computer win
		 * @return flag
		 */
		private static int computerWin() {
			int index=winBlock(computerMark,userMark);
			if (index!=0) {
				element[index]=computerMark;
				System.out.println("My choice is '"+index+"'");
				currentBoard();
				System.out.println("Computer won. Better Luck next time");
				flag=1;
			}
			return flag;
		}
		
		/**
		 * making User block from winning
		 * @return flag
		 */
		private static int computerBlock() {
			int index=winBlock(userMark,computerMark);
			if (index!=0) {
				element[index]=computerMark;
				System.out.println("Computer goes for '"+index+"' to block User");
				flag=1;
			}
			return flag;
		}
}


