package Checkers;

import java.util.Arrays;

public class Board {

	public static final int SIZE = 8;
	private Square[][] squares;

	public Square[][] getSquare() {
		return squares;
	}

	public void setSquare(Square[][] square) {
		this.squares = square;
	}

	public Board() {
		
		// Code to initialize the Board
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

	public boolean isMoveLegal(Move move) {
		
		return true;
	}

	public void movePiece(Move move) {
		// Move Piece Logic
		Piece pieceEmpty = new Piece();
		Piece pieceKing = new Piece("", "king");
		
		Piece initialPiece = new Piece();
		initialPiece = squares[move.getInitalXCoor()][move.getInitialYCoor()].getPiece();
		squares[move.getInitalXCoor()][move.getInitialYCoor()].setPiece(pieceEmpty);
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

	@Override
	public String toString() {
		return "Board [square=" + Arrays.toString(squares) + "]";
	}

}
