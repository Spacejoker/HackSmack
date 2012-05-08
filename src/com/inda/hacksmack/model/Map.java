package com.inda.hacksmack.model;

import java.util.ArrayList;
import java.util.LinkedList;

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
	int []shortestPath;
	public Map(TiledMap map) {
		tileMap = map;
		width = map.getWidth();
		height = map.getHeight();
		passableTile = new boolean[width][height];
		shortestPath = new int[width*height];
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
			return true;
		if(!isPassableTile((int)(width*(x+2*r)/HackSmackConstants.SCREEN_WIDTH), (int)(height*(y+2*r)/HackSmackConstants.SCREEN_HEIGHT)))
			return true;
		if(!isPassableTile((int)(width*(x+2*r)/HackSmackConstants.SCREEN_WIDTH), (int)(height*(y)/HackSmackConstants.SCREEN_HEIGHT)))
			return true;
		if(!isPassableTile((int)(width*(x)/HackSmackConstants.SCREEN_WIDTH), (int)(height*(y+2*r)/HackSmackConstants.SCREEN_HEIGHT)))
			return true;
		return false;
		
		
	}
	
	private boolean isPassableTileCrude(int i, int j) {
			return isPassableTile(i,j) && isPassableTile(i,j+1) && isPassableTile(i+1,j) && isPassableTile(i+1,j+1);
	}
	public Vector2f shortestPath(Vector2f v){
		int x,y;
		x = (int)v.x*width/HackSmackConstants.SCREEN_WIDTH;
		y = (int)v.y*height/HackSmackConstants.SCREEN_HEIGHT;
		int nx, ny;
		nx = shortestPath[x+y*width]%width;
		ny = shortestPath[x+y*width]/width;
		
//		System.out.println(x + " " + y + " : " + nx + " " + ny);
		return new Vector2f((float)nx-x, (float)ny-y).normalise();
		
	}
	public void whereAmI(Vector2f v){
		if(HackSmackConstants.devMode){
			int x,y;
			x = (int)v.x*width/HackSmackConstants.SCREEN_WIDTH;
			y = (int)v.y*height/HackSmackConstants.SCREEN_HEIGHT;
//			System.out.println("I am at: " + x + "," + y);
		}
	}
	public void shortestPathGenerator(Vector2f v){
	int x,y;
	x = (int)v.x*width/HackSmackConstants.SCREEN_WIDTH;
	y = (int)v.y*height/HackSmackConstants.SCREEN_HEIGHT;
	
	for(int i = 0; i < shortestPath.length; i++)
			shortestPath[i] = -2;
	int current = x + y*width;
	LinkedList <Integer> list = new LinkedList<Integer>();
	list.add(new Integer(current));
	shortestPath[current] = -1;
//	System.out.println(width + " " + height+ " "+ "Start: " + x + "," + y + " " + current +" "+ current%width + " " + current/width + " " + shortestPath[current]%width + "," + shortestPath[current]/width+ " ");

	
	while(!list.isEmpty()){
		current = list.remove().intValue();
		
		if(isPassableTileCrude((current+1)%width, (current+1)/width)){
			
			if(shortestPath[current+1] == -2){
				list.add(new Integer(current+1));
				shortestPath[current+1] = current;
			}
		}
		if(isPassableTileCrude((current-1)%width, (current-1)/width)){
			if(shortestPath[current-1] == -2 ){
				list.add(new Integer(current-1));
				shortestPath[current-1] = current;
			}
		}
		if(isPassableTileCrude((current-width)%width, (current-width)/width)){
			if(shortestPath[current-width] == -2){
				list.add(new Integer(current-width));
				shortestPath[current-width] = current;
			}
		}
		if(isPassableTileCrude((current+width)%width, (current+width)/width)){
			if(shortestPath[current+width] == -2){
				list.add(new Integer(current+width));
				shortestPath[current+width] = current;
			}
		}
	}
//	for(int i = 0; i < shortestPath.length; i++){
//		if(shortestPath[i]== -1)
//			System.out.print("start");
//		else
//			System.out.print(shortestPath[i]%width + "," + shortestPath[i]/width+ " ");
//		if(i%width == 0 && i != 0)
//			System.out.println();
//	}		
		
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
