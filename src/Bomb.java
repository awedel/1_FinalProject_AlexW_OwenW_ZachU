
public class Bomb extends Item{

	public Bomb() {
		super("Bomb");
	}
	public void effect(Fighter fighter) {
		if(fighter instanceof Enemy){
			fighter.reduceHealth(50);
		}
		
	}
}
