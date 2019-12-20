package CheckersCLI;
 class Board{
	
	private int[][]squares;
	public Board() {
		squares=new int[8][8];
	}
	
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
    
	 
	}
}