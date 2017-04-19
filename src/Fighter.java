
public class Fighter {
	private int health;
	private int damage;
	private boolean canAttack;
	public Fighter(int h, int d){
		health = h;
		damage = d;
		canAttack = true;
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
	public void changeCanAttack(){
		canAttack = !canAttack;
	}
	public boolean getCanAttack(){
		return canAttack;
	}
	public void attack(Fighter fighter, int multiplier){
		fighter.reduceHealth(this.getDamage() * multiplier);
	}
}
