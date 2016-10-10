/**
 * 
 */
package hu.elte.angry.nerdz.UNO.json;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.List;

/**
 * @author marfoldi
 *
 */
public interface JSONParser {
	/**
	 * Reads the file and saves it's content to a String
	 * @param path
	 * @return a JSON string
	 */
	public String readFile(final Path path) throws FileNotFoundException;
	
	/**
	 * Parses the JSON string
	 * @param path
	 */
	public List<? extends Object> parseJSON(final String jsonString);
	
}
