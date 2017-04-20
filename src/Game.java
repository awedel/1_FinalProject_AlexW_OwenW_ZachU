//for testing in console
import java.util.Scanner;

public class Game {
	private Player player;
	private Enemy enemy;
	
	public Game(){
		player = new Player();
		enemy = new SnakeDwarf(0);
	}
	public void playGame(){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Game Start");
		
		System.out.println("Enter 1 for Health Potion or Enter 2 for Bomb");
		int firstItem = sc.nextInt();
		if(firstItem == 1)
			new HealthPotion().addToInventory(player);
		else
			new Bomb().addToInventory(player);
		sc.nextLine();
		
		while(player.isDead() == false){
			if(enemy.isDead() == true){
				System.out.println("\n" + enemy.getName() + " Killed");
				player.levelHealth();
				player.addKilled();
				player.getItem();
				player.getNewWeapon();
				enemy = player.getNewEnemy();
				System.out.println("\nA new enemy appears\n" + enemy);
			}
			System.out.println("\n" + player + "\nYour Turn");
			System.out.println(enemy + "\nEnter 'a' to attack, 'i' to use Item, and 'p' to parry");
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
				if(!(player.getCanAttack()))
					player.changeCanAttack();
				System.out.println("Enter item slot you want to use");
				int slot = sc.nextInt();
				if(player.isInventoryEmpty()){
					System.out.println("Your Inventory is empty");
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
			System.out.println("Enemy Turn");
			if(enemy.getCanAttack()){
				enemy.attack(player,1);
				System.out.println("attacks for " + enemy.getDamage());
			}
			else{
				enemy.changeCanAttack();
			}
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
