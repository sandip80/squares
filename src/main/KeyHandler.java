package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.state.GameStateManager;

public class KeyHandler implements KeyListener {
	private GameStateManager gsm;
	
	public KeyHandler(Game game) {
		game.addKeyListener(this);
		gsm = game.getGSM();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		gsm.keyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {	
		gsm.keyReleased(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}
}