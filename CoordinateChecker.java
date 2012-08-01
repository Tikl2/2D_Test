
public class CoordinateChecker {
	
	private Rock rock = new Rock();
	private Barrel barrel = new Barrel();
	
	public Objects checkCoordinate(int x, int y){
		if(x == rock.getCoordX() && y == rock.getCoordY()){
			System.out.println("A rock is in your way.\n");
			return Objects.Rock;
		}else if(x == barrel.getCoordX() && y == barrel.getCoordY()){
			System.out.println("A barrel is in your way, it looks moveable.\n");
			return Objects.Barrel;
		}else{
			return Objects.Air;
		}
	}
}
