import java.util.Scanner;

public class Game {
	private Player player;
	private Enemy enemy;
	
	public Game(){
		player = new Player();
		enemy = new DefaultEnemy();
	}
	public void playGame(){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Game Start");
		while(player.isDead() == false){
			System.out.println("\nYour Turn");
			System.out.println("The Enemy has " + enemy.getHealth() + " health \nEnter 'attack' or 'a' to attack the Enemy");
			String input = sc.nextLine();
			
			if(input.equals("attack") || input.equals("a")){
				enemy.reduceHealth(player.getDamage());
				System.out.println("You did " + player.getDamage() + " to the enemy");
			}
			else if(input.equals("item") || input.equals("i")){
				if(player.getInventory().size() < 1)
					break;
				else
					player.useItem(0);
			}
			else if(input.equals("parry") || input.equals("p")){
				if(player.parry(enemy)){
					System.out.println("You successfully parried");
					enemy.reduceHealth(player.getDamage() * 2);
					System.out.println("You did " + player.getDamage() * 2 + " to the enemy");
				}
				else{
					System.out.println("Your parry failed!");
				}
			}
			
			if(enemy.isDead() == true){
				System.out.println("\nEnemy Killed");
				player.addKilled();
				player.getItem();
				System.out.println("\nA new enemy appears");
				enemy = new DefaultEnemy();
			}
			
			System.out.println("Enemy Turn");
			if(enemy.getCanAttack()){
				player.reduceHealth(enemy.getDamage());
				System.out.println("The Enemy Attacks for " + enemy.getDamage());
			}
			else{
				enemy.changeCanAttack();
			}
			System.out.println("\n" + player);
		}
		System.out.println("\nYOU DIED");
		System.out.println("\nYou killed " + player.getKilled() + " enemies");
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.playGame();

	}

}
