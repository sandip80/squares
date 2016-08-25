package game.state;

import java.awt.Graphics;

import game.entities.EntityData;
import game.entities.Player;
import game.tilemap.SpriteSheet;
import main.Game;

public class LevelOneState extends GameState{
	
//	private GameMap map;
	private Player player;
//	private ArrayList<Enemy> enemies;
//	private HUD hud;
//	private Coin c;
	private EntityData ed;
	
	public LevelOneState(GameStateManager gsm, Game game) {
		super(gsm, game);
		ed = new EntityData("/Spritesheets/spritesheet.dat", new SpriteSheet("/Spritesheets/spritesheet.png"));
		player = new Player(100, 100, ed, game.getKeyHandler());
	}

	@Override
	public void init() {}

	@Override
	public void update() {
		if (game.getKeyHandler().escape) {
			System.exit(0);
		}
		player.update();
	}

	@Override
	public void draw(Graphics g) {
		player.draw(g);
	}	
}