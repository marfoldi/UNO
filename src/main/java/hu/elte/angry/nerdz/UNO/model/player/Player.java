package hu.elte.angry.nerdz.UNO.model.player;

import java.util.List;

import hu.elte.angry.nerdz.UNO.model.card.ICard;

/**
 * 
 * @author Reka Bonis
 * 
 * UI Player implementation of IPlayer
 * This class is used by a real person playing this game.
 *
 */
public class Player extends AbstractPlayer{
	
	protected ICard actCard;
	protected StepCompletion completionHandler;
	
	/**
	 * This method gives the player the control, meaning it is his/her turn.
	 * Method has a completionHandler, make sure it is called at the end of the turn!
	 * 
	 * @param actCard the actual (top) card in the game
	 * @param completionHandler the handler which the player must call at the end of his/her turn
	 */
	@Override
	public void step(ICard actCard, StepCompletion completionHandler) {
		this.actCard = actCard;
		this.completionHandler = completionHandler;
	}

	/**
	 * Delegate like method to notify the player about his/her cards change.
	 * Since the player can not (should not) modify the deck, the manager notifies it about the event of change.
	 * Since the cards are List type which is reference type and is stored in the setCards method, this method is a notification only.
	 */
	@Override
	public void onCardsChange() {
		// TODO update the UI
	}

	public StepCompletion getCompletionHandler() {
		return completionHandler;
	}
	
	public List<ICard> getCards(){
		return cards;
	}
}
