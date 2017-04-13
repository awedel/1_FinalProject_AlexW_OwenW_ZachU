
public abstract class Item {
	private String itemName;
	public Item(String n){
		itemName = n;
	}
	public String getName(){
		return itemName;
	}
	
	public abstract void effect(Player player);
	

}
