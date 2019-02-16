import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class House {
	
	private Map<Integer, String> items;
	private Map<Integer, String> predicates;

	public House() {
		setUpItems();
		setUpPredicates();
	}
	
	public String verse(int verseNumber) {
		return String.format("This is %s", buildVerse(verseNumber));
	}
	
	private String buildVerse(int count) {
		if(count == 1)
			return String.format("%s %s.", items.get(count), predicates.get(count));
		else
			return String.format("%s %s ", items.get(count), predicates.get(count)) + buildVerse(count - 1);
	}
	
	public String verses(int startVerse, int endVerse) {
		return IntStream.rangeClosed(startVerse, endVerse)
				.mapToObj(this::verse)
				.collect(Collectors.joining("\n"));
	}
	
	public String sing() {
		return verses(1, 12);
	}
	
	private void setUpItems() {
		items = new HashMap<>();
		items.put(1, "the house");
		items.put(2, "the malt");
		items.put(3, "the rat");
		items.put(4, "the cat");
		items.put(5, "the dog");
		items.put(6, "the cow with the crumpled horn");
		items.put(7, "the maiden all forlorn");
		items.put(8, "the man all tattered and torn");
		items.put(9, "the priest all shaven and shorn");
		items.put(10, "the rooster that crowed in the morn");
		items.put(11, "the farmer sowing his corn");
		items.put(12, "the horse and the hound and the horn");
	}
	
	private void setUpPredicates() {
		predicates = new HashMap<>();
		predicates.put(1, "that Jack built");
		predicates.put(2, "that lay in");
		predicates.put(3, "that ate");
		predicates.put(4, "that killed");
		predicates.put(5, "that worried");
		predicates.put(6, "that tossed");
		predicates.put(7, "that milked");
		predicates.put(8, "that kissed");
		predicates.put(9, "that married");
		predicates.put(10, "that woke");
		predicates.put(11, "that kept");
		predicates.put(12, "that belonged to");
	}

}
