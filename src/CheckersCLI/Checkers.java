package CheckersCLI;

//import java.io.InputStream;

import java.util.*;

public class Checkers {
	private Player currentPlayer;
	private Board gameBoard;
	private Player playerOne;
	private Player playerTwo;
	private boolean isInProgress = false;
	private String winner;
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

		try {
			System.out.println("Enter 'Start' to begin the game");
			String input = scanner.nextLine();
			input = input.toLowerCase();
//			do {
			if (input.equals("start")) {
				System.out.println("Please select the opponent'Human' or'Computer'.");

				boolean opponentSelected = false;
				while (!opponentSelected) {
					String opponent = scanner.nextLine();
					opponent = opponent.toLowerCase();

					playerOne = new Human("r", scanner);
					currentPlayer = playerOne;

					if (opponent.equals("human")) {
						playerTwo = new Human("b", scanner);
						opponentSelected = true;
						isInProgress = true;
					} else if (opponent.equals("computer")) {
						playerTwo = new Computer("b");
						opponentSelected = true;
						isInProgress = true;
					} else {
						System.out.println("Please select the opponent'Human' or'Computer'.");
					}
				}
			} else {
				System.out.println("Invalid Input");
				System.out.println("Enter 'Start' to begin the game");
				input = scanner.nextLine();
			}
//			} while(isInProgress = false);

			if (isInProgress) {
				displayBoard();
			}
		} catch (InputMismatchException ex) {
			System.out.println("Invalid Input");
			System.out.println("Enter 'Start' to begin the game");
			String input = scanner.nextLine();
		}
	}

	public boolean isInProgress() {

		return isInProgress;

	}

	public void currentPlayerTakeTurn() {

		Move moves = new Move();
		boolean isMovevalid = false;
		do {
			if(!gameBoard.playerForfiet(currentPlayer.getColor())) {
				
				moves = currentPlayer.makeMove(gameBoard);
				if(moves != null) {
					if (gameBoard.isMoveLegal(moves, currentPlayer.getColor())) {
						gameBoard.movePiece(moves);

						Move printMove = new Move();
						printMove.setInitialXCoor(moves.getInitialXCoor() + 1);
						printMove.setInitialYCoor(moves.getInitialYCoor() + 1);

						boolean jumpContinue = false;
						if (moves.isJumpMove()) {
							Move moveJump = createNextMoveForSamePiece(moves);

							do {
								if (jumpContinue) {
									moveJump = createNextMoveForSamePiece(moveJump);
								}

								Move calcMoveJump = gameBoard.calculateNextJump(currentPlayer.getColor(), moveJump);
								if (calcMoveJump == null) {
									jumpContinue = false;
								} else {
									jumpContinue = true;
									gameBoard.movePiece(calcMoveJump);
									moveJump = calcMoveJump;
								}
							} while (jumpContinue);

							if (moveJump.getEndingXCoor() == 0) {
								printMove.setEndingXCoor(moves.getEndingXCoor() + 1);
								printMove.setEndingYCoor(moves.getEndingYCoor() + 1);
							} else {
								printMove.setEndingXCoor(moveJump.getEndingXCoor() + 1);
								printMove.setEndingYCoor(moveJump.getEndingYCoor() + 1);
							}
						} else {
							printMove.setEndingXCoor(moves.getEndingXCoor() + 1);
							printMove.setEndingYCoor(moves.getEndingYCoor() + 1);
						}

						isMovevalid = false;
						printMove(printMove);
					} else {
						System.out.println("This move is invalid - ");

						  isMovevalid=true;
					}	
				}
			
			}
			else {
				switchPlayer();
				if(gameBoard.playerForfiet(currentPlayer.getColor())) {
				// Draw	
					isInProgress = false;
					
				}
				else {
					// Winner
					isInProgress = false;
					winner = currentPlayer.getColor();
				}
				
			}


		 }while(isMovevalid);	
		 
		 String checkWinner;
		 if (currentPlayer.getColor() == playerOne.getColor()) {
				checkWinner = playerTwo.getColor();
			} else {
				checkWinner = playerOne.getColor();
			}
		 	 
		 if(gameBoard.getWinner(checkWinner)){
			 isInProgress = false;
		 	 winner = currentPlayer.getColor();
		 }
		 else {
			 switchPlayer();
		 }	
	}

	private void printMove(Move move) {
		if (currentPlayer instanceof Computer) {
			System.out.println(
					"Last Move was : Initial Cordinates : " + move.getInitialXCoor() + " " + move.getInitialYCoor()
							+ " Final Coordinates : " + move.getEndingXCoor() + " " + move.getEndingYCoor());
		}
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
		String playerWin;
		if (!isInProgress) {
			
			if(winner.equalsIgnoreCase("r")) {
				// Player 1 is Winner
				System.out.println("Congratulations!! Player One is winner!!!");
			}
			else if(winner.equalsIgnoreCase("b")) {
				// Player 2 is Winner
				System.out.println("Congratulations!! Player Two is winner!!!");
			}
			else {
				// Draw
				System.out.println("It's a Draw!! Well played.");
			}				
		}
	}

	private Move createNextMoveForSamePiece(Move move) {
		Move moveJump = new Move();

		// Start of jumpMove is the end of original move.
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
