package hu.elte.angry.nerdz.UNO.card;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import hu.elte.angry.nerdz.UNO.model.card.*;

public class CardColorTest {
	
	@Test
	public void testCardColorFromString(){
		String color = "red";
		CardColor cc = CardColor.fromString(color);
		assertEquals(cc.getStringRepresentation(), color);
	}
}
