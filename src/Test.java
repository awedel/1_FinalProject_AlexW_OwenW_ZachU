import java.util.Scanner;
public class Test {
	public static void mockGame(){
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Game Start");
		Player guy = new Player();
		Enemy badguy = new DefaultEnemy();
		Item bomb = new Bomb();
		bomb.addToInventory(guy);
		while(guy.isDead() == false){
			
			System.out.println("\nYour Turn");
			System.out.println("The Enemy has " + badguy.getHealth() + " health \nEnter 'attack' or 'a' to attack the Enemy");
			String input = sc.nextLine();
			
			if(input.equals("attack") || input.equals("a")){
				badguy.reduceHealth(guy.getDamage());
				System.out.println("You did " + guy.getDamage() + " to the enemy");
			}
			else if(input.equals("bomb") || input.equals("b")){
				if(guy.getInventory().size() < 1)
					break;
				else
					guy.useItem(0);
			}
			
			if(badguy.isDead() == true){
				System.out.println("\nEnemy Killed");
				guy.addKilled();
				System.out.println("\nA new enemy appears");
				badguy = new DefaultEnemy();
			}
			
			System.out.println("Enemy Turn");
			guy.reduceHealth(badguy.getDamage());
			System.out.println("The Enemy Attacks for " + badguy.getDamage());
			System.out.println("\n" + guy);
		}
		System.out.println("\nYOU DIED");
		System.out.println("\nYou killed " + guy.getKilled() + " enemies");
	}
	public static void itemTesting(){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Test Start");
		Player guy = new Player();
		while(guy.getHealth() < 300){
			Item potion = new HealthPotion();
			System.out.println(potion);
			potion.addToInventory(guy);
			int input = sc.nextInt();
			if(input > -1){
				 guy.useItem(input);
			}
			System.out.println(guy);
			System.out.println(guy.printInventory());
		}
		
	}
	public static void main(String[] args) {
		mockGame();
		//itemTesting();
	}
	//trying to push all through

}
