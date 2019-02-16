import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class DiamondPrinter {
	
	private Map<Character, Integer> lengthOfLine;
	
	public DiamondPrinter() {
		lengthOfLine = new HashMap<>();
		setUp('A', 1);
	}
	
	private void setUp(char letter, int length) {
		if(letter > 'Z')
			return;
		lengthOfLine.put(letter, length);
		setUp((char) (letter + 1), length + 2);
	}
	
	List<String> printToList(char letter) {
        List<String> lines = new LinkedList<>();
        lines.add(buildLine(letter));
        buildLines(lines, (char) (letter - 1));
        return adjustLines(lines, lengthOfLine.get(letter));
    }
	
	private List<String> adjustLines(List<String> lines, int lengthOfLine) {
		return lines.parallelStream()
				.map(adjustLine(lengthOfLine))
				.collect(Collectors.toList());
	}
	
	private Function<String, String> adjustLine(int lengthOfLine) {
		return line -> adjustLine(line, lengthOfLine);
	}
	
	private String adjustLine(String line, int lengthOfLine) {
		if(line.length() == lengthOfLine)
			return line;
		return adjustLine(String.format(" %s ", line), lengthOfLine);
	}
	
	private List<String> buildLines(List<String> lines, char letter) {
		if(letter < 'A')
			return lines;
		addInStartAndEnd(lines, buildLine(letter));
		return buildLines(lines, (char) (letter - 1));
	}
	
	private void addInStartAndEnd(List<String> lines, String line) {
		lines.add(0, line);
		lines.add(line);
	}
	
	private String buildLine(char letter) {
		return buildLine(letter, String.valueOf(letter));
	}
	
	private String buildLine(char letter, String line) {
		if(line.length() == lengthOfLine.get(letter))
			return line;
		if(line.length() == lengthOfLine.get(letter) - 1)
			return line + letter;
		return buildLine(letter, line + " ");
	}
	
}
