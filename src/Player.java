import java.util.ArrayList;

public class Player extends Fighter {
	private int killed;
	private ArrayList <Item> inventory;
	private Weapon weapon;
	private boolean firstwave;
	private int level;
	
	public Player(){
		super(150,20);
		weapon = new ShortSword();
		killed = 0;
		firstwave = true;
		inventory = new ArrayList <Item>();
		level = 0;
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
		return "Player Health = " + this.getHealth() + "\nWeapon = " + weapon + "\n" + inventory + "\nLevel = " + level;
	}
	public int getKilled(){
		return killed;
	}
	public void addKilled(){
		killed++;
	}
	public boolean parry(Enemy enemy){
		if(((int)(Math.random() * 100 + 1)) < 25){
			enemy.changeCanAttack();
			return true;
		}
		return false;
	}
	public void getItem(){
		if(((int)(Math.random() * 100 + 1)) < 25){
			Item potion = new HealthPotion();
			potion.addToInventory(this);
		}
		else if(((int)(Math.random() * 100 + 1)) < 15){
			Item bomb = new Bomb();
			bomb.addToInventory(this);
		}
		else if(((int)(Math.random() * 100 + 1)) < 5){
			Item pack = new FullHealthPack();
			pack.addToInventory(this);
		}
	}
	public void setWeapon(Weapon w){
		weapon = w;
	}
	public Weapon getWeapon(){
		return weapon;
	}
	public int getDamage(){
		return weapon.getWeaponDamage() + (5 * level);
	}
	public void getNewWeapon(){
		int random = ((int)(Math.random() * 100));
		if(random < 10){
			weapon = new Zweihander();
		}
		else if(random < 25){
			if(this.getDamage() < new Mace().getWeaponDamage())
				weapon = new Mace();
		}
		else if(random < 75){
			if(this.getDamage() < new Axe().getWeaponDamage())
				weapon = new Axe();
		}
	}
	public Enemy getNewEnemy(){
		if(this.getKilled() > 3)
			firstwave = false;
		else if(firstwave){
			if(this.getKilled() % 3 == 0){
				level ++;
				return new DragonOfTheDeep(0);
			}
			else if(this.getKilled() % 2 == 0){
				level ++;
				return new SkeletonEffigy(0);
			}
			else
				return new MushroomMan(0);
		}
		else{
			level ++;
			if(((int)(Math.random() * 4)) < 1)
				return new DragonOfTheDeep(level * 10);
			else if(((int)(Math.random() * 4)) < 2)
				return new MushroomMan(level * 10);
			else if(((int)(Math.random() * 4)) < 3)
				return new SnakeDwarf(level * 10);
			else
				return new SkeletonEffigy(level * 10);
		}
		return new SnakeDwarf(level * 10);
	}
	public void levelHealth(){
		this.setHealth(level * 5);;
	}
}
