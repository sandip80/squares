package game.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import main.Game;

public class Coin extends EntityManager {
	List<BufferedImage> coins;
	int currentImage = 0;
	boolean flag = false;
	
	public Coin(EntityData ed) {
		this.ed = ed;
		List<EntityObject> objs = ed.getEntityData().get(Entity.ITEM);
		coins = new ArrayList<>();
		for (EntityObject e : objs) {
			if (e.getName().matches("bronze_[0-9]")) {
				coins.add(e.getImage());
			}
		}
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		if (currentImage == 3) {
			flag = true;
		} else if (currentImage == 0) {
			flag = false;
		}
		if (flag) {
			currentImage--;
		} else {
			currentImage++;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(coins.get(currentImage), Game.WIDTH / 2, Game.HEIGHT / 2, null);
	}

	@Override
	public void keyPressed(int key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(int key) {
		// TODO Auto-generated method stub
		
	}

}
