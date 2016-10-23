package hu.elte.angry.nerdz.UNO.model.manager;

import hu.elte.angry.nerdz.UNO.model.player.IPlayer;

/**
 * 
 * @author Daniel Torok
 * 
 * This interface represents the IGameManager interface's delegate which can be used to obtain
 * informations about the game play.
 *
 */
public interface GameManagerDelegate {
	
	/**
	 * Called when the game is over, meaning one of the players (winner) has no cards left.
	 * @param winner the player who won the game
	 */
	public void onGameOver(IPlayer winner);
}
