package CheckersCLI;



public class Computer extends Player {
	public Computer() {
		super();
	}

	public Computer(String color) {
		super(color);
	}

	public String getMakemove() {
		return "move";
	}
	public Boolean isMovingLegal() {
		return(true);
}
	 public Move makeMove(Board board) {
			ValidMoves validMoves = board.getLegalMoves(this.getColor());
			Move move = new Move();
			
			// Logic to randomly select Move/Jump
			if(validMoves.getValidJumps().isEmpty()) {
				if(!validMoves.getValidMoves().isEmpty()) {
					
				}
			}		
					
			return move;
	 }
}