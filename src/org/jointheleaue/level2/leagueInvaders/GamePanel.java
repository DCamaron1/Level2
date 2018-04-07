package org.jointheleaue.level2.leagueInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font menuFont1;
	Font menuFont2;
	Font menuFont3;
	Font finalFont1;
	Font finalFont2;
	Font finalFont3;
    public static BufferedImage alienImg;
    public static BufferedImage rocketImg;
    public static BufferedImage bulletImg;
    public static BufferedImage spaceImg;
	Rocketship bob = new Rocketship(250, 700, 50, 50);
	ObjectManager manager = new ObjectManager(bob);

	@Override
	public void paintComponent(Graphics g) {
		menuFont1 = new Font("Arial", Font.BOLD, 48);
		menuFont2 = new Font("Arial", Font.BOLD, 24);
		menuFont3 = new Font("Arial", Font.BOLD, 24);
		finalFont1 = new Font("Arial", Font.PLAIN, 48);
		finalFont2 = new Font("Arial", Font.PLAIN, 24);
		finalFont3 = new Font("Arial", Font.PLAIN, 24);
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		 try {
             alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
             rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
             bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
             spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
     } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
     }
	}

	public void startGame() {
		timer.start();
	}

	public void updateMenuState() {

	}

	public void updateGameState() {
		manager.update();
		manager.manageEnemies();
		manager.checkCollision();
		manager.purgeObject();
		manager.getScore();
		if (bob.isAlive == false) {
			currentState = END_STATE;
		}
	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(menuFont1);
		g.setColor(Color.yellow);
		g.drawString("LEAGUE INVADERS", 20, 200);
		g.setFont(menuFont2);
		g.setColor(Color.yellow);
		g.drawString("Press ENTER to start", 115, 350);
		g.setFont(menuFont2);
		g.setColor(Color.yellow);
		g.drawString("Press SPACE for instructions", 80, 500);
	}

	public void drawGameState(Graphics g) {
		 g.drawImage(GamePanel.spaceImg, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT, null);
		manager.draw(g);
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(finalFont1);
		g.setColor(Color.black);
		g.drawString("Game Over", 130, 200);
		g.setFont(finalFont2);
		g.setColor(Color.black);
		g.drawString("You killed " + manager.getScore() + " enemies", 135, 350);
		g.setFont(finalFont3);
		g.setColor(Color.black);
		g.drawString("Press ENTER to restart", 115, 500);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		// gameObject.update();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		bob.update();
		if (e.getKeyCode() == 10) {
			if (currentState == MENU_STATE) {
				currentState = GAME_STATE;
			} else if (currentState == GAME_STATE) {
				currentState = END_STATE;
			} else if (currentState == END_STATE) {
				bob = new Rocketship(250, 700, 50, 50);
				manager = new ObjectManager(bob);
				currentState = MENU_STATE;
			}
		}

		if (e.getKeyCode() == 37) {
			bob.goLeft();
		}

		if (e.getKeyCode() == 39) {
			bob.goRight();
		}

		if (e.getKeyCode() == 38) {
			bob.goUp();
		}

		if (e.getKeyCode() == 40) {
			bob.goDown();
		}

		if (e.getKeyCode() == 32) {
			manager.addProjectile(new Projectile(bob.x + bob.width / 2 - 5, bob.y, 10, 10));

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		bob.stop();
	}

}
