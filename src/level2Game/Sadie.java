package level2Game;

import java.awt.Color;
import java.awt.Graphics;

public class Sadie extends GameObject{
	int xSpeed;
	int ySpeed;
	
	public Sadie(int x, int y, int width, int height) {
		super(x, y, width, height);
		xSpeed = 0;
		ySpeed = 0;
	}
	
	public void update() {
		y = y + ySpeed;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x,y,50,50);
	}
	public void stop(){
		ySpeed = 0;
	}
	
	public void jumpUp(){
		ySpeed = -4;
	}
	
	public void jumpDown(){
		ySpeed = 4;
	}
}
