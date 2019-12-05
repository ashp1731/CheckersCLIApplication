package CheckersCLI;

import java.util.*;

public class Checkers {

	public static final int SIZE = 8;
    private char[][] board;
    
	public static void main(String[] args) {
		
		Checkers checkersGame = new Checkers();
		checkersGame.setupByUser();
		
		while(checkersGame.isInProgress()) {
			checkersGame.currentPlayerTakeTurn();
			checkersGame.displayBoard();
		}
		
		checkersGame.displayEndOfGameMessage();
	}

		// Diamond Mickle
		//Hi girl how r you?
		// Hungry


	public void setupByUser() {}
	public boolean isInProgress() {
		return false;
	}
	public void currentPlayerTakeTurn() {}
	
	public void displayBoard() {
		board = new char[SIZE][SIZE];
		int i,j;
		for(i = 0; i <SIZE; i++) {
			
			for (i=1;i<SIZE;i+=2) {
			    board[i][1] = 'r';
			    board[i][5] = 'b';
			    board[i][7] = 'b';
			}
			for (i=0;i<SIZE;i+=2) {
			    board[i][0] = 'r';
			    board[i][2] = 'r';
			    board[i][6] = 'b';
			}
		}
		
		// Print board
		System.out.println("  1 2 3 4 5 6 7 8 x");
		for (i=0;i<SIZE;i++) {
		    System.out.print((i+1) + " ");
		    for (j=0;j<SIZE;j++) {
			System.out.print(board[j][i] + " ");
		    }
		    System.out.println();
		}
		System.out.println("y");
		
		
		
	}
	public void displayEndOfGameMessage() {}

}
