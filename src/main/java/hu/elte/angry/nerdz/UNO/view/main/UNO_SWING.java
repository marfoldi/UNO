package hu.elte.angry.nerdz.UNO.view.main;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UNO_SWING extends javax.swing.JFrame implements ActionListener {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object frame;





	public static JMenuBar createMenuBar() {
		
		
		
		
		
/*	JFrame ablak;*/
    JMenuBar menuBar;
    JMenu menu, submenu;
    JMenuItem menuItem;
 
    
    

    //Create the menu bar.
    menuBar = new JMenuBar();

    //Build the File Menu.
    menu = new JMenu("File");
    menu.setMnemonic(KeyEvent.VK_F);
    menu.getAccessibleContext().setAccessibleDescription("Dealing with Files");
    menuBar.add(menu);

    //a group of JMenuItems
    menuItem = new JMenuItem("New Game...",
            new ImageIcon("images/newproject.png"));
    menuItem.setMnemonic(KeyEvent.VK_P);
    menuItem.setAccelerator(KeyStroke.getKeyStroke(
            KeyEvent.VK_1, ActionEvent.ALT_MASK));
    menuItem.getAccessibleContext().setAccessibleDescription(
            "New Project");
    menu.add(menuItem);

   
  

 
    menu.addSeparator();
    submenu = new JMenu("A submenu");
    submenu.setMnemonic(KeyEvent.VK_S);

    menuItem = new JMenuItem("Menu item in the submenu");
    menuItem.setAccelerator(KeyStroke.getKeyStroke(
            KeyEvent.VK_2, ActionEvent.ALT_MASK));
    submenu.add(menuItem);

    menuItem = new JMenuItem("Another menu item");
    submenu.add(menuItem);
    menu.add(submenu);

    //Build Edit menu in the menu bar.
    menu = new JMenu("Edit");
    menu.setMnemonic(KeyEvent.VK_E);
    menu.getAccessibleContext().setAccessibleDescription(
            "Edit Menu");
    menuBar.add(menu);
    return menuBar;
	}



    

   /*void centerWindow(Window frame)*/
	
	  void setCenter(JFrame ablak)
   {
	  

	Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		frame = null;
		int x = (int) ((dimension.getWidth() - ((Dimension) frame).getWidth()) / 2);
		int y = (int) ((dimension.getHeight() - ((Dimension) frame).getHeight()) / 2);
		
		Point ablakCenter = new Point(x, y);
		ablak.setLocation(ablakCenter);

	  }  
    

	

public static void main(String[] args) {
	// TODO Auto-generated method stub
	 final JFrame frame = new JFrame("Uno Card Game");
      frame.setJMenuBar(createMenuBar());
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
      
        frame.setVisible(true);
}





@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
  

	
}
	


