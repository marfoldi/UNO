package hu.elte.angry.nerdz.UNO.view.main;


/*@author Robert */

import javax.swing.*;
import javax.swing.event.MenuEvent;



import java.awt.*;
import java.awt.event.*;



import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class UNO_SWING  extends JFrame { 

	public UNO_SWING() {
        
        setTitle("Uno Card 2016 1.0");
        setSize(650, 650);
         
        // Creates a menubar for a JFrame
        JMenuBar menuBar = new JMenuBar();
         
        // Add the menubar to the frame
        setJMenuBar(menuBar);
         
        // Define and add two drop down menu to the menubar
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
         
        // Create and add simple menu item to one of the drop down menu
        JMenuItem newAction = new JMenuItem("New");
     /*   JMenuItem openAction = new JMenuItem("Open");*/
        JMenuItem exitAction = new JMenuItem("Exit");
       
        JMenuItem helpAction = new JMenuItem("Help"); /*submenu*/
        JMenuItem InfoAction = new JMenuItem("Info");    
        
        
      /*  JMenuItem cutAction = new JMenuItem("Cut");
        JMenuItem copyAction = new JMenuItem("Copy");
        JMenuItem pasteAction = new JMenuItem("Paste");*/
         
        // Create and add CheckButton as a menu item to one of the drop down
        // menu
     
        
        /*JCheckBoxMenuItem checkAction = new JCheckBoxMenuItem("Check Action");
        // Create and add Radio Buttons as simple menu items to one of the drop
        // down menu
        JRadioButtonMenuItem radioAction1 = new JRadioButtonMenuItem(
                "Radio Button1");
        JRadioButtonMenuItem radioAction2 = new JRadioButtonMenuItem(
                "Radio Button2");
        // Create a ButtonGroup and add both radio Button to it. Only one radio
        // button in a ButtonGroup can be selected at a time.*/
       
        
        
        ButtonGroup bg = new ButtonGroup();
      /*  bg.add(radioAction1);
        bg.add(radioAction2);*/
       
        
        fileMenu.add(newAction);
        helpMenu.add(helpAction);
        helpMenu.add(InfoAction);
        /*fileMenu.add(openAction);
        fileMenu.add(checkAction);*/
       
        
        fileMenu.addSeparator();
        fileMenu.add(exitAction);
        
        
        /*editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);
        editMenu.addSeparator();
       
        
        editMenu.add(radioAction1);
        editMenu.add(radioAction2);*/
        // Add a listener to the New menu item. actionPerformed() method will
        // invoked, if user triggred this menu item
        
        
        newAction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("You have clicked on the new action");
            }
        });
    }
		   
	
public static void main(String[] args) {
	// TODO Auto-generated method stub
	UNO_SWING me = new UNO_SWING();
    me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    me.setVisible(true);
}





}


