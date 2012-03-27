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
		
		ImageEntity image = new ImageEntity();
		
		image.setPosition(position);
		image.setAnimation(new Animation(new Image[]{ResourceManager.getInstance().getImage(id)}, 1));
		
		return image;
		
	}
}
