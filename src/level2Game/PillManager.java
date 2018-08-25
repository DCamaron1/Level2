package level2Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class PillManager {
	Sadie sadie;
	private long pillTimer = 0;
	private int yourPills = 0;
	String yourPillsString;
	private int pillLength = 300;
	private long timer = 0;
	ArrayList<GoodBoyPill> pills = new ArrayList<GoodBoyPill>();

	public PillManager(Sadie rose) {
		sadie = rose;
	}

	public void update() {
		for (int i = 0; i < pills.size(); i++) {
			pills.get(i).update();
		}
		if (sadie.isProtected == true) {
			pillTimer++;
			pillLength--;
			System.out.println(pillTimer);
		}
		if (pillTimer > 300) {
			sadie.isProtected = false;
			pillTimer = 0;
		}
		if (yourPills <= 5) {
			yourPillsString = "" + yourPills;
		}
		if (yourPills >= 5) {
			yourPillsString = "max";
			yourPills = 5;
		}
		if (pillLength<0) {
			pillLength=300;
		}
	}

	public void draw(Graphics g) {
		for (int i = 0; i < pills.size(); i++) {
			pills.get(i).draw(g);
		}
		g.setColor(Color.black);
		Font font = new Font("David", Font.BOLD, 18);
		g.drawString(yourPillsString, 17, 15);
		if (sadie.isProtected) {
			g.setColor(Color.YELLOW);
			g.fillRect(20, 20, pillLength, 20);
		} else if (yourPills > 0) {
			g.setColor(Color.YELLOW);
			g.fillRect(20, 20, 300, 20);
		} 
		
	}
	
	public void addYPill() {
		yourPills = yourPills + 1;
	}

	public void addPill(GoodBoyPill pill) {
		pills.add(pill);
	}

	public void managePills() {
		long pillSpawnTime = new Random().nextInt(500)+ 200;
		if (System.currentTimeMillis() - timer >= pillSpawnTime * 2000) {
			addPill(new GoodBoyPill(SadiesDashGame.WIDTH, 450, 2));
			timer = System.currentTimeMillis();
		}
	}

	public void purgeObjects() {
		for (int i = 0; i < pills.size(); i++) {
			boolean isAliveCheck = pills.get(i).isAlive;
			if (isAliveCheck == false) {
				pills.remove(i);
			}
		}
	}

	public void checkCollision() {
		for (GoodBoyPill a : pills) {
			if (sadie.collisionBox.intersects(a.collisionBox)) {
				addYPill();
				a.isAlive = false;
			}
		}
	}

	public void usePills() {
		if (yourPills > 0) {
			sadie.isProtected = true;
			yourPills = yourPills - 1;
		}
	}
	
	public boolean inUse() {
		if (pillTimer >0) {
			System.out.println("in use");
			return true;
		}
		else {
			System.out.println("not in use");
			return false;
		}
	}
	
	
	
	
}
