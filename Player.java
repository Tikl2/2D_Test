
public class Player {

	private static int CoordX = 0;
	private static int CoordY = 0;

	public int getCoordX(){	
		return CoordX;
	}
	
	public int getCoordY(){
		return CoordY;
	}
	
	public void setCoords(int x, int y){
		CoordX = x;
		CoordY = y;
	}
	
}
