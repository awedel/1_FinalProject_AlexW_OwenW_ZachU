import java.util.ArrayList;

public class Player {
	private int health;
	private int damage;
	private int killed;
	private ArrayList <Item> inventory;
	
	public Player(){
		health = 100;
		damage = 20;
		killed = 0;
		inventory = new ArrayList <Item>();
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
	public boolean isDead(){
		if(health < 1)
			return true;
		return false;
	}
	public ArrayList <Item> getInventory(){
		return inventory;
	}
	public void useItem(int slot){
		inventory.remove(slot).effect(this);
	}
	public String printInventory(){
		return inventory.toString();
	}
	public String toString(){
		return "Player Health = " + this.getHealth();
	}
	public int getKilled(){
		return killed;
	}
	public void addKilled(){
		killed++;
	}
}
