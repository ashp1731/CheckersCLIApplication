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
	 public Move makemove(Board board) {
		 return null;
	 }
}