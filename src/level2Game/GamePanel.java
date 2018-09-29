package level2Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font menuFont;
	Font menuFont2;
	Font endFont1;
	Timer timer;
	static final int GROUND_LEVEL = 500;
	Sadie sadie = new Sadie(80, GROUND_LEVEL - 40, 50, 50);
	ObjectManager manager = new ObjectManager(sadie, 0);

	@Override
	public void paintComponent(Graphics g) {
		menuFont = new Font("David", Font.ROMAN_BASELINE, 42);
		menuFont2 = new Font("David", Font.ROMAN_BASELINE, 21);
		endFont1 = new Font("Arial", Font.CENTER_BASELINE, 60);
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	public void startGame() {
		timer.start();
	}

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
	}

	public void updateMenuState() {

	}

	public void updateGameState() {
		sadie.update();
		manager.update();
		manager.manageObjects();
		manager.checkCollision();
		manager.purgeObjects();
		if (sadie.isAlive == false) {
			currentState = END_STATE;
		}
	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {
		//g.setColor(Color.lightGray);
		//g.fillRect(0, 0, SadiesDashGame.WIDTH, SadiesDashGame.HEIGHT);
		Color skyBlue = new Color(102, 204, 255);
		Color groundBrown = new Color(102, 51, 10);
		g.setColor(skyBlue);
		g.fillRect(0, 0, SadiesDashGame.WIDTH, SadiesDashGame.HEIGHT);
		g.setColor(groundBrown);
		g.fillRect(0, GROUND_LEVEL, SadiesDashGame.WIDTH, SadiesDashGame.GROUNDH);
		g.setFont(menuFont);
		g.setColor(Color.black);
		g.drawString("Sadie's Dash", 350, 150);
		g.setFont(menuFont2);
		g.drawString("Press UP arrow key to JUMP", 353, 400);
		g.drawString("Press SPACE BAR to activate pills", 338, 440);
		g.setColor(Color.white);
		g.drawString("Press ENTER to start", 380, 520);
	}

	public void drawGameState(Graphics g) {
		Color skyBlue = new Color(102, 204, 255);
		Color groundBrown = new Color(102, 51, 10);
		g.setColor(skyBlue);
		g.fillRect(0, 0, SadiesDashGame.WIDTH, SadiesDashGame.HEIGHT);
		g.setColor(groundBrown);
		g.fillRect(0, GROUND_LEVEL, SadiesDashGame.WIDTH, SadiesDashGame.GROUNDH);
		manager.draw(g);
		g.setColor(Color.black);
		g.drawRect(19, 19, 301, 21);
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, SadiesDashGame.WIDTH, SadiesDashGame.HEIGHT);
		g.setFont(endFont1);
		g.setColor(Color.BLACK);
		g.drawString("Created by David Calderon", 100, 100);
		g.setColor(Color.red);
		g.drawString("Aww, you lost.", 300, 300);
		//g.setColor(Color.red);
		g.drawString("Better luck next time!", 230, 400);
		g.drawString("Your score: " + manager.getScore(), 300, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == 10) {
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			} else if (currentState == GAME_STATE) {
				currentState = END_STATE;
			} else if (currentState == END_STATE) {
				sadie = new Sadie(80, GROUND_LEVEL - 40, 50, 50);
				manager = new ObjectManager(sadie, manager.getHighScore());
				currentState = MENU_STATE;
			}
		}
		if (e.getKeyCode() == 38 && sadie.isJumping() == false) {
			sadie.jumpUp();
		}
		if (e.getKeyCode() == 32 && manager.inUse() == false) {
			manager.usePill();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}
}
