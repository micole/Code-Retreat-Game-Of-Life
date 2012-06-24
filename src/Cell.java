import java.util.List;

/**
 * 
 * @author micole This class was created during the CodeRetreatCHS, and then
 *         cleaned up the next day.
 */
public class Cell {
	private List<Cell> Neighbors;
	private int X;
	private int Y;
	private boolean isAlive;

	public Cell(int x, int y) {
		X = x;
		Y = y;
	}

	public Cell() {

	}

	public void setState(boolean x) {
		isAlive = x;
	}

	public boolean getState() {
		return isAlive;
	}

	public void setNeighbors(List<Cell> nigh) {
		Neighbors = nigh;
	}

	public List<Cell> getNeighbors() {
		return Neighbors;
	}

	public String toString() {
		if (isAlive)
			return ("1");
		else
			return ("0");
	}

}
