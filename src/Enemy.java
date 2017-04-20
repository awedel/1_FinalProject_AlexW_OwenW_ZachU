
public abstract class Enemy extends Fighter{
	private boolean isBoss;
	private String name;
	public Enemy(int h, int d, boolean b, String n){
		super(h,d);
		isBoss = b;
		name = n;
	}
	public boolean isBoss(){
		return isBoss;
	}
	public String toString(){
		return name + " Health = " + this.getHealth();
	}
	public String getName(){
		return name;
	}
}
