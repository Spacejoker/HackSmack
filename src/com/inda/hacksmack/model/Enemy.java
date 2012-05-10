package com.inda.hacksmack.model;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import com.inda.hacksmack.HackSmackConstants;
import com.inda.hacksmack.ResourceManager;


/**
 * An enemy in the game which is alive and kicking (hopefully!)
 */
public class Enemy extends Entity {
	
	private double defaultspeed;
	private Animation walkAnimation;
	boolean playerNoticed = false;
	int time = 0;
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

	private void updateDirectionPlayerSeen(Player player, GameState state, int tick){
	
		
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
			if(time > 1000){
				Projectile proj = new Projectile(this, getWeaponDamage());
				
				proj.setSpeed(400);
				Image []frame2 = new Image[1];
				frame2[0] = ResourceManager.getInstance().getImage("beam");
				proj.setAnimation(new Animation(frame2, 1));
				proj.setPosition(new Vector2f(position));
				proj.setDirection(new Vector2f(direction));
				state.getProjectiles().add(proj);
				
				time = 0;
			}
			
		

	}
	
	private boolean canSeePlayer(Player player, GameState state){
		boolean collidesWithMap = false;
		for(Vector2f pos = new Vector2f(getPosition()); pos.distance(player.getPosition()) > player.getRadius() + radius; 
				pos.add((new Vector2f(player.getPosition()).sub(pos).normalise().scale(10)))){
		
		collidesWithMap |= state.getMap().collidesWithMap(pos, getRadius()+2);
		}
		return !collidesWithMap;
	}
	
	public void updateDirection(Player player, GameState state, int tick) {
		time += tick;
		if(playerNoticed){
			if(canSeePlayer(player, state)){
				updateDirectionPlayerSeen(player, state, tick);
			}else{
				state.getMap().whereAmI(getPosition());
				direction = state.getMap().shortestPath(getPosition());
				//System.out.println("Cant see: " + direction);
			}
		}
		else
		{
			if(player.position.distance(position) < HackSmackConstants.FOG_OF_WAR_DISTANCE + 20){
				playerNoticed = true;
				ResourceManager.getInstance().getSound("scream").play();
			}
		}
		
	}
	
	/**
	 * Returns the correct animation for walking / standing / attacking etc
	 */
	@Override
	public Animation getAnimation() {
		if(Math.abs(speed) > 1){
			return walkAnimation;
		}
		return animation;
	}

	int getWeaponDamage(){
		return 50;
		
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
