package com.inda.hacksmack.model.cutscene;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import com.inda.hacksmack.HackSmackConstants;
import com.inda.hacksmack.ResourceManager;
import com.inda.hacksmack.factory.ImageEntityFactory;
import com.inda.hacksmack.model.Entity;
import com.inda.hacksmack.util.RandomUtil;

public class IntroCutScene implements CutScene {

	long totalTime = 5000;
	List<Entity> ret = new ArrayList<Entity>();
	private long startTime;

	Entity playerWalking;
	int characterStartX = HackSmackConstants.SCREEN_WIDTH+100, characterStartY = HackSmackConstants.SCREEN_HEIGHT - 150;
	
	
	public IntroCutScene() {
		startTime = System.currentTimeMillis();
		playerWalking = ImageEntityFactory.newImageEntity(new String[]{"intro_walk_1","intro_walk_2","intro_walk_3", "intro_walk_2"}, new Vector2f(100, 100), 250);
		playerWalking.setDirection(new Vector2f(90));
		ret.add(playerWalking);
	}
	
	@Override
	public boolean done() {
		return getPassedTime() >= this.totalTime;
	}

	@Override
	public List<Entity> getEnteties() {
		
		long time = getPassedTime();
		
		if(time < 4000){
			playerWalking.setPosition(new Vector2f((float) (characterStartX- time*0.15), characterStartY));
		} else {
			playerWalking.setAnimation(new Animation(new Image[]{ResourceManager.getInstance().getImage("intro_walk_2")}, 1));
		}
		
		return ret;
	}
	private long getPassedTime() {
		return System.currentTimeMillis() - startTime;
	}
}
