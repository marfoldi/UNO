package hu.elte.angry.nerdz.UNO.card;

import static org.junit.Assert.assertEquals;

import java.awt.Color;

import org.junit.Test;

import hu.elte.angry.nerdz.UNO.model.card.*;

public class CardColorTest {
	
	@Test
	public void testCardColorFromString(){
		String color = "red";
		CardColor cc = CardColor.fromString(color);
		assertEquals(cc.getStringRepresentation(), color);
	}
	
	@Test
	public void testCardColorFromAwtColor() {
		Color color = Color.BLACK;
		CardColor cc = CardColor.fromAwtColor(Color.BLACK);
		assertEquals(cc.getAwtColor(), color);
	}
}
