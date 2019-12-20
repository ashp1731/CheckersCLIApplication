package CheckersCLI;

import java.util.Scanner;

public class Checkers {
	//2b.adding one more private currentPlayer
	private Player currentPlayer;
	private Board gameBoard;
	private Player playerOne;
	private Player playerTwo;
	private boolean isInProgress;
	
	public Board getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	public Player getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public Player getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}
	
	
	//1a.main method
	public static void main(String[] args) {
//1b.CheckersObject
		Checkers checkersGame = new Checkers();
		
		//1c.Board Object
		Board board=new Board();
		//1d. set Checkers.board to the board object created 
		checkersGame.setGameBoard(board);
		//1e.Checkers.setUpByUser()method
		checkersGame.setupByUser();
		while (checkersGame.isInProgress()) {
			checkersGame.currentPlayerTakeTurn();
			checkersGame.displayBoard();
		}
		checkersGame.displayEndOfGameMessage();
	}
	//2.a Creating Scanner object
 Scanner  Scanner =new Scanner(System.in);
	public void setupByUser() {
		System.out.println("Enter'Start'to begin the game");
		 String input=Scanner.nextLine();
		 input.toLowerCase();
		 if (input.equals("start")){
			 System.out.println("Please select the opponent'Human' or'Computer'."); 
			 String opponent=Scanner.nextLine();
			 opponent.toLowerCase();
			 playerOne=new Human("r");
			 if(opponent.equals("human")) {
				 playerTwo=new Human("b");
				 isInProgress=true;
			 }
			 else if(opponent.equals("Computer")) {
				 playerTwo=new Computer("b");
				 isInProgress=true;
			 }
		 }
		 if (isInProgress) {
			 displayBoard();
		 }
		 
		
	}

	public boolean isInProgress() {

		return isInProgress;

	}

	public void currentPlayerTakeTurn() {
		Move move=new Move();
	}

	public void displayBoard() {
	}

	

	public void displayEndOfGameMessage() {
	}

}
