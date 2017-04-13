
public class HealthPotion extends Item{

	public HealthPotion() {
		super("Health Potion");
	}
	public void effect(Player player){
		player.increaseHealth(25);
	}

}
