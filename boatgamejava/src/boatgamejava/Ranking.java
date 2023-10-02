package boatgamejava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ranking {
	
	public static void displayScore() {
	Scanner input;
		
		try {
			input = new Scanner(new File("topscore.txt"));
			System.out.println("Rankings");
			System.out.println("# of turns  |  Name");
			while(input.hasNext()) {
				System.out.printf("%-15d%-20s\n", input.nextInt(), input.next());
			}
			System.out.println("");
			if (input != null) {
				input.close();
			}
		}
		catch 
			 (FileNotFoundException fe) { 
				 System.out.println("Error opening file."); 
				 } 
		catch 
			(NoSuchElementException ex){
				 System.out.println("File improperly formed.");
				}
	}
}
