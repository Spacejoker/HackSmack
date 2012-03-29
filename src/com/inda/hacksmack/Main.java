package com.inda.hacksmack;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.inda.hacksmack.input.InputHandler;
import com.inda.hacksmack.model.GameMode;
import com.inda.hacksmack.model.GameState;


public class Main extends BasicGame{

	public Main() {
		super("HackSmack");
	}

	private InputHandler ih;
	
	private GameState gameState;
	private LogicMaster lm;
	private GraphicsMaster gm = GraphicsMaster.getInstance();
	
	@Override
	public void init(GameContainer container) throws SlickException {

		container.getInput().addListener(ih = InputHandler.getInstance());
		
		gameState = new GameState(); // TODO: this shoulde be loaded in a controlled manner
		ih.addEvent(gameState.getPlayer());
		
		lm = LogicMaster.getInstance();
		gameState.setGameMode(GameMode.CUT_SCENE);
	}

	/**
	 * Framework method - render
	 */
	@Override
	public void render(GameContainer container, Graphics graphics) throws SlickException {
		synchronized (this.getClass()) {
			gm.drawState(gameState, graphics);
		}
	}

	/**
	 * Framework method - update logics
	 */
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		synchronized (this.getClass()) {
			lm.handleLogics(gameState, delta);
		}
	}
	
	public static void main(String[] args) {
		try {
			AppGameContainer app = new AppGameContainer(new Main());
			app.setDisplayMode(HackSmackConstants.SCREEN_WIDTH, HackSmackConstants.SCREEN_HEIGHT, false);
			app.setShowFPS(true);
			app.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
