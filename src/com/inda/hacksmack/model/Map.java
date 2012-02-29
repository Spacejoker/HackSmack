package com.inda.hacksmack.model;

import org.newdawn.slick.tiled.TiledMap;

import com.inda.hacksmack.HackSmackConstants;

/**
 * Holds the structure of a map, regarding walls etc.
 * @author Jensa
 */
public class Map {

	TiledMap tileMap;
	
	boolean[][] passableTile;
	
	public Map(TiledMap map) {
		tileMap = map;
		int width = map.getWidth();
		int height = map.getHeight();
		passableTile = new boolean[width][height];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int tileId = tileMap.getTileId(j, i, HackSmackConstants.MAP_LAYER_COLLISSION);
				if(tileId != 0){
					passableTile[j][i] = false;
				}
			}
		}
	}

	public TiledMap getTileMap() {
		return tileMap;
	}

	public boolean[][] getPassableTile() {
		return passableTile;
	}

	public boolean isPassableTile(int x, int y){
		return passableTile[x][y];
	}
}
