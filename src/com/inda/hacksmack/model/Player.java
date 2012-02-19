package com.inda.hacksmack.model;

import java.util.ArrayList;
import java.util.List;

import com.inda.hacksmack.input.InputEvent;

public class Player extends Entity implements InputEvent {
	
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

	@Override
	public void keyPressed(int arg0, char c) {
		// TODO Auto-generated method stub
		
		if(c == 'a')
			System.out.println("Jag vill gå åt vänster!");

		if(c == 'd')
			System.out.println("Jag vill gå åt höger!");

		if(c == 'w')
			System.out.println("Jag vill gå åt framåt!");

		if(c == 's')
			System.out.println("Jag vill gå åt bakåt!");
	}
	

	@Override
	public void keyReleased(int arg0, char arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(int button, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(int button, int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseWheelMoved(int change) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isAcceptingEvents() {
		// TODO Auto-generated method stub
		return true;
	}


}
