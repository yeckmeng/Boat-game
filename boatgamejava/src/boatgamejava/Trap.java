package boatgamejava;

import java.util.Random;

public class Trap extends ObjectInRiver{
	private static int strength;
	
	public Trap() {
		super("#");
		Random r = new Random();
		strength = 1 + r.nextInt(5);
		setLocation(r.nextInt(100));
	}
	public static void trap() {
		Player p1 = new Player(); 
		Player p2 = new Player();
		p1.setLocation(p1.getLocation() - strength);
		p2.setLocation(p2.getLocation() - strength);
		if(p1.getLocation() < 0) {
			p1.setLocation(0);
		}
		else if(p2.getLocation() < 0) {
			p2.setLocation(0);
		}
	}
	
	
}


