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
	private long timer = 0;
	private long score = 0;
	private long highScore = 0;
	private String scoreString;
	private String highScoreString;
	ArrayList<House> houses = new ArrayList<House>();
	ArrayList<Cloud> clouds = new ArrayList<Cloud>();
	ArrayList<Bush> bushes = new ArrayList<Bush>();
	PillManager manager;
	

	public ObjectManager(Sadie rose, long highscore) {
		sadie = rose;
		manager = new PillManager(sadie);
		this.highScore = highscore; 
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
			if (bushes.get(i).x < -50) {
				bushes.get(i).isAlive=false;
			}
		}
		if (score>highScore) {
			highScore = score;
		}
		manager.update();
		manager.checkCollision();
		manager.purgeObjects();
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
		Font font = new Font("David", Font.BOLD, 42);
		scoreString = "Score: " + score;
		g.setColor(Color.black);
		g.drawString(scoreString, 17, 55);
		highScoreString = "High Score: " + highScore ;
		g.drawString(highScoreString, 17, 70);
		sadie.draw(g);
		manager.draw(g);
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

	public void manageObjects() {
		long cloudSpawnTime = new Random().nextInt(500);
		long bushSpawnTime = new Random().nextInt(200);
		if (System.currentTimeMillis() - timer >= cloudSpawnTime * 1000) {
			addCloud(new Cloud(SadiesDashGame.WIDTH, 30, 1));
			timer = System.currentTimeMillis();
		}
		if (System.currentTimeMillis() - timer >= cloudSpawnTime * 2000) {
			addHouse(new House(SadiesDashGame.WIDTH, 410, 3));
			timer = System.currentTimeMillis();
		}
		if (System.currentTimeMillis() - timer >= bushSpawnTime * 1000) {
			addBush(new Bush(SadiesDashGame.WIDTH, 460, 4));
			timer = System.currentTimeMillis();
		}
		manager.managePills();
	}

	public void checkCollision() {
		for (Bush a : bushes) {
			if (sadie.collisionBox.intersects(a.collisionBox) && !sadie.isProtected) {
				sadie.isAlive = false;
			}
		}
	}

	public void usePill() {
		manager.usePills();
	}

	public boolean inUse() {
		return manager.inUse();
	}
	
	public void purgeObjects () {
		for (int i = 0; i < bushes.size(); i++) {
			boolean isAliveCheck = bushes.get(i).isAlive;
			if (isAliveCheck == false) {
				bushes.remove(i);
				score++;
			}
		}
	}

	public long getHighScore(){
		return highScore;
	}
	
	public long getScore(){
		return score;
	}
}
