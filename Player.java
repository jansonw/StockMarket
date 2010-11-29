
public class Player {
	private String name;
	private int cash;
	
	public Player(String name) {
		this.name = name;
		cash = 0;
	}
	
	public void incrementCash(int amount) {
		cash += amount;
	}
	
	public void decrementCash(int amount) {
		cash -= amount;
	}

	public String getName() {
		return name;
	}

	public int getCash() {
		return cash;
	}
	
	
}
