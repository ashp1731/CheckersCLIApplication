package CheckersCLI;

import java.util.List;

public class ValidMoves {
	private List<Move> validJumps;
	private List<Move> validMoves;

	public List<Move> getValidJumps() {
		return validJumps;
	}

	public void setValidJumps(List<Move> validJumps) {
		this.validJumps = validJumps;
	}

	public List<Move> getValidMoves() {
		return validMoves;
	}

	public void setValidMoves(List<Move> validMoves) {
		this.validMoves = validMoves;
	}
}
