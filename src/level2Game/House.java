package level2Game;

import java.awt.Color;
import java.awt.Graphics;

public class House extends GameObject {
	int xSpeed;

	public House(int x, int y, int xSpeed) {
		super(x, y, 70, 90);
		this.xSpeed = xSpeed;
	}

	public void update() {
		super.update();
		x = x - xSpeed;
	}

	public void draw(Graphics g) {
		g.drawImage(level2Game.GamePanel.houseImg,x,y,70,90,null);
	}

}
