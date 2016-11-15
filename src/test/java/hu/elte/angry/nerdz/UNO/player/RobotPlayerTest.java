package hu.elte.angry.nerdz.UNO.player;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

import hu.elte.angry.nerdz.UNO.model.card.Card;
import hu.elte.angry.nerdz.UNO.model.card.CardColor;
import hu.elte.angry.nerdz.UNO.model.card.CardValue;
import hu.elte.angry.nerdz.UNO.model.card.ICard;
import hu.elte.angry.nerdz.UNO.model.player.RobotPlayer;
import hu.elte.angry.nerdz.UNO.model.player.StepCompletion;

public class RobotPlayerTest {

	private RobotPlayer player = new RobotPlayer();
	private String result;
	
	@Test
	public void testNoValidCards() throws InterruptedException{
		ICard card = new Card(CardColor.BLACK, CardValue.EIGHT);
		player.setCards(Collections.emptyList());
		StepCompletion sc = new StepCompletion() {
			
			@Override
			public void drop(ICard card) {
				result = "drop";
				System.out.println(result);
			}
			
			@Override
			public void draw() {
				result = "draw";
			}
		};
		
		player.step(card, sc);
		TimeUnit.SECONDS.sleep(5);	
		
		assertEquals("draw", result);
		
	}
	
	@Test
	public void testIfHaveValidCards() throws InterruptedException{
		ICard card = new Card(CardColor.BLACK, CardValue.EIGHT);
		ArrayList<ICard> cards = new ArrayList<>();
		cards.add(card);
		player.setCards(cards);
		StepCompletion sc = new StepCompletion() {
			
			@Override
			public void drop(ICard card) {
				result = "drop";
			}
			
			@Override
			public void draw() {
				result = "draw";
			}
		};
		
		player.step(card, sc);
		TimeUnit.SECONDS.sleep(5);	
		
		assertEquals("drop", result);
		
	}
	
	@Test
	public void testCardsLength() throws InterruptedException{
		ICard card = new Card(CardColor.BLACK, CardValue.EIGHT);
		ICard card2 = new Card(CardColor.BLACK, CardValue.TWO);
		ICard card3 = new Card(CardColor.BLACK, CardValue.THREE);
		ArrayList<ICard> cards = new ArrayList<>();
		int beforeCardSize =0;
		int afterCardSize = 0;
		cards.add(card);
		cards.add(card2);
		player.setCards(cards);
		beforeCardSize=player.getValidCards(card3).size();
		StepCompletion sc =  mock(StepCompletion.class);
		
		player.step(card, new StepCompletion() {

			@Override
			public void draw() {
				
			}

			@Override
			public void drop(ICard card) {
				
			}
			
		});
		TimeUnit.SECONDS.sleep(5);	
		afterCardSize = (player.getValidCards(card3).size());
		assertEquals(beforeCardSize, afterCardSize);
		
	}

}
