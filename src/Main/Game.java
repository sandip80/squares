package Main;

import javax.swing.JFrame;

/**
 * <b>Game</b> is the main class of the squares game. It creates
 * JFrame window and adds the GamePanel object to the frame.
 * @author Sandip
 */
public class Game {
	
	/**
	 * This is the main class which creates the JFrame and adds the
	 * GamePanel object to the frame.
	 * @param argv Array of console arguments
	 */
	public static void main(String[] argv) {
		JFrame window = new JFrame("Square Fare");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
}
