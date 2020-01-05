package CheckersCLI;

import java.util.ArrayList;
import java.util.Arrays;


public class Board {

	public static final int SIZE = 8;

	private Square[][] squares;
	char[][] board;

	public Square[][] getSquares() {
		return squares;
	}

	public void setSquares(Square[][] squares) {
		this.squares = squares;
	}

	// move peice
	// square array
	// create emplty method with moviec

	// Checks if a move is valid.
	public boolean isMoveLegal(Move move,String color) {
		
//		int xfrom = movefrom.getInitialXCoor();
//		int yfrom = movefrom.getInitialYCoor();
//		int xto = moveto.getEndingXCoor();
//		int yto = moveto.getEndingYCoor();
//		String whosemove = squares[xfrom][yfrom].getPiece().getColor(); // changed to type String by Ashwini
//		
//		// Gets array indeces corresponding to the move, from parameters.
//		
//		// Check if indeces in range, if not, return false.
//		if (xfrom < 0 || xfrom > 8 || yfrom < 0 || yfrom > 8 || xto < 0 || xto > 8 || yto < 0 || yto > 8)
//			return false;
//
//		// Check to see you are moving your piece to a blank square.
//		else if ( squares[xto][yto].getPiece() != null ) {
//
//			// Checks case of simple move
//			if (Math.abs(xfrom - xto) == 1) {
//				if ((whosemove == "r") && (yto - yfrom == 1))
//					return true;
//				else if ((whosemove == "b") && (yto - yfrom == -1))
//					return true;
//			}
//
//			// Checks case of a jump
//			else if (Math.abs(xfrom - xto) == 2) {
//				if (whosemove == "r" && (yto - yfrom == 2) && board[(xfrom + xto) / 2][(yfrom + yto) / 2] == 'b')
//					return true;
//				else if (whosemove == "b" && (yto - yfrom == -2) && board[(xfrom + xto) / 2][(yfrom + yto) / 2] == 'r')
//					return true;
//			}
//		}
//		// If move is neither a simple one or a jump, it is not legal.
//		return false;
		ValidMoves ValidMoves= getLegalMoves(color);
		return ValidMoves.getValidJumps().contains(move)||(ValidMoves.getValidJumps().size()==0 &&ValidMoves.getValidMoves().contains(move));
	}

	public Board() {
//		
//		// Code to initialize the Board

	squares = new Square[8][8];

	for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {
			squares[i][j] = new Square();
			squares[i][j].setPiece(new Piece());
		}
	}

		squares[0][1].setPiece(new Piece("r", "pawn"));
		squares[0][3].setPiece(new Piece("r", "pawn"));
		squares[0][5].setPiece(new Piece("r", "pawn"));
		squares[0][7].setPiece(new Piece("r", "pawn"));
		squares[1][0].setPiece(new Piece("r", "pawn"));
		squares[1][2].setPiece(new Piece("r", "pawn"));
		squares[1][4].setPiece(new Piece("r", "pawn"));
		squares[1][6].setPiece(new Piece("r", "pawn"));
		squares[2][1].setPiece(new Piece("r", "pawn"));
		squares[2][3].setPiece(new Piece("r", "pawn"));
		squares[2][5].setPiece(new Piece("r", "pawn"));
		squares[2][7].setPiece(new Piece("r", "pawn"));

