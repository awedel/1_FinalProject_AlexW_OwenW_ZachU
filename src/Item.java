
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
	public void addToInventory(Player player){
		player.getInventory().add(this);
	}
	public abstract void effect(Fighter fighter);
}
