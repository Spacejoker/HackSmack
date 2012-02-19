package com.inda.hacksmack.model;

import java.awt.Point;

import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Vector2f;

/**
 * Base class for everything that can be shown and interacted with on screen
 * 
 * Holds basic properties for all enteties
 * @author Jensa
 */
public abstract class Entity {

	protected int health;
	protected int maxhealth;
	protected Animation animation;
	protected Vector2f direction;
	protected Point position;
	protected double speed;
	protected boolean passable;
	
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

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
	
}
