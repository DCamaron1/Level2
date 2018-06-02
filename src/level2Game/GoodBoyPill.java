package level2Game;

import java.awt.Color;
import java.awt.Graphics;

public class GoodBoyPill extends GameObject{
	int xSpeed;
	
	public GoodBoyPill(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(300,470,50,20);
	}

}
