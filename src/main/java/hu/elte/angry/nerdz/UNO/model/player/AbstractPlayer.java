package hu.elte.angry.nerdz.UNO.model.player;

import java.util.List;
import java.util.stream.Collectors;

import hu.elte.angry.nerdz.UNO.model.card.ICard;

/**
 * 
 * @author Reka Bonis
 * 
 * AbstractPlayer implementation of IPlayer interface.
 * In this game there are two types of players: human, robot
 * Except the step method they are quite similar to each other so this class server as a base implementation.
 *
 */
public abstract class AbstractPlayer implements IPlayer {
 
	protected List<ICard> cards;
	
	/**
	 * Initial cards are received through this method, acts like a delegate
	 * The initial cards must be stored on the implemented class
	 * @param cards the initial cards the player received
	 */
	public void setCards(List<ICard> cards) {
		this.cards = cards;
	}
	
	/**
	 * Filters the available cards for the player based on the parameter card.
	 * A card is considered available if it has a true boolean value for the matchingCard function.
	 * @param forCard the card which the players' deck is filtered against
	 * @return
	 */
	public List<ICard> getValidCards(ICard forCard) {
		List<ICard> filteredCards = cards.stream().filter( (card) -> {
			return card.matchingCard(forCard);
		}).collect(Collectors.toList());
		
		return filteredCards;
	}
}
