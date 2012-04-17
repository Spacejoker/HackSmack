package com.inda.hacksmack;

import java.util.Iterator;
import java.util.List;

import org.lwjgl.Sys;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import com.inda.hacksmack.factory.AnimationFactory;
import com.inda.hacksmack.model.Enemy;
import com.inda.hacksmack.model.GameMode;
import com.inda.hacksmack.model.Item;
import com.inda.hacksmack.model.Player;
import com.inda.hacksmack.model.GameState;
import com.inda.hacksmack.model.Projectile;

public class LogicMaster {
	@SuppressWarnings("unused")
	private double timepassed = 0;
	private static LogicMaster _instance;

	private LogicMaster() {
	}

	public static LogicMaster getInstance() {
		if (_instance == null) {
			_instance = new LogicMaster();
		}
		return _instance;
	}

	public void handleLogics(GameState state, int delta) {
		switch (state.getGameMode()) {
		case GAMEPLAY:

			timepassed += delta;
			Player player = state.getPlayer();

			for (Iterator<Item> iterator = state.getItems().iterator(); iterator.hasNext();) {
				Item item = iterator.next();
				if(System.currentTimeMillis() > item.getDestroyTime()){
					iterator.remove();
				}
			}
			
			// Move the player
			player.getPosition().add(new Vector2f(player.getDirection()).normalise().scale((float) (player.getSpeed() * delta / (float) 1000)));

			// make each enemy set up a direction:
			// System.out.println(player.getDirection() + " " + player.getSpeed() + " " + delta);

			for (Enemy enemy : state.getEnemies()) {
				enemy.updateDirection(state.getPlayer());

				Vector2f position = enemy.getPosition();

				position.x += enemy.getDirection().x * enemy.getSpeed() * delta;
				position.y += enemy.getDirection().y * enemy.getSpeed() * delta;
			}
			for (Iterator <Projectile>it = state.getProjectiles().iterator(); it.hasNext();) {
				Projectile proj = it.next();
				proj.getPosition().add(new Vector2f(proj.getDirection()).normalise().scale((float) (proj.getSpeed() * delta / (float) 1000)));
				for(Iterator <Enemy>e = state.getEnemies().iterator(); e.hasNext();){
					Enemy enemy = e.next();
					if(proj.getPosition().distance(enemy.getPosition()) < proj.getRadius() + enemy.getRadius()){
						//En fiende har tr�ffats, g�r dmg.
						//System.out.println("Did " + proj.getDamage() + " points of dmg! " + (int)(enemy.getHealth()-proj.getDamage()) + " hp left!");
						enemy.setHealth((int)(enemy.getHealth()-proj.getDamage()));
						it.remove();
						if(enemy.getHealth() <= 0){
							e.remove();
							
							// add death animation
							Item item = AnimationFactory.newAnimation(enemy.getDeathAnimationId(), enemy.getPosition());
							item.getAnimation().setLooping(false);
							item.setDestroyTime((long) (System.currentTimeMillis() + 4000));
							state.getItems().add(item);
						}
						break;
					}}
						
						
					
				// System.out.println(proj.toString());
			}
			
			break;
			
		case CUT_SCENE:
			if (state.getCutScene().done()) { // if a cutscene is done, go to gameplay
				state.setGameMode(GameMode.GAMEPLAY);
			}
			break;

		default:
			break;
		}
	}

}
