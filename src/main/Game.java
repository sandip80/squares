package main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import game.state.GameStateManager;

public class Game extends Canvas implements Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Dimensions
	public final static int SCALE = 3;
	public final static int HEIGHT = 160 * SCALE;
	public final static int WIDTH = HEIGHT * 12 / 9;

	// Thread variable
	private boolean running = false;
	private Thread thread;

	// Game state manager
	private GameStateManager gsm;
	
	// Key Handler
	private KeyHandler kh;

	public Game() {
		JFrame window = new JFrame("Square Fare");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		window.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		window.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		window.setResizable(false);
		window.setLocationRelativeTo(null);
		
		window.add(this);
		window.pack();

		window.setVisible(true);
	}
	
	public GameStateManager getGSM() {
		return gsm;
	}
	
	public void init() {
		gsm = new GameStateManager();
		kh = new KeyHandler(this);
	}
	
	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {		
		init();
		
		while (running) {
			tick();
			render();
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void tick() {
		gsm.update();
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		
		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
		gsm.draw(g);
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		new Game().start();
	}
}
