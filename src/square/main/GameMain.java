package square.main;

import square.game.Game;

public class GameMain {
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = WIDTH / 16 * 9;
	
	public static void main(String[] argv) {
		Window.getInstance(WIDTH, HEIGHT, "Squar Fare", new Game());
	}
}
