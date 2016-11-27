package hu.elte.angry.nerdz.UNO.card;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import hu.elte.angry.nerdz.UNO.model.card.*;

public class CardValueTest {
	
	@Test
	public void testCardColorFromString(){
		Integer val = 2;
		CardValue cv = CardValue.fromPrimitiveValue(Integer.toString(val));
		assertEquals(Integer.valueOf(cv.getPrimitiveValue()), val);
	}
}
