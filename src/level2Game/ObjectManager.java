package level2Game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import org.jointheleaue.level2.leagueInvaders.Alien;
import org.jointheleaue.level2.leagueInvaders.LeagueInvaders;


public class ObjectManager {
	Sadie sadie;
	long cloudTimer = 0;
	//ArrayList<House> house = new ArrayList<House>();
	ArrayList<Cloud> clouds = new ArrayList<Cloud>();
	ArrayList<Cloud> clouds2 = new ArrayList<Cloud>();
	//ArrayList<GoodBoyPill> pill = new ArrayList<GoodBoyPill>();
	
	
	public ObjectManager(Sadie rose) {
		sadie=rose;
	}
	
	public void update() {
		for (int i = 0; i < clouds.size(); i++) {
			clouds.get(i).update();
		}
	}
	
	public void draw(Graphics g) {
		sadie.draw(g);
		for (int i = 0; i < clouds.size(); i++) {
			clouds.get(i).draw(g);
		}
	}
	
	public void addCloud(Cloud cloud) {
		clouds.add(cloud);
	}
	
	public void manageCloud() {
		long cloudSpawnTime = new Random().nextInt(500);
		if (System.currentTimeMillis() - cloudTimer >= cloudSpawnTime*1000) {
			addCloud(new Cloud(1100, 30));
			cloudTimer = System.currentTimeMillis();
		}
	}	
}
