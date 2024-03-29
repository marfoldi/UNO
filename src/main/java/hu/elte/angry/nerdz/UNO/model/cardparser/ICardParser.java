/**
 * 
 */
package hu.elte.angry.nerdz.UNO.model.cardparser;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import hu.elte.angry.nerdz.UNO.model.card.ICard;


/**
 * @author marfoldi
 *
 */
public interface ICardParser {
	/**
	 * Reads the file and saves it's content to a String
	 * @param path
	 * @return a JSON string
	 * @throws IOException 
	 */
	public default String readFile(final Path path) throws IOException {
		return new String(Files.readAllBytes(path), Charset.forName("UTF-8"));
	}
	
	/**
	 * Parses the JSON string
	 * @param jsonString
	 */
	public List<ICard> parseJSON(final String jsonString);
	
}
