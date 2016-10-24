/**
 * 
 */
package hu.elte.angry.nerdz.UNO.model.cardparser;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import hu.elte.angry.nerdz.UNO.model.card.Card;
import hu.elte.angry.nerdz.UNO.model.card.CardColor;
import hu.elte.angry.nerdz.UNO.model.card.CardValue;
import hu.elte.angry.nerdz.UNO.model.card.ICard;

/**
 * @author marfoldi
 *
 */
public class DeckParser implements ICardParser {
	public final Path PATH;
	
	/**
	 * Default constructor
	 * @throws URISyntaxException 
	 * 
	 */
	public DeckParser() throws URISyntaxException {
		this("cards.json");
	}
	
	/**
	 * Constructor with path string parameter
	 * @param pathString
	 * @throws URISyntaxException
	 */
	public DeckParser(String pathString) throws URISyntaxException {
		PATH = Paths.get(ClassLoader.getSystemResource(pathString).toURI());
	}

	/* (non-Javadoc)
	 * @see hu.elte.angry.nerdz.UNO.json.JSONParser#parseJSON(java.lang.String)
	 */
	@Override
	public List<ICard> parseJSON(String jsonString) {
		JSONObject root;
		if(!jsonString.isEmpty()) root = new JSONObject(jsonString);
		else return null;
		
		List<ICard> deck = new ArrayList<>();
		for (Object key : root.keySet()) {
			String cardColor = key.toString();
		    Object cardValues = root.get(cardColor);
		    if(cardValues instanceof JSONArray) {
		    	deck.addAll(createSingleColorCardList(CardColor.valueOf(cardColor.toUpperCase()), (JSONArray) cardValues));
		    }
		}
		return deck;
	}
	
	/**
	 * Creates a list of cards for the given color
	 * @param Color
	 * @param cardValueList
	 * @return
	 */
	private List<ICard> createSingleColorCardList(CardColor color, JSONArray cardValues) {
		List<ICard> cardsForCurrentColor = new ArrayList<>(cardValues.length());
		for(int i=0; i<cardValues.length(); ++i) {
			Object valueObject = cardValues.opt(i);
			CardValue value = CardValue.fromInt((Integer) valueObject);
			if(value != null) {
				cardsForCurrentColor.add(new Card(color, value));				
			}
		}
		return cardsForCurrentColor;
	}

}
