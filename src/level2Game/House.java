package level2Game;

import java.awt.Color;
import java.awt.Graphics;

public class House extends GameObject{
	int xSpeed;
	
	public House(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public void update() {
		
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(1000,410,100,100);
	}
	
	
}
