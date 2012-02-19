package com.inda.hacksmack;

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
		
	}

}
