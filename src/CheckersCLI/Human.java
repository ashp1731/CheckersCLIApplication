package CheckersCLI;

public class Human extends AbstractPlayer {
	public Human() {
		super();
	}

	public Human(String color) {
		super(color);
	}

	public String getMakemove() {
		return "move";
	}
}