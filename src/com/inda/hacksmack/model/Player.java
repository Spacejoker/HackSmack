package com.inda.hacksmack.model;

import java.util.ArrayList;


import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import java.util.List;

import com.inda.hacksmack.ResourceManager;
import com.inda.hacksmack.input.InputEvent;

public class Player extends Entity implements InputEvent {
	
	private GameState gamestate;
	private List<Item> inventory = new ArrayList<Item>();
	private double weaponDamage;
	private int ammoLeft;
	private Vector2f mouseposition = new Vector2f();
	private Vector2f lookdirection = new Vector2f();
	//add more properties as needed
	
	public void setGameState(GameState gamestate){
		this.gamestate = gamestate;
	}
	
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

	private Vector2f getLookDirection(){
		return lookdirection.set(mouseposition.getX()-getPosition().getX(),mouseposition.getY()-getPosition().getY());
	}
	
	public void draw() {
			animation.getCurrentFrame().setRotation((float) ( getLookDirection().getTheta()-90));
			animation.draw(position.x, position.y);		
	}
	
	@Override
	public void keyPressed(int arg0, char c) {
		
		if(c == 'a')
			setDirection(getDirection().add(new Vector2f(-1,0)));

		if(c == 'd')
			setDirection(getDirection().add(new Vector2f(1,0)));

		if(c == 'w')
			setDirection(getDirection().add(new Vector2f(0,-1)));

		if(c == 's')
			setDirection(getDirection().add(new Vector2f(0,1)));
		
	}
	

	@Override
	public void keyReleased(int key, char c) {
		
		if(c == 'a')
			setDirection(getDirection().add(new Vector2f(1,0)));

		if(c == 'd')
			setDirection(getDirection().add(new Vector2f(-1,0)));

		if(c == 'w')
			setDirection(getDirection().add(new Vector2f(0,1)));

		if(c == 's')
			setDirection(getDirection().add(new Vector2f(0,-1)));
		
	}

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
	
		
	}

	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
		mouseposition.set(newx, newy);
		
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		mouseposition.set(newx, newy);
		
	}

	@Override
	public void mousePressed(int button, int x, int y) {
		Projectile proj = new Projectile();
		proj.setSpeed(400);
		Image []frame2 = new Image[1];
		frame2[0] = ResourceManager.getInstance().getImage("ball");
		proj.setAnimation(new Animation(frame2, 1));
		proj.setPosition(new Vector2f(position));
		proj.setDirection(new Vector2f(lookdirection));
		gamestate.getProjectiles().add(proj);
		
	}

	@Override
	public void mouseReleased(int button, int x, int y) {
		
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
