import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class Anagram {

	private final String word;

	public Anagram(String word) {
		this.word = word.toLowerCase();
	}

	public List<String> match(List<String> candidates) {
		return candidates.stream().filter(this::isAnagram).collect(Collectors.toList());
	}

	private boolean isAnagram(String candidate) {
		if (word.length() != candidate.length() || word.equals(candidate = candidate.toLowerCase()))
			return false;
		Map<Integer, Integer> wordCharsOccurrences = new HashMap<>();
		Map<Integer, Integer> candidateCharsOccurrences = new HashMap<>();
		word.chars().forEach(incrementCount(wordCharsOccurrences));
		candidate.chars().forEach(incrementCount(candidateCharsOccurrences));
		return wordCharsOccurrences.equals(candidateCharsOccurrences);
	}

	private IntConsumer incrementCount(Map<Integer, Integer> map) {
		return key -> {
			Optional<Integer> value = Optional.ofNullable(map.get(key));
			map.put(key, value.orElse(0) + 1);
		};
	}

}
