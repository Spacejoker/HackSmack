package com.inda.hacksmack.util;

import java.util.Random;

public class RandomUtil {

	static RandomUtil _instance;

	Random random = new Random(System.currentTimeMillis());
	
	private RandomUtil() {
	}
	
	public static RandomUtil getInstance(){
		if(_instance == null){
			_instance = new RandomUtil();
		}
		return _instance;
	}
	
	public Random getRandom(){
		return random;
	}
}
