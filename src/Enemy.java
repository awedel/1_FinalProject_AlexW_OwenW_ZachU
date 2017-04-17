
public abstract class Enemy {
	private int health;
	private int damage;
	private boolean isBoss;
	private boolean canAttack;
	public Enemy(int h, int d, boolean b){
		health = h;
		damage = d;
		isBoss = b;
		canAttack = true;
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
		if(health < 1)
			return true;
		return false;
	}

	public boolean isBoss(){
		return isBoss;
	}

	public String toString(){
		return "Enemy Health =" + this.getHealth();
	}
	
	public void changeCanAttack(){
		canAttack = !canAttack;
	}
	public boolean getCanAttack(){
		return canAttack;
	}
}
