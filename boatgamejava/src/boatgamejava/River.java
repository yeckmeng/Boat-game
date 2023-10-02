package boatgamejava;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class River {
	private ArrayList<ObjectInRiver> Riverlist = new ArrayList<ObjectInRiver>();
	private int rounds;
	
	
	public River() {
		Random r = new Random();
		int no_of_current = r.nextInt(20);
		int no_of_trap = r.nextInt(20);
	
	
		for (int i = 0; i < no_of_current; i++) {
			Riverlist.add(new Current());
		}
		
		for (int i = 0; i < no_of_trap; i++) {
			Riverlist.add(new Trap());
		}
	}
	public void setRounds(int rnd) {
		rounds = rnd;
	}
	public int getRounds() {
		return rounds;
	}
	public void addRounds() {
		setRounds(getRounds() + 1);
	}
	
	public void displayRiver() {
		Player p1 = new Player("",0,1,1,0); 
		Player p2 = new Player("",0,2,1,0);
		System.out.println("Player 1's name: ");
		Scanner player1input = new Scanner(System.in);
		String p1name = player1input.next();
		p1.setName(p1name);
		System.out.println("Player 2's name: ");
		Scanner player2input = new Scanner(System.in);
		String p2name = player2input.next();
		p2.setName(p2name);
		setRounds(1);
		while(p1.getLocation() < 100 && p2.getLocation() < 100) {
			
			for (int i = 0; i < 100 ; i++) {
				System.out.print("=");
			}
			System.out.println();
			System.out.println();
			for (int i = 0; i < 100 ; i++) {
				boolean objectPresent = false;
				for (ObjectInRiver r:Riverlist) {
					if (r.getLocation() == i) {
						objectPresent = true;
						System.out.print(r.getSymbol());
						if(p1.getLocation() == r.getLocation()) {
							if(r.getSymbol().equals("#")) {
								Trap.trap();
								System.out.print("[Collision has occured]");
							}
							if(r.getSymbol().equals("C")) {
								Current.current();
								System.out.print("[Collision has occured]");
							}
						}
						if(p2.getLocation() == r.getLocation()) {
							if(r.getSymbol().equals("#")) {
								Trap.trap();
								System.out.print("[Collision has occured]");
							}
							if(r.getSymbol().equals("C")) {
								Current.current();
								System.out.print("[Collision has occured]");
							}
						}
					}
				}
				if(p1.getLocation() == i) {
					System.out.print(p1.getSymbol());
				}
				if(p2.getLocation() == i) {
					System.out.print(p2.getSymbol());
				}
				if (! objectPresent) {
					System.out.print(" ");
				}
			}
			System.out.println();
			System.out.println();
			for (int i = 0; i < 100 ; i++) {
				System.out.print("=");
			}
			
			if(getRounds()%2 == 1) {
				System.out.printf("\n%s's turn to roll\n",p1name);
				System.out.println("Type 'r' to roll the dice");
				Scanner input = new Scanner(System.in);
				if(input.next().equals("r")) {
					p1.roll();
					addRounds();
				}
			}
			for (int i = 0; i < 100 ; i++) {
				System.out.print("=");
			}
			System.out.println();
			System.out.println();
			for (int i = 0; i < 100 ; i++) {
				boolean objectPresent = false;
				for (ObjectInRiver r:Riverlist) {
					if (r.getLocation() == i) {
						objectPresent = true;
						System.out.print(r.getSymbol());
						if(p1.getLocation() == r.getLocation()) {
							if(r.getSymbol().equals("#")) {
								Trap.trap();
								System.out.print("[Collision has occured]");
							}
							if(r.getSymbol().equals("C")) {
								Current.current();
								System.out.print("[Collision has occured]");
							}
						}
						if(p2.getLocation() == r.getLocation()) {
							if(r.getSymbol().equals("#")) {
								Trap.trap();
								System.out.print("[Collision has occured]");
							}
							if(r.getSymbol().equals("C")) {
								Current.current();
								System.out.print("[Collision has occured]");
							}
						}
					}
				}
				if(p1.getLocation() == i) {
					System.out.print(p1.getSymbol());
				}
				if(p2.getLocation() == i) {
					System.out.print(p2.getSymbol());
				}
				if (! objectPresent) {
					System.out.print(" ");
				}
			}
			System.out.println();
			System.out.println();
			for (int i = 0; i < 100 ; i++) {
				System.out.print("=");
			}
			
			if(getRounds()%2 == 0) {
				System.out.printf("\n%s's turn to roll\n",p2name);
				System.out.println("Type 'r' to roll the dice");
				Scanner input = new Scanner(System.in);
				if(input.next().equals("r")) {
					p2.roll();
					addRounds();
				}
			}
		
		}
			if(p1.getLocation() > 99) {
			System.out.printf("Congratulations %s for winning!\n",p1.getName());
			p1.win();
		}
		if(p2.getLocation() > 99) {
			System.out.printf("Congratulations %s for winning!\n",p2.getName());
			p2.win();
		}

		
	}
	

}

