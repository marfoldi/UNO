package hu.elte.angry.nerdz.UNO.view;

import java.awt.Dimension;

import javax.swing.JButton;

public class DeckPanel extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1936620884021404951L;

	public DeckPanel(){
		setPreferredSize(new Dimension(100, 150));
		setName("New Card");
	}
}
