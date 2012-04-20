package com.inda.hacksmack.factory;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

import com.inda.hacksmack.ResourceManager;
import com.inda.hacksmack.model.Item;
import com.inda.hacksmack.model.Item.ItemType;

public class ItemFactory {

	/**
	 * id = image id
	 */
	public static Item newItemEntity(String id, Vector2f position, ItemType type, boolean pickable){
		
		Item entity = new Item();
		
		entity.setPosition(position);
		entity.setAnimation(new Animation(new Image[]{ResourceManager.getInstance().getImage(id)}, 1));
		entity.setType(type);
		entity.setCanBePicked(pickable);
		return entity;
		
	}
}
