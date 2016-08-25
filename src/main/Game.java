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
		kh = new KeyHandler();
		window.setSize(Game.WIDTH, Game.HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		setMinimumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		setMaximumSize(new Dimension(Game.WIDTH, Game.HEIGHT));
		
		window.add(this);
		window.pack();
	}
	
	public GameStateManager getGSM() {
		return gsm;
	}
	
	public KeyHandler getKeyHandler() {
		return kh;
	}
	
	public void init() {
		this.addKeyListener(kh);
		gsm = new GameStateManager(this);
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

		int fps = 60;
		double timepertick = 1000000000D / fps;
		double delta = 0;
//		int frames = 0;
//		long timer = 0;
		
		long lasttime = System.nanoTime();
		while (running) {
			long currenttime = System.nanoTime();
			delta += (currenttime - lasttime) / timepertick;
//			timer += currenttime - lasttime;
			lasttime = currenttime;
			
			if (delta > 1) {
				tick();
				render();
				delta--;
//				frames++;
			}
			
//			if (timer >= 1000000000) {
//				System.out.println("Frames " + frames);
//				frames = 0;
//				timer = 0;
//			}
			sleep(2);
			
		}
	}
	
	public void tick() {
		kh.tick();
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

	public void sleep(long t) {
		try {
			Thread.sleep(t);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
