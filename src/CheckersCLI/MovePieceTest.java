package CheckersCLI;

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
		
		// Initialize Square Array
		move = new Move(6,7,5,8);
		squares = new Square[SIZE][SIZE];
		Piece pieceRed = new Piece("r", "pawn");
		Piece pieceBlack = new Piece("b", "pawn");
		Piece pieceEmpty = new Piece("", "");
		Piece pieceKing = new Piece("", "king");
		
		int i, j;
		for (i = 0; i < SIZE; i++) {

			for (i = 1; i < SIZE; i += 2) {
				squares[i][1].setPiece(pieceRed);
				squares[i][5].setPiece(pieceBlack); 
				squares[i][7].setPiece(pieceBlack);
			}
			for (i = 0; i < SIZE; i += 2) {
				squares[i][0].setPiece(pieceRed);
				squares[i][2].setPiece(pieceRed);
				squares[i][6].setPiece(pieceBlack);
			}
		}
		
		// Move Piece Logic
		Piece initialPiece = new Piece();
		initialPiece = squares[move.getInitialXCoor()][move.getInitialYCoor()].getPiece();
		squares[move.getInitialXCoor()][move.getInitialYCoor()].setPiece(pieceEmpty);
		squares[move.getEndingXCoor()][move.getEndingYCoor()].setPiece(initialPiece);
		
		if(squares[move.getEndingXCoor()][move.getEndingYCoor()].getPiece().getColor() == "r" && move.getEndingYCoor() == 7) {
			
		}
		else if(squares[move.getEndingXCoor()][move.getEndingYCoor()].getPiece().getColor() == "b") {
			
		}
//		initialPiece.setColor(squares[move.getInitialXCoor()][move.getInitialYCoor()].getPiece().getColor());
		
	}

}
