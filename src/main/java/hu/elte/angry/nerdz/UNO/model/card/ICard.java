package hu.elte.angry.nerdz.UNO.model.card;

public interface ICard {
	/**
	 * Sets the card color
	 * @param color
	 */
	public void setColor(CardColor color);
	
	/**
	 * Returns the card color
	 * @return a CardColor object
	 */
	public CardColor getColor();
	
	/**
	 * Sets the card value
	 * @param value
	 */
	public void setValue(CardValue value);
	
	/**
	 * Returns the card value
	 * @return A CardValue object
	 */
	public CardValue getValue();
}
