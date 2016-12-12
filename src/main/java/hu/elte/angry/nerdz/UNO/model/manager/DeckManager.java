/**
 * 
 */
package hu.elte.angry.nerdz.UNO.model.manager;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import hu.elte.angry.nerdz.UNO.model.card.ICard;
import hu.elte.angry.nerdz.UNO.model.cardparser.DeckParser;
import hu.elte.angry.nerdz.UNO.model.deck.Deck;

/**
 * @author marfoldi
 *
 */
public class DeckManager {
	private Deck deck;
	
	public DeckManager() {
		try {
			deck = new Deck(getDeckCards());
		} catch (IOException | URISyntaxException e) {
			System.err.println("Couldn't parse cards from JSON!");
			System.exit(1);
		}
	}
	
	/**
	 * Gets the ICards from the json
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	private List<ICard> getDeckCards() throws IOException, URISyntaxException {
		DeckParser parser = new DeckParser();
		return parser.parseJSON(parser.readFile(parser.PATH));
	}

	/**
	 * @return the deck
	 */
	public Deck getDeck() {
		return deck;
	}
}
