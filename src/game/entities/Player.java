package game.entities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.tilemap.MirrorImage;
import main.Game;
import main.KeyHandler;

public class Player extends Creature {
	private Map<String, BufferedImage> currentImageSet;
	private Map<String, BufferedImage> images;
	private Map<String, BufferedImage> mirrorimages;

	private String currentImage = "bunny1_ready";
	private float dx, dy;

	private long lasttime = System.nanoTime();
	private double delta = 0;
	
	private KeyHandler kh;

	public Player(float x, float y, EntityData ed, KeyHandler kh) {
		super(x, y, ed);
		this.kh = kh;
	}

	@Override
	public void init() {
		images = new HashMap<>();
		mirrorimages = new HashMap<>();
		List<EntityObject> eobj = ed.getEntityData().get(EntityType.PLAYER);
		for (EntityObject eo : eobj) {
			if (eo.getName().matches("bunny[0-9]_[a-z]*[0-9]*")) {
				images.put(eo.getName(), eo.getImage());
				mirrorimages.put(eo.getName(), MirrorImage.mirrorHorizontal(eo.getImage()));
			}
		}
		currentImageSet = images;
	}
	
	@Override
	public void update() {
		updateKeyPressRelease();
		moveAndkeepInBounds();
		animatePlayer();
	}

	private void animatePlayer() {
		long currenttime = System.nanoTime();
		delta += (currenttime - lasttime) * 1.5 / 1000000000D;
		lasttime = currenttime;
		if (delta > 1) {
			if (dx == 0 && dy == 0) {
				if (currentImage.equals("bunny1_ready")) {
					currentImage = new String("bunny1_stand");
				} else {
					currentImage = new String("bunny1_ready");
				}
			} else if (dx != 0) {
				if (currentImage.equals("bunny1_ready") || currentImage.equals("bunny1_stand")) {
					currentImage = new String("bunny1_walk1");
				} else if (currentImage.equals("bunny1_walk1")) {
					currentImage = new String("bunny1_walk2");
				} else {
					currentImage = new String("bunny1_walk1");
				}
			}
			delta--;
		}
	}

	private void moveAndkeepInBounds() {
		if (x >= 0 && (x + currentImageSet.get(currentImage).getWidth()) <= Game.WIDTH) {
			x += dx;
		} else {
			if (x < 0) {
				x = 0;
			} else {
				x = Game.WIDTH - currentImageSet.get(currentImage).getWidth();
			}
		}
		if (y > 0 && (y + currentImageSet.get(currentImage).getHeight()) <= Game.HEIGHT) {
			y += dy;
		} else {
			if (y < 0) {
				y = 0;
			} else {
				y = Game.HEIGHT - currentImageSet.get(currentImage).getHeight()	;
			}
		}
	}

	private void updateKeyPressRelease() {
		if (kh.right) {
			currentImageSet = images;
			if (dx < 2) {
				dx += 1;
			}
		} else if (kh.left) {
			currentImageSet = mirrorimages;
			if (dx > -2) {
				dx -= 1;
			}
		} else if (!kh.right || !kh.left) {
			dx = 0;
		}
	}

	@Override
	public void draw(Graphics g) {
		BufferedImage cImage = currentImageSet.get(currentImage);
		scale = 0.5f;
		g.drawImage(cImage.getScaledInstance((int)(cImage.getWidth() * scale), 
											(int)(cImage.getHeight() * scale),
											Image.SCALE_SMOOTH),
											(int) x, (int) y, null);		
	}
	
	public void keyPressed(int key) {
		
	}
	
	public void keyReleased(int key) {
		
	}
}
