package com.inda.hacksmack.model.cutscene;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.geom.Vector2f;

import com.inda.hacksmack.factory.ImageEntityFactory;
import com.inda.hacksmack.model.Entity;
import com.inda.hacksmack.util.RandomUtil;

public class IntroCutScene implements CutScene {

	long totalTime = 4000;
	List<Entity> ret = new ArrayList<Entity>();
	private long startTime;

	public IntroCutScene() {
		startTime = System.currentTimeMillis();
	}
	
	@Override
	public boolean done() {
		return getPassedTime() >= this.totalTime;
	}

	@Override
	public List<Entity> getEnteties() {
		if(ret.size() < getPassedTime() / 1000){
			ret.add(ImageEntityFactory.newImageEntity("ball", new Vector2f(RandomUtil.getInstance().getRandom().nextInt(500),RandomUtil.getInstance().getRandom().nextInt(500))));
		}
		
		return ret;
	}
	private long getPassedTime() {
		return System.currentTimeMillis() - startTime;
	}
}
