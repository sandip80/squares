package square.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import square.game.Game;

public final class Window extends Canvas{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Window normalWindow;

	private Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);
		frame.setSize(new Dimension(width,height));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		//frame.add(game);
		frame.setVisible(true);
		//game.start();	
	}
	
	public static Window getInstance(int width, int height, String title, Game game) {
		if (normalWindow == null) {
			normalWindow = new Window(width, height, title, game);
		}
		return normalWindow;
	}
	
}
