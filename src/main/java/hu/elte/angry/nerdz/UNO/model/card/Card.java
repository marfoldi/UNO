/**
 * 
 */
package hu.elte.angry.nerdz.UNO.model.card;

/**
 * @author gpeter1009
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
	 * @see hu.elte.angry.nerdz.UNO.model.card.ICard#setColor(hu.elte.angry.nerdz.UNO.model.card.CardColor)
	 */
	@Override
	public void setColor(CardColor color) {
		this.color = color;
	}
	
	/* (non-Javadoc)
	 * @see hu.elte.angry.nerdz.UNO.model.card.ICard#getColor()
	 */
	@Override
	public CardColor getColor() {
		return color;
	}


	/* (non-Javadoc)
	 * @see hu.elte.angry.nerdz.UNO.model.card.ICard#setValue(hu.elte.angry.nerdz.UNO.model.card.CardValue)
	 */
	@Override
	public void setValue(CardValue value) {
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see hu.elte.angry.nerdz.UNO.model.card.ICard#getValue()
	 */
	@Override
	public CardValue getValue() {
		return value;
	}
}
