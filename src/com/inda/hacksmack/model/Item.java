package com.inda.hacksmack.model;

/**
 * Basically just an "Entity"
 * @author Jensa
 */
public class Item extends Entity {
	boolean canBePicked;

	public boolean getCanBePicked() {
		return canBePicked;
	}

	public void setCanBePicked(boolean canBePicked) {
		this.canBePicked = canBePicked;
	}
	
}
