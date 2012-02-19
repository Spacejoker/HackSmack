package com.inda.hacksmack;

import org.newdawn.slick.geom.Vector2f;

import com.inda.hacksmack.model.Enemy;
import com.inda.hacksmack.model.GameState;

public class LogicMaster {

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
		
		//make each enemy set up a direction:
		for (Enemy enemy : state.getEnemies()) {
			enemy.updateDirection(state.getPlayer());
			
			Vector2f position = enemy.getPosition();

			position.x += enemy.getDirection().x * enemy.getSpeed() * delta;
			position.y += enemy.getDirection().y * enemy.getSpeed() * delta;
		}
	}

}
