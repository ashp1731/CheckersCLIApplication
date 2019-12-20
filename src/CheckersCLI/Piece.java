package CheckersCLI;

public class Piece {

	private String color; // red or black
	private String rank; // pawn or king

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public Piece() {}
	
	public Piece(String color, String rank) {
		this.color = color;
		this.rank = rank;
	}

	public void kingPiece() {
		this.rank = "king";
	}
}
