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
public class HealthBar {

	double healthPercentage = 100;
	double shieldPercentage = 100;
	
	Image characterImage = null;

	Vector2f position = new Vector2f(126, 128);

	double mindegree = 0;
	double maxdegree = 7*210.0/360.0;

	double shieldmin = 1*210.0/360.0;
	double shieldmax = 7*210.0/360.0;

	Polygon healthPart = new Polygon();
	Polygon shieldPart = new Polygon();
	
	Image bg = null;
	
	public HealthBar() {
		setHealthPercentage(100);
		updateMe();
		bg = ResourceManager.getInstance().getImage("healthbar-bg");
	}

	public void updateMe() {
		System.out.println("in");
		double mod = 1.0/60.0;
		double rad = 100;
		
		healthPart = new Polygon();
		shieldPart = new Polygon();

		if(healthPercentage > 0){
			double start = (maxdegree -  mindegree) * (100-healthPercentage) / 100.0 + mindegree;
			
			for (double degree = start; degree >= start; degree += mod) {
				if (degree < maxdegree) {
					float x = (float) (Math.cos(degree) * rad + position.x);
					float y = (float) (Math.sin(degree) * rad*-1 + position.y);
					healthPart.addPoint(x, y);
				} else {
					mod = Math.abs(mod)*-1;
					rad = 80;
				}
			}
		} else {
			healthPart = null;
		}
		
		rad = 120;
		mod = Math.abs(mod);
		if(shieldPercentage > 0){
			double start = (shieldmax -  shieldmin) * (100-shieldPercentage) / 100.0 + shieldmin;
			
			for (double degree = start; degree >= start; degree += mod) {
				if (degree < shieldmax) {
					float x = (float) (Math.cos(degree) * rad + position.x);
					float y = (float) (Math.sin(degree) * rad*-1 + position.y);
					shieldPart.addPoint(x, y);
				} else {
					mod = Math.abs(mod)*-1;
					rad = 104;
				}
			}
		} else {
			shieldPart = null;
		}
		System.out.println("out");
	}

	public Polygon getRedPart() {
		return healthPart;
	}

	public void setP(Polygon p) {
		this.healthPart = p;
	}

	public Image getCharacterImage() {
		return characterImage;
	}

	public void setCharacterImage(Image characterImage) {
		this.characterImage = characterImage;
	}

	public double getMindegree() {
		return mindegree;
	}

	public void setMindegree(double mindegree) {
		this.mindegree = mindegree;
	}

	public double getMaxdegree() {
		return maxdegree;
	}

	public void setMaxdegree(double maxdegree) {
		this.maxdegree = maxdegree;
	}

	public double getHealthPercentage() {
		return healthPercentage;
	}

	public void setHealthPercentage(double percentage) {
		this.healthPercentage = percentage;
	}

	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}

	public Polygon getHealthPart() {
		return healthPart;
	}

	public void setHealthPart(Polygon healthPart) {
		this.healthPart = healthPart;
	}

	public Image getBg() {
		return bg;
	}

	public void setBg(Image bg) {
		this.bg = bg;
	}

	public double getShieldPercentage() {
		return shieldPercentage;
	}

	public void setShieldPercentage(double shieldPercentage) {
		this.shieldPercentage = shieldPercentage;
	}

	public double getShieldmax() {
		return shieldmax;
	}

	public void setShieldmax(double shieldmax) {
		this.shieldmax = shieldmax;
	}

	public Polygon getShieldPart() {
		return shieldPart;
	}

	public void setShieldPart(Polygon shieldPart) {
		this.shieldPart = shieldPart;
	}
}
