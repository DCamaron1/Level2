package level2Game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class ObjectManager {
	Sadie sadie;
	ArrayList<House> house = new ArrayList<House>();
	ArrayList<Cloud> clouds = new ArrayList<Cloud>();
	ArrayList<GoodBoyPill> pill = new ArrayList<GoodBoyPill>();
	
	public ObjectManager(Sadie rose) {
		sadie=rose;
	}
	
	public void update() {
		
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
}
