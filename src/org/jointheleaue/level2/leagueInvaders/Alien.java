package org.jointheleaue.level2.leagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {

	public Alien(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public void draw(Graphics g) {
        g.drawImage(GamePanel.alienImg, x, y, width, height, null);
	}

	public void update() {
		super.update();
		y = y + 6;
	}
}
