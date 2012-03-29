package com.inda.hacksmack.model.cutscene;

import java.util.List;

import com.inda.hacksmack.model.Entity;

/**
 * Interface for a cutscene
 * @author Jensa
 */
public interface CutScene {
	
	/**
	 * true means that the cutscene has ended
	 */
	boolean done();
	
	/**
	 * Everything to draw for the current time in the cutscene, ordered with bottom object first
	 */
	List<Entity> getEnteties();

}
