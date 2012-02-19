package com.inda.hacksmack.factory;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import com.inda.hacksmack.ResourceManager;
import com.inda.hacksmack.model.Enemy;

public class EnemyFactory {

	/**
	 * Create an enemy given an ID and a position - 
	 */
	public static Enemy newEnemy(String id, Vector2f position){
		
		Enemy enemy = new Enemy();
		
		enemy.setAnimation(new Animation(new Image[]{ResourceManager.getInstance().getImage("enemy_giant")}, 100));
		enemy.setPosition(position);
		enemy.setPassable(false);
		enemy.setMaxhealth(100);
		enemy.setDirection(new Vector2f(1,1));
		enemy.setSpeed(0.1);
		return enemy;
	}
}
