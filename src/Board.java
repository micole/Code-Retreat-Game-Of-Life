import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author micole This class was created during the CodeRetreatCHS, and then
 *         cleaned up the next day.
 */
public class Board {

	Cell board[][];
	Cell temp[][];
	int width;
	int height;

	/**
	 * Create the board with the width and height
	 * 
	 * @param width
	 * @param height
	 */
	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		board = new Cell[height][width];
		temp = new Cell[height][width];

		/**
		 * creation of the cells
		 */
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.height; j++) {
				board[i][j] = new Cell(i, j);
				temp[i][j] = new Cell(i, j);
			}
		}

		/**
		 * creation of the neighbors
		 */
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.height; j++) {
				List<Cell> arrayNextTo = new ArrayList<Cell>();
				for (int k = -1; k < 2; k++) {
					for (int l = -1; l < 2; l++) {
						if (!(k == 0 && l == 0)) {
							try {
								arrayNextTo.add(board[i + k][j + l]);
							} catch (Exception e) {
								// System.out.println("ERROR");
							}
						}
					}
				}
				board[i][j].setNeighbors(arrayNextTo);
				temp[i][j].setNeighbors(arrayNextTo);
			}
		}
	}

	/**
	 * Randomize the board up.
	 */
	public void randomize() {
		Random r = new Random();
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				board[i][j].setState(r.nextBoolean());
			}
		}
	}

	/**
	 * print 1's on alive and 0's on dead.
	 */
	public String toString() {
		String string = "";
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.height; j++) {
				if (board[i][j].getState()) {
					string += "1";
				} else {
					string += "0";
				}
			}
			string += "\n";
		}
		return (string);
	}

	/**
	 * run one cycle of the game.
	 */
	public void tick() {
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.height; j++) {
				int sum = 0;
				for (Cell c : board[i][j].getNeighbors()) {
					if (c.getState()) {
						// System.out.println("alive");
						sum++;
					}
				}
				if (sum == 3) {
					temp[i][j].setState(true);
				} else if (board[i][j].getState() && sum == 2) {
					temp[i][j].setState(true);
				} else {
					temp[i][j].setState(false);
				}
			}
		}
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.height; j++) {
				board[i][j].setState(temp[i][j].getState());
			}
		}
	}
}
