package com.inda.hacksmack.model;

/**
 * Basically just an "Entity"
 * @author Jensa
 */
public class Item extends Entity {
	
	public enum ItemType{GEM, ANIMATION}
	ItemType type;
	
	boolean canBePicked;

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
}
