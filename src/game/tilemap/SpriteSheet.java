package game.tilemap;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage spriteSheet;
	
	public SpriteSheet(String path) {
		spriteSheet = ImageLoader.getImage(path);
	}
	
	public BufferedImage crop(int x, int y, int width, int height) {
		return spriteSheet.getSubimage(x, y, width, height);
	}
}
