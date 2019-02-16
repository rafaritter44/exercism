import java.util.function.Predicate;

class RaindropConverter {

	private String output;
	
    String convert(int number) {
    	output = "";
    	Predicate<Integer> hasAsFactor = hasAsFactor(number);
		return hasAsFactor.test(3) | hasAsFactor.test(5) | hasAsFactor.test(7)
				? output : String.valueOf(number);
    }
    
    private Predicate<Integer> hasAsFactor(int number) {
    	return factor -> {
    		boolean hasAsFactor = number % factor == 0;
    		if(hasAsFactor)
    			output += toWord(factor);
    		return hasAsFactor;
    	};
    }
    
    private String toWord(int number) {
    	switch(number) {
    		case 3: return "Pling";
    		case 5: return "Plang";
    		case 7: return "Plong";
    		default: return "";
    	}
    }

}
