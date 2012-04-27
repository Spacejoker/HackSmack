package com.inda.hacksmack.model;

import com.inda.hacksmack.ResourceManager;

public class Projectile extends Entity {

	double damage;
	Entity source;
	{
			ResourceManager.getInstance().getSound("fireball_0").play(1.0f, 0.5f);
	}

	public Projectile(Entity source, double damage) {
		this.damage = damage;
		this.source = source;
	}

	public void explode() {
			ResourceManager.getInstance().getSound("fireball_1").play(1.0f, 0.5f);
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
