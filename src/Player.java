import java.util.ArrayList;

public class Player extends Fighter {
	private int killed;
	private ArrayList <Item> inventory;
	
	public Player(){
		super(100,20);
		killed = 0;
		inventory = new ArrayList <Item>();
	}
	public Item useInventory(int slot){
		return inventory.remove(slot);
	}
	public ArrayList<Item> getInventory(){
		return inventory;
	}
	public Item getInventory(int slot){
		return inventory.get(slot);
	}
	public boolean isInventoryEmpty(){
		//true if empty
		return inventory.size() < 1;
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
	public boolean parry(Enemy enemy){
		if(((int) (Math.random() * 100 + 1)) < 25){
			enemy.changeCanAttack();
			return true;
		}
		return false;
	}
	public void getItem(){
		if(((int) Math.random() * 100 + 1) < 15){
			Item potion = new HealthPotion();
			potion.addToInventory(this);
			//for printing
			System.out.println("\n" + this.printInventory());
		}
	}
}
