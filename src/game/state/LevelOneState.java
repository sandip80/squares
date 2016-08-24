package game.state;

import java.awt.Graphics;

import game.entities.EntityData;
import game.entities.Player;
import game.tilemap.SpriteSheet;

public class LevelOneState extends GameState{
	
//	private GameMap map;
	private Player player;
//	private ArrayList<Enemy> enemies;
//	private HUD hud;
//	private Coin c;
	private EntityData ed;
	
	public LevelOneState(GameStateManager gsm) {
		this.gsm = gsm;
		ed = new EntityData("/Spritesheets/spritesheet.dat", new SpriteSheet("/Spritesheets/spritesheet.png"));
		player = new Player(100, 100, ed);
	}

	@Override
	public void init() {}

	@Override
	public void update() {
		player.update();
	}

	@Override
	public void draw(Graphics g) {
		player.draw(g);
	}

	@Override
	public void keyPressed(int key) {
		player.keyPressed(key);		
	}

	@Override
	public void keyReleased(int key) {
		player.keyReleased(key);
	}
	
}