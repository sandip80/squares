package game.state;

import java.awt.Graphics;

import main.Game;

public abstract class GameState {
	
	protected GameStateManager gsm;
	protected Game game;
	
	public GameState(GameStateManager gsm, Game game) {
		this.gsm = gsm;
		this.game = game;
	}
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics g);
}
