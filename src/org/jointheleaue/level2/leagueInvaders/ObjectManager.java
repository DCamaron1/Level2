package org.jointheleaue.level2.leagueInvaders;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship bob;
	long enemyTimer = 0;
	long enemySpawnTime = 2000;
	long score = 0;
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> aliens = new ArrayList<Alien>();

	public ObjectManager(Rocketship billy) {
		bob = billy;
	}

	public void update() {
		bob.update();
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}

	}

	public void draw(Graphics g) {
		bob.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}

	}

	public long getScore() {
		return score;
	}

	public void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}

	public void addAlien(Alien alien) {
		aliens.add(alien);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Alien(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
			enemyTimer = System.currentTimeMillis();
		}

	}

	public void purgeObject() {
		for (int i = 0; i < projectiles.size(); i++) {
			boolean isAliveCheck = projectiles.get(i).isAlive;
			if (isAliveCheck == false) {
				projectiles.remove(i);
			}
		}
		for (int i = 0; i < aliens.size(); i++) {
			boolean isAliveCheck = aliens.get(i).isAlive;
			if (isAliveCheck == false) {
				aliens.remove(i);
				score = score + 1;
			}
		}
	}

	public void checkCollision() {
		for (Alien a : aliens) {
			if (bob.collisionBox.intersects(a.collisionBox)) {
				bob.isAlive = false;
			}
			for (Projectile p : projectiles) {
				if (a.collisionBox.intersects(p.collisionBox)) {
					a.isAlive = false;
				}
				if (a.collisionBox.intersects(p.collisionBox)) {
					p.isAlive = false;
				}
			}
		}
	}
}
