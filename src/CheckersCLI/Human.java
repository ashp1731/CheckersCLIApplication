package CheckersCLI;

import java.util.Scanner;

public class Human extends Player {

	Scanner input = null;

	public Human() {
		super();
		input = new Scanner(System.in);
	}

	public Human(String color) {
		super(color);
		input = new Scanner(System.in);
	}

	public Human(String color, Scanner input) {
		super(color);
		this.input = input;

	}

	public Boolean isMovingLegal() {
		return (true);
	}

	public Move makeMove(Board board) {
		Move move = null;
		if (this.getColor() == "r") {
			System.out.println("Current Player : " + "Player One 'r'");
		} else {
			System.out.println("Current Player : " + "Player Two 'b'");
		}

		System.out.println();

		boolean inputWasNotValid = false;
		do {
			System.out.println("Which place do you want to move ? : ");

			int xInitial = readNextInt() - 1;
			int yInitial = readNextInt() - 1;

			String color = board.getSquares()[xInitial][yInitial].getPiece().getColor();
			if (!this.getColor().equalsIgnoreCase(color)) {
				System.out.println("Not your turn!");
				System.out.println("Which place do you want to move ? : ");
				inputWasNotValid = true;
			} else {

				System.out.println("Where do you want to move it to ? : ");
				int xFinal = readNextInt() - 1;
				int yFinal = readNextInt() - 1;
	
				// Create Move Object
				if (xInitial >= 0 && yInitial >= 0 && xFinal >= 0 && yFinal >= 0) {
					move = new Move(xInitial, yInitial, xFinal, yFinal);
					inputWasNotValid = false;
				} else {
					System.out.println("Invalid move!");
					inputWasNotValid = true;
				}
			}
		} while (inputWasNotValid);
		return move;
	}
	
	private int readNextInt () {
		int readInput = -1;
		boolean inputWasNotValid = false;
		do {
			if (input.hasNextInt()) {
				readInput = input.nextInt();
				inputWasNotValid = false;
			} else {
				inputWasNotValid = true;
				input.next();
				System.out.println("Invalid input. Reenter number");
			}
		} while (inputWasNotValid);
		return readInput;
	}
}
