package level2Game;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SadiesDashGame {
	JFrame frame = new JFrame();
	static final int WIDTH = 1100;
	static final int HEIGHT = 600;
	static final int GROUNDW = 1100;
	static final int GROUNDH = 100;
	GamePanel panel;

	public void createUI() throws IOException {
		panel = new GamePanel();
		frame.setVisible(true);
		frame.addKeyListener(panel);
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT);
		panel.startGame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) throws IOException {
		SadiesDashGame bob = new SadiesDashGame();
		bob.createUI();
	}
}
