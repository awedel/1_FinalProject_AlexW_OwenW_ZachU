
public class Player {
	private int health;
	private int damage;
	//private ArrayList <Item> items;
	
	public Player(){
		health = 100;
		damage = 20;
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
}
