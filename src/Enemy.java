
public abstract class Enemy extends Fighter{
	private boolean isBoss;
	public Enemy(int h, int d, boolean b){
		super(h,d);
		isBoss = b;
	}

	public boolean isBoss(){
		return isBoss;
	}

	public String toString(){
		return "Enemy Health =" + this.getHealth();
	}
}
