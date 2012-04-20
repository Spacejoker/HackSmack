package com.inda.hacksmack.model;

/**
 * Basically just an "Entity", can be destroyed at a certain point in time (disappear)
 * @author Jensa
 */
public class Item extends Entity {
	
	public enum ItemType{GEM, ANIMATION}
	ItemType type;
	boolean canBePicked;

	private long destroyTime = Long.MAX_VALUE;

	public boolean getCanBePicked() {
		return canBePicked;
	}

	public void setCanBePicked(boolean canBePicked) {
		this.canBePicked = canBePicked;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public void setDestroyTime(long f) {
		this.destroyTime = f;
	}

	public long getDestroyTime() {
		return destroyTime;
	}
	
}
