package hu.elte.angry.nerdz.UNO.model.card;

/**
 * 
 * @author Peter Gerencser
 * 
 * Represents the color of the cards
 *
 */
public enum CardColor {
	YELLOW("yellow"), RED("red"), GREEN("green"), BLUE("blue"), BLACK("black");
	
	private final String stringRepresentation;
	
	/**
	 * CardColor constructor
	 * @param stringRepresentation
	 */
	private CardColor(String stringRepresentation) {
		this.stringRepresentation = stringRepresentation;
	}

	/**
	 * @return the stringRepresentation
	 */
	public String getStringRepresentation() {
		return stringRepresentation;
	}

	/**
	 * Looks up a CardColor by it's String representation
	 * @param value
	 * @return
	 */
	public static CardColor fromString(String value) {
		for(CardColor cardColor : CardColor.values()) {
			if(cardColor.stringRepresentation.equals(value)) {
				return cardColor;
			}
		}
		return null;
	}
}
