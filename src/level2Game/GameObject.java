package level2Game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	boolean isAlive = true;
	boolean isProtected = false;
	Rectangle collisionBox;

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
