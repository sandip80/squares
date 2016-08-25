package game.state;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import main.Game;

public class GameStateManager {
	private List<GameState> gameStates;
	private int currentState;
	
	public static final int MENUSTATE = 0;
	public static final int HELPSTATE = 1;
	public static final int LEVEL1STATE = 2;
	
	public GameStateManager(Game game) {
		gameStates = new ArrayList<>();
		currentState = MENUSTATE;
		gameStates.add(new MenuState(this, game));
		gameStates.add(new HelpState(this, game, (MenuState) gameStates.get(MENUSTATE)));
		gameStates.add(new LevelOneState(this, game));
	}
	
	public void setState(int state) {
		currentState = state;
		gameStates.get(currentState).init();
	}
	
	public void update() {
		gameStates.get(currentState).update();
	}
	
	public void draw(Graphics g) {
		gameStates.get(currentState).draw(g);
	}
}
