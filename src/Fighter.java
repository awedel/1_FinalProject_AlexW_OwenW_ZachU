
public class Fighter {
	private int health;
	private int damage;
	
	public Fighter(int h, int d){
		health = h;
		damage = d;
	}
	public boolean isDead(){
		if(this.getHealth() < 1)
			return true;
		return false;
	}
	public int getHealth(){
		return health;
	}
	public int getDamage(){
		return damage;
	}
	public void reduceHealth(int reduction){
		health -= reduction;
	}
	public void increaseHealth(int increase){
		health += increase;
	}
	public void useItem(Item item){
		item.effect(this);
	}
}
