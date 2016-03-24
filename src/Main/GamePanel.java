package Main;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable, KeyListener{
	
	// Dimensions
	private final int WIDTH = 1280;
	private final int HEIGHT = 720;
	
	// Thread
	private Thread thread;
	private Boolean running;
	private final int FPS = 60;
	private int targetTime = 1000 / FPS;
	
	// Image
	BufferedImage img;
	Graphics2D g;
	
	public GamePanel() {
		super();
		if (thread == null) {
			thread = new Thread();
			addKeyListener(this);
			thread.start();
			System.out.println("Thread running");
		}
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
