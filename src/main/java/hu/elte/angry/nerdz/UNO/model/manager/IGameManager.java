package hu.elte.angry.nerdz.UNO.model.manager;

/**
 * 
 * @author Daniel Torok
 * 
 * This interface represents a manager which is capable of controlling the game flow.
 * The manager can iterate over the players, giving them control in a specified order.
 * The manager has the card deck which the players can draw from, also stores the top (current) card and
 * checks if the card dropped by the player is valid or not compared to the top card.
 * 
 * The manager has a delegate which can be used to obtain informations about the game play.
 *
 */
public interface IGameManager {
	
	/**
	 * Starts the game and with the given amount of cards for each player.
	 * @param numberOfCards the amount of cards to start the game with
	 */
	public void start(int numberOfCards);
	
	/**
	 * Sets the delegate in which inside information can be obtained.
	 * @param delegate
	 */
	public void setDelegate(GameManagerDelegate delegate);
}
