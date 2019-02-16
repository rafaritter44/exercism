import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Proverb {
	
	private static class Line {
    	String firstWord, secondWord;
    	
    	Line(String firstWord, String secondWord) {
    		this.firstWord = firstWord;
    		this.secondWord = secondWord;
    	}
    }

	private List<Line> lines;
	private Optional<String> lastLine;
	
    Proverb(String[] words) {
    	lines = new LinkedList<>();
    	setUp(reverse(words));
    }
    
    String recite() {
    	return lines.stream()
    			.map(this::buildRegularLine)
    			.collect(Collectors.joining())
    			.concat(lastLine.orElse(""));
    }
    
    private String buildRegularLine(Line line) {
    	return String.format("For want of a %s the %s was lost.\n", line.firstWord, line.secondWord);
    }
    
    private String buildLastLine(String word) {
    	return String.format("And all for the want of a %s.", word);
    }
    
    private void setUp(String... words) {
    	if(words.length == 0)
    		lastLine = Optional.empty();
    	else if(words.length == 1)
    		lastLine = Optional.of(buildLastLine(words[0]));
    	else {
    		addInTheBeginning(new Line(words[1], words[0]));
    		setUp(nextSubArray(words));
    	}
    }
    
    private String[] nextSubArray(String[] array) {
    	return Arrays.copyOfRange(array, 1, array.length);
    }
    
    private void addInTheBeginning(Line line) {
    	lines.add(0, line);
    }
    
    @SuppressWarnings("unchecked")
	private <T> T[] reverse(T[] array) {
    	List<T> list = Arrays.asList(array);
    	Collections.reverse(list);
    	return (T[]) list.toArray();
    }

}
