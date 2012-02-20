package com.inda.hacksmack;

import org.newdawn.slick.geom.Vector2f;

import com.inda.hacksmack.model.Enemy;
import com.inda.hacksmack.model.Player;
import com.inda.hacksmack.model.GameState;

public class LogicMaster {
	private double timepassed = 0;
	private static LogicMaster _instance;
	
	private LogicMaster() {
	}
	
	public static LogicMaster getInstance(){
		if(_instance == null){
			_instance = new LogicMaster();
		}
		return _instance;
	}
	
	public void handleLogics(GameState state, int delta){
		timepassed += delta;
		//make each enemy set up a direction:
		Player player = state.getPlayer();
		Vector2f pp = state.getPlayer().getPosition();
		

		pp.add(new Vector2f(player.getDirection()).normalise().scale((float) (player.getSpeed() * delta/(float)1000)));
		
		
		System.out.println(player.getDirection() + " " + player.getSpeed() + " " + delta);
		
		for (Enemy enemy : state.getEnemies()) {
			enemy.updateDirection(state.getPlayer());
			
			Vector2f position = enemy.getPosition();

			position.x += enemy.getDirection().x * enemy.getSpeed() * delta;
			position.y += enemy.getDirection().y * enemy.getSpeed() * delta;
		}
	}

}
