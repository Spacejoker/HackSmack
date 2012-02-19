package com.inda.hacksmack.model;

import java.util.List;

import org.newdawn.slick.Graphics;

import com.inda.hacksmack.ResourceManager;

/**
 * Contains the GameState - this can be momentarily dumped and loaded to save/retrieve gamestate
 * 
 * @author Jensa
 */
public class GameState {
	
	private Map map;
	private List<Enemy> enemies;
	private List<Item> items;
	private List<Projectile> projectiles;
	private Player player;
	
	public GameState() {
		
		//Loads a default map:
		this.map = new Map(ResourceManager.getInstance().getTiledMap("test"));
		
	}
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public List<Enemy> getEnemies() {
		return enemies;
	}
	public void setEnemies(List<Enemy> enemies) {
		this.enemies = enemies;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public List<Projectile> getProjectiles() {
		return projectiles;
	}
	public void setProjectiles(List<Projectile> projectiles) {
		this.projectiles = projectiles;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
}
