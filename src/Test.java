import java.util.Scanner;
public class Test {
	public static void mockGame(){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Game Start");
		Player guy = new Player();
		Enemy badguy = new DefaultEnemy(100, 10);
		while(guy.isDead() == false && badguy.isDead() == false){
			System.out.println("Your Turn");
			System.out.println("The Enemy has " + badguy.getHealth() + " health \nEnter 'attack' or 'a' to attack the Enemy");
			String input = sc.nextLine();
			if(input.equals("attack") || input.equals("a")){
				badguy.reduceHealth(guy.getDamage());
				System.out.println("You did " + guy.getDamage() + " to the enemy");
			}
			System.out.println("Enemy Turn");
			guy.reduceHealth(badguy.getDamage());
			System.out.println("The Enemy Attacks for " + badguy.getDamage() + "\nYou now have " + guy.getHealth() + " health");
		}
		if(guy.isDead() == true){
			System.out.println("\nYOU DIED");
		}
		else{
			System.out.println("\nYOU WIN");
		}
	}
	public static void main(String[] args) {
		mockGame();
		//fuck you alex

	}

}
