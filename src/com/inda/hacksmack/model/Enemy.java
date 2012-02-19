package com.inda.hacksmack.model;


public class Enemy extends Entity {

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
	}
}
