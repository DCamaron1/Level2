package org.jointheleaue.level2.leagueInvaders;

import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	Rocketship bob;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
	public ObjectManager(Rocketship billy) {
		bob= billy;
	}
	
	public void update() {
		bob.update();
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
	}
	
	public void draw(Graphics g) {
		bob.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}

	}
	
	public void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
		
		
	}
}
