package game.entities;

public enum EntityType {
	ENEMY, ENVIRONMENT, HUD, ITEM, PARTICLE, PLAYER;

	public static EntityType get(String type) {
		switch(type) {
			case "ENEMY":
				return ENEMY;
			case "ENVIRONMENT":
				return ENVIRONMENT;
			case "HUD":
				return HUD;
			case "ITEM":
				return ITEM;
			case "PARTICLE":
				return PARTICLE;
			case "PLAYER":
				return PLAYER;
			default:
				return null;
				
		}
	}
}
