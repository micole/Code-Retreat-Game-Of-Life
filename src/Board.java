import java.util.ArrayList;
import java.util.List;

public class Board {

	Cell board[][] = new Cell[5][5];
	Cell temp[][] = new Cell[5][5];

	public Board() {
		/**
		 * creation of the cells
		 */
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = new Cell(i, j);
				temp[i][j] = new Cell(i,j);
			}
		}

		/**
		 * creation of the neighbors
		 */
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				List<Cell> arrayNextTo = new ArrayList<Cell>();
				for (int k = -1; k < 2; k++) {
					for (int l = -1; l < 2; l++) {
						if (!(k == 0 && l == 0)) {
							try {
								arrayNextTo.add(board[i + k][j + l]);
							} catch (Exception e) {
								//System.out.println("ERROR");
							}
						}
					}
				}
				board[i][j].setNeighbors(arrayNextTo);
				temp[i][j].setNeighbors(arrayNextTo);
			}
		}
		
		setShape();
		
		for (int x = 0; x < 5; x++){
			tick();
			for(int i = 0; i < 5; i++){
				for(int j = 0; j < 5; j++){
					if(board[i][j].isAlive){
						System.out.print("1");
					}
					else{
						System.out.print("0");
					}
				}
				System.out.print("\n");
			}
			System.out.print("\n\n\n");
			//System.out.println(board);
		}
		//System.out.println(board[3][3]);
		//System.out.println(board[3][3].Neighbors.size());
	}
	
	private void setShape() {
		board[2][1].setState(true);
		board[2][2].setState(true);
		board[2][3].setState(true);
		
	}

	public void tick(){
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				int sum = 0;
				for(Cell c: board[i][j].Neighbors){
					if (c.isAlive){
						//System.out.println("alive");
						sum++;
					}
				}
				if (sum == 3){
					temp[i][j].setState(true);
				}
				else if(board[i][j].isAlive && sum == 2){
					temp[i][j].setState(true);
				}
				else{
					temp[i][j].setState(false);
				}
				
			}
		}
		for(int i = 0; i < 5; i++){
			for (int j = 0; j < 5; j++){
				board[i][j].isAlive = temp[i][j].isAlive;
			}
		}
		//board = temp;
		
	}

}
