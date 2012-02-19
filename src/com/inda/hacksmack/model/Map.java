package com.inda.hacksmack.model;

import org.newdawn.slick.tiled.TiledMap;

import com.inda.hacksmack.ResourceManager;

/**
 * Holds the structure of a map, regarding walls etc.
 * @author Jensa
 */
public class Map {
	TiledMap tileMap; // might be worth reusing this class from the framework
	
	public Map() {
		ResourceManager.getInstance().getTiledMap("testmap");
	}
}
