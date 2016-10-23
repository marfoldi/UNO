/**
 * 
 */
package hu.elte.angry.nerdz.UNO.cardparser;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import hu.elte.angry.nerdz.UNO.model.card.ICard;
import hu.elte.angry.nerdz.UNO.model.cardparser.ICardParser;

/**
 * @author marfoldi
 *
 */
@RunWith(Parameterized.class)
public class FileReaderTest {
	private ICardParser parser;
	private Path path;
	private String fileContent;
	
	@Parameters
	public static Collection<Object[]> data() throws URISyntaxException {
    	return Arrays.asList(new Object[][] {     
    		{ Paths.get(ClassLoader.getSystemResource("emptyFile.json").toURI()), "" } 
    	});
	}
	
	/**
	 * Create a new parser before each test
	 */
	@Before
	public void setUp() {
		parser = new ICardParser() {
			@Override
			public List<ICard> parseJSON(String jsonString) {
				// TODO Auto-generated method stub
				return null;
			}};
	}
	
	/**
	 * Constructor for parameterized tests
	 * @param path
	 * @param fileContent
	 */
	public FileReaderTest(Path path, String fileContent) {
		this.path = path;
		this.fileContent = fileContent;
	}

	/**
	 * File reader test
	 * @throws IOException
	 */
	@Test
	public void testReadFile() throws IOException {
		assertNotNull(parser);
		assertNotNull(path);
		assertNotNull(fileContent);
		assertEquals(fileContent, parser.readFile(path));
	}

}
