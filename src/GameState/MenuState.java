package GameState;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.sun.glass.events.KeyEvent;

import Main.GamePanel;
import TileMap.Background;

public class MenuState extends GameState {
	
	private Background bg;
	
	private final String[] options = {
		"Start",
		"Help",
		"Quit"
	};
	
	private int currentOption;
	Graphics parentg;
		
	public MenuState(GameStateManager gsm) {
		this.gsm = gsm;
		currentOption = 0;
		try {
			bg = new Background("/background/menuBG.gif", 1);
			bg.setDifferentialChange(-5, 0);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void init() {}

	@Override
	public void update() {
		bg.update();
	}

	@Override
	public void draw(Graphics g) {
		parentg = g;
		bg.draw(g);
		drawOptions(g);
	}

	private void drawOptions(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		for (int i = 0; i < 3; i++) {
			if (i == currentOption) {
				g2D.setColor(Color.RED);
			} else {
				g2D.setColor(Color.BLACK);
			}
			g2D.setStroke(new BasicStroke(5));
			g2D.drawRect(GamePanel.WIDTH / 2 - 100, GamePanel.HEIGHT / 3 - 75 / 2 + 120 * i, 200, 75);
			g2D.setStroke(new BasicStroke(1));
			g2D.setFont(new Font("Calibri", Font.PLAIN, 50));
			drawCenteredString(options[i], GamePanel.WIDTH, GamePanel.HEIGHT * 2 / 3 + 240 * i, g2D);
		}	
	}

	public void drawCenteredString(String s, int w, int h, Graphics2D g2D) {
	    FontMetrics fm = g2D.getFontMetrics();
	    int x = (w - fm.stringWidth(s)) / 2;
	    int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
	    g2D.drawString(s, x, y);
	}

	@Override
	public void keyPressed(int key) {
		if (key == KeyEvent.VK_UP) {
			currentOption--;
			if (currentOption < 0) {
				currentOption = options.length - 1;
			}
		} else if (key == KeyEvent.VK_DOWN) {
			currentOption++;
			if (currentOption == options.length) {
				currentOption = 0;
			}
		} else if (key == KeyEvent.VK_ENTER) {
			createEvent();
		}
		
	}

	private void createEvent() {
		if (currentOption == 2) {
			System.exit(0);
		} else if (currentOption == 1) {
			// open help window
		} else {
			// open game
		}
	}

	@Override
	public void keyReleased(int key) {}

}
