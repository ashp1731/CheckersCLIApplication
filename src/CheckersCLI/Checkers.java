package CheckersCLI;

import java.io.InputStream;
import java.util.*;

public class Checkers {

	public static final int SIZE = 8;
    private char[][] board;
    private char whosemovenow;
    
	public static void main(String[] args) {
		
		Checkers checkersGame = new Checkers();
		checkersGame.setupByUser();
		
		while(checkersGame.isInProgress()) {
			
			checkersGame.currentPlayerTakeTurn();
			checkersGame.displayBoard();
		}
		
		checkersGame.displayEndOfGameMessage();
	}

	public void setupByUser() {
	}
	
	public  boolean isInProgress() {
		if(whosemovenow=='r') {
			System.out.println("There is no winner");
			return true;
		}
			else {
				return false;
			}	
		}
		
	
	public void currentPlayerTakeTurn() {}

	private Scanner Scanner(InputStream in) {
		// TODO Auto-generated method stub
		return null;
	}

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
