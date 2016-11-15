package hu.elte.angry.nerdz.UNO.model.card;

/**
 * 
 * @author Peter Gerencser
 * 
 * Represents the value of the cards
 *
 */
public enum CardValue {
	//ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE;
	ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9);

	private final int integerRepresentation;

	CardValue(int integerRepresentation) {
		this.integerRepresentation = integerRepresentation;
	}
	
	/**
	 * @return the integerRepresentation
	 */
	public int getIntegerRepresentation() {
		return integerRepresentation;
	}

	/**
	 * Looks up a CardValue by it's integer representation
	 * @param value
	 * @return
	 */
	public static CardValue fromInt(int value) {
		for(CardValue cardValue : CardValue.values()) {
			if(cardValue.getIntegerRepresentation() == value) {
				return cardValue;
			}
		}
		return null;
	}

}
