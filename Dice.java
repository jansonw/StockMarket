import java.util.Random;


public class Dice {
	
	private final int NUM_SIDES = 6;
	private Random gen;
	
	public Dice() {
		gen = new Random();		
	}
	
	public int rollOne() {
		return gen.nextInt(NUM_SIDES) + 1;
	}
	
	public Pair rollTwo() {
		return new Pair(rollOne(), rollOne());
	}
}
