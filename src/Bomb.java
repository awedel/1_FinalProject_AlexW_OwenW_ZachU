
public class Bomb extends Item{

	public Bomb() {
		super("Bomb");
		// TODO Auto-generated constructor stub
	}

	public void effect(Player player) {
		// TODO Auto-generated method stub
		//does nothing, has no effect on player
	}

	public void effect(Enemy enemy) {
		enemy.reduceHealth(100);
		
	}

}
