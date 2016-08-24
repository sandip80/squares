package game.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import game.tilemap.SpriteSheet;
import game.ultilities.FileParser;

public final class EntityData {
	private Map<EntityType, List<EntityObject>> ed;
	
	public EntityData(String datapath, SpriteSheet sheet) {
		ed = new HashMap<>();
		try {
			FileParser.parseEntityData(datapath, sheet, ed);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Map<EntityType, List<EntityObject>> getEntityData() {
		return ed;
	}
}
