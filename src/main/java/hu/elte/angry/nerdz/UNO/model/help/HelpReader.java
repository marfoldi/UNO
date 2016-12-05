/**
 * 
 */
package hu.elte.angry.nerdz.UNO.model.help;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author marfoldi
 *
 */
public class HelpReader {
	public final Path PATH;
	
	/**
	 * Default constructor
	 * @throws URISyntaxException 
	 * 
	 */
	public HelpReader() throws URISyntaxException {
		this("help.txt");
	}
	
	/**
	 * Constructor with path string parameter
	 * @param pathString
	 * @throws URISyntaxException
	 */
	public HelpReader(String pathString) throws URISyntaxException {
		PATH = Paths.get(ClassLoader.getSystemResource(pathString).toURI());
	}
	
	/**
	 * Returns the content of the given file
	 * @return
	 */
	public String getHelpContent() {
		try {
			return new String(Files.readAllBytes(PATH), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
			return "Help is empty...";
		}
	}
}
