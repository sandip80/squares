package game.tilemap;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.Game;

public class Background {
	
	private BufferedImage image;
	
	private double x;
	private double y;
	private double dx;
	private double dy;
	
	public Background(String path) {
		image = ImageLoader.getImage(path);
		x = 0;
		y = 0;
	}
	
	public void setDifferentialChange(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void update() {
		x += dx;
		if (x < -1 * Game.WIDTH) {
			x = Game.WIDTH;
		}
		y += dy;
		if (y < -1 * Game.HEIGHT) {
			y = Game.HEIGHT;
		}
	}
	
	public void draw(Graphics g) {
		Image img = image.getScaledInstance(Game.WIDTH, Game.HEIGHT, 
				Image.SCALE_SMOOTH);
		g.drawImage(img, (int) x, (int) y, null);
		if (x < 0) {
			g.drawImage(img, (int) x + Game.WIDTH, (int) y, null);
		}
		if (x > 0) {
			g.drawImage(img, (int) x - Game.WIDTH, (int) y, null);
		}
	}
}
