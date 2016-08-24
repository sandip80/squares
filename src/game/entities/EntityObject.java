package game.entities;

import java.awt.image.BufferedImage;

public final class EntityObject {
	BufferedImage img;
	String type;
	String name;
	
	public EntityObject(BufferedImage img, String type, String name) {
		this.img = img;
		this.type = type;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public BufferedImage getImage() {
		return img;
	}
}
