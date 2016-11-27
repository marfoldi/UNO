/**
 * 
 */
package hu.elte.angry.nerdz.UNO.GameManagerTests;

import hu.elte.angry.nerdz.UNO.Mock.*;
import hu.elte.angry.nerdz.UNO.model.card.ICard;
import hu.elte.angry.nerdz.UNO.model.manager.GameManager;
import hu.elte.angry.nerdz.UNO.model.player.IPlayer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Daniel Torok
 * 
 * UNIT tests for the GameManager implementation of the IGameManager
 *
 */
public class GameManagerTest {
	
	private DeckMock deck;
	private PlayerMock player;
	private List<IPlayer> players;
	private GameManager gameManager;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		deck = new DeckMock();
		player = new PlayerMock();
		players = new ArrayList<IPlayer>();
		players.add(player);
		
		// ??: when ArrayList<IPlayer.. is changed to ArrayList<PlayerMock.. it doesnt compile..
		gameManager = new GameManager(players, deck);
	}

	/**
	 * Start test
	 * 
	 * One of the expectations when the game starts is that the manager shuffles the deck.
	 * This test is checking whether the IDeck's shuffle method is called during start.
	 */
	@Test
	public void testStartMethodShufflesTheDeck() {
		// We do not want to iterate through the players, so we let it time out.
		player.stepAction = PlayerMock.action.TIMEOUT;
		
		// Start the game, here the numberOfCards argument is irrelevant.
		gameManager.start(1);
		
		// Check if the mocked deck class has the activity shuffle.
		assertTrue(deck.activities.contains("shuffle"));
	}
	
	/**
	 * Start test
	 * 
	 * One of the expectations when the game starts is that the manager draws the initial top card from the deck.
	 * This card is the first card which the first player is acting upon.
	 * 
	 * We'll supply this initial card and test it if the player gets it in its step method.
	 */
	@Test
	public void testStartMethodDrawsInitialCardFromDeck() {
		// Create initial card
		String identifier = "mockCard";
		CardMock initialCard = new CardMock();
		initialCard.identifier = identifier;
		
		// Supply it to the deck
		deck.mockCard = initialCard;
		
		// We do not want to iterate through the players, so we let it time out.
		player.stepAction = PlayerMock.action.TIMEOUT;
		gameManager.start(1);
		
		// Check if the player got the control
		assertTrue(player.activities.contains("step"));
		
		// Check the card in the step method
		ICard stepCard = player.cardInStepMethod;
		if (!(stepCard instanceof CardMock)) {
			fail("Wrong kind of card in step method");
			return;
		}
		
		CardMock castedStepCard = (CardMock) stepCard;
		assertEquals(castedStepCard.identifier, identifier);
	}
	
	/**
	 * Start test
	 * 
	 * One of the expectations when the game starts is that the manager gives the players fixed amount of starting cards.
	 * The amount is given as a parameter to the start method.
	 * 
	 * We'll check it in the player's setCards and onCardsChange method.
	 */
	@Test
	public void testStartMethodGivesPlayersCards() {
		// Create initial card
		int numberOfCards = 3;
		CardMock initialCard = new CardMock();
		
		// Supply it to the deck
		deck.mockCard = initialCard;
		
		// We do not want to iterate through the players, so we let it time out.
		player.stepAction = PlayerMock.action.TIMEOUT;
		gameManager.start(numberOfCards);
		
		// Get the cards
		List<ICard> playersCard = player.cardsInSetCardsMethod;
		assertNotNull(playersCard);
		assertEquals(playersCard.size(), numberOfCards);
		
		// Check the correct methods
		assertTrue(player.activities.contains("setCards"));
		assertTrue(player.activities.contains("onCardsChange"));
	}

}
