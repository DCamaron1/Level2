package level2Game;

import java.awt.Color;
import java.awt.Graphics;

public class Sadie extends GameObject{

	public Sadie(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.drawRect(50,50,50,50);
	}
}
