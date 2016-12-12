package hu.elte.angry.nerdz.UNO.view.card;

import java.awt.Color;

/**
 * 
 * @author Peter Gerencser
 * 
 * Represents the color of the cards (on the ui)
 *
 */
public enum CardColor {
	YELLOW(Color.YELLOW), RED(Color.RED), GREEN(Color.GREEN), BLUE(Color.BLUE), BLACK(Color.BLACK);
	
	private final Color awtColor;
	
	/**
	 * CardColor constructor
	 * @param awtColor
	 */
	private CardColor(Color awtColor) {
		this.awtColor = awtColor;
	}
	
	/**
	 * @return the awtColor
	 */
	public Color getAwtColor() {
		return awtColor;
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