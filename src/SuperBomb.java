
public class SuperBomb extends Item{
	public SuperBomb() {
		super("Super Bomb");
	}
	public void effect(Fighter fighter) {
		if(fighter instanceof Enemy){
			fighter.reduceHealth(fighter.getHealth());
		}
		
	}

}
