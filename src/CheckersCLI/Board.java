package CheckersCLI;

import java.util.Arrays;

class Board {
	
	public static final int SIZE = 8;
	
	private Square[][] squares;

	public Square[][] getSquares() {
		return squares;
	}

	public void setSquares(Square[][] squares) {
		this.squares = squares;
	}
	
	
//	public Board() {
//		
//		// Board Initialization
//		Piece r = new Piece("r", "pawn");
//		Piece b = new Piece("b", "pawn");
//		this.squares = new Square[SIZE][SIZE];
//		
//		int i, j;
//		for (i = 0; i < SIZE; i++) {
//
//			for (i = 1; i < SIZE; i += 2) {
//				this.squares[i][1].setPiece(r); 
//				this.squares[i][5].setPiece(b);
//				this.squares[i][7].setPiece(b);
//				this.squares[i][0].setPiece(r);
//				this.squares[i][2].setPiece(r);
//				this.squares[i][6].setPiece(b);
//			}
//		}
//	}

//	public void movePiece(Move move) {
//		// Code added by Ashwini
//		//Date : 12/10/2019
//		// this method will update the array squares with final coordinates
//
//		
//		
//		if(isMoveLegal(move)) {
//			
//			Square sInitial = new Square();
//			sInitial.setPiece(squares[move.getInitialXCoor()][move.getInitialYCoor()].getPiece());
//			
//		}
//	}
//
//	public  boolean isMoveLegal(Move move){
//		return true;
//	}
	
	@Override
	public String toString() {
		return "Board [squares=" + Arrays.toString(squares) + "]";
	}
	
	
}