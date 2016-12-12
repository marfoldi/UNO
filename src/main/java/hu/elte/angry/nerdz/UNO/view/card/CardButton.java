package hu.elte.angry.nerdz.UNO.view.card;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * 
 * @author marfoldi
 *
 */
public class CardButton extends JButton{
	private static final long serialVersionUID = 1738125548069780650L;
	private final Color color;
	private final int value;

	/**
	 * 
	 * @param color
	 * @param value
	 */
	public CardButton(Color color, int value) {
		super();
		this.color = color;
		this.value = value;
		//setForeground(Color.DARK_GRAY);
		setFont(new Font(getName(), Font.BOLD, 18));
		setPreferredSize(new Dimension(100, 150));
		setText(String.valueOf(value));
		setBackground(color);
	}
	
	/**
	 * 
	 * @param color
	 * @param value
	 * @param actionListener
	 */
	public CardButton(Color color, int value, ActionListener actionListener){
		this(color, value);
		addActionListener(actionListener);
	}

	public Color getColor() {
		return color;
	}

	public int getValue() {
		return value;
	}

}
