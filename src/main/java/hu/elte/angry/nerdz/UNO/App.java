package hu.elte.angry.nerdz.UNO;

import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import hu.elte.angry.nerdz.UNO.view.DeskPanel;
import hu.elte.angry.nerdz.UNO.view.card.CardButton;
import hu.elte.angry.nerdz.UNO.view.card.CardColor;
import hu.elte.angry.nerdz.UNO.view.card.CardValue;
import hu.elte.angry.nerdz.UNO.view.window.AppMenuBar;

public class App extends JFrame {
	private static final long serialVersionUID = -5071602386904303971L;

	public App(DeskPanel desk) {
		super("UNO");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setJMenuBar(new AppMenuBar());
		this.add(desk);
		this.setVisible(true);
	}



	@Override
	protected void processWindowEvent(WindowEvent e) {
		if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			int exit = JOptionPane.showConfirmDialog(this, "Are you sure exit ?");
			if (exit == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		} else {
			super.processWindowEvent(e);
		}
	}
}
