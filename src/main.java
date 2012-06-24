

/**
 * 
 * @author micole
 * This class was created during the 
 * CodeRetreatCHS, and then cleaned up the
 * next day.
 */
public class main {

	/**
	 * Run the program for 10 ticks on a 5X5 board
	 * @param args
	 */
	public static void main(String[] args) {
		Board board = new Board(5, 5);
		board.randomize();
		for(int i = 0; i < 10; i++){
			board.tick();
			System.out.println(board.toString());
			System.out.println("\n\n\n\n");
		}
		//board.board[3][3].toString();

	}

}
