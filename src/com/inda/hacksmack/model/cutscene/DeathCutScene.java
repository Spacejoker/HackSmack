package com.inda.hacksmack.model.cutscene;

import java.util.ArrayList;
import java.util.Random;

import java.util.List;


import org.lwjgl.Sys;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import com.inda.hacksmack.HackSmackConstants;
import com.inda.hacksmack.ResourceManager;

import com.inda.hacksmack.factory.AnimationFactory;
import com.inda.hacksmack.factory.ImageEntityFactory;
import com.inda.hacksmack.factory.ItemFactory;
import com.inda.hacksmack.input.InputEvent;
import com.inda.hacksmack.input.InputHandler;
import com.inda.hacksmack.model.Entity;
import com.inda.hacksmack.model.GameState;
import com.inda.hacksmack.model.ImageEntity;
import com.inda.hacksmack.model.Item;
import com.inda.hacksmack.model.Item.ItemType;
import com.inda.hacksmack.util.RandomUtil;
import com.sun.org.apache.bcel.internal.generic.DADD;

public class DeathCutScene implements CutScene, InputEvent{
	
	Entity bg;
	private GameState state;

	long totalTime = 14000;
	List<Entity> ret = new ArrayList<Entity>();
	private long startTime;
	Item[] explosions;
	
	int[] explosionTimes;
	boolean[] explosionVisible, explosionDone;
	int explosionCnt = 450, minExplosionTime = 0, maxExplosionTime = 10000;
	private ImageEntity playerWalking;
	private ImageEntity death_text;
	
	public DeathCutScene(GameState state) {
		super();

		startTime = System.currentTimeMillis();
		this.state = state;
		InputHandler.getInstance().addEvent(this);
		explosions = new Item[explosionCnt];
		
		Random random = RandomUtil.getInstance().getRandom();
		explosionTimes = new int[explosionCnt];
		explosionVisible = new boolean[explosionCnt];
		explosionDone = new boolean[explosionCnt];
		
		for (int i = 0; i < explosionCnt; i++) {
			int r = random.nextInt(maxExplosionTime - minExplosionTime);
			explosionTimes[i] = r + minExplosionTime;
		}
		
		for (int i = 0; i < explosionCnt; i++) {

			Item animation = AnimationFactory.newAnimation("explosion", new Vector2f(0,0));
			animation.getAnimation().setCurrentFrame(RandomUtil.getInstance().getRandom().nextInt(animation.getAnimation().getFrameCount()));
			animation.getPosition().x += RandomUtil.getInstance().getRandom().nextInt(HackSmackConstants.SCREEN_WIDTH);
			animation.getPosition().y += RandomUtil.getInstance().getRandom().nextInt(HackSmackConstants.SCREEN_HEIGHT);

			explosions[i] = animation;
		}
		
		
		death_text = ImageEntityFactory.newImageEntity(new String[] { "death_text" }, new Vector2f(0, 0), 1);
		death_text.setDirection(new Vector2f(90));
		
		bg = ImageEntityFactory.newImageEntity(new String[] { "space_bg" }, new Vector2f(0, 0), 1);
		bg.setDirection(new Vector2f(90));
		
		playerWalking = ImageEntityFactory.newImageEntity(new String[] { "intro_walk_1"}, new Vector2f(-100, 200), 50);
		playerWalking.setDirection(new Vector2f(90));
		
	}

	@Override
	public List<Entity> getEnteties() {
		long time = getPassedTime();
		ret.clear();
		ret.add(bg);
		ret.add(playerWalking);
		
		playerWalking.setPosition(new Vector2f(getPassedTime()/5-200 , 160 + time/17));
		playerWalking.setDirection(new Vector2f(getPassedTime()/4));
		
		
		for (int i = 0; i < explosionCnt; i++) {
			if(!explosionVisible[i] && explosionTimes[i] <= time){
				explosionVisible[i] = true;
				explosions[i].getAnimation().setCurrentFrame(0);
			}
			
			if(explosionVisible[i] && explosions[i].getAnimation().getFrame() >= explosions[i].getAnimation().getFrameCount() - 1){
				explosionDone[i] = true;
			}
		}
		
		for (int i = 0; i < explosionCnt; i++) {
			if(explosionVisible[i] && !explosionDone[i]){
				ret.add(explosions[i]);
			}
		}
		
		
		if(time > 5000){
			ret.add(death_text);
		}
		
		return ret;
	}

	@Override
	public void keyPressed(int key, char c) {
		if(c == ' ')	{
			totalTime = 0;
			state.setCutScene(new IntroCutScene());
		}
	}


	private long getPassedTime() {
		return System.currentTimeMillis() - startTime;
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
		return !done();
	}
	
	@Override
	public boolean done() {
		return getPassedTime() >= this.totalTime;
	}
}