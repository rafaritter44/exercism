class Hamming {

	private String leftStrand, rightStrand;

	Hamming(String leftStrand, String rightStrand) {
		if (leftStrand.length() != rightStrand.length())
			throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
		this.leftStrand = leftStrand;
		this.rightStrand = rightStrand;
	}

	int getHammingDistance() {
		return getHammingDistance(leftStrand, rightStrand);
	}

	private int getHammingDistance(String leftStrand, String rightStrand) {
		if (leftStrand.isEmpty())
			return 0;
		return (sameFirstChar(leftStrand, rightStrand) ? 0 : 1)
				+ getHammingDistance(leftStrand.substring(1), rightStrand.substring(1));
	}

	private boolean sameFirstChar(String leftStrand, String rightStrand) {
		return leftStrand.charAt(0) == rightStrand.charAt(0);
	}

}
