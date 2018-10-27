package level2Game;

import java.awt.Color;
import java.awt.Graphics;

public class GoodBoyPill extends GameObject{
	int xSpeed;
	
	public GoodBoyPill(int x, int y, int xSpeed) {
		super(x, y,50,20);
		this.xSpeed = xSpeed;
	}
	
	public void update() {
		super.update();
		x = x - xSpeed;
	}
	
	public void draw(Graphics g) {
		g.drawImage(level2Game.GamePanel.pillImg,x,y,50,20,null);
	}
	
	
	
}
