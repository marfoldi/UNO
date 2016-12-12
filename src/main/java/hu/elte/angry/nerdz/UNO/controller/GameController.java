package hu.elte.angry.nerdz.UNO.controller;

import hu.elte.angry.nerdz.UNO.model.manager.GameManager;
import hu.elte.angry.nerdz.UNO.view.DeskPanel;

/**
 * 
 * @author TheDago
 *
 */
public class GameController implements IGameController {
	private final DeskPanel view;
	private final GameManager model;
	
	/**
	 * @param view
	 * @param model
	 */
	public GameController(DeskPanel view, GameManager model) {
		super();
		this.view = view;
		this.model = model;
	}

	/**
	 * @return the view
	 */
	public DeskPanel getView() {
		return view;
	}

	/**
	 * @return the model
	 */
	public GameManager getModel() {
		return model;
	}
}
