package hu.elte.angry.nerdz.UNO.model.manager;

import hu.elte.angry.nerdz.UNO.model.card.ICard;
import hu.elte.angry.nerdz.UNO.model.deck.IDeck;
import hu.elte.angry.nerdz.UNO.model.player.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Daniel Torok
 *
 * Default implementation for IGameManager
 * 
 * This manager is capable of controlling the game flow of an UNO card game.
 * The players and the deck must be initialized before initializing this class.
 * 
 */
public class GameManager implements IGameManager {

	private GameManagerDelegate delegate;
	
	// The current card, cards dropped by the players are getting validated against this
	private ICard topCard;
	
	// Manager has all the players' card associated with the player
	private Map<IPlayer, List<ICard>> playersCards;
	private List<IPlayer> players;
	private IDeck deck;
	private ICard newCard;
	
	public GameManager(List<IPlayer> players, IDeck deck) {
		this.players = players;
		this.playersCards = new HashMap<IPlayer, List<ICard>>();
		this.deck = deck;
	}
	
	/**
	 * Starts the game and with the given amount of cards for each player.
	 * @param numberOfCards the amount of cards to start the game with
	 */
	@Override
	public void start(int numberOfCards) {
		// Early error handling
		// We can't start the game if the players property is not set, or there are not enough players.
		if (players == null || players.size() == 0) {
			System.exit(0);
		}
		
		deck.shuffle();
		topCard = deck.drawCard();
		
		// Initial cards, every player gets the same amount of cards
		players.forEach( (player) -> {
			List<ICard> cards = deck.drawCards(numberOfCards);
			playersCards.put(player, cards);
			
			player.setCards(cards);
			player.onCardsChange();
		});
		
		// Call the recursive iteration from the beginning
		playerTurn(0);
	}
	
	/**
	 * Sets the delegate in which inside information can be obtained.
	 * @param delegate
	 */
	@Override
	public void setDelegate(GameManagerDelegate delegate) {
		this.delegate = delegate;
	}
	
	// MARK: - Private
	
	/**
	 * Recursive - asynchronous iteration over the players.
	 * The player with index of playerIndex (within players list) gets the control along with the StepCompletion.
	 * When the player is finished, it calls one of the completion handler's method which gives the control back to this function.
	 * After the control is received and the action is validated the recursive function is called with the next index.
	 * 
	 * Base case: one of the players win the game, meaning it does not have any card left.
	 * @param playerIndex the current player's index
	 */
	private void playerTurn(int playerIndex) {
		// Get the next player's index
		int nextIndex = (playerIndex + 1) % players.size();
		
		// Retrieve current player and its deck
		IPlayer player = players.get(playerIndex);
		List<ICard> playerCards = playersCards.get(player);
		
		// Give the control to the player
		player.step(topCard, new StepCompletion() {

			@Override
			public void draw() {
				ICard card = deck.drawCard();
				playerCards.add(card);
				
				newCard = card;
				
				// TODO call this on different thread
				player.onCardsChange();
				
				playerTurn(nextIndex);
			}

			@Override
			public void drop(ICard card) {
				if (!topCard.matchingCard(card)) {
					playerTurn(playerIndex);
					return;
				}
				
				playerCards.remove(card);
				topCard = card;
					
				// TODO call this on different thread
				player.onCardsChange();
					
				if (playerCards.isEmpty()) {
					// TODO null check
					// TODO call this on different thread
					delegate.onGameOver(player);
				} else {
					playerTurn(nextIndex);
				}
			}
			
		});
	}

	public ICard getTopCard() {
		return topCard;
	}
	
	public IPlayer getPlayer(int ind){
		if(ind >= players.size()){
			return null;
		}
		return players.get(ind);
	}

	/**
	 * @return the newCard
	 */
	public ICard getNewCard() {
		return newCard;
	}
}
