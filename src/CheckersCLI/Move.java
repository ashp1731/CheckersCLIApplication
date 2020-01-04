package CheckersCLI;
// Move class : Indicates Intial & Final positions of Pawn
public class Move {

	private int initialXCoor, initialYCoor;
	private int endingXCoor, endingYCoor;
	public Move() {
		
	}

	public int getInitialXCoor() {
		return initialXCoor;
	}

	public void setInitialXCoor(int initialXCoor) {
		this.initialXCoor = initialXCoor;
	}

	public int getInitialYCoor() {
		return initialYCoor;
	}

	public void setInitialYCoor(int initialYCoor) {
		this.initialYCoor = initialYCoor;
	}

	public int getEndingXCoor() {
		return endingXCoor;
	}

	public void setEndingXCoor(int endingXCoor) {
		this.endingXCoor = endingXCoor;
	}

	public int getEndingYCoor() {
		return endingYCoor;
	}

	public void setEndingYCoor(int endingYCoor) {
		this.endingYCoor = endingYCoor;
	}

	public Move(int initialXCoor, int initialYCoor, int endingXCoor, int endingYCoor) {
		this.initialXCoor = initialXCoor;
		this.initialYCoor = initialYCoor;
		this.endingXCoor = endingXCoor;
		this.endingYCoor = endingYCoor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + endingXCoor;
		result = prime * result + endingYCoor;
		result = prime * result + initialXCoor;
		result = prime * result + initialYCoor;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Move other = (Move) obj;
		if (endingXCoor != other.endingXCoor)
			return false;
		if (endingYCoor != other.endingYCoor)
			return false;
		if (initialXCoor != other.initialXCoor)
			return false;
		if (initialYCoor != other.initialYCoor)
			return false;
		return true;
	}


}
