package level2Game;

import java.awt.Color;
import java.awt.Graphics;

public class Cloud extends GameObject{
	int xSpeed; 
	
	public Cloud(int x, int y, int width, int height) {
		super(x, y, width, height);
		xSpeed=2;
	}

	public void update() {
		x = x + xSpeed;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(500,40,100,50);
	}
}
