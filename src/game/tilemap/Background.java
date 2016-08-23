package game.tilemap;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import main.Game;

public class Background {
	
	private Image image;
	
	private double x;
	private double y;
	private double dx;
	private double dy;
	
	public Background(String path) {
		try {
			image = ImageLoader.getImage(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		image = image.getScaledInstance(Game.WIDTH, Game.HEIGHT, 
				Image.SCALE_SMOOTH);
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
		g.drawImage(image, (int) x, (int) y, null);
		if (x < 0) {
			g.drawImage(image, (int) x + Game.WIDTH, (int) y, null);
		}
		if (x > 0) {
			g.drawImage(image, (int) x - Game.WIDTH, (int) y, null);
		}
	}
}
