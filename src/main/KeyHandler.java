package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.state.GameStateManager;

public class KeyHandler implements KeyListener {
	public class Key {
		private boolean pressed = false;
		
		public boolean isPressed() {
			return pressed;
		}
		
		public void toggle(boolean isPressed) {
			pressed = isPressed;
		}
	}
	
	public Key up = new Key();
	public Key down = new Key();
	public Key right = new Key();
	public Key left = new Key();
	public Key enter = new Key();

	private GameStateManager gsm;
	
	public KeyHandler(Game game) {
		game.addKeyListener(this);
		gsm = game.gsm;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		toggleKey(e.getKeyCode(), true);
		gsm.keyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		toggleKey(e.getKeyCode(), false);	
		gsm.keyReleased(e.getKeyCode());
	}

	private void toggleKey(int keyCode, boolean isPressed) {
		if (keyCode == KeyEvent.VK_UP) {
			up.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			down.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			right.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_LEFT) {
			left.toggle(isPressed);
		}
		if (keyCode == KeyEvent.VK_ENTER) {
			enter.toggle(isPressed);
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {}
}