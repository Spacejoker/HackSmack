package com.inda.hacksmack.model;

public class AnimationTypeData {

	String[] imageIds;
	String id;
	Integer speed;

	public AnimationTypeData(String[] imageIds, String id, Integer speed) {
		super();
		this.imageIds = imageIds;
		this.id = id;
		this.speed = speed;
	}

	public String[] getImageIds() {
		return imageIds;
	}

	public void setImageIds(String[] imageIds) {
		this.imageIds = imageIds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

}
