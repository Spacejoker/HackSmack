package com.inda.hacksmack.model;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.tiled.TiledMap;

import com.inda.hacksmack.ResourceManager;
import com.inda.hacksmack.factory.EnemyFactory;

/**
 * Contains the GameState - this can be momentarily dumped and loaded to save/retrieve gamestate
 * 
 * @author Jensa
 */
public class GameState {

	private Map map;
	private List<Enemy> enemies = new ArrayList<Enemy>();
	private List<Item> items = new ArrayList<Item>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	private Player player;

	/**
	 * Loads a default map
	 */
	public GameState() {
		this("test");
	}

	public GameState(String mapName) {
		this.map = new Map(ResourceManager.getInstance().getTiledMap(mapName));
		
		//Load all enemies from tilefile:
		TiledMap tileMap = map.getTileMap();
		int objcnt = tileMap.getObjectCount(0);
		for (int i = 0; i < objcnt; i++) {
			String enemyId = tileMap.getObjectProperty(0, i, "id", "");
			Enemy newEnemy = EnemyFactory.newEnemy(enemyId, new Vector2f(tileMap.getObjectX(0, i), tileMap.getObjectY(0, i)));
			enemies.add(newEnemy);
		}
		
		player = new Player();
		player.setPosition(new Vector2f(100, 100));
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
