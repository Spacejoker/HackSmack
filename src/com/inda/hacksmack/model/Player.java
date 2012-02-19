package com.inda.hacksmack.model;

import java.util.ArrayList;
import java.util.List;

public class Player extends Entity {
	
	private List<Item> inventory = new ArrayList<Item>();
	private double weaponDamage;
	private int ammoLeft;
	//add more properties as needed
	
	public List<Item> getInventory() {
		return inventory;
	}

	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}

	public double getWeaponDamage() {
		return weaponDamage;
	}

	public void setWeaponDamage(double weaponDamage) {
		this.weaponDamage = weaponDamage;
	}

	public int getAmmoLeft() {
		return ammoLeft;
	}

	public void setAmmoLeft(int ammoLeft) {
		this.ammoLeft = ammoLeft;
	}
}
