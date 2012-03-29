package com.inda.hacksmack.factory;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import com.inda.hacksmack.ResourceManager;
import com.inda.hacksmack.model.ImageEntity;

public class ImageEntityFactory {

	/**
	 * id = image id
	 */
	public static ImageEntity newImageEntity(String id, Vector2f position){
		
		ImageEntity entity = new ImageEntity();
		
		entity.setPosition(position);
		entity.setAnimation(new Animation(new Image[]{ResourceManager.getInstance().getImage(id)}, 1));
		
		return entity;
		
	}
	
	public static ImageEntity newImageEntity(String[] ids, Vector2f position, int animationSpeed){
		
		ImageEntity entity = new ImageEntity();
		
		entity.setPosition(position);
		
		Image[] images = new Image[ids.length];
		for (int i = 0; i < ids.length; i++) {
			images[i] = ResourceManager.getInstance().getImage(ids[i]);
		}
		
		entity.setAnimation(new Animation(images, animationSpeed));
		
		
		return entity;
		
	}
	
}
