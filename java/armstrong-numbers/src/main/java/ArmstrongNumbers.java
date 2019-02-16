import java.util.Arrays;
import java.util.stream.IntStream;

class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {
		return numberToCheck == digits(numberToCheck)
				.map(digit -> (int) Math.pow(digit, numberOfDigits(numberToCheck)))
				.sum();
	}

	private IntStream digits(int number) {
		return Arrays.stream(String.valueOf(number).split("")).mapToInt(Integer::parseInt);
	}

	private int numberOfDigits(int number) {
		return String.valueOf(number).length();
	}

}
