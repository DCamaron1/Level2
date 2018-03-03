package org.jointheleaue.level2.leagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int xSpeed;
	int ySpeed;

	public Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		xSpeed = 0;
		ySpeed = 0;
	}

	public void update() {
		x = x + xSpeed;
		y = y + ySpeed;
	}

	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
	}

	public void goRight() {
		xSpeed = 5;
	}

	public void goLeft() {
		xSpeed = -5;
	}

	public void goDown() {
		ySpeed = 5;
	}

	public void goUp() {
		ySpeed = -5;
	}
	
	public void stop() {
		ySpeed = 0;
		xSpeed = 0;
	}
}
