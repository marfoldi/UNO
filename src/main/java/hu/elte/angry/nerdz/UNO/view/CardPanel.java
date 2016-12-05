package hu.elte.angry.nerdz.UNO.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CardPanel extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1738125548069780650L;

	public CardPanel() {
		super();
		setForeground(Color.DARK_GRAY);
		setFont(new Font(getName(), Font.BOLD, 18));
		setPreferredSize(new Dimension(100, 150));
	}
	
	public CardPanel(int value, Color color){
		this();
		setCardParams(value, color);
	}
	
	public CardPanel(int value, Color color, ActionListener actionListener){
		this(value,color);
		addActionListener(actionListener);
	}
	
	/**
	 * Sets the Card params
	 * 
	 * @param value
	 * @param color
	 */
	public void setCardParams(int value, Color color){
		setText(String.valueOf(value));
		setBackground(color);
	}
}
