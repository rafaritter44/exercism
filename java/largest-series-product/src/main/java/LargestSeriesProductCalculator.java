import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.LongStream;

public class LargestSeriesProductCalculator {
	
	private String inputNumber;
	
    public LargestSeriesProductCalculator(String inputNumber) {
        if(!onlyDigits(inputNumber))
        	throw new IllegalArgumentException("String to search may only contain digits.");
        this.inputNumber = inputNumber;
    }
    
    private Boolean onlyDigits(String input) {
    	return input.matches("[0-9]*");
    }

    public long calculateLargestProductForSeriesLength(int numberOfDigits) {
    	if(numberOfDigits == 0) return 1L;
        validateSeriesLength(numberOfDigits);
        return allSequences(inputNumber, numberOfDigits).stream()
        		.map(this::toLongStream)
        		.map(this::product)
        		.mapToLong(Long::valueOf)
        		.max()
        		.getAsLong();
    }
    
    private void validateSeriesLength(int numberOfDigits) {
    	if(isNegative(numberOfDigits))
        	throw new IllegalArgumentException("Series length must be non-negative.");
        if(numberOfDigits > inputNumber.length())
        	throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
    }
    
    private Boolean isNegative(int number) {
    	return number < 0;
    }
    
    private List<List<Integer>> allSequences(String digits, int length) {
    	return allSequences(digits, length, new ArrayList<>());
    }
    
    private List<List<Integer>> allSequences(String digits, int length, List<List<Integer>> result) {
    	if(length > digits.length()) return result;
    	result.add(take(digits, length));
    	return allSequences(digits.substring(1), length, result);
    }
    
    private List<Integer> take(String digits, int quantity) {
    	return take(digits.chars().map(Character::getNumericValue).iterator(), quantity, new ArrayList<>());
    }
    
    private List<Integer> take(Iterator<Integer> digits, int quantity, List<Integer> result) {
    	if(quantity == 0) return result;
    	result.add(digits.next());
    	return take(digits, quantity - 1, result);
    		
    }
    
    private LongStream toLongStream(List<Integer> integerList) {
    	return integerList.stream().mapToLong(Long::valueOf);
    }
    
    private Long product(LongStream numbers) {
    	return numbers.reduce(1L, (number1, number2) -> number1 * number2);
    }
    
}
