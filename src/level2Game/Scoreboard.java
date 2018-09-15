package level2Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Scoreboard {
	private long score = 0;
	private String scoreString;
	Font font;
	ScoreBox box = new ScoreBox(29, 460, 50, 50);

	public void paintComponent(Graphics g) {
		font = new Font("David", Font.ROMAN_BASELINE, 42);
	}

	public Scoreboard() {

	}

	public void update() {
		scoreString = "" + score;
	}

	public void draw(Graphics g) {
		box.draw(g);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString(scoreString, 20, 60);
	}

	/*public void checkCollisons() {
		if (box.collisionBox.intersects()) {
			score++;
		}
	}*/
}
