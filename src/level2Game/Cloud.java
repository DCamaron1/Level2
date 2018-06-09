package level2Game;

import java.awt.Color;
import java.awt.Graphics;

public class Cloud extends GameObject{
	int xSpeed; 
	
	public Cloud(int x, int y, int xSpeed) {
		super(x, y,100,50);
		xSpeed= this.xSpeed;
	}

	public void update() {
		super.update();
		x = x - xSpeed;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(x,y,width,height);
	}
}
