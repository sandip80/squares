package game.state;

import java.awt.Graphics;

import game.entities.Coin;
import game.entities.EntityData;
import game.tilemap.SpriteSheet;

public class LevelOneState extends GameState{
	
//	private GameMap map;
//	private Player player;
//	private ArrayList<Enemy> enemies;
//	private HUD hud;
	private Coin c;
	private EntityData ed;
	
	public LevelOneState(GameStateManager gsm) {
		this.gsm = gsm;
		ed = new EntityData("/Spritesheets/spritesheet.dat", new SpriteSheet("/Spritesheets/spritesheet.png"));
		c = new Coin(ed);
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		c.update();
	}

	@Override
	public void draw(Graphics g) {
		c.draw(g);
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