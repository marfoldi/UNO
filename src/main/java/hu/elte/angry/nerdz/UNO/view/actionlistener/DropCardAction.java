package hu.elte.angry.nerdz.UNO.view.actionlistener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import hu.elte.angry.nerdz.UNO.model.card.CardColor;
import hu.elte.angry.nerdz.UNO.model.card.CardValue;
import hu.elte.angry.nerdz.UNO.view.CardPanel;
import hu.elte.angry.nerdz.UNO.view.Desk;
import hu.elte.angry.nerdz.UNO.view.PlayerPanel;

public class DropCardAction extends PlayerActionListener {

	public DropCardAction(Desk desk, PlayerPanel playerPanel) {
		super(desk, playerPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (desk.topOfDeck.getText().equals(((JButton) e.getSource()).getText())
				|| desk.topOfDeck.getBackground().equals(((JButton) e.getSource()).getBackground())) {
			playerPanel.dropCard(Integer.parseInt(((JButton) e.getSource()).getName()));
			Color cardColor = ((JButton) e.getSource()).getBackground();
			int cardValue = Integer.parseInt(((JButton) e.getSource()).getText());
			playerPanel.showCards();
		}
	}

}
