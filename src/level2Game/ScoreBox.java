package level2Game;

import java.awt.Color;
import java.awt.Graphics;

public class ScoreBox extends GameObject{

	public ScoreBox(int x, int y, int width, int height) {
		super(x, y, width, height);	
	}
	
	public void update() { 
		
	}

	public void draw(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect(x,y,height,width);
	}
}	
	
