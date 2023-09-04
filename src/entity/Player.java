package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	
	GamePanel gp;
	KeyHandler keyH;
	
	
	
	
	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		setDefaultValues();
		getPalayerImage();
		
	}
	

	public void setDefaultValues() {
		
		y = 100;
		x = 100;
		speed = 4;
		direction = "down";
	}
	
	public void getPalayerImage() {
		
		try {
			
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/New Piskel up1-1.png.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/New Piskel up2-1.png.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/New Piskel down1-1.png.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/New Piskel down2-1.png.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/New Piskel left1-1.png.png"));
			left2= ImageIO.read(getClass().getResourceAsStream("/player/New Piskel left2-1.png.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/New Piskel right1-1.png.png"));
			right2= ImageIO.read(getClass().getResourceAsStream("/player/New Piskel right2-1.png.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		if(keyH.upPressed == true) {
			direction = "up";
			y -= speed;
		}
		else if(keyH.downPressed == true) {
			direction = "down";
			y += speed;	
		}
		else if(keyH.leftPressed == true) {
			direction = "left";
			x -= speed;
		}
		else if(keyH.rightPressed == true){
			direction = "right";
			x += speed;
		}
		spriteCounter++;
		if(spriteCounter > 10) {
			if(spriteNum == 1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
	}
	
	public void draw(Graphics2D g2) {
		
	//g2.setColor(Color.white); 
    //g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		
		BufferedImage image = null;
		switch(direction) {
		case "up":
			if(spriteNum == 1) {
				image = up1;
			}
			if (spriteNum == 2) {
				image = up2;
			}
			break;
		case "down":
			if(spriteNum == 1) {
				image = down1;
			}
			if (spriteNum == 2) {
				image = down2;
				
				break;
			}
		case "left":
			if(spriteNum == 1) {
				image = left1;
			}
			if (spriteNum == 2) {
				image = left2;
			}
			break;
		case "right":
			if(spriteNum == 1) {
				image = right1;
			}
			if (spriteNum == 2) {
				image = right2;
			}
			break;
			
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null); 
		
		
		
	}
	
}
