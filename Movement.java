import java.util.Scanner;

public class Movement {
	
	private Player player = new Player();
	private Barrel barrel = new Barrel();
	private Scanner scanner = new Scanner(System.in);
	private CoordinateChecker Check = new CoordinateChecker();
	
	private Facing facing = Facing.UP;
	private String input;
	private boolean end;
	
	public void totalMovement(){
		do{
			inputRetriever();
			
			if(input.equals("end")){
				end = true;
			}else{
				inputHandler();
			}
			
			printCoords();
			printFacing();
		}while(end == false);
	}
	
	private void inputHandler(){
		if(input.equals("w")){
			if(facing != Facing.UP){
				facing = Facing.UP;
			}else if(Check.checkCoordinate(player.getCoordX(), player.getCoordY() + 1) == Objects.Air){
				player.setCoords(player.getCoordX(), player.getCoordY() + 1);
			}
		}else if(input.equals("a")){
			if(facing != Facing.LEFT){
				facing = Facing.LEFT;
			}else if(Check.checkCoordinate(player.getCoordX() - 1, player.getCoordY()) == Objects.Air){
				player.setCoords(player.getCoordX() - 1, player.getCoordY());
			}
		}else if(input.equals("s")){
			if(facing != Facing.DOWN){
				facing = Facing.DOWN;
			}else if(Check.checkCoordinate(player.getCoordX(), player.getCoordY() - 1) == Objects.Air){
				player.setCoords(player.getCoordX(), player.getCoordY() - 1);
			}
		}else if(input.equals("d")){
			if(facing != Facing.RIGHT){
				facing = Facing.RIGHT;
			}else if(Check.checkCoordinate(player.getCoordX() + 1, player.getCoordY()) == Objects.Air){
				player.setCoords(player.getCoordX() + 1, player.getCoordY());
			}
		}else if(input.equals("f")){
			if(facing == Facing.UP && Check.checkCoordinate(player.getCoordX(), player.getCoordY() + 1) == Objects.Barrel){
				if(Check.checkCoordinate(barrel.getCoordX(), barrel.getCoordY() + 1) == Objects.Air){
					barrel.setCoords(barrel.getCoordX(), barrel.getCoordY() + 1);
				}
			}else if(facing == Facing.LEFT && Check.checkCoordinate(player.getCoordX() - 1, player.getCoordY()) == Objects.Barrel){
				if(Check.checkCoordinate(barrel.getCoordX() - 1, barrel.getCoordY()) == Objects.Air){
					barrel.setCoords(barrel.getCoordX() - 1, barrel.getCoordY());
				}
			}else if(facing == Facing.DOWN && Check.checkCoordinate(player.getCoordX(), player.getCoordY() - 1) == Objects.Barrel){
				if(Check.checkCoordinate(barrel.getCoordX(), barrel.getCoordY() - 1) == Objects.Air){
					barrel.setCoords(barrel.getCoordX(), barrel.getCoordY() - 1);
				}
			}else if(facing == Facing.RIGHT && Check.checkCoordinate(player.getCoordX() + 1, player.getCoordY()) == Objects.Barrel){
				if(Check.checkCoordinate(barrel.getCoordX() + 1, barrel.getCoordY()) == Objects.Air){
					barrel.setCoords(barrel.getCoordX() + 1, barrel.getCoordY());
				}
			}
		}
	}
	
	private void inputRetriever(){
		input = scanner.nextLine();
	}
	
	private void printCoords(){
		System.out.println("X: "+player.getCoordX()+"\nY: "+player.getCoordY());
	}
	
	private void printFacing(){
		System.out.print("Facing: ");
		
		if(facing == Facing.UP){
			System.out.println("UP");
		}else if(facing == Facing.LEFT){
			System.out.println("LEFT");
		}else if(facing == Facing.DOWN){
			System.out.println("DOWN");
		}else if(facing == Facing.RIGHT){
			System.out.println("RIGHT");
		}
	}
}
