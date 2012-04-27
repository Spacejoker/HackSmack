package com.inda.hacksmack.model;

import org.newdawn.slick.Animation;


/**
 * An enemy in the game which is alive and kicking (hopefully!)
 */
public class Enemy extends Entity {
	
	private double defaultspeed;
	private Animation walkAnimation;
	boolean playerNoticed = false;
	
	public Enemy(){
		passable = false;
	}
	
	public void setSpeed(double speed){
		this.speed = speed;
		defaultspeed = speed;
	}	
	
	/**
	 * The AI is in this method -> just walk towards the player for now
	 * @param player
	 */

	public void updateDirection(Player player) {
		
		
		if(playerNoticed){
			float py = player.getPosition().y;
			float px = player.getPosition().x;
			float ey = position.y;
			float ex = position.x;
			
			direction.x = px - ex;
			direction.y = py - ey;
			
			direction.normalise();
			
			if(direction.x*direction.x + direction.y * direction.y > 0.1){
				direction.normalise();
			} else {
				direction.x = 0;
				direction.y = 0;
			}
			
			if(Math.sqrt(Math.pow(position.x - player.getPosition().x, 2) + Math.pow(position.y - player.getPosition().y, 2)) < player.getRadius() + radius){
				
				speed = 0;
			} else {
				speed = defaultspeed;
			}
		} else {
			speed = 0;
			
			if(player.position.distance(position) < 300){
				playerNoticed = true;
				System.out.print("Hittad!");
			}
		}
	}
	
	/**
	 * Returns the correct animation for walking / standing / attacking etc
	 */
	@Override
	public Animation getAnimation() {
		if(Math.abs(speed) > 0.01){
			return walkAnimation;
		}
		return animation;
	}

	public Animation getWalkAnimation() {
		return walkAnimation;
	}

	public void setWalkAnimation(Animation walkAnimation) {
		this.walkAnimation = walkAnimation;
	}

	/**
	 * should be enemy-specific or something?
	 */
	public String getDeathAnimationId() {
		return "explosion";
	}
	
	
}
