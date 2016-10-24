/**
 * 
 */
package hu.elte.angry.nerdz.UNO.model.card;

/**
 * @author Peter Gerencser
 *
 */
public class Card implements ICard {
	private CardColor color;
	private CardValue value;

	/**
	 * @param color
	 * @param value
	 */
	public Card(CardColor color, CardValue value) {
		super();
		this.color = color;
		this.value = value;
	}
	
	/* (non-Javadoc)
	 * @see hu.elte.angry.nerdz.UNO.model.card.ICard#getColor()
	 */
	@Override
	public CardColor getColor() {
		return color;
	}
	
	/* (non-Javadoc)
	 * @see hu.elte.angry.nerdz.UNO.model.card.ICard#getValue()
	 */
	@Override
	public CardValue getValue() {
		return value;
	}
	
	/* (non-Javadoc)
	 * @see hu.elte.angry.nerdz.UNO.model.card.ICard#matchingCard()
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Card [color=" + color + ", value=" + value + "]";
	}
}
