package boatgamejava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class Player {
	private String name;
	private int location;
	private int symbol;
	private int turns;
	private int dice;
	
	public Player(String name, int location, int symbol, int turns, int dice) {
		super();
		this.name = name;
		this.location = location;
		this.symbol = symbol;
		this.turns = turns;
		this.dice = dice;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public int getLocation() {
		return location;
	}
	
	public void setLocation(int l) {
		location = l;
	}
	
	public int getSymbol() {
		return symbol;
	}
	
	public void setSymbol(int symbol) {
		this.symbol = symbol;
	}
	
	
	public int getDice() {
		return dice;
	}
	
	public void setDice(int d) {
		dice = d;
	}
	
	public void roll() {
		Random r = new Random();
		dice = 1 + r.nextInt(6);
		System.out.printf("Dice rolled: %d\n",getDice());
		setLocation(getLocation() + getDice());
		System.out.printf("Turns: %d\n",getTurns());
		setTurns(getTurns() + 1);
	}
	
	

	
	public Player(int trn) {
		turns = trn;
	}
	public Player() {
		turns = 1;
	}
	
	public void setTurns(int trn) {
		turns = trn;
	}
	public int getTurns() {
		return turns;
	}
	
	public void addTurn() {
		setTurns(getTurns() + 1);
	}

	public void win() {
		Formatter output;
		try {
			File f = new File("topscore.txt");
			if(! f.exists()) {
				output = new Formatter(new File("topscore.txt"));	
				output.format("%d %s\r\n", turns, name);					
				output.close();	
			}
			else {
			PrintWriter out = new PrintWriter(new FileWriter(f, true));	
			out.append(turns + " " + name +"\r\n");					
			out.close();
			}
		}
		catch(IOException e){
	        System.out.println("COULD NOT LOG!!");
	    }
		catch(SecurityException se) {
			System.out.println("You do not have write access");
			System.exit(1);
		}
		catch(NoSuchElementException ex) {
			System.out.println("File improperly formed.");
		}
		Sort();
	}
	
	public void Sort() {
		try {
			FileReader fread = new FileReader("topscore.txt");
			BufferedReader bread = new BufferedReader(fread);
			
			List<String> l = new ArrayList<String>();
			String str;
			
			while((str = bread.readLine()) != null) {
				l.add(str);
			}
			bread.close();
			
			Collections.sort(l);
			
			FileWriter fwrite = new FileWriter("topscore.txt");
            BufferedWriter bwrite = new BufferedWriter(fwrite);
            for(String s: l){
                  bwrite.write(s);
                  bwrite.write("\n");
            }
            
            bwrite.close();
            System.out.println("\nSorted content has been written in file");
		}
		catch (FileNotFoundException e) {
			System.out.println("Error opening file."); 
		} 
		catch (IOException e) {
			System.out.println("Input/Output error occurred."); 
     }
		
		
	}

}


