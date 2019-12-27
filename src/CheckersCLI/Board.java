package CheckersCLI;

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
	public boolean isMoveLegal(Move movefrom, Move moveto) {
		
		int xfrom = movefrom.getInitialXCoor();
		int yfrom = movefrom.getInitialYCoor();
		int xto = moveto.getEndingXCoor();
		int yto = moveto.getEndingYCoor();
		char whosemove = squares[xfrom][yfrom].getPiece().getColor;
		
		// Gets array indeces corresponding to the move, from parameters.
		
		// Check if indeces in range, if not, return false.
		if (xfrom < 0 || xfrom > 8 || yfrom < 0 || yfrom > 8 || xto < 0 || xto > 8 || yto < 0 || yto > 8)
			return false;

		// Check to see you are moving your piece to a blank square.
		else if ( squares[xto][yto].getPiece() != null ) {

			// Checks case of simple move
			if (Math.abs(xfrom - xto) == 1) {
				if ((whosemove == 'r') && (yto - yfrom == 1))
					return true;
				else if ((whosemove == 'b') && (yto - yfrom == -1))
					return true;
			}

			// Checks case of a jump
			else if (Math.abs(xfrom - xto) == 2) {
				if (whosemove == 'r' && (yto - yfrom == 2) && board[(xfrom + xto) / 2][(yfrom + yto) / 2] == 'b')
					return true;
				else if (whosemove == 'b' && (yto - yfrom == -2) && board[(xfrom + xto) / 2][(yfrom + yto) / 2] == 'r')
					return true;
			}
		}
		// If move is neither a simple one or a jump, it is not legal.
		return false;
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
		if (squares[move.getEndingXCoor()][move.getEndingYCoor()].getPiece().getColor() == "r"
				&& move.getEndingYCoor() == 7) {

			kingPiece = squares[move.getEndingXCoor()][move.getEndingYCoor()].getPiece();
			kingPiece.setRank("king");
			squares[move.getEndingXCoor()][move.getEndingYCoor()].setPiece(kingPiece);

		} else if (squares[move.getEndingXCoor()][move.getEndingYCoor()].getPiece().getColor() == "b"
				&& move.getEndingYCoor() == 0) {

			kingPiece = squares[move.getEndingXCoor()][move.getEndingYCoor()].getPiece();
			kingPiece.setRank("king");
			squares[move.getEndingXCoor()][move.getEndingYCoor()].setPiece(kingPiece);

		}

		// Jump Logic

	}

	public Move[] getLegalMoves(Player player) {
		// Return an array containing all the legal CheckersMoves
		// for the specfied player on the current board. If the player
		// has no legal moves, null is returned.
		return null;

	}

	@Override
	public String toString() {
		return "Board [squares=" + Arrays.toString(squares) + "]";

	}

}