		squares[5][0].setPiece(new Piece("b", "pawn"));
		squares[5][2].setPiece(new Piece("b", "pawn"));
		squares[5][4].setPiece(new Piece("b", "pawn"));
		squares[5][6].setPiece(new Piece("b", "pawn"));
		squares[6][1].setPiece(new Piece("b", "pawn"));
		squares[6][3].setPiece(new Piece("b", "pawn"));
		squares[6][5].setPiece(new Piece("b", "pawn"));
		squares[6][7].setPiece(new Piece("b", "pawn"));
		squares[7][0].setPiece(new Piece("b", "pawn"));
		squares[7][2].setPiece(new Piece("b", "pawn"));
		squares[7][4].setPiece(new Piece("b", "pawn"));
		squares[7][6].setPiece(new Piece("b", "pawn"));
	}
	

	public Board(Square[] square) {
		super();
		this.squares = squares;
	}

 
	public void movePiece(Move move) {
		// Move Piece Logic
		Piece pieceEmpty = new Piece();
		Piece pieceKing = new Piece("", "king");

		Piece initialPiece = new Piece();
		initialPiece = squares[move.getInitialXCoor()][move.getInitialYCoor()].getPiece();
		squares[move.getInitialXCoor()][move.getInitialYCoor()].setPiece(pieceEmpty);
		squares[move.getEndingXCoor()][move.getEndingYCoor()].setPiece(initialPiece);

		Piece kingPiece;
		if (squares[move.getInitialXCoor()][move.getInitialYCoor()].getPiece().getColor() == "r"
				&& move.getEndingYCoor() == 7) {

			kingPiece = squares[move.getInitialXCoor()][move.getInitialYCoor()].getPiece();
			kingPiece.setRank("king");
			kingPiece.setColor("R");
			squares[move.getEndingXCoor()][move.getEndingYCoor()].setPiece(kingPiece);

		} else if (squares[move.getInitialXCoor()][move.getInitialYCoor()].getPiece().getColor() == "b"
				&& move.getEndingYCoor() == 0) {

			kingPiece = squares[move.getInitialXCoor()][move.getInitialYCoor()].getPiece();
			kingPiece.setRank("king");
			kingPiece.setColor("B");
			squares[move.getEndingXCoor()][move.getEndingYCoor()].setPiece(kingPiece);

		}

		// Jump Logic
		if (canJump(squares[move.getInitialXCoor()][move.getInitialYCoor()].getPiece().getColor(), move.getInitialXCoor(),
				move.getInitialYCoor(), move.getInitialXCoor() + 1, move.getInitialYCoor() + 1,
				move.getInitialXCoor() + 2, move.getInitialYCoor() + 2))
			squares[move.getInitialXCoor() + 1][move.getInitialYCoor() + 1].setPiece(pieceEmpty);

		if (canJump(squares[move.getInitialXCoor()][move.getInitialYCoor()].getPiece().getColor(), move.getInitialXCoor(),
				move.getInitialYCoor(), move.getInitialXCoor() - 1, move.getInitialYCoor() - 1,
				move.getInitialXCoor() - 2, move.getInitialYCoor() - 2))
			squares[move.getInitialXCoor() - 1][move.getInitialYCoor() - 1].setPiece(pieceEmpty);

		if (canJump(squares[move.getInitialXCoor()][move.getInitialYCoor()].getPiece().getColor(), move.getInitialXCoor(),
				move.getInitialYCoor(), move.getInitialXCoor() - 1, move.getInitialYCoor() + 1,
				move.getInitialXCoor() - 2, move.getInitialYCoor() + 2))
			squares[move.getInitialXCoor() - 1][move.getInitialYCoor() + 1].setPiece(pieceEmpty);

		if (canJump(squares[move.getInitialXCoor()][move.getInitialYCoor()].getPiece().getColor(), move.getInitialXCoor(),
				move.getInitialYCoor(), move.getInitialXCoor() + 1, move.getInitialYCoor() - 1,
				move.getInitialXCoor() + 2, move.getInitialYCoor() - 2))
			squares[move.getInitialXCoor() + 1][move.getInitialYCoor() - 1].setPiece(pieceEmpty);
		
		squares[move.getInitialXCoor()][move.getInitialYCoor()].setPiece(pieceEmpty);
		squares[move.getEndingXCoor()][move.getEndingYCoor()].setPiece(initialPiece);

	}

	public boolean canJump(String color, int r1, int c1, int r2, int c2, int r3, int c3) {
		// check whether the player can legally jump from (r1,c1) to (r3,c3). It is
		// assumed
		// that the player has a piece at (r1,c1), that (r3,c3) is a position
		// that is 2 rows and 2 columns distant from (r1,c1) and that
		// (r2,c2) is the square between (r1,c1) and (r3,c3).

		if (r3 < 0 || r3 >= 8 || c3 < 0 || c3 >= 8)
			return false; // (r3,c3) is off the board.

		if (squares[r3][c3].getPiece().getColor() != null) {
			return false; // (r3,c3) already contains a piece.
		}

		if (color == "r") {
			if (squares[r1][c1].getPiece().getColor() == "r" && r3 < r1)
				return false; // Regular red piece can only move up.
			if (squares[r2][c2].getPiece().getColor() != "b" && squares[r2][c2].getPiece().getColor() != "B")
				return false; // There is no black piece to jump.
			return true; // jump is legal
		} else {
			if (squares[r1][c1].getPiece().getColor() == "b" && r3 > r1)
				return false; // Regular black piece can only move up.
			if (squares[r2][c2].getPiece().getColor() != "r" && squares[r2][c2].getPiece().getColor() != "R")
				return false; // There is no black piece to jump.
			return true; // jump is legal
		}
	} // end canJump()

