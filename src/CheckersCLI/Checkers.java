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
		if(gameBoard.isMoveLegal(move)) {
			gameBoard.movePiece(move);
		}
		
		if(currentPlayer==playerOne) {
			currentPlayer=playerOne;
		}
		else {
			currentPlayer=playerTwo;
		}
		
	}

	public Move enterMove() {
		if (currentPlayer instanceof Human) {
			currentPlayer.makemove(gameBoard);
		}
		else {
			if(currentPlayer==playerOne) {
				System.out.println("The current Player is:PlayerOne with color 'r'");
			}
			else {
				System.out.println("The current Player is:PlayerTwo with color 'b");
			}
		}
		System.out.println("Which place do you want to move?:");
		java.util.Scanner input;
		int xInitial=input.nextInt()-1;
		int yInitial=input.nextInt()-1;
		String color=gameBoard.getSquares()[xInitial][yInitial].getPiece().getColor();
		
		return move;
	}
	public void displayBoard() {
		// Print board

				System.out.println("\n		1	2	3	4	5	6	7	8	x");
				System.out.println("=================================================================================");
				System.out.println();
				for (int i = 0; i < gameBoard.SIZE; i++) {
					System.out.print("\t" + (i + 1) + "\t");
					for (int j = 0; j < gameBoard.SIZE; j++) {

						if (gameBoard.getSquares()[i][j].getPiece().getColor() == null) {
							System.out.print("*" + "\t");
						} else {
							System.out.print(gameBoard.getSquares()[i][j].getPiece().getColor() + "\t");
						}
					}
					System.out.println();
					System.out.println();
				}
				System.out.println("=================================================================================");
				System.out.println("\ty\n");
	}

	

	public void displayEndOfGameMessage() {
	}

}