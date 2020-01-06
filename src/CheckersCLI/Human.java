package CheckersCLI;

import java.util.InputMismatchException;
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
	
	public String getMakemove() {
		return "move";
	}
	public Boolean isMovingLegal() {
		return(true);
}
	 public Move makeMove(Board board) {
		 Move move = new Move();
			if (this.getColor() == "r") {
				System.out.println("Current Player : " + "Player One 'r'");
			} else {
				System.out.println("Current Player : " + "Player Two 'b'");
			}

			System.out.println();
			
			try {
				System.out.println("Which place do you want to move ? : ");

				int xInitial = input.nextInt() - 1;
				int yInitial = input.nextInt() - 1;

				String color = board.getSquares()[xInitial][yInitial].getPiece().getColor();
				if (!this.getColor() .equalsIgnoreCase(color) ) {
					System.out.println("Not your turn!");
					System.out.println("Which place do you want to move ? : ");
					xInitial = input.nextInt() - 1;
					yInitial = input.nextInt() - 1;
				}

				System.out.println("Where do you want to move it to ? : ");
				int xFinal = input.nextInt() - 1;
				int yFinal = input.nextInt() - 1;

				// Create Move Object
				if (xInitial >= 0 && yInitial >= 0 && xFinal >= 0 && yFinal >= 0) {
					move = new Move(xInitial, yInitial, xFinal, yFinal);
				} else {
					System.out.println("Invalid move!");
				}
				return move;
			}catch (InputMismatchException ex) {
				System.out.println("Invalid input. Reenter number");
				return null;
			}
			

	 }
}


