package com.inda.hacksmack.factory;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import com.inda.hacksmack.ResourceManager;
import com.inda.hacksmack.model.AnimationTypeData;
import com.inda.hacksmack.model.Item;
import com.inda.hacksmack.model.Item.ItemType;

public class AnimationFactory {

	/**
	 * Create an enemy given an ID and a position - 
	 */
	public static Item newAnimation(String id, Vector2f position){
		AnimationTypeData animationData = ResourceManager.getInstance().getAnimationData(id);
		
		Image[] images = ResourceManager.getInstance().getImages(animationData.getImageIds());
		
		Animation a = new Animation(images, animationData.getSpeed());
		
		Item item = new Item();
		
		item.setAnimation(a);
		item.setPosition(position);
		item.setType(ItemType.ANIMATION);
		
		return item;
	}
}
