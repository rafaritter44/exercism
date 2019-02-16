public class Bob {

	private final String SURE;
	private final String CHILL_OUT;
	private final String CALM_DOWN;
	private final String FINE;
	private final String WHATEVER;

	public Bob() {
		SURE = "Sure.";
		CHILL_OUT = "Whoa, chill out!";
		CALM_DOWN = "Calm down, I know what I'm doing!";
		FINE = "Fine. Be that way!";
		WHATEVER = "Whatever.";
	}

	public String hey(String phrase) {
		phrase = phrase.trim();
		if (phrase.isEmpty())
			return FINE;
		if (isQuestion(phrase) && isYelling(phrase))
			return CALM_DOWN;
		if (isQuestion(phrase))
			return SURE;
		if (isYelling(phrase))
			return CHILL_OUT;
		return WHATEVER;
	}

	private boolean isQuestion(String phrase) {
		return phrase.endsWith("?");
	}

	private boolean isYelling(String phrase) {
		return phrase.chars().anyMatch(Character::isLetter)
				&& phrase.chars()
				.filter(Character::isLetter)
				.allMatch(Character::isUpperCase);
	}

}
