package hu.elte.angry.nerdz.UNO.view.actionlistener;

import java.awt.event.ActionEvent;

import hu.elte.angry.nerdz.UNO.view.Desk;
import hu.elte.angry.nerdz.UNO.view.PlayerPanel;

public class DrawCardAction extends PlayerActionListener{

	public DrawCardAction(Desk desk, PlayerPanel playerPanel) {
		super(desk, playerPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		playerPanel.addCard(randomCard());
		playerPanel.showCards();
	}

}
