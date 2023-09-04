package main;

import javax.swing.JFrame;

public class Main {
	
	public static void main(String[] argds ) {
		
	JFrame window = new JFrame();
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // this allow the user to close the window properly using the (x)
	window.setResizable(false);  // this to make sure the window can't be resized
	window.setTitle("2D Adventure Game");
	
	GamePanel gamePanel = new GamePanel(); // we are adding the GamePanel to the Window 
	window.add(gamePanel);
	
	window.pack(); // this so we can actually see the window 
	
	window.setLocationRelativeTo(null); // this ensures that the window will be displayed at the center of the screen;
	window.setVisible(true);  // this so we can see the window.
	
	gamePanel.startGameThread();
	
    
	
	
	
	
	}

}
