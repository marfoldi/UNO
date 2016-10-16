/**
 * 
 */
package hu.elte.angry.nerdz.UNO.json;

import java.io.IOException;
import java.nio.file.Files;
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
	 * @throws IOException 
	 */
	public default String readFile(final Path path) throws IOException {
		return new String(Files.readAllBytes(path));
	}
	
	/**
	 * Parses the JSON string
	 * @param jsonString
	 */
	public List<? extends Object> parseJSON(final String jsonString);
	
}
