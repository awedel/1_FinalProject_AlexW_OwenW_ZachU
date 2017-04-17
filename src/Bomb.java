
public class Bomb extends Item{

	public Bomb() {
		super("Bomb");
		
	}

	public void effect(Player player) {
		//does nothing, has no effect on player
	}

	public void effect(Enemy enemy) {
		enemy.reduceHealth(100);
		
	}

}
