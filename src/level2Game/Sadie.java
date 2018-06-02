package level2Game;

import java.awt.Color;
import java.awt.Graphics;

public class Sadie extends GameObject{
	int xSpeed;
	int ySpeed;
	
	public Sadie(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(50,460,50,50);
	}
}
