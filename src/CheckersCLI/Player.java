package CheckersCLI;

import java.util.*;

abstract public class Player{
	private String color;
	public Player() {
	}
	
	public Player(String color) {
		this.color=color;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	 abstract public Move makemove(Board board) ;
	 
		
	}
	

