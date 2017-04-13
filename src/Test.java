import java.util.Scanner;
public class Test {
	public static void mockGame(){
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Game Start");
		Player guy = new Player();
		Enemy badguy = new DefaultEnemy();
		Item potion = new HealthPotion();
		guy.addItem(potion);
		
		while(guy.isDead() == false){
			
			System.out.println("\nYour Turn");
			System.out.println("The Enemy has " + badguy.getHealth() + " health \nEnter 'attack' or 'a' to attack the Enemy");
			String input = sc.nextLine();
			
			if(input.equals("heal") || input.equals("h")){
				guy.useItem(0);
				System.out.println("Player used Item");
			}
			
			if(input.equals("attack") || input.equals("a")){
				badguy.reduceHealth(guy.getDamage());
				System.out.println("You did " + guy.getDamage() + " to the enemy");
			}
			
			if(badguy.isDead() == true){
				System.out.println("\nEnemy Killed");
				guy.addKilled();
				System.out.println("\nA new enemy appears");
				badguy = new DefaultEnemy();
			}
			
			System.out.println("Enemy Turn");
			guy.reduceHealth(badguy.getDamage());
			System.out.println("The Enemy Attacks for " + badguy.getDamage() + "\nYou now have " + guy.getHealth() + " health");
		}
		System.out.println("\nYOU DIED");
		System.out.println("\nYou killed " + guy.getKilled() + " enemies");
	}
	public static void main(String[] args) {
		mockGame();
	}

}
