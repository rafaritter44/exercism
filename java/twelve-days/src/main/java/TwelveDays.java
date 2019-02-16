import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TwelveDays {
	
	private Map<Integer, String> gifts;
	private Map<Integer, String> cardinals;
	private Map<Integer, String> ordinals;
	
	public TwelveDays() {
		setUpGifts();
		setUpCardinals();
		setUpOrdinals();
	}
	
	String verse(int verseNumber) {
        return buildVersePrefix(verseNumber).concat(buildVerseSuffix(verseNumber));
    }

    String verses(int startVerse, int endVerse) {
        return IntStream.rangeClosed(startVerse, endVerse)
        		.mapToObj(this::verse)
        		.collect(Collectors.joining("\n"));
    }
    
    String sing() {
        return verses(1, 12);
    }
    
    private String buildVersePrefix(int verseNumber) {
    	return String.format("On the %s day of Christmas my true love gave to me: ", ordinals.get(verseNumber));
    }
    
    private String buildVerseSuffix(int verseNumber) {
    	switch(verseNumber) {
    	case 1: return format("%s %s.\n", verseNumber);
    	case 2: return format("%s %s, and ", verseNumber) + buildVerseSuffix(1);
    	default: return format("%s %s, ", verseNumber) + buildVerseSuffix(verseNumber - 1);
    	}
    }
    
    private String format(String format, int verseNumber) {
    	return String.format(format, cardinals.get(verseNumber), gifts.get(verseNumber));
    }
	
	private void setUpGifts() {
		gifts = new HashMap<>();
		gifts.put(1, "Partridge in a Pear Tree");
		gifts.put(2, "Turtle Doves");
		gifts.put(3, "French Hens");
		gifts.put(4, "Calling Birds");
		gifts.put(5, "Gold Rings");
		gifts.put(6, "Geese-a-Laying");
		gifts.put(7, "Swans-a-Swimming");
		gifts.put(8, "Maids-a-Milking");
		gifts.put(9, "Ladies Dancing");
		gifts.put(10, "Lords-a-Leaping");
		gifts.put(11, "Pipers Piping");
		gifts.put(12, "Drummers Drumming");
	}
	
	private void setUpCardinals() {
		cardinals = new HashMap<>();
		cardinals.put(1, "a");
		cardinals.put(2, "two");
		cardinals.put(3, "three");
		cardinals.put(4, "four");
		cardinals.put(5, "five");
		cardinals.put(6, "six");
		cardinals.put(7, "seven");
		cardinals.put(8, "eight");
		cardinals.put(9, "nine");
		cardinals.put(10, "ten");
		cardinals.put(11, "eleven");
		cardinals.put(12, "twelve");
	}
	
	private void setUpOrdinals() {
		ordinals = new HashMap<>();
		ordinals.put(1, "first");
		ordinals.put(2, "second");
		ordinals.put(3, "third");
		ordinals.put(4, "fourth");
		ordinals.put(5, "fifth");
		ordinals.put(6, "sixth");
		ordinals.put(7, "seventh");
		ordinals.put(8, "eighth");
		ordinals.put(9, "ninth");
		ordinals.put(10, "tenth");
		ordinals.put(11, "eleventh");
		ordinals.put(12, "twelfth");
	}
	
}
