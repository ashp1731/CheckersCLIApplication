package CheckersCLI;

import java.util.*;
import java.io.*;

public class Checkers {

	public static void main(String[] args) {
		
	public static final int SIZE = 8;
<<<<<<< HEAD
    private char[][] board;
    private int redcheckers;
    private int blackcheckers;
    private char currentplayer;
    
	
		
		
		
=======
	private char[][] board;

	public static void main(String[] args) {

>>>>>>> 58a42270f5be15bb52d667669db331eec96bfc0a
		Checkers checkersGame = new Checkers();
		checkersGame.setupByUser();
		checkersGame.displayBoard();
		while (checkersGame.isInProgress()) {
			checkersGame.currentPlayerTakeTurn();
			checkersGame.displayBoard();
		}

		checkersGame.displayEndOfGameMessage();
	}

<<<<<<< HEAD
=======
	// Diamond Mickle
	// Hi girl how r you?
	// Hungry
//cfc
>>>>>>> 58a42270f5be15bb52d667669db331eec96bfc0a

	public void setupByUser() {
		
	}

	public boolean isInProgress() {
		return false;
	}

	public void currentPlayerTakeTurn() {
	}

	public void displayBoard() {
		
	Board board = new Board();
	System.out.println(board.toString());
//		board = new char[SIZE][SIZE];
//		int i, j;
//		for (i = 0; i < SIZE; i++) {
//
//			for (i = 1; i < SIZE; i += 2) {
//				board[i][1] = 'r';
//				board[i][5] = 'b';
//				board[i][7] = 'b';
//			}
//			for (i = 0; i < SIZE; i += 2) {
//				board[i][0] = 'r';
//				board[i][2] = 'r';
//				board[i][6] = 'b';
//			}
//		}

		// Print board
<<<<<<< HEAD
		System.out.println("  1 2 3 4 5 6 7 8 x");
		for (i=0;i<SIZE;i++) {
		    System.out.print((i+1) + " ");
		    for (j=0;j<SIZE;j++) {
			System.out.print(board[j][i] + " ");
		    }
		    System.out.println();
		}
		System.out.println("y");
		
		Scanner stdin = new Scanner(System.in);

		if (currentplayer=='r')
		    System.out.println("Current turn : Red");
		else
		    System.out.println("Current turn : Black");

		
		
		
		
		
		   }
		  }
		
		
		
	}
	
	}
=======
//		System.out.println("  1 2 3 4 5 6 7 8 x");
//		for (i = 0; i < SIZE; i++) {
//			System.out.print((i + 1) + " ");
//			for (j = 0; j < SIZE; j++) {
//				System.out.print(board[j][i] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println("y");

	}

	public void displayEndOfGameMessage() {
	}

}
>>>>>>> 58a42270f5be15bb52d667669db331eec96bfc0a
