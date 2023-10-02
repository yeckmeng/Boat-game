package boatgamejava;

public class ObjectInRiver {
	private int location;
	private String symbol;

	public ObjectInRiver(String s) {
		symbol = s;
	}

	public int getLocation() {
		return location;
	}
	
	public void setLocation(int l) {
		this.location = l;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}
