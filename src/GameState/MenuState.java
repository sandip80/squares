package GameState;

import java.awt.Graphics;

import TileMap.Background;

public class MenuState extends GameState {
	
	private Background bg;
	
	public MenuState(GameStateManager gsm) {
		this.gsm = gsm;
		
		try {
			bg = new Background("/background/menuBG.gif", 1);
			bg.setDifferentialChange(-5, 0);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	public void init() {}

	@Override
	public void update() {
		bg.update();
	}

	@Override
	public void draw(Graphics g) {
		bg.draw(g);		
	}

	@Override
	public void keyPressed(int key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(int key) {
		// TODO Auto-generated method stub
		
	}

}
