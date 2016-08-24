package game.entities;

import java.awt.image.BufferedImage;

public final class EntityObject {
	private final BufferedImage img;
	private String name;
	
	public EntityObject(BufferedImage img, String name) {
		this.img = img;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public BufferedImage getImage() {
		return img;
	}
}
