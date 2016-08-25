package game.state;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import main.Game;

public class HelpState extends MenuState {
	private final MenuState ms;

	public HelpState(GameStateManager gsm, Game game, MenuState ms) {
		super(gsm, game);
		this.bg = ms.bg;
		this.ms = ms;
	}

	@Override
	public void init() {}

	@Override
	public void update() {
		if (game.getKeyHandler().backspace) {
			gsm.setState(GameStateManager.MENUSTATE);
		}
		this.currentOption = ms.currentOption;
		updateBackground();
	}

	@Override
	public void draw(Graphics g) {
		drawBackground(g);
		drawHelp(g);
	}

	private void drawHelp(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(Color.GREEN);
		drawCenteredString("HELP", Game.WIDTH, Game.HEIGHT, g2D);
	}
}
