package hu.elte.angry.nerdz.UNO.view.card;

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
	private final CardColor color;
	private final CardValue value;

	/**
	 * 
	 * @param color
	 * @param value
	 */
	public CardButton(CardColor color, CardValue value) {
		super();
		this.color = color;
		this.value = value;
		//setForeground(Color.DARK_GRAY);
		setFont(new Font(getName(), Font.BOLD, 18));
		setPreferredSize(new Dimension(100, 150));
		setText(String.valueOf(value.getPrimitiveValue()));
		setBackground(color.getAwtColor());
	}
	
	/**
	 * 
	 * @param color
	 * @param value
	 * @param actionListener
	 */
	public CardButton(CardColor color, CardValue value, ActionListener actionListener){
		this(color, value);
		addActionListener(actionListener);
	}

	/**
	 * @return the color
	 */
	public CardColor getColor() {
		return color;
	}

	/**
	 * @return the value
	 */
	public CardValue getValue() {
		return value;
	}
}
