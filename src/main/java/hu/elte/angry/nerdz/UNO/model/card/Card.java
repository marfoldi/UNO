package hu.elte.angry.nerdz.UNO.model.card;

/**
 * 
 * @author Peter Gerencser
 * 
 * Default implementation for the ICard.
 * This Card implementation can be used in the game of UNO.
 *
 */
public class Card implements ICard {
	private CardValue value;
	private CardColor color;

	public Card(CardValue value, CardColor color) {
		this.value = value;
		this.color = color;
	}

	/**
	 * Gets the value of the card
	 * @return
	 */
	@Override
	public CardValue getValue() {
		return value;
	}

	/**
	 * Gets the color of the card
	 * @return
	 */
	@Override
	public CardColor getColor() {
		return color;
	}

	/**
	 * Determines if the card can be placed on top of the parameter card
	 * @param card
	 * @return
	 */
	@Override
	public boolean matchingCard(ICard card) {
		if (!(card instanceof Card)) {
			return false;
		}
		
		boolean colorCheck = color.equals(card.getColor());
		boolean valueCheck = value.equals(card.getValue());
		
		return colorCheck || valueCheck;
	}

}
