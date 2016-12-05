/**
 * 
 */
package hu.elte.angry.nerdz.UNO.model.help;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author marfoldi
 *
 */
public class HelpReaderTest {
	private HelpReader reader;
	private Path path;
	
	/**
	 * Create a new parser before each test
	 * @throws URISyntaxException 
	 */
	@Before
	public void setUp() throws URISyntaxException {
		reader = new HelpReader();
		path = Paths.get(ClassLoader.getSystemResource("help.txt").toURI());
	}
	
	@Test
	public void testHelpContent() {
		String content = reader.getHelpContent();
		
		assertNotNull(content);
		assertNotEquals("Help is empty...", content);
	}
}
