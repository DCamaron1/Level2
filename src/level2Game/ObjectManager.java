package level2Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import org.jointheleaue.level2.leagueInvaders.Alien;
import org.jointheleaue.level2.leagueInvaders.LeagueInvaders;
import org.jointheleaue.level2.leagueInvaders.Projectile;

public class ObjectManager {
	Sadie sadie;
	long timer = 0;
	long pillTimer = 0;
	ArrayList<House> houses = new ArrayList<House>();
	ArrayList<Cloud> clouds = new ArrayList<Cloud>();
	ArrayList<Bush> bushes = new ArrayList<Bush>();
	ArrayList<GoodBoyPill> pills = new ArrayList<GoodBoyPill>();
	int yourPills = 0;
	String yourPillsString; 
	int pillTime=300;

	public ObjectManager(Sadie rose) {
		sadie = rose;
	}

	public void update() {
		for (int i = 0; i < clouds.size(); i++) {
			clouds.get(i).update();
		}
		for (int i = 0; i < houses.size(); i++) {
			houses.get(i).update();
		}
		for (int i = 0; i < bushes.size(); i++) {
			bushes.get(i).update();
		}
		for (int i = 0; i < pills.size(); i++) {
			pills.get(i).update();
		}
		if (sadie.isProtected == true) {
			pillTimer++;
			pillTime--;
			System.out.println(pillTimer);
			
		}
		if (pillTimer > 300) {
			sadie.isProtected = false;
			pillTimer=0;
		}
		if (yourPills<=5) {
			yourPillsString = "" + yourPills;
		}
		if (yourPills>5) {
			yourPillsString = "max";
		}
		//if (pillTime==0 && yourPills>0) {
		//	pillTime=300;
		//}
	}

	public void draw(Graphics g) {
		for (int i = 0; i < clouds.size(); i++) {
			clouds.get(i).draw(g);
		}
		for (int i = 0; i < houses.size(); i++) {
			houses.get(i).draw(g);
		}
		for (int i = 0; i < bushes.size(); i++) {
			bushes.get(i).draw(g);
		}
		for (int i = 0; i < pills.size(); i++) {
			pills.get(i).draw(g);
		}
		sadie.draw(g);
		g.setColor(Color.YELLOW);
		g.fillRect(20,20,pillTime,20);
		g.setColor(Color.black);
		Font font = new Font("David", Font.BOLD, 18);
		g.drawString(yourPillsString,17,15);
	}

	public void addCloud(Cloud cloud) {
		clouds.add(cloud);
	}

	public void addHouse(House house) {
		houses.add(house);
	}

	public void addBush(Bush bush) {
		bushes.add(bush);
	}

	public void addPill(GoodBoyPill pill) {
		pills.add(pill);
	}

	public void addYPill() {
		yourPills = yourPills + 1;
	}

	public void manageObjects() {
		long cloudSpawnTime = new Random().nextInt(500);
		long bushSpawnTime = new Random().nextInt(400 + 50);
		long pillSpawnTime = new Random().nextInt(800 + 500);
		if (System.currentTimeMillis() - timer >= cloudSpawnTime * 1000) {
			addCloud(new Cloud(1100, 30, 1));
			timer = System.currentTimeMillis();
		}
		if (System.currentTimeMillis() - timer >= cloudSpawnTime * 2000) {
			addHouse(new House(1100, 410, 3));
			timer = System.currentTimeMillis();
		}
		if (System.currentTimeMillis() - timer >= bushSpawnTime * 1000) {
			addBush(new Bush(1100, 460, 4));
			timer = System.currentTimeMillis();
		}
		if (System.currentTimeMillis() - timer >= pillSpawnTime * 3000) {
			addPill(new GoodBoyPill(1100, 450, 2));
			timer = System.currentTimeMillis();
		}
	}

	public void checkCollision() {
		for (Bush a : bushes) {
			if (sadie.collisionBox.intersects(a.collisionBox) && sadie.isProtected == false) {
				sadie.isAlive = false;
			}
		}

		for (GoodBoyPill a : pills) {
			if (sadie.collisionBox.intersects(a.collisionBox)) {
				addYPill();
				a.isAlive = false;
			}
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
}
