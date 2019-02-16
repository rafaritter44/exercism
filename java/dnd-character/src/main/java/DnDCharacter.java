import java.util.Random;
import java.util.stream.IntStream;

public class DnDCharacter {
	
	private Random random;
	private int strength;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int wisdom;
	private int charisma;
	
	public DnDCharacter() {
		random = new Random();
		strength = ability();
		dexterity = ability();
		constitution = ability();
		intelligence = ability();
		wisdom = ability();
		charisma = ability();
	}

    public int ability() {
        return IntStream.generate(this::rollDice)
        		.limit(4L)
        		.sorted()
        		.skip(1L)
        		.sum();
    }
    
    private int rollDice() {
    	return random.nextInt(6) + 1;
    }

    public int modifier(int input) {
        return Math.floorDiv((input - 10), 2);
    }
    
    public int getStrength() {
    	return strength;
    }
    
    public int getDexterity() {
    	return dexterity;
    }
    
    public int getConstitution() {
    	return constitution;
    }
    
    public int getIntelligence() {
    	return intelligence;
    }
    
    public int getWisdom() {
    	return wisdom;
    }
    
    public int getCharisma() {
    	return charisma;
    }
    
    public int getHitpoints() {
    	return 10 + modifier(constitution);
    }

}
