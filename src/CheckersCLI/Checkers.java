package CheckersCLI;

import java.io.InputStream;
import java.util.Scanner;
import java.util.*;

public class Checkers {
	private Player currentPlayer;
	private Board gameBoard;
	private Player playerOne;
	private Player playerTwo;
	private boolean isInProgress;
	Scanner Scanner = new Scanner(System.in);
	java.util.Scanner input;
	public Board getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(Board gameBoard) {
		this.gameBoard = gameBoard;
	}

	public Player getPlayerOne() {
		return playerOne;
	}

	public void setInProgress(boolean isInProgress) {
		this.isInProgress = isInProgress;
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

	public Checkers() {

	}

	public Checkers(Board gameBoard, Player playerOne, Player playerTwo) {
		super();
		this.gameBoard = gameBoard;
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}

	public void setupByUser() {
		System.out.println("Enter'Start'to begin the game");
		String input = Scanner.nextLine();
		input.toLowerCase();
		if (input.equals("start")) {
			System.out.println("Please select the opponent'Human' or'Computer'.");
			String opponent = Scanner.nextLine();
			opponent.toLowerCase();
			playerOne = new Human("r");
			currentPlayer=playerOne;
			if (opponent.equals("human")) {
				playerTwo = new Human("b");
				isInProgress = true;
			} else if (opponent.equals("Computer")) {
				playerTwo = new Computer("b");
				isInProgress = true;
			}
		}
		if (isInProgress=true) {
			displayBoard();
		}

	}

	public boolean isInProgress() {

		return isInProgress;

	}

	public void currentPlayerTakeTurn() {
		Move moves=new Move();
		 moves=currentPlayer.makemove(gameBoard);
		if(gameBoard.isMoveLegal(moves, moves)) {
			gameBoard.movePiece(moves);
		}

		if (currentPlayer.getColor() == playerOne.getColor()) {
			currentPlayer = playerTwo;
		} else {
			currentPlayer = playerOne;
		}

	}

	public void displayBoard() {

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
		if (!isInProgress) {
			System.out.println();
		}
	}

	public Move enterMove() {
		Move Move = new Move();
		if (currentPlayer instanceof Human) {
			System.out.println("The current Player is:Human and color 'r'");

		}

		System.out.println("Which place do you want to move?:");

		int xInitial = input.nextInt() - 1;
		int yInitial = input.nextInt() - 1;
		if (currentPlayer.getColor() == "r" && xInitial == 'b') {
			System.out.println("Not Your Turn!");
		}
		String color = gameBoard.getSquares()[xInitial][yInitial].getPiece().getColor();
		if (color == currentPlayer.getColor()) {
			System.out.println("Your Turn");
		} else if (currentPlayer.getColor() != color) {
			System.out.println("Not Your Turn");
		}

		System.out.println("Where do you want to move it to?:");
		int xFinal = input.nextInt() - 1;
		int yFinal = input.nextInt() - 1;

		if (xInitial >= 0 && yInitial >= 0 && xFinal >= 0 && yFinal >= 0)

		{
			Move = new Move(xInitial, yInitial, xFinal, yFinal);
		}
		
		
		//I am confuse from the line
		//pass above created Move object to Board
//	if(Board.isMoveLegal(Move, Move)==true) {
//		Board.movePiece(Move);
//	}
	else {
		System.out.println("Invalid Move!");
		currentPlayer.makemove(gameBoard);
	}
		

		return Move;
	}

	public static void main(String[] args) {

		Checkers checkersGame = new Checkers();

		Board Board = new Board();

		checkersGame.setGameBoard(Board);

		checkersGame.setupByUser();
		while (checkersGame.isInProgress()) {
			checkersGame.currentPlayerTakeTurn();
			checkersGame.displayBoard();
		}
		checkersGame.displayEndOfGameMessage();
	}
}
