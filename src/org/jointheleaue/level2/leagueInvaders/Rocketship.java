package org.jointheleaue.level2.leagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 5;
	}

	public void update(Graphics g) {

	}

	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}

	public void goRight() {
		x = x + speed;
	}

	public void goLeft() {
		x = x - speed;
	}

	public void goDown() {
		y = y + speed;
	}

	public void goUp() {
		y = y - speed;
	}
}
