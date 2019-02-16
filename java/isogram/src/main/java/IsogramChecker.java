import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class IsogramChecker {

	private static final List<Character> ALLOWED_TO_REPEAT = Arrays.asList(' ', '-');

	boolean isIsogram(String phrase) {
		Set<Character> charactersInPhrase = new HashSet<>();
		for (char character : phrase.toCharArray()) {
			if (ALLOWED_TO_REPEAT.contains(character))
				continue;
			if (!charactersInPhrase.add(Character.toLowerCase(character)))
				return false;
		}
		return true;
	}

}
