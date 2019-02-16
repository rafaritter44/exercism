import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Scrabble {
	
	private Map<Character, Integer> letterValues;
	private String word;

    public Scrabble(String word) {
    	initializeLetterValues();
    	this.word = word;
    }
    
    private void initializeLetterValues() {
    	letterValues = new HashMap<>();
    	setLetterValue(1,
    			'a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't',
    			'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T');
    	setLetterValue(2,
    			'd', 'g',
    			'D', 'G');
    	setLetterValue(3,
    			'b', 'c', 'm', 'p',
    			'B', 'C', 'M', 'P');
    	setLetterValue(4,
    			'f', 'h', 'v', 'w', 'y',
    			'F', 'H', 'V', 'W', 'Y');
    	setLetterValue(5,
    			'k',
    			'K');
    	setLetterValue(8,
    			'j', 'x',
    			'J', 'X');
    	setLetterValue(10,
    			'q', 'z',
    			'Q', 'Z');
    }
    
    private void setLetterValue(Integer value, Character... letters) {
    	Stream.of(letters).forEach(letter -> letterValues.put(letter, value));
    }

    public int getScore() {
        return word.chars()
        		.map(letter -> letterValues.get((char) letter))
        		.sum();
    }

}
