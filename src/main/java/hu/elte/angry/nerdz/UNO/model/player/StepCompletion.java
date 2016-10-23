package hu.elte.angry.nerdz.UNO.model.player;

import hu.elte.angry.nerdz.UNO.model.card.ICard;

/**
 * 
 * @author Reka Bonis
 * 
 * This interface represents a set of action a player can choose from during his/her turn of the game.
 * It is used as an asynchronous method's completionHandler, which means one of these methods must be called
 * at the end of the turn.
 *
 */
public interface StepCompletion {
	
	/**
	 * Player choose to draw a card.
	 * 
	 * Reasons:
	 *  - does not have any matching card
	 */
	public void draw();
	
	/**
	 * Player dropped a card.
	 * @param card the card dropped by the player
	 */
	public void drop(ICard card);
}
