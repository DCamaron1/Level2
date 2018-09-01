package level2Game;

import java.awt.Color;
import java.awt.Graphics;

public class Bush extends GameObject {
	int xSpeed;

	public Bush(int x, int y, int xSpeed) {
		super(x, y, 40, 40);
		this.xSpeed = xSpeed;
	}

	public void update() {
		super.update();
		x = x - xSpeed;
	}

	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}
}
