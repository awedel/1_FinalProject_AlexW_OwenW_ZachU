
public class Player {
	private int health;
	private int damage;
	private int killed;
	//private ArrayList <Item> items;
	
	public Player(){
		health = 100;
		damage = 20;
		killed = 0;
	}
	public int getHealth(){
		return health;
	}
	public int getDamage(){
		return damage;
	}
	public void reduceHealth(int num){
		health -= num;
	}
	public boolean isDead(){
		if(health < 1)
			return true;
		return false;
	}
	public String toString(){
		return "Player Health =" + this.getHealth();
	}
	public int getKilled(){
		return killed;
	}
	public void addKilled(){
		killed++;
	}
}
