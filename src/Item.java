
public abstract class Item {
	private String itemName;
	public Item(String n){
		itemName = n;
	}
	public String getName(){
		return itemName;
	}
	public String toString(){
		return this.getName();
	}
	
<<<<<<< HEAD
	public void addToInventory(Player player){
		player.getInventory().add(this);
	}
	public abstract void effect(Player player);
	public abstract void effect(Enemy enemy);

=======
xD
>>>>>>> branch 'master' of https://github.com/awedel/1_FinalProject_AlexW_OwenW_ZachU.git
}
