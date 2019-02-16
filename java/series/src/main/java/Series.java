import java.util.ArrayList;
import java.util.List;

public class Series {
	
	private String digits;
	
	public Series(String digits) {
		this.digits = digits;
	}
	
	public List<String> slices(int length) {
		validateLength(length);
		return slices(length, digits, new ArrayList<>());
	}
	
	private void validateLength(int length) {
		if(length < 1) throw new IllegalArgumentException("Slice size is too small.");
		if(length > digits.length()) throw new IllegalArgumentException("Slice size is too big.");
	}
	
	private List<String> slices(int length, String string, List<String> result) {
		if(string.length() < length) return result;
		result.add(takeFirst(length, string));
		return slices(length, string.substring(1), result);
	}
	
	private String takeFirst(int characters, String string) {
		return string.substring(0, characters);
	}

}
