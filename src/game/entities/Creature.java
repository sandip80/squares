package game.entities;

public abstract class Creature extends Entity {
	protected static final int HEALTH = 100;
	
	public Creature(float x, float y, EntityData ed) {
		super(x, y, ed);
	}
}
