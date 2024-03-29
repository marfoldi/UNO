package hu.elte.angry.nerdz.UNO.player;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import hu.elte.angry.nerdz.UNO.model.card.Card;
import hu.elte.angry.nerdz.UNO.model.card.ICard;
import hu.elte.angry.nerdz.UNO.model.player.IPlayer;
import hu.elte.angry.nerdz.UNO.model.player.Player;
import hu.elte.angry.nerdz.UNO.model.player.StepCompletion;

public class PlayerTest {
	
	private IPlayer player;

	@Test
	public void testStepIsValid() {
		player = new Player();
		StepCompletion sc = mock(StepCompletion.class);
		ICard card = mock(Card.class);
		
		player.step(card, sc);
		
		assertNotNull(((Player)player).getCompletionHandler());
		assertEquals(sc, ((Player)player).getCompletionHandler());
	}

}
