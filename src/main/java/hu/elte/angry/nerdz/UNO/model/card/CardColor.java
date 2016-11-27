package hu.elte.angry.nerdz.UNO.model.card;

import java.awt.Color;

/**
 * 
 * @author Peter Gerencser
 * 
 * Represents the color of the cards
 *
 */
public enum CardColor {
	YELLOW("yellow", Color.YELLOW), RED("red", Color.RED), GREEN("green", Color.GREEN), BLUE("blue", Color.BLUE), BLACK("black", Color.BLACK);
	
	private final String stringRepresentation;
	private final Color awtColor;
	
	/**
	 * CardColor constructor
	 * @param stringRepresentation
	 * @param awtColor
	 */
	private CardColor(String stringRepresentation, Color awtColor) {
		this.stringRepresentation = stringRepresentation;
		this.awtColor = awtColor;
	}

	/**
	 * @return the stringRepresentation
	 */
	public String getStringRepresentation() {
		return stringRepresentation;
	}
	
	/**
	 * @return the awtColor
	 */
	public Color getAwtColor() {
		return awtColor;
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
	
	/**
	 * Looks up a CardColor by it's awt color value
	 * @param value
	 * @return
	 */
	public static CardColor fromAwtColor(Color color) {
		for(CardColor cardColor : CardColor.values()) {
			if(cardColor.awtColor.equals(color)) {
				return cardColor;
			}
		}
		return null;
	}
}
