package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	
	// Fps
	int FPS = 60;
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread; // this the game clock, keeps the game running at a certain speed(fps) keeps refreshing the screen at given time
	
	
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4;
	
	public GamePanel() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true); // this is set true, as all the drawings from this will be on an offscreen painting buffer
		
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
		
		
	}
	
	public void startGameThread() {
		gameThread = new Thread(this); // we are passing the GamePanel class in this Thread using "(this)"
		gameThread.start(); // going to call the run method below 
	}


	@Override
	public void run() {
		// this method is called when the Thread is started 
		// this where we are going to create our game loop which will be the core of our game.
		
		double drawInterval = 1000000000/FPS; // this is one second, i.e 1B nano sec
		                                      // drawing the screen 0.01666 seconds
		double nextDrawTime = System.nanoTime() + drawInterval;
		while(gameThread != null) {
			
			//1.UPDATE: update information such as character position
			update();
			
			//2 DRAW: draw the screen with the updated information
			
			repaint();
			
			try {
				double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000; // changing it to milli seconds 
				
                if(remainingTime < 0) {
                	remainingTime = 0;
                	
                }
                
                
                  Thread.sleep((long)remainingTime); // pauses game loop 
		
			       nextDrawTime += drawInterval;
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		
	
	}
	
	public void update() {
		
		// changing the player position
		if(keyH.upPressed == true) {
			playerY -= playerSpeed;
		}
		else if(keyH.downPressed == true) {
			playerY += playerSpeed;	
		}
		else if(keyH.leftPressed == true) {
			playerX -= playerSpeed;
		}
		else if(keyH.rightPressed == true){
			playerX += playerSpeed;
		}
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		// Now this is where we are going to draw something onto the screen
		
		Graphics2D g2 = (Graphics2D)g;  // we are converting the (Graphics g) into a 2d class
		
		g2.setColor(Color.white);
		
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		
		g2.dispose();
	}
	
	
	
	
	

}
