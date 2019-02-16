import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ProteinTranslator {
	
	private Map<String, String> translation;
	private static final int CODON_LENGTH = 3;
	
	public ProteinTranslator() {
		translation = new HashMap<>();
		translation.put("AUG", "Methionine");
		translation.put("UUU", "Phenylalanine");
		translation.put("UUC", "Phenylalanine");
		translation.put("UUA", "Leucine");
		translation.put("UUG", "Leucine");
		translation.put("UCU", "Serine");
		translation.put("UCC", "Serine");
		translation.put("UCA", "Serine");
		translation.put("UCG", "Serine");
		translation.put("UAU", "Tyrosine");
		translation.put("UAC", "Tyrosine");
		translation.put("UGU", "Cysteine");
		translation.put("UGC", "Cysteine");
		translation.put("UGG", "Tryptophan");
		translation.put("UAA", "STOP");
		translation.put("UAG", "STOP");
		translation.put("UGA", "STOP");
	}

    public List<String> translate(String rnaSequence) {
        return takeWhile(protein -> !"STOP".equals(protein),
        		asCodons(rnaSequence)
        		.map(translation::get)
        		.iterator());
    }
    
    private <T> List<T> takeWhile(Predicate<T> condition, Iterator<T> elements) {
    	List<T> included = new ArrayList<>();
    	return takeWhile(condition, elements, included);
    }
    
    private <T> List<T> takeWhile(Predicate<T> condition, Iterator<T> elements, List<T> included) {
    	T next;
    	if(elements.hasNext() && condition.test(next = elements.next())) {
    		included.add(next);
    		return takeWhile(condition, elements, included);
    	}
    	return included;
    }
    
    private Stream<String> asCodons(String rnaSequence) {
    	if(rnaSequence.length() < CODON_LENGTH)
    		return Stream.empty();
    	return Stream.concat(
    			Stream.of(firstCodonOf(rnaSequence)),
    			asCodons(remainingCodonsOf(rnaSequence)));
    }
    
    private String firstCodonOf(String rnaSequence) {
    	return rnaSequence.substring(0, CODON_LENGTH);
    }
    
    private String remainingCodonsOf(String rnaSequence) {
    	return rnaSequence.substring(CODON_LENGTH);
    }
    
}