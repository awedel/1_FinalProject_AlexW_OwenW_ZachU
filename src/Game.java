import java.util.Scanner;

public class Game {
	private Player player;
	private Enemy enemy;
	
	public Game(){
		player = new Player();
		enemy = new SnakeDwarf();
	}
	public void playGame(){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Game Start");
		while(player.isDead() == false){
			System.out.println("\nYour Turn");
			System.out.println("The Enemy has " + enemy.getHealth() + " health \nEnter 'a' to attack, 'i' to use Item, and 'p' to parry");
			String input = sc.nextLine();
			
			if(input.equals("attack") || input.equals("a")){
				if(player.getCanAttack()){
					player.attack(enemy, 1);
					System.out.println("You did " + player.getDamage() + " to the enemy");
				}
				else{
					System.out.println("You cannot attack");
					player.changeCanAttack();
				}
			}
			else if(input.equals("item") || input.equals("i")){
				System.out.println("Enter item slot you want to use");
				int slot = sc.nextInt();
				if(player.isInventoryEmpty()){
					System.out.println("Your Inventory is empty");
					break;
				}
				else{
					if(player.getInventory(slot) instanceof HealthPotion)
						player.useItem(player.useInventory(slot));
					else
						enemy.useItem(player.useInventory(slot));
				}
			}
			else if(input.equals("parry") || input.equals("p")){
				if(player.parry(enemy)){
					System.out.println("You successfully parried");
					player.attack(enemy, 2);
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
				player.getNewWeapon();
				System.out.println("\nA new enemy appears");
				enemy = new DefaultEnemy();
			}
			
			System.out.println("Enemy Turn");
			if(enemy.getCanAttack()){
				enemy.attack(player,1);
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
	
	//main

	public static void main(String[] args) {
		Game game = new Game();
		game.playGame();

	}

}
