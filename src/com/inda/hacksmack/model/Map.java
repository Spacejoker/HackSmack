package com.inda.hacksmack.model;

import org.newdawn.slick.tiled.TiledMap;

/**
 * Holds the structure of a map, regarding walls etc.
 * @author Jensa
 */
public class Map {

	TiledMap tileMap;
	
	public Map(TiledMap map) {
		tileMap = map;
//		try {
//			tileMap = new TiledMap(new FileInputStream("src/content/maps/test.tmx"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		tileSet = ResourceManager.getInstance().getTileset("test");
	}

	public TiledMap getTileMap() {
		return tileMap;
	}
}
