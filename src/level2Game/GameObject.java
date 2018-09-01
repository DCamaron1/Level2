package level2Game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	private int x;
	private int y;
	private int width;
	private int height;
	private boolean isAlive = true;
	private boolean isProtected = false;
	private Rectangle collisionBox;

	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle(x, y, height, width);
	}

	public void update() {
		collisionBox.setBounds(x, y, width, height);

	}

	public void draw(Graphics g) {

	}

}
