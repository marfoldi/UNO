/**
 * 
 */
package hu.elte.angry.nerdz.UNO.json;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author marfoldi
 *
 */
@RunWith(Parameterized.class)
public class JSONParserTest {
	private JSONParser parser;
	private Path path;
	private String fileContent;
	
	@Parameters
	public static Collection<Object[]> data() throws URISyntaxException {
    	return Arrays.asList(new Object[][] {     
    		{ Paths.get(ClassLoader.getSystemResource("emptyFile.json").toURI()), "" } 
    	});
	}
	
	/**
	 * Create a new JSONParser before each test
	 */
	@Before
	public void setUp() {
		parser = new JSONParser() {};
	}
	
	/**
	 * Constructor for parameterized tests
	 * @param path
	 * @param fileContent
	 */
	public JSONParserTest(Path path, String fileContent) {
		this.path = path;
		this.fileContent = fileContent;
	}

	/**
	 * File reader test
	 * @throws IOException
	 */
	@Test
	public void testReadFile() throws IOException {
		assertNotNull(path);
		assertNotNull(fileContent);
		assertEquals(fileContent, parser.readFile(path));
	}

}
