import java.util.Scanner;
public class Test {
	public void mockGame(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Game Start");
		Player guy = new Player();
		while(guy.getHealth() < 0){
			System.out.println("Enter 'attack' to attack the Enemy");
			String input = sc.nextLine();
			if(input == "attack"){
				
			}
		}
	}
	public static void main(String[] args) {
		

	}

}
