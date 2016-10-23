/**
 * 
 */
package hu.elte.angry.nerdz.UNO.cardparser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import hu.elte.angry.nerdz.UNO.model.card.ICard;
import hu.elte.angry.nerdz.UNO.model.cardparser.DeckParser;

/**
 * @author marfoldi
 *
 */
public class ParserTest {
	private DeckParser parser;
	private Path path;
	
	/**
	 * Create a new parser before each test
	 * @throws URISyntaxException 
	 */
	@Before
	public void setUp() throws URISyntaxException {
		parser = new DeckParser();
		path = Paths.get(ClassLoader.getSystemResource("cards.json").toURI());
	}
	
	/**
	 * Parser test
	 * @throws IOException
	 */
	@Test
	public void testParseJSON() throws IOException {
		assertNotNull(parser);
		assertNotNull(path);
		List<ICard> deck = parser.parseJSON(parser.readFile(path));
		assertEquals(4*10, deck.size());
	}
}
