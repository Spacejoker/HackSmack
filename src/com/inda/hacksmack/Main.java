package com.inda.hacksmack;

import java.awt.Font;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

import com.inda.hacksmack.model.GameState;
import com.inda.hacksmack.model.Player;
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
	Player player;
	
	@Override
	public void init(GameContainer container) throws SlickException {
		
		container.getInput().addListener(ih = InputHandler.getInstance());
		player = new Player();
		ih.addEvent(player);
		
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
			GraphicsMaster.drawState(gameState, graphics);
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
