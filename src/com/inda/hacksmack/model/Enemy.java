package com.inda.hacksmack.model;


public class Enemy extends Entity {

	/**
	 * The AI is in this method -> just walk towards the player for now
	 * @param player
	 */
	public void updateDirection(Player player) {
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
			direction.x = 0;
			direction.y = 0;
		}
	}
}
