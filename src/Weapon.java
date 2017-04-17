
public abstract class Weapon {
	private int damage;
	private String name;
	
	public Weapon(String n, int d){
		name = n;
		damage = d;
	}
	public String getName(){
		return name;
	}
	
}
