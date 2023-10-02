package boatgamejava;

import java.util.Scanner;

public class Game {
	private River River;
	private int option = -1;
	Scanner input = new Scanner(System.in);
	
	public Game() {
		River = new River();
	}

	public void start() {
		while (option != 3) {
			System.out.println("Option 1: Play the game");
			System.out.println("Option 2: View ranking");
			System.out.println("Option 3: Exit");
			System.out.println("Enter option: ");
			option = input.nextInt();
			if (option != 3) {
				switch(option) {
				case 1: 
					River.displayRiver();
				case 2:
					Ranking.displayScore();
					
				default:
					System.out.println("Please enter only numbers from 1-3!");
				}
			}		
		}
		System.out.println("Thank you for playing!");
	}
}
