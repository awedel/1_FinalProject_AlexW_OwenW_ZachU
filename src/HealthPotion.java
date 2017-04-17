
public class HealthPotion extends Item{

	public HealthPotion() {
		super("Health Potion");
	}
	public void effect(Player player){
		player.increaseHealth(25);
	}
	
	public void effect(Enemy enemy) {
		//does nothing, has no effect on enemy
	}

}
