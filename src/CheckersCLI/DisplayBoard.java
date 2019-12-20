package CheckersCLI;

public class DisplayBoard {

	private int[][] squares;

	public int[][] getSquares() {
		return squares;
	}

	public void setSquares(int[][] squares) {
		this.squares = squares;
	}

	public DisplayBoard(int size) {
		this.squares = new int[size][size];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(int i = 0; i <= 9; i++){
//
//            if(i == 0){
//                System.out.print("\\");
//            }
//
//            else if(i < 9){
//                System.out.print(i);
//            }
//
//            for(int j = 0; j < 9; j++){
//
//                if(i == 0 && j != 0){
//                    System.out.print(j + " ");
//                }
//
//                else if(i != 9 && j == 0){
//                    System.out.print(" ");
//                }
//
//                else if (i == 9){
//                    System.out.print("--");
//                }
//
//                else{
//                	String display = "";
//                	if((i == 1 || i == 3 )&& j % 2 == 0)
//                	{
//                        display = "r"; 
//                	}
//                	else if(i == 2 & j % 2 != 0)
//                	{
//                        display = "r"; 
//                	}
//                	else if( (i == 6 || i == 8) && j % 2 != 0) {
//                		display = "b";
//                	}
//                	else if(i == 7 && j % 2 == 0) {
//                		display = "b";
//                	}
//                	else {
//                        display = " "; 
//                	}
//
//
//                    System.out.print(display + " ");
//                }
//
//            } 
//            System.out.println("|");
//        }

	}

}
