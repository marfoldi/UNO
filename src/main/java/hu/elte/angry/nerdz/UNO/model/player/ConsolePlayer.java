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
		
		String[] components = input.split(" ");
		String color = components[0];
		String number = components[1];
		
		ICard card = createCardFrom(color, number);
		return (cards.contains(card)) ? new UserAction("drop", card) : selectAction();
	}
	
	private ICard createCardFrom(String colorCase, String numberCase) {
		return new Card(CardColor.fromString(colorCase.toLowerCase()), CardValue.fromPrimitiveValue(numberCase));
	}

}
