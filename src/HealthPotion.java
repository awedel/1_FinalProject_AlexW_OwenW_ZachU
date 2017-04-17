
public class HealthPotion extends Item{

	public HealthPotion() {
		super("Health Potion");
	}
	public void effect(Fighter fighter) {
		if(fighter instanceof Player ){
			fighter.increaseHealth(25);
		}
	}

}
