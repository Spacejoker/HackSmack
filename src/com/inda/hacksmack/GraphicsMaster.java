package com.inda.hacksmack;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.tiled.TiledMap;

import com.inda.hacksmack.model.GameState;

/**
 * Singleton 
 * 
 * @author Jensa
 */
public class GraphicsMaster {

	public static void drawState(GameState gameState, Graphics graphics) {
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
		
		int objcnt = tileMap.getObjectCount(0);
		for (int i = 0; i < objcnt; i++) {
			String imageName = tileMap.getObjectProperty(0, i, "image", "");
			Image image = ResourceManager.getInstance().getImage(imageName);
			
			image.draw(tileMap.getObjectX(0, i), tileMap.getObjectY(0, i));
		}
	}

	
}
