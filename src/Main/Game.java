package Main;

import javax.swing.JFrame;

public class Game {
	
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
