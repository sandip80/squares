package game.state;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import game.tilemap.Background;
import main.Game;
import main.KeyHandler;

public class MenuState extends GameState {
	
	protected List<Background> bg;
	
	private final String[] options = {
		"Start",
		"Help",
		"Quit"
	};
	
	protected int currentOption;
	private boolean flagup = true;
	private boolean flagdown = true;
	private KeyHandler kh;
		
	public MenuState(GameStateManager gsm, Game game) {
		super(gsm, game);
		currentOption = 0;
		bg = new ArrayList<Background>();
		for (int i = 0; i < 4; i++) {
			Background b = new Background("/Background/bg_layer" + new Integer(i + 1).toString() + ".png");
			b.setDifferentialChange(-i, 0);
			bg.add(b);
		}
		kh = game.getKeyHandler();
	}
	
	protected void drawBackground(Graphics g) {
		for (int i = 0; i < bg.size(); i++) {
			bg.get(i).draw(g);
		}
	}
	
	protected void updateBackground() {
		for (int i = 0; i < bg.size(); i++) {
			bg.get(i).update();
		}
	}

	@Override
	public void init() {}

	@Override
	public void update() {
		if (kh.up) {
			if (flagup) {
				currentOption--;
				flagup = false;
			}
			if (currentOption < 0) {
				currentOption = options.length - 1;
			}
		} else if (kh.down) {
			if (flagdown) {
				currentOption++;
				flagdown = false;
			}
			if (currentOption == options.length) {
				currentOption = 0;
			}
		} else if (kh.enter) {
			createEvent();
		}
		if (!kh.up) {
			flagup = true;
		} 
		if (!kh.down) {
			flagdown = true;
		}
		updateBackground();
	}

	@Override
	public void draw(Graphics g) {
		drawBackground(g);
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
			g2D.setStroke(new BasicStroke(3));
			g2D.drawRect(Game.WIDTH / 2 - 50, Game.HEIGHT / 3 - 25 + 60 * i, 100, 50);
			g2D.setStroke(new BasicStroke(1));
			g2D.setFont(new Font("Calibri", Font.PLAIN, 25));
			drawCenteredString(options[i], Game.WIDTH, Game.HEIGHT * 2 / 3 + 120 * i, g2D);
		}	
	}

	public void drawCenteredString(String s, int w, int h, Graphics2D g2D) {
	    FontMetrics fm = g2D.getFontMetrics();
	    int x = (w - fm.stringWidth(s)) / 2;
	    int y = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
	    g2D.drawString(s, x, y);
	}

	private void createEvent() {
		if (currentOption == 2) {
			System.exit(0);
		} else if (currentOption == 1) {
			gsm.setState(GameStateManager.HELPSTATE);
		} else {
			gsm.setState(GameStateManager.LEVEL1STATE);
		}
	}
}
