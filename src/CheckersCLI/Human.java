package CheckersCLI;

public class Human extends Player {
	public Human() {
		super();
	}

	public Human(String color) {
		super(color);
	}

	public String getMakemove() {
		return "move";
	}
	public Boolean isMovingLegal() {
		return(true);
}
	 public Move makemove(Board board) {
		 return null;
	 }
}


