package GameState;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class GameStateManager {
	private List<GameState> gameStates;
	private int currentState;
	
	private static final int MENUSTATE = 0;
	private static final int LEVELSTATE = 1;
	
	public GameStateManager() {
		gameStates = new ArrayList<>();
		currentState = MENUSTATE;
		gameStates.add(new MenuState(this));
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
	
	public void keyPressed(int key) {
		gameStates.get(currentState).keyPressed(key);
	}
	
	public void keyReleased(int key) {
		gameStates.get(currentState).keyReleased(key);
	}
}
