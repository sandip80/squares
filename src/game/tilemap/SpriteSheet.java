package game.tilemap;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
	private BufferedImage spriteSheet;
	
	public SpriteSheet(String path) {
		try {
			spriteSheet = ImageLoader.getImage(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage crop(int x, int y, int width, int height) {
		return spriteSheet.getSubimage(x, y, width, height);
	}
}
