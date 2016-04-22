package game.tilemap;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Background {
	
	private BufferedImage image;
	
	private double x;
	private double y;
	private double dx;
	private double dy;
	
	public Background(String name, double mScale) {
		try {
			image = ImageIO.read(getClass().getResourceAsStream(name));
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		x = 0;
		y = 0;
	}
	
	public void setDifferentialChange(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void update() {
		x += dx;
		if (x < -1 * GamePanel.WIDTH) {
			x = GamePanel.WIDTH;
		}
		y += dy;
		if (y < -1 * GamePanel.HEIGHT) {
			y = GamePanel.HEIGHT;
		}
	}
	
	public void draw(Graphics g) {
		Image img = image.getScaledInstance(GamePanel.WIDTH, GamePanel.HEIGHT, 
				Image.SCALE_SMOOTH);
		g.drawImage(img, (int) x, (int) y, null);
		if (x < 0) {
			g.drawImage(img, (int) x + GamePanel.WIDTH, (int) y, null);
		}
		if (x > 0) {
			g.drawImage(img, (int) x - GamePanel.WIDTH, (int) y, null);
		}
	}
}