//
	private boolean canMove(String color, int r1, int c1, int r2, int c2) {
		// determine whether the player can legally move from (r1,c1) to (r2,c2). It is
		// assumed that (r1,r2) contains one of the player's pieces and
		// that (r2,c2) is a neighboring square.

		if (r2 < 0 || r2 >= 8 || c2 < 0 || c2 >= 8)
			return false; // (r2,c2) is off the board.

		if (squares[r2][c2].getPiece().getColor() != null)
			return false; // (r2,c2) already contains a piece.
		
		if (color == "R" || color == "B")
			return true; 

		if (color == "r") {
			if (squares[r1][c1].getPiece().getColor() == "r" && r2 < r1)
				return false; // Regular red piece can only move down.
			return true; // The move is legal.
		} else {
			if (squares[r1][c1].getPiece().getColor() == "b" && r2 > r1)
				return false; // Regular black piece can only move up.
			return true; // The move is legal.
			
			
			
			
			
		}
	} // end canMove()
	
	public ValidMoves getLegalMoves(String color) {
		// Return an array containing all the legal CheckersMoves
		// for the specfied player on the current board. If the player
		// has no legal moves, null is returned.
		ArrayList<Move> moves = new ArrayList<>();
		ValidMoves validMoves = new ValidMoves();
		// Check possible jumps

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (squares[row][col].getPiece().getColor() == color 
						|| squares[row][col].getPiece().getColor() == color.toUpperCase()) {
					if (canJump(color, row, col, row + 1, col + 1, row + 2, col + 2))
						moves.add(new Move(row, col, row + 2, col + 2));
					if (canJump(color, row, col, row - 1, col + 1, row - 2, col + 2))
						moves.add(new Move(row, col, row - 2, col + 2));
					if (canJump(color, row, col, row + 1, col - 1, row + 2, col - 2))
						moves.add(new Move(row, col, row + 2, col - 2));
					if (canJump(color, row, col, row - 1, col - 1, row - 2, col - 2))
						moves.add(new Move(row, col, row - 2, col - 2));
				}
			}
		}
		validMoves.setValidJumps(moves);
		
		moves = new ArrayList<>();
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				if (squares[row][col].getPiece().getColor() == color
						|| squares[row][col].getPiece().getColor() == color.toUpperCase()) {
					if (canMove(color, row, col, row + 1, col + 1))
						moves.add(new Move(row, col, row + 1, col + 1));
					if (canMove(color, row, col, row - 1, col + 1))
						moves.add(new Move(row, col, row -0 1, col + 1));
					if (canMove(color, row, col, row + 1, col - 1))
						moves.add(new Move(row, col, row + 1, col - 1));
					if (canMove(color, row, col, row - 1, col - 1))
						moves.add(new Move(row, col, row - 1, col - 1));
				}
			}
		}
		validMoves.setValidMoves(moves);
		return validMoves;
	}


	@Override
	public String toString() {
		return "Board [squares=" + Arrays.toString(squares) + "]";

	}

}
