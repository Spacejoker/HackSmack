package com.inda.hacksmack.model;


public class EnemyTypeData {

	String[] animationImageIds, walkImageIds;
	int maxhealth;
	double speed;
	double radius;
	String id;
	
	public EnemyTypeData(String[] animationImageIds, int maxhealth, double speed, double radius, String id, String[] walkImageIds) {
		super();
		this.animationImageIds = animationImageIds;
		this.maxhealth = maxhealth;
		this.speed = speed;
		this.radius = radius;
		this.id = id;
		this.walkImageIds = walkImageIds;
	}
	
	public int getMaxhealth() {
		return maxhealth;
	}
	public void setMaxhealth(int maxhealth) {
		this.maxhealth = maxhealth;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String[] getAnimationImageIds() {
		return animationImageIds;
	}
	public void setAnimationImageIds(String[] animationImageIds) {
		this.animationImageIds = animationImageIds;
	}

	public String[] getWalkImageIds() {
		return walkImageIds;
	}

	public void setWalkImageIds(String[] walkImageIds) {
		this.walkImageIds = walkImageIds;
	}
	
	
}
