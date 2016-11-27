package hu.elte.angry.nerdz.UNO.view.window;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;


public class AppHelpBox extends JFrame {
	private static final long serialVersionUID = 6053886643319617200L;

	public AppHelpBox() {
		JTextArea message = new JTextArea();
		message.setWrapStyleWord(true);
		message.setLineWrap(true);
		message.setEditable(false);
		message.setFocusable(false);
		message.setOpaque(false);

		message.setText("Setup:\n The game is for 2-10 players, ages 7 and over. Every player starts with seven\n"
				+ " cards, and they are dealt face down.\n"
				+ "The rest of the cards are placed in a Draw Pile face down. Next to the pile a space "
				+ "should be designated for a Discard Pile.\n"
				+ "The top card should be placed in the Discard Pile, and the game begins!\n"
				+ "Game Play: The first player is normally the player to the left of the dealer "
				+ "(you can also choose the youngest player) and"
				+ "gameplay usually follows a clockwise direction. Every player views his/her "
				+ "cards and tries to match the card in the Discard Pile."
				+ "You have to match either by the number, color, or the symbol/Action. "
				+ "For instance, if the Discard Pile has a red card that is "
				+ "an 8 you have to place either a red card or a card with an 8 on it. "
				+ "You can also play a Wild card (which can alter current color in play)."
				+ "If the player has no matches or they choose not to play any of their "
				+ "cards even though they might have a match, they must draw a"
				+ "card from the Draw pile. If that card can be played, play it. Otherwise, "
				+ "the game moves on to the next person in turn. You can "
				+ "also play a Wild card, or a Wild Draw Four card on your turn."
				+ "Note: If the first card turned up from the Draw Pile (to form the Discard Pile) "
				+ "is an Action card, the Action from that card"
				+ "applies and must be carried out. The exceptions are if the Wild or Wild Draw Four"
				+ " cards are turned up, in which case – Return"
				+ "them to the Draw Pile, shuffle them, and turn over a new card. At any time, "
				+ "if the Draw Pile becomes depleted and no one has"
				+ "yet won the round, take the Discard Pile, shuffle it, and turn it over "
				+ "to regenerate a new Draw Pile" + "There are two different ways to play regarding drawing new cards. "
				+ "The Official Uno Rules states that after a card is drawn "
				+ "the player can discard it if it is a match, or if not, play passes on "
				+ "to the next player. The other type is where players"
				+ "continue to draw cards until they have a match, even if it is 10 times"
				+ "The game continues until a player has one card left. "
				+ "The moment a player has just one card they must yell “UNO!”"
				+ "If they are caught not saying “Uno” by another player before any card "
				+ "has been played, the player must draw two new cards"
				+ "Once a player has no cards remaining, the game round is over, points"
				+ " are scored, and the game begins over again. Normally,"
				+ "veryone tries to be the first one to achieve 500 points, but you can"
				+ "also choose whatever points number to win the game, as" + "long as everyone agrees to it");

		// create a scrollpane, givin it the textarea as a constructor argument
		JScrollPane ScrollPane = new JScrollPane(message, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		// now add the scrollpane to the jframe's content pane, specifically
		// placing it in the center of the jframe's borderlayout
		JFrame frame = new JFrame("UNO Help");
		/* frame.setBounds(200, 800,805, 932); */

		/* frame.setPreferredSize(new Dimension(900, 800)); */
		/* frame.setResizable(true); */

		frame.getContentPane().add(ScrollPane, BorderLayout.CENTER);

		frame.setSize(500, 500);

		ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		// set the frame size (you'll usually want to call frame.pack())
		/* frame.setSize(new Dimension(240, 180)); */

		// center the frame
		frame.setLocationRelativeTo(null);

		// make it visible to the user
		frame.setVisible(true);
	}

}

	
	
	
	
	
	
	
	
	
	
	
