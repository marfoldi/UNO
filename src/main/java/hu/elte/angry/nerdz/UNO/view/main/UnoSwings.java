package hu.elte.angry.nerdz.UNO.view.main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class UnoSwings extends JFrame implements ActionListener {

	JMenu file, help;
	JMenuItem newProjekt, closeProjekt, HelpProjekt;
	/* private AbstractButton exitAction; */

	private static final long serialVersionUID = 1L;

	public void ConfirmExitDialog() {

		// -------------------------------------------------------------
		// Call super class constructor plus set the size for the Window
		// -------------------------------------------------------------

		this.setSize(350, 150);

		// ------------------------------------------------------------------
		// Get the frame's content pane. It is not neccessary to set the
		// layout manager to BorderLayout (as I did below) since BorderLayout
		// is the default for the frame's content pane.
		// ------------------------------------------------------------------
		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		// -----------------
		// Simple text label
		// -----------------
		JLabel label1 = new JLabel("Confirm Exit Dialog Example", JLabel.LEFT);

		// -----------------------------------------------------
		// Add all buttons directory to the frame's content pane
		// -----------------------------------------------------
		contentPane.add(label1, BorderLayout.SOUTH);

	}

	public UnoSwings() {

		setTitle("Uno Card 2016 1.0");
		setSize(650, 650);

		// Creates a menubar for a JFrame
		JMenuBar menuBar = new JMenuBar();

		// Add the menubar to the frame
		setJMenuBar(menuBar);

		// Define and add two drop down menu to the menubar
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);

		// Create and add simple menu item to one of the drop down menu
		JMenuItem newAction = new JMenuItem("New Game");
		/* JMenuItem openAction = new JMenuItem("Open"); */
		JMenuItem exitAction = new JMenuItem("Exit");
		exitAction.addActionListener(this);

		JMenuItem helpAction = new JMenuItem("Help"); /* submenu */
		JMenuItem InfoAction = new JMenuItem("Info");

		new ButtonGroup();

		fileMenu.add(newAction);
		helpMenu.add(helpAction);

		helpMenu.add(InfoAction);

		/*
		 * fileMenu.add(openAction); fileMenu.add(checkAction);
		 */

		fileMenu.addSeparator();
		fileMenu.add(exitAction);
		fileMenu.addSeparator();
		fileMenu.add(InfoAction);

		// Add a listener to the New menu item. actionPerformed() method will
		// invoked, if user triggred this menu item

		InfoAction.addActionListener(new ActionListener() {

			/* newAction.addActionListener(new ActionListener() { */

			public void actionPerformed(ActionEvent e) {

				new AboutBox();

			}
		});

		exitAction.addActionListener(new ActionListener() {

			/* newAction.addActionListener(new ActionListener() { */

			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});

	}

	protected void processWindowEvent(WindowEvent e) {

		if (e.getID() == WindowEvent.WINDOW_CLOSING) {

			int exit = JOptionPane.showConfirmDialog(this, "Are you sure exit ?");
			if (exit == JOptionPane.YES_OPTION) {
				System.exit(0);
			}

		} else {

			// If you do not want listeners processing the WINDOW_CLOSING
			// events, you could this next call in an else block for the:
			// if (e.getID() ...)
			// statement. That way, only the other types of Window events
			// (iconification, activation, etc.) would be sent out.

			super.processWindowEvent(e);
		}

	}

	public static void main(String[] args) {
		UnoSwings GUI = new UnoSwings();
		GUI.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		
		 */

	}
}
