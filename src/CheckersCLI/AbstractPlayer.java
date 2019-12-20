package CheckersCLI;

abstract public class AbstractPlayer {
	private String color;

	public AbstractPlayer() {
	}

	public AbstractPlayer(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	abstract public String getMakemove();

	public static void main(String[] args) {

	}

}
