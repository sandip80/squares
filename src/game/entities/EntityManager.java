package game.entities;

import java.awt.Graphics;

public abstract class EntityManager {

	protected EntityData ed;
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics g);
	public abstract void keyPressed(int key);
	public abstract void keyReleased(int key);
}
