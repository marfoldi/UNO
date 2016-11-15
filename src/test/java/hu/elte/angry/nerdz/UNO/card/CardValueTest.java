package hu.elte.angry.nerdz.UNO.card;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import hu.elte.angry.nerdz.UNO.model.card.*;

public class CardValueTest {
	
	@Test
	public void testCardColorFromString(){
		int val = 2;
		CardValue cv = CardValue.fromInt(val);
		assertEquals(cv.getIntegerRepresentation(), val);
	}
}
