package hu.elte.angry.nerdz.UNO.model.player;

import hu.elte.angry.nerdz.UNO.controller.GameController;
import hu.elte.angry.nerdz.UNO.model.card.ICard;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class RobotPlayer extends AbstractPlayer {
	
	private Timer timer;
	private GameController controller;
	
	public RobotPlayer(GameController controller) {
		timer = new Timer();
		this.controller = controller;
	}

	/**
	 * 
	 */
	public RobotPlayer() {
		super();
		timer = new Timer();
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
		System.out.println("Robot turn... Thinking..");
		List<ICard> validCards = getValidCards(actCard);
		
		// Waits a random time (1s - 5s) before acting
		long timeout = (long) (new Random()).nextInt(4000)+1000;
		
		TimerTask action = new TimerTask() {
	        public void run() {
	        	
	        	if (validCards.isEmpty()) {
	        		System.out.println("I dont have any card, drawing");
	    			completionHandler.draw();
	    		} else {
	    			// Robot player randomly selects a card from the available ones
	    			int cardIndex = (new Random()).nextInt(validCards.size());
	    			ICard cardToDrop = validCards.get(cardIndex);
	    			System.out.println("Dropping card: " + cardToDrop);
	    			if(controller != null) controller.setViewTopCard(cardToDrop);
	    			completionHandler.drop(cardToDrop);
	    		}
	        	
	        }
	    };
	    
	    this.timer.schedule(action, timeout);
	}

	/**
	 * Delegate like method to notify the player about his/her cards change.
	 * Since the player can not (should not) modify the deck, the manager notifies it about the event of change.
	 * Since the cards are List type which is reference type and is stored in the setCards method, this method is a notification only.
	 */
	@Override
	public void onCardsChange() {
		// no-op
		// Robot player does not care about cards change.
	}
	
}
