package com.inda.hacksmack.model;

import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;

import com.inda.hacksmack.ResourceManager;

/**
 * Holds the structure of a map, regarding walls etc.
 * @author Jensa
 */
public class Map {
	SpriteSheet tileSet; // might be worth reusing this class from the framework
	
	public Map() {
		tileSet = ResourceManager.getInstance().getTileset("test");
	}
	
	public Image getImage(){
		
		return tileSet.getSprite(5, 2);
	}
}
