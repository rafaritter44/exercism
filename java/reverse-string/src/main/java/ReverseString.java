import java.util.function.BinaryOperator;
import java.util.stream.Stream;

class ReverseString {
	
	private static final BinaryOperator<String> REVERSE = (first, second) -> second + first;

    String reverse(String inputString) {
        return chars(inputString).reduce(REVERSE).orElse("");
    }
    
    private Stream<String> chars(String inputString) {
    	return inputString.chars().mapToObj(character -> String.valueOf((char) character));
    }
  
}