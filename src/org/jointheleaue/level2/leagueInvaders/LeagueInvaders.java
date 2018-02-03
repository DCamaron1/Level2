package org.jointheleaue.level2.leagueInvaders;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	JFrame frame; 
	final int WIDTH = 500;
	final int HEIGHT = 800;
	GamePanel gamePanel;
	
	public LeagueInvaders(){
		frame = new JFrame();
		gamePanel = new GamePanel();
	}
	
	public void setup(){
		frame.add(gamePanel);
		frame.addKeyListener(gamePanel);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.pack();
		gamePanel.startGame();
		System.out.println(gamePanel.getSize());
	}
	
	public static void main(String[] args) {
		LeagueInvaders bob = new LeagueInvaders();
		bob.setup();
	}
}
