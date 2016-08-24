package game.entities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.Game;

public class Player extends Creature {
	private Map<String, BufferedImage> images;

	private String currentImage = "bunny1_ready";
	private float dx, dy;

	private long lasttime = System.nanoTime();
	private double delta = 0;

	public Player(float x, float y, EntityData ed) {
		super(x, y, ed);
	}

	@Override
	public void init() {
		images = new HashMap<>();
		List<EntityObject> eobj = ed.getEntityData().get(EntityType.PLAYER);
		for (EntityObject eo : eobj) {
			if (eo.getName().matches("bunny[0-9]_[a-z]*[0-9]*")) {
				images.put(eo.getName(), eo.getImage());
			}
		}
	}
	
	@Override
	public void update() {
		if (x < Game.WIDTH) {
			x += dx;
		}
		if (y < Game.HEIGHT) {
			y += dy;
		}
		long currenttime = System.nanoTime();
		delta += (currenttime - lasttime) * 1.9 / 1000000000D;
		lasttime = currenttime;
		if (delta > 1) {
			if (dx == 0) {
				if (currentImage.equals("bunny1_ready")) {
					currentImage = new String("bunny1_stand");
				} else {
					currentImage = new String("bunny1_ready");
				}
			}
			delta--;
		}
	}

	@Override
	public void draw(Graphics g) {
		BufferedImage cImage = images.get(currentImage);
		scale = 0.5f;
		g.drawImage(cImage.getScaledInstance((int)(cImage.getWidth() * scale), 
											(int)(cImage.getHeight() * scale),
											Image.SCALE_SMOOTH),
											(int) x, (int) y, null);		
	}
	
	public void keyPressed(int key) {
		if (key == KeyEvent.VK_RIGHT) {
			dx += 1;
		}
		if (key == KeyEvent.VK_LEFT) {
			dx -= 1;
		}
	}
	
	public void keyReleased(int key) {
		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
			dx = 0;
		}
	}
}
