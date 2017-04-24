public class FullHealthPack extends Item{

	public FullHealthPack() {
		super("Full Health Pack");
	}
	public void effect(Fighter fighter) {
		if(fighter instanceof Player ){
			fighter.increaseHealth(100 - fighter.getHealth());
		}
	}


}
