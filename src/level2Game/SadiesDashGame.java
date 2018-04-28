package level2Game;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SadiesDashGame {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	
	public void createUI() {
		frame.setVisible(true);
		frame.add(panel);
		frame.setSize(1100,500);
		
	}
	
	public static void main(String[] args) {
		SadiesDashGame bob = new SadiesDashGame();
		bob.createUI();
	}
}
