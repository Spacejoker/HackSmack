package com.inda.hacksmack;

import java.awt.Font;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;

public class Main extends BasicGame {

	private static final String IMAGE_FOLDER = "content/images/";
	Image bgImage;

	public Main() {
		super("HackSmack");
	}
	TrueTypeFont deprecatiedFont;
	@Override
	public void init(GameContainer container) throws SlickException {

		deprecatiedFont = new TrueTypeFont(new Font("Courier new", Font.BOLD, 24), false);
		
		bgImage = new Image(IMAGE_FOLDER + "tmp.png");
	}

	/**
	 * Framework method - render
	 */
	@Override
	public void render(GameContainer container, Graphics graphics) throws SlickException {
		synchronized (this.getClass()) {
			graphics.drawImage(bgImage, 0, 0);
			deprecatiedFont.drawString(20, 20, "Inda ownage");
		}
	}

	/**
	 * Framework method - update logics
	 */
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		synchronized (this.getClass()) {
			//do something
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
