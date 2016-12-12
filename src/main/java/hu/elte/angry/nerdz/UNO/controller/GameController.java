package hu.elte.angry.nerdz.UNO.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import hu.elte.angry.nerdz.UNO.model.card.CardColor;
import hu.elte.angry.nerdz.UNO.model.card.ICard;
import hu.elte.angry.nerdz.UNO.model.help.HelpReader;
import hu.elte.angry.nerdz.UNO.model.manager.GameManager;
import hu.elte.angry.nerdz.UNO.model.player.Player;
import hu.elte.angry.nerdz.UNO.model.player.RobotPlayer;
import hu.elte.angry.nerdz.UNO.view.card.CardButton;
import hu.elte.angry.nerdz.UNO.view.DeskPanel;
import hu.elte.angry.nerdz.UNO.view.RobotPanel;

/**
 * 
 * @author TheDago
 *
 */
public class GameController implements IGameController {
	private GameManager model;
	private DeskPanel view;
	
	/**
	 * 
	 */
	public GameController() {}

	/**
	 * @param view
	 * @param model
	 */
	public GameController(GameManager model, DeskPanel view, int startCardNum) {
		super();
		this.model = model;
		this.view = view;
		model.start(startCardNum);
	}
	
	/**
	 * Maps model robots to view robots (panels)
	 */
	public List<RobotPanel> mapModelRobotsToViewRobots(List<RobotPlayer> robotPlayers) {
		List<RobotPanel> robotPanels = new ArrayList<>();
		for(int i=0;i<robotPlayers.size();i++){
			robotPanels.add(new RobotPanel("Robot"+ (i+1)));
		}
		return robotPanels;
	}
	
	/**
	 * Maps model cards to view cards (buttons)
	 * @param cards
	 * @return
	 */
	public List<CardButton> mapModelCardsToViewCards(List<ICard> cards) {
		List<CardButton> viewCards = new ArrayList<>(cards.size());
		for(ICard card : cards){
			viewCards.add(mapModelCardToViewCard(card));
		}
		return viewCards;
	}


	/**
	 * Maps a model card to view card (button)
	 * @param card
	 * @return
	 */
	public CardButton mapModelCardToViewCard(ICard card) {
		CardButton cardButton = new CardButton(mapModelCardColorToViewColor(card.getColor()), card.getValue().ordinal());
		cardButton.addActionListener(addCardActionListener(card, cardButton));
		return cardButton;
	}

	/**
	 * Maps a model CardColor to java.awt.color
	 * @param color
	 * @return
	 */
	private Color mapModelCardColorToViewColor(CardColor color) {
		switch (color) {
			case BLACK:
				return Color.BLACK;
			case BLUE:
				return Color.BLUE;
			case GREEN:
				return Color.GREEN;
			case RED:
				return Color.RED;
			case YELLOW:
				return Color.YELLOW;
			default:
				return Color.BLACK;
		}
	}
	
	/**
	 * Returns the help file content
	 * @return
	 */
	public static String getHelpFileContent() {
		try {
			return new HelpReader().getHelpContent();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Adds an action listener for each card
	 * @param card
	 * @param cardButton
	 * @return
	 */
	private ActionListener addCardActionListener(ICard card, CardButton cardButton) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Player player = ((Player) model.getPlayer(0));
				int oldCardNum = player.getCardNum();
				player.getCompletionHandler().drop(card);
				if(player.getCardNum() < oldCardNum) { //Success - TODO: Use onCardsChange()
					view.getPlayerPanel().dropCard(cardButton);
					view.getDeckPanel().setTopOfDeck(cardButton);
				}
			}
		};
	}
	
	/**
	 * Adds an action listener to the deck button
	 */
	public void addDeckActionListener() {
		view.getDeckPanel().addDeckButtonActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Player player = ((Player) model.getPlayer(0));
				player.getCompletionHandler().draw();
				ICard newCard = model.getNewCard();
				CardButton newCardButton = mapModelCardToViewCard(newCard);
				view.getPlayerPanel().addCard(newCardButton, addCardActionListener(newCard, newCardButton));
			}
		});
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(GameManager model) {
		this.model = model;
	}

	/**
	 * @param view the view to set
	 */
	public void setView(DeskPanel view) {
		this.view = view;
	}
	
	/**
	 * Sets view top card
	 * @param card
	 */
	public void setViewTopCard(ICard card) {
		CardButton cardButton = mapModelCardToViewCard(card);
		view.getDeckPanel().setTopOfDeck(cardButton);
	}
}
