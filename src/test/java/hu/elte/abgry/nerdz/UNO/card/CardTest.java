package hu.elte.abgry.nerdz.UNO.card;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import hu.elte.angry.nerdz.UNO.model.card.*;

public class CardTest {
	
	public ICard testcard1 = new Card(CardColor.BLACK, CardValue.EIGHT);
	public ICard testcard2 = new Card(CardColor.BLACK, CardValue.SEVEN);
	public ICard testcard3 = new Card(CardColor.RED, CardValue.NINE);
	
	@Test
	public void testMatchingCard(){
		assertEquals(testcard1.matchingCard(testcard2), true);
	}
	
	@Test
	public void testFailMatchingCard(){
		assertEquals(testcard1.matchingCard(testcard3), false);
	}
	
	@Test
	public void testEquals(){
		assertEquals(testcard1.equals(testcard1), true);
	}
	
	@Test
	public void testFailEquals(){
		assertEquals(testcard1.equals(testcard2), false);
	}
}
