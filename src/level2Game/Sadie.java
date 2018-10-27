package level2Game;

import java.awt.Color;
import java.awt.Graphics;

import org.jointheleaue.level2.leagueInvaders.GamePanel;

public class Sadie extends GameObject {
	int xSpeed;
	int ySpeed;

	public Sadie(int x, int y, int width, int height) {
		super(x, y, width, height);
		xSpeed = 0;
		ySpeed = 0;
	}

	public void update() {
		super.update();
		y = y + ySpeed;
		if (y > 460) {
			y = 460;
		}
		if (y < 340) {
			ySpeed = 4;
		}
	}

	public void draw(Graphics g) {
		g.drawImage(level2Game.GamePanel.sadieImg,x,y,50,50,null);
	}

	public void stop() {
		ySpeed = 0;
	}

	public void jumpUp() {
		ySpeed = -4;
	}
	
	public boolean isJumping(){
		if(y==460){
			return false;
		}
		else{
			return true;
		}
	}
}
