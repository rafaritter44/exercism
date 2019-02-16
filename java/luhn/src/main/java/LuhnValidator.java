import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LuhnValidator {
	
	private Predicate<Integer> divisibleBy10;
	private Predicate<String> shorterThan2;
	
	public LuhnValidator() {
		this.divisibleBy10 = dividend -> divisibleBy(dividend, 10);
		this.shorterThan2 = string -> shorterThan(string, 2);
	}

    public Boolean isValid(String candidate) {
    	if(!onlyDigits(candidate = removeSpacesFrom(candidate)) || shorterThan2.test(candidate)) {
    		return false;
    	}
        List<Integer> digitsList = toDigitsList(reverse(candidate));
        List<Integer> everySecondDigit =
        		everySecondDigitOf(digitsList).stream()
        		.map(this::oneDigitDoubleOf)
        		.collect(Collectors.toList());
        Integer sum = sumOf(everySecondDigit, remainingFromEverySecondDigitOf(digitsList));
        return divisibleBy10.test(sum);
    }
    
    private Boolean shorterThan(String string, int minimumLength) {
    	return string.length() < minimumLength;
    }
    
    private String reverse(String string) {
    	return new StringBuilder(string).reverse().toString();
    }
    
    private Boolean onlyDigits(String string) {
    	return string.matches("[0-9]+");
    }
    
    private String removeSpacesFrom(String string) {
    	return string.replace(" ", "");
    }
    
    private Integer sumOf(List<Integer> firstNumbersList, List<Integer> secondNumbersList) {
    	return Stream.concat(firstNumbersList.stream(), secondNumbersList.stream())
    			.mapToInt(Integer::intValue)
    			.sum();
    }
    
    private Boolean divisibleBy(int dividend, int divisor) {
    	return dividend % divisor == 0;
    }
    
    private static List<Integer> toDigitsList(String digits) {
    	return digits.chars()
    			.map(Character::getNumericValue)
    			.boxed()
    			.collect(Collectors.toList());
    }
    
    private List<Integer> remainingFromEverySecondDigitOf(List<Integer> digits) {
    	return remainingFromEverySecondDigitOf(digits.iterator(), new ArrayList<>());
    }
    
    private List<Integer> remainingFromEverySecondDigitOf(Iterator<Integer> digits, List<Integer> result) {
    	if(digits.hasNext()) {
    		result.add(digits.next());
    	}
    	if(digits.hasNext()) {
    		digits.next();
    		return remainingFromEverySecondDigitOf(digits, result);
    	}
    	return result;
    }
    
    private List<Integer> everySecondDigitOf(List<Integer> digits) {
    	return everySecondDigitOf(digits.iterator(), new ArrayList<>());
    }
    
    private List<Integer> everySecondDigitOf(Iterator<Integer> digits, List<Integer> result) {
    	if(!digits.hasNext()) {
    		return result;
    	}
    	digits.next();
    	if(!digits.hasNext()) {
    		return result;
    	}
    	result.add(digits.next());
    	return everySecondDigitOf(digits, result);
    }
    
    private int oneDigitDoubleOf(int number) {
    	return toOneDigit(doubleOf(number));
    }
    
    private int toOneDigit(int number) {
    	return number > 9
    			? number - 9
    			: number;
    }
    
    private int doubleOf(int number) {
    	return number * 2;
    }

}
