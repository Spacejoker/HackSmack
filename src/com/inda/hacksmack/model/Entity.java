package com.inda.hacksmack.model;

import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Vector2f;

/**
 * Base class for everything that can be shown and interacted with on screen
 * 
 * Holds basic properties for all enteties
 * 
 * @author Jensa
 */
public abstract class Entity {

	protected int health;
	protected int maxhealth;
	protected Animation animation;
	protected Vector2f direction = new Vector2f();
	protected Vector2f position = new Vector2f();
	protected double speed;
	protected boolean passable;
	protected double radius = 16;

	/**
	 * Draws whatever is returned by getAnimation() - could be overridden by subclasses to allow for more flexible animation handling
	 */
	public void draw() {
		Animation curAnimation = getAnimation();
		curAnimation.getCurrentFrame().setRotation((float) (direction.getTheta() - 90));
		curAnimation.draw(position.x, position.y);
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxhealth() {
		return maxhealth;
	}

	public void setMaxhealth(int maxhealth) {
		this.maxhealth = maxhealth;
	}

	public Animation getAnimation() {
		return animation;
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	public Vector2f getDirection() {
		return direction;
	}

	public void setDirection(Vector2f direction) {
		this.direction = direction;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public boolean getPassable() {
		return passable;
	}

	public void setPassable(boolean passable) {
		this.passable = passable;
	}

	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
}
