package game.ultilities;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import game.entities.Entity;
import game.entities.EntityObject;
import game.tilemap.SpriteSheet;

public class FileParser {
	/**
     * A checked exception class for bad data files
     */
    @SuppressWarnings("serial")
    public static class MalformedDataException extends Exception {
        public MalformedDataException() { }

        public MalformedDataException(String message) {
            super(message);
        }

        public MalformedDataException(Throwable cause) {
            super(cause);
        }

        public MalformedDataException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    
    public static void parseEntityData(String filename, SpriteSheet sp,
    		Map<Entity, List<EntityObject>> entityMap) throws MalformedDataException{
    	BufferedReader reader = null;
    	
    	try {
    		File f = new File(FileParser.class.getResource(filename).getFile());
    		reader = new BufferedReader(new FileReader(f));

            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
            	String[] tokens = inputLine.split(" ");
            	if (tokens.length != 6) {
            		throw new MalformedDataException("Line should contain 6 attributes : "
            				+ "type, name, x, y and height. The order of the attributes should "
            				+ "be same as here. Each attributes should be assigned with an equal "
            				+ "sign and there should be no space between the = and the attribute "
            				+ "and the attribute's value. "
            				+ "Ex: type=ITEM name=coin x=345 y=456 width=23 height=45");
            	}
            	String type = tokens[0].split("=")[1];
            	String name = tokens[1].split("=")[1];
            	String x = tokens[2].split("=")[1];
            	String y = tokens[3].split("=")[1];
            	String width = tokens[4].split("=")[1];
            	String height = tokens[5].split("=")[1];
            	BufferedImage entityImage = sp.crop(new Integer(x).intValue(),
            								new Integer(y).intValue(),
            								new Integer(width).intValue(),
            								new Integer(height).intValue());
            	EntityObject et = new EntityObject(entityImage, type, name);
            	List<EntityObject> eo = entityMap.get(Entity.get(type));
            	if (eo == null) {
            		eo = new ArrayList<EntityObject>();
            	}
            	eo.add(et);
            	entityMap.put(Entity.get(type), eo);
            }
    	} catch(IOException e) {
    		e.printStackTrace();
    	} finally {
    		if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
    	}
    }
}