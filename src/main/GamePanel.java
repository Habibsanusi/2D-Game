package main;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;

// this game panel works kinda like a game screen.
public class GamePanel extends JPanel implements Runnable{
	
	// SCREEN SETTINGS
	final int originalTilesize = 16; // 16x16 tile means thats going to be the size of player characters, npcs, map tiles.
	final int scale = 3; //this is to scale the tile size as it would be to small for modern day computer screens
	
	final int tileSize = originalTilesize * scale; // now the tile size has been scaled to be 48x48 which a lot bigger and clearer.
	
	// now you have to determine how many tiles can be displayed on a single screen, Horizontally and Vertically 
	final int maxScreenCol = 16;  // so 16 tiles across "Horizontally"
	final int maxScreenRow = 12; // and 12 tiles down "Vertically"
	final int screenWidth = tileSize * maxScreenCol; // this will be 48*16 = 768 pixels 
	final int screenHeight = tileSize * maxScreenRow; // this will be 48*12 = 576 pixels
	
	
	Thread gameThread; // this the game clock, keeps the game running at a certain speed(fps) keeps refreshing the screen at given time
	
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); // this is set true, as all the drawings from this will be on an offscreen painting buffer
		
		
		
		
	}
	
	public void startGameThread() {
		gameThread = new Thread(this); // we are passing the GamePanel class in this Thread using "(this)"
		gameThread.start(); // going to call the run method below 
	}


	@Override
	public void run() {
		// this method is called when the Thread is started 
		// this where we are going to create our game loop which will be the core of our game.
		
		
	}
	
	
	
	

}
