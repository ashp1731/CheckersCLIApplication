package CheckersCLI;

import Checkers.Piece;
import Checkers.Square;

public class MovePieceTest {

	
	public static final int SIZE = 8;
	
	private Move move;
	private Square[][] squares;

	public Square[][] getSquares() {
		return squares;
	}

	public void setSquares(Square[][] squares) {
		this.squares = squares;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void movePieceInSquare() {
		
		// Code to initialize the Board
				squares = new Square[8][8];
				Piece pieceEmpty = new Piece("", "");
				Piece pieceKing = new Piece("", "king");

				for(int i = 0; i < 8; i++) {
					for(int j = 0; j < 8; j++) {
						squares[i][j] = new Square();
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
				squares[6][6].setPiece(new Piece("b", "pawn"));
				squares[6][1].setPiece(new Piece("b", "pawn"));
				squares[6][3].setPiece(new Piece("b", "pawn"));
				squares[6][5].setPiece(new Piece("b", "pawn"));
				squares[6][7].setPiece(new Piece("b", "pawn"));
				squares[7][0].setPiece(new Piece("b", "pawn"));
				squares[7][2].setPiece(new Piece("b", "pawn"));
				squares[7][4].setPiece(new Piece("b", "pawn"));
				squares[7][6].setPiece(new Piece("b", "pawn"));
		
		// Move Piece Logic
		Piece initialPiece = new Piece();
		initialPiece = squares[move.getInitialXCoor()][move.getInitialYCoor()].getPiece();
		squares[move.getInitialXCoor()][move.getInitialYCoor()].setPiece(NULL);
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
//		initialPiece.setColor(squares[move.getInitialXCoor()][move.getInitialYCoor()].getPiece().getColor());
		
	}

}
