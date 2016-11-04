package hu.elte.angry.nerdz.UNO.view.main;

/*@author Robert */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 
 * 
 * @author Róbert
 *
 */
public class UNO_SWING extends JFrame {

	JMenu file, help;
	JMenuItem newProjekt, closeProjekt, HelpProjekt;

	private static final long serialVersionUID = 1L;
	 
	 
	public UNO_SWING() {

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

		}

		
			
		        
			
			 public static void main(String[] args) {
				 UNO_SWING me = new UNO_SWING();
					/*AboutBox ab = new AboutBox();*/
					me.setVisible(true);
				
						
			 }
	    }
 
			 
		
					
						
					
			 
	
	  
	

			 
			 
		
	


	
		
	


	
	
	
	
	



