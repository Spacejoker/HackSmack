package com.inda.hacksmack.model.cutscene;

import java.util.ArrayList;

import java.util.List;


import org.newdawn.slick.geom.Vector2f;

import com.inda.hacksmack.HackSmackConstants;

import com.inda.hacksmack.factory.ImageEntityFactory;
import com.inda.hacksmack.input.InputEvent;
import com.inda.hacksmack.input.InputHandler;
import com.inda.hacksmack.model.Entity;

public class DeathCutScene implements CutScene, InputEvent{
	
	boolean done = false;
	Entity text1;

	@Override
	public boolean done() {
		return done;
	}

	public DeathCutScene() {
		super();
		InputHandler.getInstance().addEvent(this);
		
		
		text1 = ImageEntityFactory.newImageEntity(new String[] { "deathscreen" }, new Vector2f(HackSmackConstants.SCREEN_WIDTH, HackSmackConstants.SCREEN_HEIGHT - 340), 1);
		text1.setPosition(new Vector2f((HackSmackConstants.SCREEN_WIDTH-600)/2, (HackSmackConstants.SCREEN_HEIGHT -400)/2));
		text1.setDirection(new Vector2f(90));
	}

	@Override
	public List<Entity> getEnteties() {
		List<Entity> ret = new ArrayList<Entity>();
	
		ret.add(text1);
		
		return ret;
	}


	@Override
	public void keyPressed(int key, char c) {
		
		//System.out.println(key + " " + c);
		if(c == ' ')
			done = true;
	}

	@Override
	public void keyReleased(int key, char c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(int button, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int button, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(int change) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAcceptingEvents() {
		return !done;
	}
}