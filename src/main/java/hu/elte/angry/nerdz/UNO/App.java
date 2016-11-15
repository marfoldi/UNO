package hu.elte.angry.nerdz.UNO;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import hu.elte.angry.nerdz.UNO.model.card.ICard;
import hu.elte.angry.nerdz.UNO.model.cardparser.DeckParser;
import hu.elte.angry.nerdz.UNO.model.deck.Deck;
import hu.elte.angry.nerdz.UNO.model.deck.IDeck;
import hu.elte.angry.nerdz.UNO.model.manager.GameManager;
import hu.elte.angry.nerdz.UNO.model.manager.GameManagerDelegate;
import hu.elte.angry.nerdz.UNO.model.player.*;

/**
 * Hello world!
 *
 */
public class App implements GameManagerDelegate
{
    public static void main( String[] args ) throws URISyntaxException, IOException
    {
        ConsolePlayer player = new ConsolePlayer();
        RobotPlayer robotPlayerOne = new RobotPlayer();
        RobotPlayer robotPlayerTwo = new RobotPlayer();
        
        List<IPlayer> players = new ArrayList<IPlayer>();
        players.add(player);
        players.add(robotPlayerOne);
        players.add(robotPlayerTwo);
        
        DeckParser parser = new DeckParser();
        String jsonString = parser.readFile(parser.PATH);
        List<ICard> cards = parser.parseJSON(jsonString);
        IDeck deck = new Deck(cards);
        
        GameManager manager = new GameManager(players, deck);
        manager.start(7);
        //manager.setDelegate(this);
    }

	@Override
	public void onGameOver(IPlayer winner) {
		System.out.println("Winner: " + winner);
		
	}
}
