package CheckersCLI;



public class Computer extends Player {
	public Computer() {
		super();
	}

	public Computer(String color) {
		super(color);
	}

	public Boolean isMovingLegal() {
		return(true);
}
	 public Move makeMove(Board board) {
			ValidMoves validMoves = board.getLegalMoves(this.getColor());
			Move move = new Move();
			int arraySize;
			System.out.println("Current Player : " + "Player Two 'b'");
			if(validMoves.getValidJumps().size()>0){
				arraySize = validMoves.getValidJumps().size();
				int rand=(int)(Math.random()*arraySize);
				return move=validMoves.getValidJumps().get(rand);
			}
			else if(validMoves.getValidMoves().size()>0){
				arraySize = validMoves.getValidMoves().size();
				int rand=(int)(Math.random()*arraySize);
				return move=validMoves.getValidMoves().get(rand);
			}
			else {
				return null;
			}
			
					
			
	 }
}