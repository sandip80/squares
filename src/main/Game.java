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
	public boolean running = false;

	// Game state manager
	public GameStateManager gsm;
	
	// Key Handler
	private KeyHandler kh;

	public Game() {
		gsm = new GameStateManager();
		JFrame window = new JFrame("Square Fare");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.setMinimumSize(new Dimension(WIDTH / SCALE, HEIGHT / SCALE));
		window.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		window.setPreferredSize(new Dimension(WIDTH, HEIGHT));

		window.add(this);
		window.pack();

		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setFocusable(true);
		window.requestFocusInWindow();
		window.setVisible(true);
	}
	
	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}
	
	public synchronized void stop() {
		running = false;
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 60D;
		
		int frames = 0;
		int ticks = 0;
		
		long timer = System.currentTimeMillis();
		double delta = 0;
		
		kh = new KeyHandler(this);
		
		while (running) {
			long currentTime = System.nanoTime();
			delta += (currentTime - lastTime) / nsPerTick;
			lastTime = currentTime;
			
			while (delta > 1) {
				ticks++;
				tick(ticks);
				delta -= 1;
			}

			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				System.err.println(e.getLocalizedMessage());
				e.printStackTrace();
			}
			
			frames++;
			render();
			
			if (System.currentTimeMillis() - timer >= 1000) {
				timer += 1000;
				System.out.println(frames + " frames, " + ticks + " ticks.");
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	public void tick(int ticks) {
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		
		Graphics g = bs.getDrawGraphics();
		gsm.draw(g);
		gsm.update();
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args) {
		new Game().start();
	}
}
