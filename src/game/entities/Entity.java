package game.entities;

import java.awt.Graphics;

public abstract class Entity {

	protected float x, y;
	protected float scale = 1;
	protected EntityData ed;
	
	public Entity(float x, float y, EntityData ed) {
		this.x = x;
		this.y = y;
		this.ed = ed;
		init();
	}
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics g);
}
