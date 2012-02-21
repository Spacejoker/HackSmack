package com.inda.hacksmack;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.tiled.TiledMap;

import com.inda.hacksmack.model.Enemy;
import com.inda.hacksmack.model.GameState;
import com.inda.hacksmack.model.Item;
import com.inda.hacksmack.model.Projectile;

/**
 * static?
 * 
 * @author Jensa
 */
public class GraphicsMaster {

	private static GraphicsMaster _instance;
	private GraphicsMaster() {
		
	}
	
	public static GraphicsMaster getInstance(){
		if(_instance == null){
			_instance = new GraphicsMaster();
		}
		return _instance;
	}
	
	public void drawState(GameState gameState, Graphics graphics) {
		TiledMap tileMap = gameState.getMap().getTileMap();
		for (int x = 0; x < tileMap.getWidth(); x++) {
			for (int y = 0; y < tileMap.getHeight(); y++) {
				Image tileImage = tileMap.getTileImage(x, y, 0);
				if(tileImage != null){
					tileImage.draw(x*32, y*32);
				}
			}
		}
		
		for (int x = 0; x < tileMap.getWidth(); x++) {
			for (int y = 0; y < tileMap.getHeight(); y++) {
				Image tileImage = tileMap.getTileImage(x, y, 1);
				if(tileImage != null){
					tileImage.draw(x*32, y*32);
				}
			}
		}
		
		
		//draw all enteties:
		for (Item item : gameState.getItems()) {
			System.out.println("draw item: " + item);
		}
		
		for (Enemy enemy : gameState.getEnemies()) {
			enemy.draw();
		}
		
		gameState.getPlayer().draw();

		for(Projectile proj : gameState.getProjectiles()){
			proj.draw();
		}
		
	}

	
}
