import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PangramChecker {

	private Stream<Character> alphabet;

	public PangramChecker() {
		alphabet = toCharStream(IntStream.rangeClosed('a', 'z'));
	}

	public boolean isPangram(String input) {
		return alphabet.allMatch(letters(input)::contains);
	}

	private List<Character> letters(String phrase) {
		return toCharStream(phrase.chars())
				.map(Character::toLowerCase)
				.collect(Collectors.toList());
	}

	private Stream<Character> toCharStream(IntStream intStream) {
		return intStream.mapToObj(letter -> (char) letter);
	}

}
