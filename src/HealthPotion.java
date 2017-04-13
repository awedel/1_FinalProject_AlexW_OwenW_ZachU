
public class HealthPotion extends Item{

	public HealthPotion() {
		super("Health Potion");
		// TODO Auto-generated constructor stub
	}
	public void effect(Player player){
		player.increaseHealth(25);
	}

}
