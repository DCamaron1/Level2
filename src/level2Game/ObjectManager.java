package level2Game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import org.jointheleaue.level2.leagueInvaders.Alien;
import org.jointheleaue.level2.leagueInvaders.LeagueInvaders;


public class ObjectManager {
	Sadie sadie;
	long timer = 0;
	ArrayList<House> houses = new ArrayList<House>();
	ArrayList<Cloud> clouds = new ArrayList<Cloud>();
	ArrayList<Bush> bushes = new ArrayList<Bush>();
	ArrayList<GoodBoyPill> pills = new ArrayList<GoodBoyPill>();
	
	
	public ObjectManager(Sadie rose) {
		sadie=rose;
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
	}
	
	public void draw(Graphics g) {
		sadie.draw(g);
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
	
	public void manageCloud() {
		long cloudSpawnTime = new Random().nextInt(500);
		long bushSpawnTime = new Random().nextInt(450);
		long pillSpawnTime = new Random().nextInt(1000)+400;
		if (System.currentTimeMillis() - timer >= cloudSpawnTime*1000) {
			addCloud(new Cloud(1100, 30,1));
			timer = System.currentTimeMillis();
		}
		if (System.currentTimeMillis() - timer >= cloudSpawnTime*2000) {
			addHouse(new House(1100, 410,3));
			timer = System.currentTimeMillis();
		}
		if (System.currentTimeMillis() - timer >= bushSpawnTime*1000) {
			addBush(new Bush(1100, 450,3));
			timer = System.currentTimeMillis();
		}
		if (System.currentTimeMillis() - timer >= pillSpawnTime*4000) {
			addPill(new GoodBoyPill(1100, 450,2));
			timer = System.currentTimeMillis();
		}
	}	
}
