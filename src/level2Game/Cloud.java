package level2Game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Cloud extends GameObject {
	int xSpeed;
	int cloudY = new Random().nextInt(30);

	public Cloud(int x, int y, int xSpeed) {
		super(x, y, 100, 50);
		this.xSpeed = xSpeed;
	}

	public void update() {
		super.update();
		x = x - xSpeed;
	}

	public void draw(Graphics g) {
		g.drawImage(level2Game.GamePanel.cloudImg,x,y,100,50,null);
	}
}
