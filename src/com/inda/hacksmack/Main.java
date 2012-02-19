package com.inda.hacksmack;

import java.awt.Font;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.InputListener;

import com.inda.hacksmack.model.GameState;
import com.inda.hacksmack.input.InputHandler;

public class Main extends BasicGame{

	Image bgImage;
	public Main() {
		super("HackSmack");
	}

	TrueTypeFont deprecatiedFont;
	ResourceManager rm;
	InputHandler ih;
	GameState gameState;
	
	@Override
	public void init(GameContainer container) throws SlickException {
		//container.getInput();
		container.getInput().addListener(ih = InputHandler.getInstance());
		rm = ResourceManager.getInstance();
		
		deprecatiedFont = new TrueTypeFont(new Font("Courier new", Font.BOLD, 24), false);
		
		bgImage = rm.getImage("background");

		rm.getSound("fireball_0").play();
		
		gameState = new GameState(); // TODO: this shoulde be loaded in a controlled manner
	}

	/**
	 * Framework method - render
	 */
	@Override
	public void render(GameContainer container, Graphics graphics) throws SlickException {
		synchronized (this.getClass()) {
			
			TiledMap tileMap = gameState.getMap().getTileMap();
			for (int x = 0; x < tileMap.getWidth(); x++) {
				for (int y = 0; y < tileMap.getHeight(); y++) {
					//System.out.println(x + " " + y);
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
		}
		
		//container.getInput().poll(0, 0);
	}

	/**
	 * Framework method - update logics
	 */
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		synchronized (this.getClass()) {
			// do something
			//ih.printKeys();
		}
	}
	
	public static void main(String[] args) {
		try {
			AppGameContainer app = new AppGameContainer(new Main());
			app.setDisplayMode(1024, 720, false);
			app.setShowFPS(true);
			app.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
