import java.util.List;

/**
 * 
 * @author micole
 *
 */
public class Cell {
	public List<Cell> Neighbors;
	public int X;
	public int Y;
	public boolean isAlive;
	
	
	public Cell(int x, int y){
		X = x;
		Y = y;
	}
	
	public Cell(){
		
	}
	
	public void setState(boolean x){
		isAlive = x;
	}
	
	public void setNeighbors(List<Cell> nigh){
		Neighbors = nigh;
	}
	
	public String toString(){
		return (X + " " + Y);
		//return (String.valueOf(Neighbors.size()));
	}
	
}
