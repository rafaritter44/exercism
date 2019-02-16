import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PigLatinTranslator {

	private final List<Character> vowels;
	private final List<Character> consonants;

	public PigLatinTranslator() {
		vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');
		consonants = Arrays.asList('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v',
				'w', 'x', 'y', 'z');
	}

	public String translate(String phrase) {
		return words(phrase).map(this::translateWord).collect(Collectors.joining(" "));
	}

	private String translateWord(String word) {
		if (startsWithVowel(word) || word.startsWith("xr") || word.startsWith("yt"))
			return word + "ay";
		return movePrefixToTheEnd(word, consonantPrefix(word)) + "ay";
	}

	private String consonantPrefix(String word) {
		return quAfterConsonantClusterPrefix(word)
				.orElse(yAfterConsonantClusterPrefix(word).orElse(consonantClusterPrefix(word).get()));
	}

	private String movePrefixToTheEnd(String word, String prefix) {
		return word.substring(prefix.length()) + prefix;
	}

	private Stream<String> words(String phrase) {
		return Arrays.stream(phrase.split(" "));
	}

	private Optional<String> consonantClusterPrefix(String word) {
		return consonantClusterPrefix(word, "");
	}

	private Optional<String> consonantClusterPrefix(String word, String prefix) {
		if (word.isEmpty())
			return Optional.ofNullable(prefix);
		return isConsonant(word.charAt(0)) ? consonantClusterPrefix(word.substring(1), prefix + word.charAt(0))
				: Optional.ofNullable(prefix);
	}

	private Optional<String> yAfterConsonantClusterPrefix(String word) {
		StringBuilder prefix = new StringBuilder();
		for (char character : word.toCharArray()) {
			if (isVowel(character))
				return Optional.empty();
			if ('y' == character) {
				if (prefix.length() == 0)
					return Optional.empty();
				return Optional.of(prefix.toString());
			}
			if (isConsonant(character))
				prefix.append(character);
		}
		return Optional.empty();
	}

	private Optional<String> quAfterConsonantClusterPrefix(String word) {
		StringBuilder prefix = new StringBuilder();
		for (char character : word.toCharArray()) {
			if (isConsonant(character)) {
				prefix.append(character);
				continue;
			}
			if (isVowel(character)) {
				prefix.append(character);
				break;
			}
		}
		if (prefix.length() < 2)
			return Optional.empty();
		if ("qu".equals(prefix.substring(prefix.length() - 2)))
			return Optional.of(prefix.toString());
		return Optional.empty();
	}

	private boolean startsWithVowel(String word) {
		return isVowel(word.charAt(0));
	}

	private boolean isVowel(char character) {
		return vowels.contains(character);
	}

	private boolean isConsonant(char character) {
		return consonants.contains(character);
	}

}
