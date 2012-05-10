package com.inda.hacksmack.model;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Polygon;
import org.newdawn.slick.geom.Vector2f;

import com.inda.hacksmack.ResourceManager;

/**
 * Uber health bar
 * 
 * @author Jensa
 */
public class HeatAndBatteryBar {

	float heat = 100;
	float battery = 100;

	float height = 182;
	float heatx = 5, heatWidth = 18;
	float batteryx = 120, batteryWidth = 49;

	Vector2f position = new Vector2f(40, 450);

	Polygon heatPart = new Polygon();

	Image bg = null;

	public HeatAndBatteryBar() {
		updateMe();
		bg = ResourceManager.getInstance().getImage("battery-bg");
	}

	public void updateMe() {
		
		heatPart = new Polygon();

		if (heat > 0) {
			float initx = position.x + 19;
			float inity = position.y + 57;
			heatPart.addPoint(initx, inity + height*(1 - heat/100));
			heatPart.addPoint(initx + heatWidth, inity + height*(1 - heat/100));
			heatPart.addPoint(initx + heatWidth, inity + height);
			heatPart.addPoint(initx, inity + height);
		} else {
			heatPart = null;
		}
	}

	public Polygon getRedPart() {
		return heatPart;
	}

	public void setP(Polygon p) {
		this.heatPart = p;
	}

	public float getHealthPercentage() {
		return heat;
	}

	public void setHealthPercentage(float percentage) {
		this.heat = percentage;
	}

	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}

	public Polygon getHealthPart() {
		return heatPart;
	}

	public void setHealthPart(Polygon healthPart) {
		this.heatPart = healthPart;
	}

	public Image getBg() {
		return bg;
	}

	public void setBg(Image bg) {
		this.bg = bg;
	}

	public double getShieldPercentage() {
		return battery;
	}

	public float getHeat() {
		return heat;
	}

	public void setHeat(float heat) {
		this.heat = heat;
	}

	public float getBattery() {
		return battery;
	}

	public void setBattery(float battery) {
		this.battery = battery;
	}
	
}
