package hu.elte.angry.nerdz.UNO.model.card;

/**
 * 
 * @author Peter Gerencser
 * 
 * Represents the value of the cards
 *
 */
public enum CardValue {
	// ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE;
	ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9);

	private final int value;

	CardValue(int value) {
		this.value = value;
	}

	private int getValue() {
		return value;
	}
}
