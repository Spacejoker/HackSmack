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

public class IntroCutScene implements CutScene {

	long totalTime = 14000;
	List<Entity> ret = new ArrayList<Entity>();
	private long startTime;

	Entity playerWalking;
	int characterStartX = HackSmackConstants.SCREEN_WIDTH+100, characterStartY = HackSmackConstants.SCREEN_HEIGHT - 550;
	Entity text1, text2, spaceArtifact;
	
	public IntroCutScene() {
		startTime = System.currentTimeMillis();
		playerWalking = ImageEntityFactory.newImageEntity(new String[]{"intro_walk_1","intro_walk_2","intro_walk_3", "intro_walk_2"}, new Vector2f(100, 100), 250);
		playerWalking.setDirection(new Vector2f(90));
		
		text1 = ImageEntityFactory.newImageEntity(new String[]{"conversation_1"}, new Vector2f(0, HackSmackConstants.SCREEN_HEIGHT - 340), 1);
		text1.setDirection(new Vector2f(90));
		
		text2 = ImageEntityFactory.newImageEntity(new String[]{"conversation_2"}, new Vector2f(0, HackSmackConstants.SCREEN_HEIGHT - 340), 1);
		text2.setDirection(new Vector2f(90));
		
		spaceArtifact = ImageEntityFactory.newImageEntity(new String[]{"space_artifact"}, new Vector2f(250, HackSmackConstants.SCREEN_HEIGHT - 590), 1);
		spaceArtifact.setDirection(new Vector2f(90));
		ret.add(playerWalking);
	}
	
	@Override
	public boolean done() {
		return getPassedTime() >= this.totalTime;
	}

	@Override
	public List<Entity> getEnteties() {
		
		long time = getPassedTime();
		ret.clear();
		if(time < 4000){
			playerWalking.setPosition(new Vector2f((float) (characterStartX- time*0.15), characterStartY));
			ret.add(playerWalking);
		} else {
			playerWalking.setAnimation(new Animation(new Image[]{ResourceManager.getInstance().getImage("intro_walk_2")}, 1));
			ret.add(playerWalking);
		}
		
		if(time > 4000 && time <= 9000){
			ret.add(text1);
		}
		
		if(time > 9000 && time <= 14000){
			ret.add(text2);
		}
		
		ret.add(spaceArtifact);
		
		return ret;
	}

	private long getPassedTime() {
		return System.currentTimeMillis() - startTime;
	}
}
