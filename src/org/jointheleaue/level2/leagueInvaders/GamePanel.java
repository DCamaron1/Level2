package org.jointheleaue.level2.leagueInvaders;

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
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;
	Font menuFont;
	Font finalFont;

	@Override
	public void paintComponent(Graphics g) {
		menuFont = new Font("Arial",Font.PLAIN,48);
		finalFont = new Font("Arial",Font.PLAIN,48);
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
		// gameObject = new GameObject(50, 10, 100, 100);
	}

	public void startGame() {
		timer.start();
	}

	public void updateMenuState() {

	}

	public void updateGameState() {

	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(menuFont);
		g.setColor(Color.yellow);
		g.drawString("LEAGUE INVADERS", 20,200 );
	}

	public void drawGameState(Graphics g) {
		//System.out.println("drawing game state");
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}

	public void drawEndState(Graphics g) {
		//System.out.println("drawing end state");
		g.setColor(Color.red);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(finalFont);
		g.setColor(Color.black);
		g.drawString("Game Over", 100, 200);
		
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
		// System.out.println("action");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("typed");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("pressed");
		if(currentState == MENU_STATE){
			currentState=GAME_STATE;
			System.out.println("Drawing Game State");
		}

		else if(currentState == GAME_STATE){
			currentState = END_STATE;
            System.out.println("Checking End State");
		}
		else if(currentState == END_STATE){
            currentState = MENU_STATE;
            System.out.println("Checking Menu State");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("released");
	}

}
