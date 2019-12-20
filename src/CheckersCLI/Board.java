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
	
<<<<<<< HEAD
	//move peice
	//square array
	//create emplty method with moviec
	public String toString() {
		return ;
		
		// Checks if a move is valid.
	    public boolean isMoveLegal(int movefrom, int moveto) {

		// Gets array indeces corresponding to the move, from parameters.
		int xfrom = movefrom/10 - 1;
		int yfrom = movefrom%10 - 1;
		int xto = moveto/10 - 1;
		int yto = moveto%10 - 1;
		
		// Check if indeces in range, if not, return false.
		if (xfrom < 0 || xfrom > 7 || yfrom < 0 || yfrom > 7 ||
		    xto < 0 || xto > 7 || yto < 0 || yto > 7) 
		    return false;

		// Check to see you are moving your piece to a blank square.
		else if (board[xfrom][yfrom]==whosemove && board[xto][yto]=='_') {

		    // Checks case of simple move
		    if (Math.abs(xfrom-xto)==1) {
			if ((whosemove == 'r') && (yto - yfrom == 1))
			    return true;
			else if ((whosemove == 'b') && (yto - yfrom == -1))
			    return true;
		    } 
		    
		    // Checks case of a jump
		    else if (Math.abs(xfrom-xto)==2) {
			if (whosemove == 'r' && (yto - yfrom == 2) && 
			    board[(xfrom+xto)/2][(yfrom+yto)/2] == 'b')
			    return true;
			else if (whosemove == 'b' && (yto - yfrom == -2) && 
			    board[(xfrom+xto)/2][(yfrom+yto)/2] == 'r')
			    return true;
		    }
		}
		// If move is neither a simple one or a jump, it is not legal.
		return false;
	    }
    
	 
=======
	
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
>>>>>>> 58a42270f5be15bb52d667669db331eec96bfc0a
	}
	
	
}