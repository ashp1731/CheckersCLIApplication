package CheckersCLI;

public class Checkers {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
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
	public void displayBoard() {}
	public void displayEndOfGameMessage() {}

}
