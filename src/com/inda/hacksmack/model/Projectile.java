package com.inda.hacksmack.model;

public class Projectile extends Entity {

	double damage;
	Entity source;
	
	public Projectile(Entity source, double damage){
		this.damage = damage;
		this.source = source;
	}
	
	public Entity getSource() {
		return source;
	}
	
	public void setSource(Entity source) {
		this.source = source;
	}
	
	public double getDamage() {
		return damage;
	}
	
	public void setDamage(double damage) {
		this.damage = damage;
	}
	
}
