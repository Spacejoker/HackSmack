package com.inda.hacksmack.factory;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import com.inda.hacksmack.ResourceManager;
import com.inda.hacksmack.model.Enemy;
import com.inda.hacksmack.model.EnemyTypeData;

public class EnemyFactory {

	/**
	 * Create an enemy given an ID and a position - 
	 */
	public static Enemy newEnemy(String id, Vector2f position){
		
		Enemy enemy = new Enemy();
		
		EnemyTypeData typeData = ResourceManager.getInstance().getEnemyTypeData(id);
		
		String[] animationImageIds = typeData.getAnimationImageIds();
		Image[] animationImages = new Image[animationImageIds.length];
		for (int i = 0; i < animationImageIds.length; i++) {
			animationImages[i] = ResourceManager.getInstance().getImage(animationImageIds[i]);
		}
		
		
		String[] walkImageIds = typeData.getWalkImageIds();
		Image[] walkImages = new Image[walkImageIds.length];
		for (int i = 0; i < walkImageIds.length; i++) {
			System.out.println("Walk image: " + walkImageIds[i]);
			walkImages[i] = ResourceManager.getInstance().getImage(walkImageIds[i]);
		}
		
		enemy.setAnimation(new Animation(animationImages, 100));
		enemy.setWalkAnimation(new Animation(walkImages, 100));
		enemy.setPosition(position);
		enemy.setPassable(false);
		
		enemy.setMaxhealth(typeData.getMaxhealth());
		enemy.setHealth(enemy.getMaxhealth());
		enemy.setDirection(new Vector2f(1,1));
		enemy.setSpeed(typeData.getSpeed());
		enemy.setRadius(typeData.getRadius());
		
		return enemy;
	}
}
