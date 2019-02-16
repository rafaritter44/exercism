import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class RnaTranscription {

	private Map<String, String> transcription;

	public RnaTranscription() {
		transcription = new HashMap<>();
		transcription.put("G", "C");
		transcription.put("C", "G");
		transcription.put("T", "A");
		transcription.put("A", "U");
	}

	String transcribe(String dnaStrand) {
		return chars(dnaStrand)
				.map(transcription::get)
				.collect(Collectors.joining());
	}

	private Stream<String> chars(String string) {
		return string.chars().mapToObj(character -> String.valueOf((char) character));
	}

}
