
public abstract class Enemy extends Fighter{
	private boolean isBoss;
	private boolean canAttack;
	public Enemy(int h, int d, boolean b){
		super(h,d);
		isBoss = b;
		canAttack = true;
	}

	public boolean isBoss(){
		return isBoss;
	}

	public String toString(){
		return "Enemy Health =" + this.getHealth();
	}
	
	public void changeCanAttack(){
		canAttack = !canAttack;
	}
	public boolean getCanAttack(){
		return canAttack;
	}
}
