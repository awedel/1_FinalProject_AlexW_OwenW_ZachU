
public class Enemy {
	private int health;
	private int damage;
	private boolean isBoss;
	public Enemy(int h, int d){
		health = h;
		damage = d;
	}
	public int getHealth(){
		return health;
	}
	public void reduceHealth(int num){
		health -= num;
	}
	public int getDamage(){
		return damage;
	}
	public boolean isDead(){
		if(health < 0)
			return true;
		return false;
	}
	public boolean isBoss(){
		return isBoss;
	}
}
