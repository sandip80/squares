package game.state;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.KeyEvent;

import main.Game;

public class HelpState extends MenuState {

	public HelpState(GameStateManager gsm, MenuState ms) {
		super(gsm);
		this.bg = ms.bg;
	}

	@Override
	public void init() {}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public void draw(Graphics g) {
		parentg = g;
		drawBackground(g);
		drawHelp(g);
	}

	private void drawHelp(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		g2D.setColor(Color.GREEN);
		drawCenteredString("HELP", Game.WIDTH, Game.HEIGHT, g2D);
	}

	@Override
	public void keyPressed(int key) {
		if (key == KeyEvent.VK_BACK_SPACE) {
			gsm.setState(GameStateManager.MENUSTATE);
		}
	}

	@Override
	public void keyReleased(int key) {}

}
