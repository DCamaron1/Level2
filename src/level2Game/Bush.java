package level2Game;

import java.awt.Color;
import java.awt.Graphics;

public class Bush extends GameObject{
	int xSpeed; 
	
	public Bush(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void update() {
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(500,460,50,50);
	}
}
