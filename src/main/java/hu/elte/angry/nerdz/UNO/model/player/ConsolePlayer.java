/**
 * 
 */
package hu.elte.angry.nerdz.UNO.model.player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import hu.elte.angry.nerdz.UNO.model.card.*;

/**
 * @author Reka Bonis
 *
 */
public class ConsolePlayer extends AbstractPlayer {

	public ConsolePlayer() {
		
	}
	
	/**
	 * This method gives the player the control, meaning it is his/her turn.
	 * Method has a completionHandler, make sure it is called at the end of the turn!
	 * 
	 * @param actCard the actual (top) card in the game
	 * @param completionHandler the handler which the player must call at the end of his/her turn
	 */
	@Override
	public void step(ICard actCard, StepCompletion completionHandler) {
		System.out.println("Top card is: " + actCard.toString());
		System.out.println("Your cards are: " + cards.toString());
		System.out.println("Your valid cards are: " + getValidCards(actCard).toString());
		
		UserAction action = selectAction();
		if ("pass".equals(action.action)) {
			completionHandler.draw();
		} else {
			completionHandler.drop(action.card);
		}
	}

	
	@Override
	public void onCardsChange() {
		
	}
	
	// MARK: - Private
	
	private class UserAction {
		public String action;
		public ICard card;
		
		public UserAction(String action) {
			this.action = action;
		}

		public UserAction(String string, ICard card) {
			this(string);
			this.card = card;
		}
	}
	
	private UserAction selectAction() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
	    
		try {
			System.out.print(":: ");
			input = br.readLine();
		} catch (IOException e) {
			return selectAction();
		}
		
		UserAction action = parseActionFromString(input);
		return (action == null) ? selectAction() : action;
	}
	
	private UserAction parseActionFromString(String input) {
		if ("pass".equals(input.toLowerCase())) {
			return new UserAction("pass");
		}
		
		if (input.length() != 2) {
			return null;
		}
		
		String colorCase = "" + input.charAt(0);
		String numberCase = "" + input.charAt(1);
		
		ICard card = createCardFrom(colorCase, numberCase);
		return (cards.contains(card)) ? new UserAction("drop", card) : selectAction();
	}
	
	private ICard createCardFrom(String colorCase, String numberCase) {
		int number;
		try {
			number = Integer.parseInt(numberCase);
		} catch (NumberFormatException e) {
			return null;
		}
		
		CardColor color;
		switch (colorCase.toLowerCase()) {
		case "r": color = CardColor.RED; break;
		case "b": color = CardColor.BLUE; break;
		case "y": color = CardColor.YELLOW; break;
		case "g": color = CardColor.GREEN; break;
		default: return null;
		}
		
		CardValue value;
		switch (number) {
		case 0: value = CardValue.ZERO; break;
		case 1: value = CardValue.ONE; break;
		case 2: value = CardValue.TWO; break;
		case 3: value = CardValue.THREE; break;
		case 4: value = CardValue.FOUR; break;
		case 5: value = CardValue.FIVE; break;
		case 6: value = CardValue.SIX; break;
		case 7: value = CardValue.SEVEN; break;
		case 8: value = CardValue.EIGHT; break;
		case 9: value = CardValue.NINE; break;
		default: return null;
		}
		
		return new Card(color, value);
	}

}
