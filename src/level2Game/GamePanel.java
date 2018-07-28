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
	Font endFont1;
	Font endFont;
	Timer timer;
	Sadie sadie = new Sadie(80, 460, 50, 50);
	ObjectManager manager = new ObjectManager(sadie);

	@Override
	public void paintComponent(Graphics g) {
		menuFont = new Font("David", Font.ROMAN_BASELINE, 42);
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
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, SadiesDashGame.WIDTH, SadiesDashGame.HEIGHT);
		g.setFont(menuFont);
		g.setColor(Color.black);
		g.drawString("Sadie's Dash", 200, 300);
	}

	public void drawGameState(Graphics g) {
		Color skyBlue = new Color(102, 204, 255);
		Color groundBrown = new Color(102, 51, 10);
		g.setColor(skyBlue);
		g.fillRect(0, 0, SadiesDashGame.WIDTH, SadiesDashGame.HEIGHT);
		g.setColor(groundBrown);
		g.fillRect(0, 500, SadiesDashGame.GROUNDW, SadiesDashGame.GROUNDH);
		manager.draw(g);
		g.setColor(Color.YELLOW);
		g.drawRect(20,20,100,20);

	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, SadiesDashGame.WIDTH, SadiesDashGame.HEIGHT);
		g.setFont(endFont1);
		g.setColor(Color.BLACK);
		g.drawString("Created by David Calderon", 200, 300);
		g.setColor(Color.red);
		g.drawString("Aww, you lost.", 300, 300);
		g.setColor(Color.red);
		g.drawString("Better luck next time", 230, 400);
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
				sadie= new Sadie(80,460,50,50);
				manager=new ObjectManager(sadie);
				currentState = MENU_STATE;
			}
		}

		if (e.getKeyCode() == 32) {
			sadie.jumpUp();
		}
		
		if (e.getKeyCode()==83 && manager.yourPills>0) {
			sadie.isProtected=true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
