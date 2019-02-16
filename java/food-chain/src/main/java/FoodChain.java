import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FoodChain {

	private Map<Integer, String> animals;
	private Map<Integer, String> rhymes;
	private String verseEnding;
	
	public FoodChain() {
		setUpAnimals();
		setUpRhymes();
		verseEnding = "I don't know why she swallowed the fly. Perhaps she'll die.";
	}

	public String verse(int verse) {
		return verseBeginning(verse) + (verse == 8 ? ""
				: verseMiddle(verse) + verseEnding)
				.replaceFirst("spider\\.", "spider that wriggled and jiggled and tickled inside her.");
	}
	
	public String verses(int startVerse, int endVerse) {
		return IntStream.rangeClosed(startVerse, endVerse)
				.mapToObj(this::verse)
				.collect(Collectors.joining("\n\n"));
	}
	
	private String verseMiddle(int verse) {
		if(verse == 1) return "";
		else return String.format("She swallowed the %s to catch the %s.\n",
				animals.get(verse), animals.get(verse - 1)) + verseMiddle(verse - 1);
	}
	
	private String verseBeginning(int verse) {
		return String.format("I know an old lady who swallowed a %s.\n%s", animals.get(verse), rhymes.get(verse));
	}
	
	private void setUpAnimals() {
		animals = new HashMap<>();
		animals.put(1, "fly");
		animals.put(2, "spider");
		animals.put(3, "bird");
		animals.put(4, "cat");
		animals.put(5, "dog");
		animals.put(6, "goat");
		animals.put(7, "cow");
		animals.put(8, "horse");
	}
	
	private void setUpRhymes() {
		rhymes = new HashMap<>();
		rhymes.put(1, "");
		rhymes.put(2, "It wriggled and jiggled and tickled inside her.\n");
		rhymes.put(3, "How absurd to swallow a bird!\n");
		rhymes.put(4, "Imagine that, to swallow a cat!\n");
		rhymes.put(5, "What a hog, to swallow a dog!\n");
		rhymes.put(6, "Just opened her throat and swallowed a goat!\n");
		rhymes.put(7, "I don't know how she swallowed a cow!\n");
		rhymes.put(8, "She's dead, of course!");
	}

}
