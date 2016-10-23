package hu.elte.angry.nerdz.UNO.model.card;

/**
 * 
 * @author Peter Gerencser
 * 
 * This interface represents a Card.
 * Cards can be used with Decks and they are the fundamental elements of the game.
 * Every card has a color and a value (number or activity) associated with it.
 *
 */
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
	
	/**Determines if the card can be placed on top of the parameter card
	 * @param card
	 * @return
	 */
	public boolean matchingCard(ICard card);
}
