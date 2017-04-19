import java.util.ArrayList;

public class Player extends Fighter {
	private int killed;
	private ArrayList <Item> inventory;
	private Weapon weapon;
	
	public Player(){
		super(100,20);
		weapon = new ShortSword();
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
	public String toString(){
		return "Player Health = " + this.getHealth() + "\nWeapon = " + weapon + "\n" + inventory;
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
		if(((int) Math.random() * 100 + 1) < 25){
			Item potion = new HealthPotion();
			potion.addToInventory(this);
		}
		else if(((int) Math.random() * 100 + 1) < 15){
			Item bomb = new Bomb();
			bomb.addToInventory(this);
		}
		else if(((int) Math.random() * 100 + 1) < 5){
			Item pack = new FullHealthPack();
			pack.addToInventory(this);
		}
		else if(((int) Math.random() * 100 + 1) == 1){
			Item boom = new SuperBomb();
			boom.addToInventory(this);
		}
	}
	public void setWeapon(Weapon w){
		weapon = w;
	}
	public int getDamage(){
		return weapon.getWeaponDamage();
	}
	public void getNewWeapon(){
		int random = ((int) Math.random() * 100);
		if(random < 25)
			weapon = new Mace();
		else if(random < 50)
			weapon = new Axe();
	}
}
