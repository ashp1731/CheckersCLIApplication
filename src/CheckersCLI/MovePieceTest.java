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
		
		
		for(int i=0;i <8;i++){ 
			squares [0][ i ].setPiece(pieceBlack); 
			squares [2][ i ].setPiece(pieceBlack);
			squares [6][ i++].setPiece(pieceRed);
			} 
		
		for(int i=1;i <8;i++){ 
			squares [1][ i ].setPiece(pieceBlack); 
			squares [5][ i ].setPiece(pieceRed); 
			squares [7][ i++].setPiece(pieceRed);
			}
		
		// Move Piece Logic
		Piece initialPiece = new Piece();
		initialPiece = squares[move.getInitialXCoor()][move.getInitialYCoor()].getPiece();
		squares[move.getInitialXCoor()][move.getInitialYCoor()].setPiece(pieceEmpty);
		squares[move.getEndingXCoor()][move.getEndingYCoor()].setPiece(initialPiece);
		
		// change "pawn" to "king"
		if(squares[move.getEndingXCoor()][move.getEndingYCoor()].getPiece().getColor() == "r" && move.getEndingYCoor() == 7) {
			Piece pieceKingR = new Piece("r", "king");
			squares[move.getEndingXCoor()][move.getEndingYCoor()].setPiece(pieceKingR);
		}
		else if(squares[move.getEndingXCoor()][move.getEndingYCoor()].getPiece().getColor() == "b") {
			Piece pieceKingB = new Piece("b", "king");
			squares[move.getEndingXCoor()][move.getEndingYCoor()].setPiece(pieceKingB);		
		}

		
	}

}
