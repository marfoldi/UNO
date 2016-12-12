/**
 * 
 */
package hu.elte.angry.nerdz.UNO.model.manager;

import java.util.List;
import java.util.ArrayList;

import hu.elte.angry.nerdz.UNO.controller.GameController;
import hu.elte.angry.nerdz.UNO.model.player.IPlayer;
import hu.elte.angry.nerdz.UNO.model.player.Player;
import hu.elte.angry.nerdz.UNO.model.player.RobotPlayer;

/**
 * @author marfoldi
 *
 */
public class PlayerManager {
	private final Player player;
	private final List<RobotPlayer> robotPlayers;
	private final List<IPlayer> allPlayers;
	
	/**
	 * Initializes the robotPlayer list with opponentCount robots and creates a new player
	 * @param playerCount
	 */
	public PlayerManager(int opponentCount, GameController controller) {
		allPlayers = new ArrayList<IPlayer>(opponentCount+1);
		player = new Player();
		allPlayers.add(player);
		robotPlayers = new ArrayList<RobotPlayer>(opponentCount);
		for(int i=0; i<opponentCount ; i++){
			RobotPlayer robotPlayer = new RobotPlayer(controller);
			allPlayers.add(robotPlayer);
			robotPlayers.add(robotPlayer);
		}
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @return the robotPlayers
	 */
	public List<RobotPlayer> getRobotPlayers() {
		return robotPlayers;
	}
	
	/**
	 * 
	 * @return the allPlayers
	 */
	public List<IPlayer> getPlayers() {
		return allPlayers;
	}
}
