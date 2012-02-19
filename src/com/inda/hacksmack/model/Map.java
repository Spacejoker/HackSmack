package com.inda.hacksmack.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.Layer;
import org.newdawn.slick.tiled.TiledMap;

import com.inda.hacksmack.ResourceManager;

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
