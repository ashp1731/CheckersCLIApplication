package CheckersCLI;

//import java.io.InputStream;

import java.util.*;

public class Checkers {
	private Player currentPlayer;
	private Board gameBoard;
	private Player playerOne;
	private Player playerTwo;
	private boolean isInProgress;
	Scanner scanner = new Scanner(System.in);

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
		System.out.println("Enter 'Start' to begin the game");
		String input = scanner.nextLine();
		input = input.toLowerCase();
		if (input.equals("start")) {
			System.out.println("Please select the opponent'Human' or'Computer'.");
			
			boolean opponentSelected = false;
			while(!opponentSelected) {
				String opponent = scanner.nextLine();
				opponent = opponent.toLowerCase();
				
				playerOne = new Human("r", scanner);
				currentPlayer = playerOne;
				
				if (opponent.equals("human")) {
					playerTwo = new Human("b", scanner);
					opponentSelected = true;
					isInProgress = true;
				} else if (opponent.equals("Computer")) {
					playerTwo = new Computer("b");
					opponentSelected = true;
					isInProgress = true;
				} else {
					System.out.println("Please select the opponent'Human' or'Computer'.");
					//opponent = scanner.nextLine();
					isInProgress = true;
				}
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
		 boolean isMovevalid=false; 
		 do {
			 moves=currentPlayer.makemove(gameBoard);
			if (gameBoard.isMoveLegal(moves,currentPlayer.getColor())){
				gameBoard.movePiece(moves);
				
				boolean jumpContinue = false;
				if (moves.isJumpMove()) {
					Move moveJump = createNextMoveForSamePiece(moves);
					
					do {
						if(jumpContinue) {
							moveJump = createNextMoveForSamePiece(moveJump);
						}
						
						Move calcMoveJump = gameBoard.calculateNextJump(currentPlayer.getColor(), moveJump);
						if (calcMoveJump == null) {
							jumpContinue = false;
						} else {
							jumpContinue = true;
							System.out.println("Jumping: " + calcMoveJump);
							gameBoard.movePiece(calcMoveJump);
						}
					} while (jumpContinue);
				}
				
				isMovevalid=false;
			} 
			else {
				System.out.println("This move is invalid - ");
				  isMovevalid=true;
			 }
		 }while(isMovevalid);
		 
	

		switchPlayer();


	}

	private void switchPlayer() {
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
		for (int i = 0; i < Board.SIZE; i++) {
			System.out.print("\t" + (i + 1) + "\t");
			for (int j = 0; j < Board.SIZE; j++) {

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

	private Move createNextMoveForSamePiece(Move move) {
		Move moveJump = new Move();
		
		//Start of jumpMove is the end of original move.
		moveJump.setInitialXCoor(move.getEndingXCoor());
		moveJump.setInitialYCoor(move.getEndingYCoor());
		return moveJump;
	}
	
	public static void main(String[] args) {

		Checkers checkersGame = new Checkers();
		checkersGame.setGameBoard(new Board());

		checkersGame.setupByUser();
		while (checkersGame.isInProgress()) {
			checkersGame.currentPlayerTakeTurn();
			checkersGame.displayBoard();
		}
		checkersGame.displayEndOfGameMessage();
	}
}
