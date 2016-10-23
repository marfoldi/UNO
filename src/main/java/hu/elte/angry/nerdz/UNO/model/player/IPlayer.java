package hu.elte.angry.nerdz.UNO.model.player;

import java.util.List;

import hu.elte.angry.nerdz.UNO.model.card.ICard;

/**
 * 
 * @author Reka Bonis
 * 
 * This interface represents a player.
 * Used with the IGameManager, instances of this interface are the active participants of the game.
 *
 */
public interface IPlayer {
	
	/**
	 * This method gives the player the control, meaning it is his/her turn.
	 * Method has a completionHandler, make sure it is called at the end of the turn!
	 * 
	 * @param actCard the actual (top) card in the game
	 * @param completionHandler the handler which the player must call at the end of his/her turn
	 */
	public void step(ICard actCard, StepCompletion completionHandler);
	
	/**
	 * Initial cards are received through this method, acts like a delegate
	 * The initial cards must be stored on the implemented class
	 * @param cards the initial cards the player received
	 */
	public void setCards(List<ICard> cards);
	
	/**
	 * Delegate like method to notify the player about his/her cards change.
	 * Since the player can not (should not) modify the deck, the manager notifies it about the event of change.
	 * Since the cards are List type which is reference type and is stored in the setCards method, this method is a notification only.
	 */
	public void onCardsChange();
}
