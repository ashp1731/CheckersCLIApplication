package CheckersCLI;

import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.io.InputStream;
import java.util.*;

public class Checkers {
	Board gameBoard;
	Player playerOne;
	Player playerTwo;
	Button newGameButton;
	Button closeButton;
	Label message;

	public void setupByUser(ActionEvent evt) {
		// response the user to click oe of these two button
		Object src = evt.getSource();
		if (src == newGameButton)
			doNewGame();
		else if (src == closeButton)
			doclose();
	}

	// starting to new game.
	void doNewGame() {
		if (isInProgress() == true) {
			message.setText("Finish the current game first!!");
			return;

		}
		// MORE CONDITION ARE HERE TO WRITE
	}

	void doclose() {
		if (isInProgress() == false) {
			message.setText("Lets Start the game!!");
			// choose player1 or player2
			message.setText("Player1");
			System.out.println("choose");
			message.setText("Player2");
			return;
		}
		// MORE CONDITION ARE HERE TO WRITE
	}

	public boolean isInProgress() {
		if (r != 0 || b != 0) {
			System.out.println("there is no winner");
			return true;
		} else {

			return false;
		}
	}

	public void currentPlayerTakeTurn() {

	}

	public void displayBoard() {

	}

	public void displayEndOfGameMessage() {
	}

	public static void main(String[] args) {
		Label message = new Label("", Label.CENTER);
		Button newGameButton = new Button("New Game");

		Button closeButton = new Button("Close");
		Checkers checkersGame = new Checkers();
		checkersGame.setupByUser(null);

		while (checkersGame.isInProgress()) {
			checkersGame.currentPlayerTakeTurn();
			checkersGame.displayBoard();
		}
		checkersGame.displayEndOfGameMessage();
	}

}
