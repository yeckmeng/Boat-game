package boatgamejava;

import java.util.Random;

public class Current extends ObjectInRiver{
	private static int strength;

	public Current() {
		super("C");
		Random r = new Random();
		strength = 1 + r.nextInt(5);
		setLocation(r.nextInt(100));
	}
	public static void current() {
		Player p1 = new Player(); 
		Player p2 = new Player();
		p1.setLocation(p1.getLocation() + strength);
		p2.setLocation(p2.getLocation() + strength);

	}
}
	
