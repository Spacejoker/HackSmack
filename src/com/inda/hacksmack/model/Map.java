package com.inda.hacksmack.model;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.tiled.TiledMap;

import com.inda.hacksmack.HackSmackConstants;

/**
 * Holds the structure of a map, regarding walls etc.
 * @author Jensa
 */
public class Map {

	TiledMap tileMap;
	int width;
	int height;
	boolean[][] passableTile;
	
	public Map(TiledMap map) {
		tileMap = map;
		width = map.getWidth();
		height = map.getHeight();
		passableTile = new boolean[width][height];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int tileId = tileMap.getTileId(j, i, HackSmackConstants.MAP_LAYER_COLLISSION);
				if(tileId != 0){
					passableTile[j][i] = false;
				} else {
					passableTile[j][i] = true;
				}
			}
		}
	}

	public boolean collidesWithMap(Vector2f v, double r){
		float x = v.x;
		float y = v.y;

		if(!isPassableTile((int)(width*(x)/HackSmackConstants.SCREEN_WIDTH), (int)(height*(y)/HackSmackConstants.SCREEN_HEIGHT)))
			return false;
		if(!isPassableTile((int)(width*(x+2*r)/HackSmackConstants.SCREEN_WIDTH), (int)(height*(y+2*r)/HackSmackConstants.SCREEN_HEIGHT)))
			return false;
		if(!isPassableTile((int)(width*(x+2*r)/HackSmackConstants.SCREEN_WIDTH), (int)(height*(y)/HackSmackConstants.SCREEN_HEIGHT)))
			return false;
		if(!isPassableTile((int)(width*(x)/HackSmackConstants.SCREEN_WIDTH), (int)(height*(y+2*r)/HackSmackConstants.SCREEN_HEIGHT)))
			return false;
			
		return true;
		
		
	}
	
	public TiledMap getTileMap() {
		return tileMap;
	}

	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public boolean[][] getPassableTile() {
		return passableTile;
	}

	public boolean isPassableTile(int x, int y){
		if( x >= width || x < 0)
			return false;
		if(y >= height || y < 0)
			return false;
		return passableTile[x][y];
	}
}
