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
	 * Gets the value of the card
	 * @return
	 */
	public CardValue getValue();
	
	/**
	 * Gets the color of the card
	 * @return
	 */
	public CardColor getColor();
	
	/**
	 * Determines if the card can be placed on top of the parameter card
	 * @param card
	 * @return
	 */
	public boolean matchingCard(ICard card);
}
