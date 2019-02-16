import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

class Acronym {

	private static final Function<String, String> FIRST_CHAR = string -> string.substring(0, 1);
	private String phrase;

	Acronym(String phrase) {
		this.phrase = phrase;
	}

	String get() {
		return Arrays.stream(phrase.split(" |-"))
				.filter(string -> !string.isEmpty())
				.map(FIRST_CHAR.andThen(String::toUpperCase))
				.collect(Collectors.joining());
	}

}
