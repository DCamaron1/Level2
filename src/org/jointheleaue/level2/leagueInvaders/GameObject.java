package org.jointheleaue.level2.leagueInvaders;

import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int width;
	int height;

	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void update() {
		x = x + 1;
	}

	public void draw(Graphics g) {
		// g.setColor(new Color());
		g.fillRect(x, y, width, height);
		System.out.println(width + "x" + height);
	}
}
