package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import GameState.GameStateManager;

public class GamePanel extends BufferedCanvas implements KeyListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Dimensions
	public final static int WIDTH = 1280;
	public final static int HEIGHT = 720;
	
	// Game state manager
	private GameStateManager gsm;
	
	public GamePanel() {
		gsm = new GameStateManager();
		addKeyListener(this);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.start();
		setFocusable(true);
		requestFocusInWindow();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {
		gsm.keyPressed(e.getKeyCode());
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		gsm.keyReleased(e.getKeyCode());
	}

	@Override
	public void render(Graphics g) {
		gsm.draw(g);
		gsm.update();
	}
}
